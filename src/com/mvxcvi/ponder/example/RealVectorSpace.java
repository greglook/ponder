/* ... */

package com.mvxcvi.ponder.example;


import com.mvxcvi.ponder.Domain;

import java.util.Random;
import java.util.Vector;


/**
 * This class models real vector spaces with arbitrary dimensionality.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public class RealVectorSpace implements Domain<Vector<Double>> {

    /** Internal random number generator. */
    private final Random random;

    /** Number of dimensions. */
    private final int dimension;

    /** Range of permitted coordinate values. */
    private final double range;


    /**
     * Creates a new vector space. The space will have the given dimensionality
     * and vector values will fall in [-range, range].
     *
     * @param dimension  number of coordinates per vector
     * @param range      boundary on coordinate values
     */
    public RealVectorSpace(int dimension, double range) {

        if ( dimension < 1 ) throw new IllegalArgumentException("RealVectorSpace must have positive number of dimensions: " + dimension);
        if ( range <= 0.0  ) throw new IllegalArgumentException("RealVectorSpace must have a positive range: " + range);

        this.random = new Random();
        this.dimension = dimension;
        this.range = range;

    }


    @Override
    public Vector<Double> random() {

        Vector<Double> vector = new Vector<Double>(dimension);

        for ( int i = 0; i < dimension; i++ ) vector.add(range*(2.0*random.nextDouble() - 1.0));

        return vector;

    }

}
