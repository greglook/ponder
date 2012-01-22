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

    public V randomNeighbor(V vector, D delta);

}
