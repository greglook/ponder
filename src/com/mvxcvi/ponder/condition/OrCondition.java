/* ... */

package com.mvxcvi.ponder.condition;


import com.mvxcvi.ponder.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


/**
 * This condition requires that one of multiple sub-conditions be satisfied.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public class OrCondition implements Condition {

    /** The set of sub-conditions. */
    private final List<Condition> conditions;



    /**
     * Creates a union from the given conditions.
     *
     * @param conditions  collection of conditions
     */
    public OrCondition(Collection<Condition> conditions) {

        if ( conditions == null ) throw new IllegalArgumentException("Property 'conditions' must not be null");
        if ( conditions.isEmpty() ) throw new IllegalArgumentException("Property 'conditions' must not be empty");

        this.conditions = Collections.unmodifiableList(new ArrayList<Condition>(conditions));

    }


    /**
     * Gets the list of subconditions.
     *
     * @return subconditions
     */
    public List<Condition> getConditions() { return conditions; }


    @Override
    public void update(double score) {

        for ( Condition condition : conditions ) {
            condition.update(score);
        }

    }


    @Override
    public boolean satisfied() {

        for ( Condition condition : conditions ) {
            if ( condition.satisfied() ) return true;
        }

        return false;

    }


    @Override
    public String toString() {

        return StringUtils.join(conditions, " or ");

    }

}
