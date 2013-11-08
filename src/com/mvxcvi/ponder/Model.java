/* Copyright 2012 Greg Look. All rights reserved. */

package com.mvxcvi.ponder;


/**
 * A model represents a relationship or mapping between a vector of variable
 * inputs and some output type. Models are a type of <em>mathematical function</em>.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public interface Model<X, Y> {

    /**
     * Computes an output value from the given input vector. This method
     * should return <code>null</code> if the inputs are invalid.
     *
     * @param input  model input vector
     * @return output value
     */
    public Y evaluate(X input);

}
