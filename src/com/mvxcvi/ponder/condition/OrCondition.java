/* Copyright 2012 Greg Look. All rights reserved. */

package com.mvxcvi.ponder.condition;


import com.mvxcvi.ponder.Condition;
import com.mvxcvi.ponder.Result;
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
public class OrCondition<V, S> implements Condition<V, S> {

    /** The set of sub-conditions. */
    private final List<Condition<? super V, ? super S>> conditions;



    /**
     * Creates a union from the given conditions.
     *
     * @param conditions  collection of conditions
     */
    public OrCondition(Collection<Condition<? super V, ? super S>> conditions) {

        if ( conditions == null ) throw new IllegalArgumentException("OrCondition must be constructed with non-null subconditions");
        if ( conditions.isEmpty() ) throw new IllegalArgumentException("OrCondition must be constructed with non-empty subconditions");

        this.conditions = Collections.unmodifiableList(new ArrayList<Condition<? super V, ? super S>>(conditions));

    }


    /**
     * Gets the list of subconditions.
     *
     * @return subconditions
     */
    public List<Condition<? super V, ? super S>> getConditions() { return conditions; }


    @Override
    public void update(Result<? extends V, ? extends S> result) {

        for ( Condition<? super V, ? super S> condition : conditions ) {
            condition.update(result);
        }

    }


    @Override
    public boolean satisfied() {

        for ( Condition<? super V, ? super S> condition : conditions ) {
            if ( condition.satisfied() ) return true;
        }

        return false;

    }


    @Override
    public String toString() {

        return StringUtils.join(conditions, " or ");

    }

}
