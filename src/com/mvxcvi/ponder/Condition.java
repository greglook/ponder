/* Copyright 2012 Greg Look. All rights reserved. */

package com.mvxcvi.ponder;


/**
 * This interface gives a way to provide customized conditions specifying when
 * a strategy should cease computation during problem solving. A simple example
 * is an iteration condition, which is satisfied after a fixed number of calls
 * to {@link update}.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public interface Condition<X, Y> {

    /**
     * Updates the condition with a new best search result.
     *
     * @param result  current best search result
     */
    public void update(Result<? extends X, ? extends Y> result);


    /**
     * Determines whether this condition has been met.
     *
     * @return true if the condition has been satisfied
     */
    public boolean satisfied();

}
