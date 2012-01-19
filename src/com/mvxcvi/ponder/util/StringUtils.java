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

        return join(collection, delimiter, "%s");

    }


    /**
     * Joins the elements of a collection together into one string with some
     * format string.
     *
     * @param collection  collection of elements
     * @param delimiter   string to insert between elements
     * @param format      format string for elements
     * @return joined string
     */
    public static String join(Collection<?> collection, String delimiter, String format) {

        StringBuilder str = new StringBuilder();

        for ( Object element : collection ) {
            if ( str.length() > 0 ) str.append(delimiter);
            str.append(String.format(format, element));
        }

        return str.toString();

    }

}
