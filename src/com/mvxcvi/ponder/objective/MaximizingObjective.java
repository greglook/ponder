/* Copyright 2012 Greg Look. All rights reserved. */

package com.mvxcvi.ponder.objective;


import java.util.Comparator;


/**
 * This class provides a simple objective function which attempts to
 * maximize comparable values.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public class MaximizingObjective<Y extends Comparable<Y>> implements Comparator<Y> {

    /**
     * Compares two output values for order. Returns a negative integer, zero,
     * or a positive integer as the first argument is better, equivalent to, or
     * worse than the second.
     *
     * This method inverts the default comparison order, meaning numeric values
     * will be maximized by this objective.
     *
     * @param a  first value
     * @param b  second value
     * @return ordering result
     */
    @Override
    public int compare(Y a, Y b) {

        // choose maximal value
        return b.compareTo(a);

    };

}
