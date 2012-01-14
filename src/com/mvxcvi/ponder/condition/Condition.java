/* ... */

package com.mvxcvi.ponder.condition;


/**
 * This interface gives a way to provide customized conditions specifying when
 * a strategy should cease computation during problem solving. A simple example
 * is a threshold condition, which halts when the fitness of the best
 * solution exceeds a certain value.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public interface Condition {

    /**
     * Updates the condition with a new 'best score'.
     *
     * @param score  current best solution fitness
     */
    public void update(double score);


    /**
     * Reports whether this condition has been met.
     *
     * @return true if the condition has been satisfied
     */
    public boolean satisfied();

}
