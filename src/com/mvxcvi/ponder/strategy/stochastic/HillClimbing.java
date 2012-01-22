/* Copyright 2012 Greg Look. All rights reserved. */

package com.mvxcvi.ponder.strategy.stochastic;


import com.mvxcvi.ponder.Objective;
import com.mvxcvi.ponder.Result;
import com.mvxcvi.ponder.domain.DifferentialDomain;
import com.mvxcvi.ponder.strategy.AbstractStrategy;


/**
 * This strategy iteratively searches nearby candidate vectors and selects the
 * first which results in an improvement.
 *
 * Stochastic Hill Climbing belongs to the Stochastic Optimization and Local
 * Optimization family of algorithms. It is a direct search technique, as it
 * does not require derivatives of the search space.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public class HillClimbing<V, D, S> extends AbstractStrategy<DifferentialDomain<V, D>, V, S> {

    ///// CONFIGURATION /////

    /** Step size. */
    private final D stepSize;



    ///// STRATEGY METHODS /////

    /**
     * Creates a new Stochastic Hill Climbing strategy.
     *
     * @param domain     search domain
     * @param objective  objective function
     * @param stepSize   neighbor step size
     */
    public HillClimbing(DifferentialDomain<V, D> domain, Objective<V, S> objective, D stepSize) {

        super(domain, objective);

        if ( stepSize  == null ) throw new IllegalArgumentException("AdaptiveRandomSearch cannot be constructed with null step size");

        this.stepSize = stepSize;

        current = evaluate(domain.random());

    }


    @Override
    public Result<V, S> search() {

        Result<V, S> candidate = evaluate(domain.randomNeighbor(current.getVector(), stepSize));

        if ( candidate.improves(current) ) current = candidate;

        return current;

    }

}
