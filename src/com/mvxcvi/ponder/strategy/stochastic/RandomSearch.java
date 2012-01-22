/* Copyright 2012 Greg Look. All rights reserved. */

package com.mvxcvi.ponder.strategy.stochastic;


import com.mvxcvi.ponder.Domain;
import com.mvxcvi.ponder.Objective;
import com.mvxcvi.ponder.Result;
import com.mvxcvi.ponder.Strategy;


/**
 * This strategy iteratively selects random vectors in the search space as
 * candidates.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public class RandomSearch<V, S> implements Strategy<V, S> {

    /** Search vector domain. */
    private final Domain<V> domain;

    /** Objective function. */
    private final Objective<V, S> objective;



    /**
     * Creates a new RandomSearch.
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
