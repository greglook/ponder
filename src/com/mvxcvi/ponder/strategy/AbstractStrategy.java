/* ... */

package com.mvxcvi.ponder.strategy;


import com.mvxcvi.ponder.Domain;
import com.mvxcvi.ponder.Objective;
import com.mvxcvi.ponder.Strategy;


/**
 * Base class which provides a skeleton strategy implementation.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public abstract class AbstractStrategy<S, R extends Comparable<R>> implements Strategy<S, R> {

    ///// CONFIGURATION /////

    /** Solution domain. */
    protected final Domain<S> domain;

    /** Strategic objective. */
    protected final Objective<S, R> objective;



    ///// VARIABLES /////

    /** Current best solution. */
    protected S bestSolution = null;

    /** Current best result. */
    protected R bestResult = null;



    ///// INITIALIZATION /////

    /**
     * Initializes common strategy properties.
     *
     * @param domain     solution domain
     * @param objective  search objective
     */
    public AbstractStrategy(Domain<S> domain, Objective<S, R> objective) {

        if ( domain    == null ) throw new IllegalArgumentException("Strategy cannot be constructed with null domain");
        if ( objective == null ) throw new IllegalArgumentException("Strategy cannot be constructed with null objective");

        this.domain = domain;
        this.objective = objective;

    }



    ///// ACCESSORS /////

    @Override
    public Domain<S> getDomain() { return domain; }


    @Override
    public Objective<S, R> getObjective() { return objective; }


    @Override
    public S bestSolution() { return bestSolution; }


    @Override
    public R bestResult() { return bestResult; }



    ///// HELPER METHODS /////

    /**
     * Wraps the evaluation of solutions by the objective. This method updates
     * the current best solution and result if the new result is better than
     * the current one.
     *
     * Formally, if the curent best solution <code>s1</code> and candidate
     * solution <code>s2</code> evaluate to results <code>r1</code> and
     * <code>r2</code> respectively, <code>s2</code> will replace
     * <code>s1</code> iff <code>r2.compareTo(r1)</code> is not positive.
     *
     * @param solution  candidate solution
     * @return the evaluation result
     */
    protected R evaluate(S solution) {

        R result = objective.evaluate(solution);

        if (( result != null ) && (( bestResult == null ) || ( result.compareTo(bestResult) <= 0 ))) {
            bestSolution = solution;
            bestResult = result;
        }

        return result;

    }

}
