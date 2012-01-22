/* Copyright 2012 Greg Look. All rights reserved. */

package com.mvxcvi.ponder;


/**
 * This class provides a framework for executing a search with some condition
 * determinining when to stop searching.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public class Search<V, S> implements Runnable {

    ///// CONFIGURATION /////

    /** Strategy to search with. */
    protected final Strategy<V, S> strategy;

    /** Halting condition for search. */
    protected final Condition<? super V, ? super S> condition;



    ///// VARIABLES /////

    /** Current best result found. */
    protected Result<V, S> best = null;

    /** Number of search iterations run. */
    protected int iterations = 0;

    /** Milliseconds spent searching. */
    protected long elapsed = 0L;



    ///// INITIALIZATION /////

    /**
     * Creates a new search.
     *
     * @param strategy   strategy to search with
     * @param condition  halting condition for search
     */
    public Search(Strategy<V, S> strategy, Condition<? super V, ? super S> condition) {

        if ( strategy  == null ) throw new IllegalArgumentException("Search cannot be constructed with null strategy");
        if ( condition == null ) throw new IllegalArgumentException("Search cannot be constructed with null condition");

        this.strategy = strategy;
        this.condition = condition;

    }



    ///// ACCESSORS /////

    /**
     * Gets the current best result found.
     *
     * @return best search result
     */
    public Result<V, S> getResult() { return best; }


    /**
     * Gets the number of iterations of searching.
     *
     * @return times search was called
     */
    public int iterations() { return iterations; }


    /**
     * Gets the number of milliseconds spent searching.
     *
     * @return milliseconds elapsed
     */
    public long elapsed() { return elapsed; }



    ///// SEARCH METHODS /////

    /**
     * Runs the search.
     */
    @Override
    public void run() {

        while ( !condition.satisfied() ) {

            long start = System.currentTimeMillis();

            Result<V, S> candidate = strategy.search();
            onSearch(candidate);

            pickBest(candidate);
            condition.update(best);

            elapsed += System.currentTimeMillis() - start;
            iterations++;

        }

    }



    ///// HELPER METHODS /////

    /**
     * This method provides an internal hook for overriding classes to perform
     * some code on each search iteration.
     */
    protected void onSearch(Result<V, S> candidate) {

        // no-op unless overridden

    }


    /**
     * Determines whether the candidate result should replace the current best
     * result stored. By default, result values are treated as a cost function
     * and this method will attempt to minimize them.
     *
     * This method may be overridden to provide custom selection criteria.
     *
     * @param candidate  candidate result
     */
    protected synchronized void pickBest(Result<V, S> candidate) {

        if ( candidate == null ) return;

        if (( best == null ) || ( candidate.compareTo(best) <= 0 )) {
            best = candidate;
        }
    }

}
