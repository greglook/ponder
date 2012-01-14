/* ... */

package com.mvxcvi.ponder.condition;


/**
 * This condition is satisfied after a fixed number of scores have been
 * calculated. In practice, this provides an upper bound on the number of
 * iterations a strategy will calculate.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public class IterationCondition implements Condition {

    /** The number of iterations required. */
    private final int limit;

    /** The current number of iterations. */
    private int iterations = 0;



    /**
     * Creates a new condition at the given iteration count.
     *
     * @param limit  max iterations to calculate
     */
    public IterationCondition(int limit) {

        if ( limit < 1 ) throw new IllegalArgumentException("Property 'limit' must be positive: " + limit);

        this.limit = limit;

    }


    /**
     * Gets the iteration limit for this condition.
     *
     * @return maximum iteration limit
     */
    public int getLimit() { return limit; }


    @Override
    public void update(double score) {

        iterations++;

    }


    @Override
    public boolean satisfied() {

        return iterations >= limit;

    }


    @Override
    public String toString() {

        return String.format("(iterations >= %d)", limit);

    }

}
