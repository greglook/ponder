/* ... */

package com.mvxcvi.ponder;


/**
 * Strategies are metaheuristics for efficiently searching vector spaces for
 * optimizing an objective function.
 *
 * The {@link search} method may be called iteratively to attempt to find
 * better results. Each call performs some unit of work before returning to the
 * caller.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public interface Strategy<V, S> {

    /**
     * Performs an iteration to produce a candidate search result.
     * This should perform the smallest unit-of-work possible and is intended
     * to be called repeatedly to produce more/better candidates.
     *
     * @return candidate solution
     */
    public Result<V, S> search();

}
