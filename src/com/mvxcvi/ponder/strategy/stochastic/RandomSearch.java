/* Copyright 2012 Greg Look. All rights reserved. */

package com.mvxcvi.ponder.strategy.stochastic;


import com.mvxcvi.ponder.Domain;
import com.mvxcvi.ponder.Objective;
import com.mvxcvi.ponder.Result;
import com.mvxcvi.ponder.Strategy;


/**
 * This strategy selects random vectors in the search space as candidates.
 *
 * Random Search belongs to the fields of Stochastic Optimization and Global
 * Optimization. Random search is a direct search method as it does not require
 * derivatives to search a continuous domain.
 *
 * The strategy of Random Search is to sample solutions from across the entire
 * search domain using a uniform probability distribution. Each candidate is
 * independent of the samples that came before it.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public class RandomSearch<V, S> implements Strategy<V, S> {

    /** Search vector domain. */
    private final Domain<V> domain;

    /** Objective function. */
    private final Objective<V, S> objective;



    /**
     * Creates a new Random Search strategy.
     *
     * @param domain     search domain
     * @param objective  objective function
     */
    public RandomSearch(Domain<V> domain, Objective<V, S> objective) {

        if ( domain    == null ) throw new IllegalArgumentException("RandomSearch cannot be constructed with null domain");
        if ( objective == null ) throw new IllegalArgumentException("RandomSearch cannot be constructed with null objective");

        this.domain = domain;
        this.objective = objective;

    }


    @Override
    public Result<V, S> search() {

        V candidate = domain.random();

        return new Result<V, S>(objective, candidate);

    }

}
