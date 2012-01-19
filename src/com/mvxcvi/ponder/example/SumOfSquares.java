/* ... */

package com.mvxcvi.ponder.example;


import com.mvxcvi.ponder.Objective;

import java.util.Vector;


/**
 * ...
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public class SumOfSquares implements Objective<Vector<Double>, Double> {

    private final Vector<Double> offset;


    public SumOfSquares() {

        this(null);

    }


    public SumOfSquares(Vector<Double> offset) {

        this.offset = offset;

    }


    @Override
    public Double evaluate(Vector<Double> solution) {

        double sum = 0.0;

        for ( int i = 0; i < solution.size(); i++ ) {

            double coordinate = solution.get(i);

            if (( offset != null ) && ( i < offset.size() )) {
                coordinate += offset.get(i);
            }

            sum += coordinate * coordinate;

        }

        return sum;

    }

}
