/* Copyright 2012 Greg Look. All rights reserved. */

package com.mvxcvi.ponder.strategy;


import com.mvxcvi.ponder.Domain;
import com.mvxcvi.ponder.Objective;
import com.mvxcvi.ponder.Result;
import com.mvxcvi.ponder.Strategy;


/**
 * This class provides an extremely simple base for strategy implementations.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public abstract class AbstractStrategy<D extends Domain<V>, V, S> implements Strategy<V, S> {

    ///// CONFIGURATION /////

    /** Search vector domain. */
    protected final D domain;

    /** Objective function. */
    protected final Objective<V, S> objective;



    ///// PROPERTIES /////

    /** Current (best) search result. */
    protected Result<V, S> current;
    public Result<V, S> currentResult() { return current; }



    /**
     * Creates a new strategy.
     *
     * @param domain     search domain
     * @param objective  objective function
     */
    public AbstractStrategy(D domain, Objective<V, S> objective) {

        if ( domain    == null ) throw new IllegalArgumentException("Strategy cannot be constructed without a domain");
        if ( objective == null ) throw new IllegalArgumentException("Strategy cannot be constructed without an objective");

        this.domain = domain;
        this.objective = objective;

    }



    ///// HELPER METHODS /////

    /**
     * Shortcut to evaluate a candidate vector to produce a result.
     *
     * @param vector  candidate vector
     * @return constructed evaluation result
     */
    protected Result<V, S> evaluate(V vector) {

        if ( vector == null ) return null;

        return new Result<V, S>(objective, vector);

    }

}
