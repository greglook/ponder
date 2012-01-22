/* ... */

package com.mvxcvi.ponder;


/**
 * This is a simple class to pair up solution vectors and their evaluation
 * results.
 *
 * Solutions are immutable once created.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public class Result<V, S> implements Comparable<Result<V, S>> {

    /** Parent objective function. */
    private final Objective<V, S> objective;

    /** Search vector. */
    private final V vector;

    /** Solution result. */
    private final S value;



    /**
     * Creates a new result pair.
     *
     * @param objective  objective function
     * @param vector     search vector
     */
    public Result(Objective<V, S> objective, V vector) {

        if ( objective == null ) throw new IllegalArgumentException("Result cannot be created with null objective");
        if ( vector    == null ) throw new IllegalArgumentException("Result cannot be created with null vector");

        this.objective = objective;
        this.vector = vector;
        this.value = objective.evaluate(vector);

    }



    ///// ACCESSORS /////

    /**
     * Returns the objective function which measured this rersult.
     *
     * @return objective function
     */
    public Objective<V, S> getObjective() { return objective; }


    /**
     * Returns this result's search vector.
     *
     * @return search vector
     */
    public V getVector() { return vector; }


    /**
     * Returns this result's value.
     *
     * @return solution value
     */
    public S getValue() { return value; }


    @Override
    public int compareTo(Result<V, S> other) {

        if ( other == this ) return 0;
        if ( objective != other.getObjective() ) throw new IllegalArgumentException("Cannot compare two results with different objective functions");

        return objective.compare(value, other.getValue());

    }

}
