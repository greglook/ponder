/* Copyright 2012 Greg Look. All rights reserved. */

package com.mvxcvi.ponder.condition;


import com.mvxcvi.ponder.Condition;
import com.mvxcvi.ponder.Result;


/**
 * This condition is satisfied when the score passes a configured threshold
 * value.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public class ThresholdCondition<Y extends Comparable<Y>> implements Condition<Object, Y> {

    ///// CONFIGURATION /////

    /** The value threshold. */
    private final Y threshold;

    /** Whether the value must be above (true) or below (false) the threshold. */
    private final boolean positive;



    ///// PROPERTIES /////

    /** The current value. */
    private Y value = null;



    ///// INITIALIZATION /////

    /**
     * Creates a new condition at the given threshold.
     *
     * @param threshold  value threshold
     * @param positive   true if the score must be above the threshold
     */
    public ThresholdCondition(Y threshold, boolean positive) {

        if ( threshold == null ) throw new IllegalArgumentException("ThresholdCondition must be constructed with non-null threshold");

        this.threshold = threshold;
        this.positive = positive;

    }



    ///// ACCESSORS /////

    /**
     * Gets the threshold value for this condition.
     *
     * @return threshold value
     */
    public Y getThreshold() { return threshold; }


    /**
     * Gets the current value used by this condition.
     *
     * @return last updated value
     */
    public Y currentValue() { return value; }



    ///// CONDITION METHODS /////

    @Override
    public void update(Result<? extends Object, ? extends Y> result) {

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

        return String.format("(%1$sthreshold%1$s | %s %s %s)",
            value, positive ? ">=" : "<=", threshold);

    }

}
