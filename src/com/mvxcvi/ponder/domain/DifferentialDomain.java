/* Copyright 2012 Greg Look. All rights reserved. */

package com.mvxcvi.ponder.domain;


import com.mvxcvi.ponder.Domain;


/**
 * This interface represents a domain with differentiable vectors. The generic
 * type D represents a way of measuring deltas between two vector types V.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public interface DifferentialDomain<V, D> extends Domain<V> {

    /**
     * Selects a neighbor within delta of the given vector with uniform
     * probability.
     *
     * @param vector  original search vector
     * @param delta   selection step size
     * @return a random neighboring vector
     */
    public V randomNeighbor(V vector, D delta);


    /**
     * Returns some concept of the 'diameter' of the search domain.
     *
     * @return domain boundary widths
     */
    public D diameter();


    /**
     * Scales a delta value up or down by a real factor. A factor of 1.0 should
     * result in no change.
     *
     * @param delta   step delta value
     * @param factor  scaling factor
     * @return a scaled copy of the delta
     */
    public D scale(D delta, double factor);

}
