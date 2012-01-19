/* ... */

package com.mvxcvi.ponder;


/**
 * Strategies are algorithmic approaches to solving certain types of problems.
 * A strategy object is built to generate solution results for a given problem
 * objective.
 *
 * The {@link search} method may be called iteratively to attempt to find
 * better solution vectors. Each call performs some unit of work before
 * returning to the caller.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public interface Strategy<D extends Domain<S>, O extends Objective<S, R>> {

    /**
     * Gets the domain being searched by this strategy.
     *
     * @return solution domain
     */
    public D getDomain();


    /**
     * Gets the objective for this strategy.
     *
     * @return objective function
     */
    public O getObjective();


    /**
     * Gets the best solution found by this strategy.
     *
     * @return current best solution
     */
    public S bestSolution();


    /**
     * Gets the result of the best solution found by this strategy.
     *
     * @return current best result
     */
    public R bestResult();


    /**
     * Estimates the progress this strategy has made towards finding a
     * solution to the problem.
     *
     * @return value between 0.0 and 1.0
     */
    public double progress();


    /**
     * Determines whether this strategy has finished searching the
     * solution space.
     *
     * @return false if the strategy should search further
     */
    public boolean isDone();


    /**
     * Performs an iteration to produce or enhance the solution to the problem.
     * This should perform the smallest unit-of-work possible towards
     * calculating a solution.
     */
    public void search();

}
