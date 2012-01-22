/* Copyright 2012 Greg Look. All rights reserved. */

package com.mvxcvi.ponder.objective;


import com.mvxcvi.ponder.Objective;


/**
 * This class provides a base for an objective function which attempts to
 * minimize the resulting values.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public abstract class MinimizingObjective<V, S extends Comparable<S>> implements Objective<V, S> {

    @Override
    public int compare(S a, S b) {

        // choose minimal value
        return a.compareTo(b);

    };

}
