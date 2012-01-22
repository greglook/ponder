/* ... */

package com.mvxcvi.ponder.condition;


import com.mvxcvi.ponder.Condition;
import com.mvxcvi.ponder.Result;
import com.mvxcvi.ponder.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


/**
 * This condition requires that multiple sub-conditions be satisfied.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public class AndCondition<V, S> implements Condition<V, S> {

    /** The set of sub-conditions. */
    private final List<Condition<? super V, ? super S>> conditions;



    /**
     * Creates an intersection from the given conditions.
     *
     * @param conditions  collection of conditions
     */
    public AndCondition(Collection<Condition<? super V, ? super S>> conditions) {

        if ( conditions == null ) throw new IllegalArgumentException("AndCondition must be constructed with non-null subconditions");
        if ( conditions.isEmpty() ) throw new IllegalArgumentException("AndCondition must be constructed with non-empty subconditions");

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
            if ( !condition.satisfied() ) return false;
        }

        return true;

    }


    @Override
    public String toString() {

        return StringUtils.join(conditions, " and ");

    }

}
