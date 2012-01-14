/* ... */

package com.mvxcvi.ponder;


/**
 * This interface generically models a solution to a type of problem. Solutions
 * should refer to the problem that they are solving. A solution to a problem
 * has some score, which defines how ideal a solution it is.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public interface Solution<P extends Problem> extends Cloneable, Comparable<Solution<P>> {

    /**
     * Gets the <code>Problem</code> this <code>Solution</code> is for.
     *
     * @return the problem
     */
    public P getProblem();

    /**
     * Gets a numeric representation of this solution's fitness at solving the
     * problem. This method should return <code>NaN</code> if the solution is
     * completely inviable.
     *
     * @return solution fitness
     */
    public double score();

}
