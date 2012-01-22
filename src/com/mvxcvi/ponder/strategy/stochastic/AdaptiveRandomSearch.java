/* Copyright 2012 Greg Look. All rights reserved. */

package com.mvxcvi.ponder.strategy.stochastic;


import com.mvxcvi.ponder.Objective;
import com.mvxcvi.ponder.Result;
import com.mvxcvi.ponder.Strategy;
import com.mvxcvi.ponder.domain.DifferentialDomain;


/**
 * This strategy ... as candidates.
 *
 * Adaptive Random Search is an extension of the Random Search algorithm.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public class AdaptiveRandomSearch<V, D, S> implements Strategy<V, S> {

    ///// CONFIGURATION /////

    /** Search vector domain. */
    private final DifferentialDomain<V, D> domain;

    /** Objective function. */
    private final Objective<V, S> objective;



    ///// PROPERTIES /////

    /** The current search iteration. */
    private int iteration = 0;

    /** Number of iterations since the current result changed. */
    private int stasis = 0;

    /** Current search result. */
    private Result<V, S> current;

    /** Current step size. */
    private D stepSize;
    public D getStepSize() { return stepSize; }


    /** Small step size scaling factor. */
    private double smallFactor = 1.3;
    public double getSmallFactor() { return smallFactor; }
    public void setSmallFactor(double value) {
        if ( value < 1.0 ) throw new IllegalArgumentException("Small scaling factor must not be less than unity: " + value);
        smallFactor = value;
    }


    /** Large step size scaling factor. */
    private double largeFactor = 3.0;
    public double getLargeFactor() { return largeFactor; }
    public void setLargeFactor(double value) {
        if ( value < 1.0 ) throw new IllegalArgumentException("Large scaling factor must not be less than unity: " + value);
        largeFactor = value;
    }


    /** Number of iterations between large-step-size trials. */
    private int trialPeriod = 10;
    public int getTrialPeriod() { return trialPeriod; }
    public void setTrialPeriod(int value) {
        if ( value < 1 ) throw new IllegalArgumentException("Trial period must be positive: " + value);
        trialPeriod = value;
    }


    /** Max iterations to spend in stasis before shrinking step size. */
    private int stasisLimit = 30;
    public int getStasisLimit() { return stasisLimit; }
    public void setStasisLimit(int value) {
        if ( value < 1 ) throw new IllegalArgumentException("Stasis limit must be positive: " + value);
        stasisLimit = value;
    }



    ///// STRATEGY METHODS /////

    /**
     * Creates a new Adaptive Random Search strategy.
     *
     * @param domain      search domain
     * @param objective   objective function
     * @param stepFactor  initial step size factor
     */
    public AdaptiveRandomSearch(DifferentialDomain<V, D> domain, Objective<V, S> objective, double stepFactor) {

        if ( domain    == null ) throw new IllegalArgumentException("AdaptiveRandomSearch cannot be constructed with null domain");
        if ( objective == null ) throw new IllegalArgumentException("AdaptiveRandomSearch cannot be constructed with null objective");
        if ( stepFactor <= 0.0 ) throw new IllegalArgumentException("AdaptiveRandomSearch must have a positive initial step size factor");

        this.domain = domain;
        this.objective = objective;

        current = new Result<V, S>(objective, domain.random());
        stepSize = domain.scale(domain.diameter(), stepFactor);

    }


    @Override
    public Result<V, S> search() {

        // calculate scaled-up step size
        D largeStepSize = domain.scale(stepSize, (iteration++ % trialPeriod) == 0 ? largeFactor : smallFactor);

        // select close and far neighbors
        Result<V, S> close = new Result<V, S>(objective, domain.randomNeighbor(current.getVector(), stepSize));
        Result<V, S> far   = new Result<V, S>(objective, domain.randomNeighbor(current.getVector(), largeStepSize));

        // check for improvement
        if (( close.compareTo(current) <= 0 ) || ( far.compareTo(current) <= 0 )) {
            if ( close.compareTo(far) <= 0 ) {
                current = close;
            } else {
                current = far;
                stepSize = largeStepSize;
            }
            stasis = 0;
        } else if ( stasis++ >= stasisLimit ) {
            stepSize = domain.scale(stepSize, 1/smallFactor);
            stasis = 0;
        }

        return current;

    }

}
