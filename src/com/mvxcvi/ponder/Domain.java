/* ... */

package com.mvxcvi.ponder;


/**
 * This interface provides a way to interact with the space of all solutions
 * of a certain type. It also provides factory methods for generating random
 * points in the domain.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public interface Domain<S> {

    // TODO: fill in more functions

    public S random();

    public S randomNeighbor(S solution);

    public S randomNeighbor(S solution, double distance);

}
