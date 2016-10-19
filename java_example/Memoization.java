package java_example;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jinshengjie on 2016/10/19.
 * <p>
 * ===========================================
 * Memoization ensures that a function doesn't run for the same inputs more than once by keeping
 * a record of the results for given inputs (usually in an object).
 * <p>
 * Memoization is a common strategy for dynamic programming problems, which are problems where the solution is composed
 * of solutions to the same problem with smaller inputs (as with the fibonacci problem, above). The other common strategy
 * for dynamic programming problems is going bottom-up, which is usually cleaner and often more efficient.
 * ===========================================
 */
public class Memoization {
    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        Memoization memoization = new Memoization();
        System.out.println("fibRecursive(bad)===>start");
        long start1 = new Date().getTime();
        memoization.fibRecursive(25);
        System.out.println("fibRecursive(bad)===>end, Time-consuming = " + (new Date().getTime() - start1) + "ms");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("fib(good)===>start");
        long start2 = new Date().getTime();
        memoization.fib(25);
        System.out.println("fib(good)===>end, Time-consuming = " + (new Date().getTime() - start2) + "ms");
    }

    // bad
    public int fibRecursive(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        System.out.println("computing fibRecursive(" + n + ")");
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    //**********************************************************************************************
    // good
    public int fib(int n) {

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
