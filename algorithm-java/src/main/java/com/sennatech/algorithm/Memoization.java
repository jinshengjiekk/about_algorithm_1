package com.sennatech.algorithm;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StopWatch;

/**
 * <pre>
 * ===========================================
 * Memoization ensures that a function doesn't run for the same inputs more than once by keeping
 * a record of the results for given inputs (usually in an object).
 * Memoization is a common strategy for dynamic programming problems, which are problems where the solution is composed
 * of solutions to the same problem with smaller inputs (as with the fibonacci problem, above). The other common strategy
 * for dynamic programming problems is going bottom-up, which is usually cleaner and often more efficient.
 * ===========================================
 * </pre>
 *
 * @author Created by jinshengjie on 2016/10/19.
 */
public class Memoization {

    private Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        Memoization memoization = new Memoization();
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start("fibRecursive(bad)===>start");
        memoization.fibRecursive(15);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&\n");
        stopWatch.start("fib(good)===>start");
        memoization.fib(15);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    // bad
    private int fibRecursive(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        System.out.println("computing fibRecursive(" + n + ")");
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    // good
    private int fib(int n) {
        // edge case
        if (n < 0) {
            throw new IllegalArgumentException("Index was negative. No such thing as a negative index in a series.");

            // base cases
        } else if (n == 0 || n == 1) {
            return n;
        }

        // see if we've already calculated this
        if (memo.containsKey(n)) {
            System.out.println("grabbing memo[" + n + "]");
            return memo.get(n);
        }

        System.out.println("computing fib(" + n + ")");
        int result = fib(n - 1) + fib(n - 2);

        // memoize
        memo.put(n, result);

        return result;
    }

}
