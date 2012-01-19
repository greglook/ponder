/* ... */

package com.mvxcvi.ponder;


/**
 * An objective produces results by evaluating candidate solutions. The result
 * should measure the optimality of the given solution in a comparable manner.
 *
 * Objective instances should be immutable.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public interface Objective<S, R extends Comparable<R>> {

    /**
     * Computes a result representing the objective value of the given
     * candidate solution. This method should return <code>null</code> if the
     * candidate is completely inviable.
     *
     * @param soultion  candidate solution vector
     * @return evaluation result
     */
    public R evaluate(S solution);

}
