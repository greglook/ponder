/* ... */

package com.mvxcvi.ponder.example;


import com.mvxcvi.ponder.Condition;
import com.mvxcvi.ponder.condition.IterationCondition;
import com.mvxcvi.ponder.Result;
import com.mvxcvi.ponder.Search;
import com.mvxcvi.ponder.Strategy;
import com.mvxcvi.ponder.strategy.stochastic.RandomSearch;
import com.mvxcvi.ponder.util.StringUtils;

import java.util.Vector;


/**
 * ...
 *
 * @author Greg Look (greg@mvxcvi.com)
 */
public class Example {

    public static void main(String[] args) throws Exception {

        if ( args.length < 2 ) {
            System.out.println("Usage: <iterations> <dimension> [range] [offset...]");
            System.exit(1);
        }

        int iterations = Integer.parseInt(args[0]);
        int dimension = Integer.parseInt(args[1]);
        double range = ( args.length >= 3 ) ? Double.parseDouble(args[2]) : 1.0;

        Vector<Double> offset = null;
        if ( args.length > 3 ) {
            offset = new Vector<Double>(args.length - 3);
            for ( int i = 3; i < args.length; i++ ) offset.add(Double.parseDouble(args[i]));
        }

        System.out.printf("Searching %d-D vector space over [-%.2f, %.2f] with %d iterations\n", dimension, range, range, iterations);
        if ( offset != null ) System.out.printf("Objective is offset by [%s]\n", StringUtils.join(offset, ", ", "%6.2f"));

        RealVectorSpace domain = new RealVectorSpace(dimension, range);
        SumOfSquares objective = new SumOfSquares(offset);

        Strategy<Vector<Double>, Double> strategy = new RandomSearch<Vector<Double>, Double>(domain, objective);
        Condition<? super Vector<Double>, ? super Double> limit = new IterationCondition(iterations);

        Search<Vector<Double>, Double> search = new Search<Vector<Double>, Double>(strategy, limit) {

            @Override
            protected void onSearch(Result<Vector<Double>, Double> candidate) {
                if ( candidate == null ) {
                    System.out.printf("%3d) candidate null\n", iterations());
                } else {
                    System.out.printf("%3d) [%s] => %.2f vs %s\n", iterations(),
                        StringUtils.join(candidate.getVector(), ", ", "%6.2f"),
                        candidate.getValue(),
                        ( best == null ) ? "no best result" : String.format("best of %.2f", best.getValue()));
                }
            }

        };

        search.run();

        System.out.printf("Search completed in %d ms after %d iterations\n", search.elapsed(), search.iterations());

        Result<Vector<Double>, Double> result = search.getResult();

        if ( result == null ) {
            System.out.println("No result found!");
        } else {
            System.out.printf("Vector: [%s]\n", StringUtils.join(result.getVector(), ", ", "%.2f"));
            System.out.printf(" Value: %.2f\n", result.getValue());
        }

    }

}
