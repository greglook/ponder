/* ... */

package com.mvxcvi.ponder.condition;


import com.mvxcvi.ponder.Condition;
import com.mvxcvi.ponder.Result;


/**
 * This condition is satisfied when the score passes a configured threshold
 * value.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public class ThresholdCondition<S extends Comparable<S>> implements Condition<Object, S> {

    /** The value threshold. */
    private final S threshold;

    /** Whether the score must be above (true) or below (false) the threshold. */
    private final boolean positive;

    /** The current value. */
    private S value = null;



    /**
     * Creates a new condition at the given threshold.
     *
     * @param threshold  value threshold
     * @param positive   true if the score must be above the threshold
     */
    public ThresholdCondition(S threshold, boolean positive) {

        if ( threshold == null ) throw new IllegalArgumentException("ThresholdCondition must be constructed with non-null threshold");

        this.threshold = threshold;
        this.positive = positive;

    }


    /**
     * Gets the threshold value for this condition.
     *
     * @return threshold value
     */
    public S getThreshold() { return threshold; }


    @Override
    public void update(Result<? extends Object, ? extends S> result) {

        value = result.getValue();

    }


    @Override
    public boolean satisfied() {

        if ( value == null ) return false;

        // negative if threshold < value
        // positive if threshold > value
        int comparison = threshold.compareTo(value);

        return positive ? ( comparison <= 0 ) : ( comparison >= 0 );

    }


    @Override
    public String toString() {

        return String.format("(value %s %s)", positive ? ">=" : "<=", threshold);

    }

}
