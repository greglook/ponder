/* Copyright 2012 Greg Look. All rights reserved. */

package com.mvxcvi.ponder.example;


import com.mvxcvi.ponder.objective.MinimizingObjective;

import java.util.Vector;


/**
 * This class models an objective to minimize the sum of the squares of the
 * coordinates in a given search vector, after some offset.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public class SumOfSquares extends MinimizingObjective<Vector<Double>, Double> {

    /** Offset values. */
    private final Vector<Double> offset;


    /**
     * Constructs a new objective with no offset.
     */
    public SumOfSquares() {

        this(null);

    }


    /**
     * Constructs an objective with the given offset.
     *
     * @param offset  optional vector of coordinate offsets
     */
    public SumOfSquares(Vector<Double> offset) {

        this.offset = offset;

    }


    @Override
    public Double evaluate(Vector<Double> vector) {

        double sum = 0.0;

        for ( int i = 0; i < vector.size(); i++ ) {

            double coordinate = vector.get(i);

            if (( offset != null ) && ( i < offset.size() )) {
                coordinate += offset.get(i);
            }

            sum += coordinate * coordinate;

        }

        return sum;

    }

}
