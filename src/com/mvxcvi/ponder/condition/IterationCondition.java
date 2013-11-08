/* Copyright 2012 Greg Look. All rights reserved. */

package com.mvxcvi.ponder.condition;


import com.mvxcvi.ponder.Condition;
import com.mvxcvi.ponder.Result;


/**
 * This condition is satisfied after a fixed number of scores have been
 * calculated. In practice, this provides an upper bound on the number of
 * iterations a strategy will calculate.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public class IterationCondition implements Condition<Object, Object> {

    ///// CONFIGURATION /////

    /** The number of iterations required. */
    private final int limit;



    ///// PROPERTIES /////

    /** The current iteration. */
    private int iteration = 0;



    ///// INITIALIZATION /////

    /**
     * Creates a new condition at the given iteration count.
     *
     * @param limit  max iterations to calculate
     */
    public IterationCondition(int limit) {

        if ( limit < 1 ) throw new IllegalArgumentException("IterationCondition must be constructed with positive limit: " + limit);

        this.limit = limit;

    }



    ///// ACCESSORS /////

    /**
     * Gets the iteration limit for this condition.
     *
     * @return maximum iteration limit
     */
    public int getLimit() { return limit; }


    /**
     * Gets the current iteration.
     *
     * @return number of update calls
     */
    public int currentIteration() { return iteration; }



    ///// CONDITION METHODS /////

    @Override
    public void update(Result<? extends Object, ? extends Object> result) {

        iteration++;

    }


    @Override
    public boolean satisfied() {

        return iteration >= limit;

    }


    @Override
    public String toString() {

        return String.format("(%1$siteration%1$s | %d >= %d )",
            satisfied() ? "+" : "-", iteration, limit);

    }

}
