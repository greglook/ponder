/* ... */

package com.mvxcvi.ponder.strategy.stochastic;


import com.mvxcvi.ponder.Domain;
import com.mvxcvi.ponder.Objective;
import com.mvxcvi.ponder.strategy.AbstractStrategy;


/**
 * Random search iteratively selects random solutions and retains the best one
 * found.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public class RandomSearch<S, R extends Comparable<R>> extends AbstractStrategy<S, R> {

    ///// CONFIGURATION /////

    /** Number of iterations to complete. */
    private final int maxIterations;



    ///// VARIABLES /////

    /** Current iteration number. */
    private int iteration = 0;



    ///// INITIALIZATION /////

    /**
     * Creates a new random search strategy.
     *
     * @param domain      solution domain
     * @param objective   search objective
     * @param iterations  number of iterations to search for
     */
    public RandomSearch(Domain<S> domain, Objective<S, R> objective, int iterations) {

        super(domain, objective);

        if ( iterations < 1 ) throw new IllegalArgumentException("RandomSearch must perform at least one iteration: " + iterations);

        maxIterations = iterations;

    }



    ///// STRATEGY EXECUTION /////

    @Override
    public double progress() {

        return (double)iteration/maxIterations;

    }


    @Override
    public boolean isDone() {

        return iteration >= maxIterations;

    }


    @Override
    public void search() {

        S candidate = domain.random();

        evaluate(candidate);

        iteration++;

    }

}
