/* ... */

package com.mvxcvi.ponder.example;


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
        if ( offset != null ) System.out.printf("Objective is offset by [%s]\n", StringUtils.join(offset, ", ", "%.2f"));

        RealVectorSpace domain = new RealVectorSpace(dimension, range);
        SumOfSquares objective = new SumOfSquares(offset);

        Strategy<Vector<Double>, Double> strategy = new RandomSearch<Vector<Double>, Double>(domain, objective, iterations);

        long start = System.currentTimeMillis();

        int iteration = 0;
        while ( !strategy.isDone() ) {
            strategy.search();
            iteration++;
            //System.out.printf("%3d) [%s] => %.2f\n", iteration, StringUtils.join(strategy.bestSolution(), ", ", "%.2f"), strategy.bestResult());
        }

        long elapsed = System.currentTimeMillis() - start;

        System.out.printf("Search completed in %d ms:\n", elapsed);

        if ( strategy.bestSolution() == null ) {
            System.out.println("No solution found!");
        } else {
            System.out.printf("Solution: [%s]\n", StringUtils.join(strategy.bestSolution(), ", ", "%.2f"));
            System.out.printf("Result: %.2f\n", strategy.bestResult());
        }

    }

}
