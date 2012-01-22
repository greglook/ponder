/* Copyright 2012 Greg Look. All rights reserved. */

package com.mvxcvi.ponder;


/**
 * This interface provides a way to interact with the space of all solution
 * vectors of a certain type. It also provides factory methods for generating
 * random points in the domain.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public interface Domain<V> {

    public V random();

}
