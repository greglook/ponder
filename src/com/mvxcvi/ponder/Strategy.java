/* ... */

package com.mvxcvi.ponder;


/**
 * A <code>Strategy</code> is an algorithmic approach to solving a certain
 * type of problem. A strategy object is built to generate solutions to some
 * specific problem instance.
 *
 * The #solve method may be called iteratively to attempt to generate better
 * solutions to the problem. Each call performs some unit of work before
 * returning to the caller.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public interface Strategy<P extends Problem, S extends Solution<P>> {

    /**
     * Performs a unit of work to produce a solution to the problem.
     *
     * @return the best solution found so far
     */
    public S solve();


    /**
     * Gets the current best solution.
     *
     * @return solution object
     */
    public S getSolution();

}
