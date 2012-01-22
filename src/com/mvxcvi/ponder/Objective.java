/* Copyright 2012 Greg Look. All rights reserved. */

package com.mvxcvi.ponder;


import java.util.Comparator;


/**
 * An objective function produces solution scores by evaluating candidate search
 * vectors. The solution should measure the optimality of the given vector in an
 * ordered manner.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public interface Objective<V, S> extends Comparator<S> {

    /**
     * Computes a solution value from the given search vector. This method
     * should return <code>null</code> if the vector is completely inviable.
     *
     * @param vector  search vector
     * @return solution value
     */
    public S evaluate(V vector);


    /**
     * Compares two solution values for order. Returns a negative integer,
     * zero, or a positive integer as the first argument is better, equivalent
     * to, or worse than the second. This means that by default, numeric
     * value comparisons will result in minimizing searches.
     *
     * @param a  first value
     * @param b  second value
     * @return ordering result
     */
    public int compare(S a, S b);

}
