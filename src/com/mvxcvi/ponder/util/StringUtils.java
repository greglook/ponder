/* ... */

package com.mvxcvi.ponder.util;


import java.util.Collection;


/**
 * This class provides some static String-handling utilities.
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public final class StringUtils {

    /**
     * Joins the elements of a collection together into one string.
     *
     * @param collection  collection of elements
     * @param delimiter   string to insert between elements
     * @return joined string
     */
    public static String join(Collection<?> collection, String delimiter) {

        StringBuilder str = new StringBuilder();

        for ( Object element : collection ) {
            if ( str.length() > 0 ) str.append(delimiter);
            str.append(element.toString());
        }

        return str.toString();

    }

}
