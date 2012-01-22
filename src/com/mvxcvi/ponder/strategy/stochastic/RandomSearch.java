/* Copyright 2012 Greg Look. All rights reserved. */

package com.mvxcvi.ponder.strategy.stochastic;


import com.mvxcvi.ponder.Domain;
import com.mvxcvi.ponder.Objective;
import com.mvxcvi.ponder.Result;
import com.mvxcvi.ponder.strategy.AbstractStrategy;


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
public class RandomSearch<V, S> extends AbstractStrategy<Domain<V>, V, S> {

    /**
     * Creates a new Random Search strategy.
     *
     * @param domain     search domain
     * @param objective  objective function
     */
    public RandomSearch(Domain<V> domain, Objective<V, S> objective) {

        super(domain, objective);

    }


    @Override
    public Result<V, S> search() {

        return evaluate(domain.random());

    }

}
