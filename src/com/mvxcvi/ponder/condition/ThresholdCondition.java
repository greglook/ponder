/* ... */

package com.mvxcvi.ponder.condition;


/**
 * This condition is satisfied when the score passes a configured threshold
 * value.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public class ThresholdCondition implements Condition {

    /** The score value threshold. */
    private final double threshold;

    /** Whether the score must be above (true) or below (false) the threshold. */
    private final boolean positive;

    /** The current best score. */
    private double score = Double.NaN;



    /**
     * Creates a new condition at the given threshold.
     *
     * @param threshold  score threshold
     * @param positive   true if the score must be above the threshold
     */
    public ThresholdCondition(double threshold, boolean positive) {
        
        this.threshold = threshold;
        this.positive = positive;

    }


    /**
     * Gets the threshold value for this condition.
     *
     * @return threshold value
     */
    public double getThreshold() { return threshold; }


    @Override
    public void update(double score) {

        this.score = score;

    }


    @Override
    public boolean satisfied() {

        return positive ? ( score >= threshold ) : ( score <= threshold );

    }


    @Override
    public String toString() {

        return String.format("(score %s %f)", positive ? ">=" : "<=", threshold);

    }

}
