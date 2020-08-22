package com.sennatech.algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

/**
 * ========================================
 * <pre>
 * Bottom-Up Algorithms
 * Going bottom-up is a way to avoid recursion, saving the memory cost that recursion incurs when it builds up the call stack.
 * Put simply, a bottom-up algorithm "starts from the beginning," while a recursive algorithm often "starts from
 * the end and works backwards."
 * </pre>
 * ========================================
 * <pre>
 * Going bottom-up is a common strategy for dynamic programming problems, which are problems where the solution is
 * composed of solutions to the same problem with smaller inputs (as with the fibonacci problem).
 * The other common strategy for dynamic programming problems is memoization.
 * </pre>
 *
 * @author Created by jinshengjie on 2016/10/22.
 */
public class BottomUp {

    private static final Logger logger = LoggerFactory.getLogger(BottomUp.class);

    public static void main(String[] args) {
        BottomUp bu = new BottomUp();
        final StopWatch watch = new StopWatch();
        watch.start("product1ToN_1 time-consuming");
        try {
            bu.product1ToN_1(20000);
        } catch (StackOverflowError ex) {
            logger.info("StackOverflowError");
        }
        watch.stop();
        watch.start("product1ToN_2 time-consuming");
        bu.product1ToN_2(200000000);
        watch.stop();
        watch.prettyPrint();
    }


    /**
     *  == bad ==
     * <pre>
     * This approach has a problem: it builds up a call stack of size O(n)O, which makes our total memory cost O(n).
     * This makes it vulnerable to a stack overflow error, where the call stack gets too big and runs out of space.
     * </pre>
     */
    private int product1ToN_1(int n) {
        // we assume n >= 1
        return (n > 1) ? (n * product1ToN_1(n - 1)) : 1;
    }


    /**
     * == good==
     * <pre>
     * This approach uses O(1)O space (O(n) time).
     * Some compilers and interpreters will do what's called tail call optimization (TCO), where it can optimize some
     * recursive functions to avoid building up a tall call stack. Python and Java decidedly do not use TCO. Some Ruby
     * implementations do, but most don't. Some C implementations do, and the JavaScript spec recently allowed TCO.
     * Scheme is one of the few languages that guarantee TCO in all implementations.
     * In general, best not to assume your compiler/interpreter will do this work for you.
     * </pre>
     */
    private int product1ToN_2(int n) {
        // we assume n >= 1

        int result = 1;
        for (int num = 1; num <= n; num++) {
            result *= num;
        }
        return result;
    }

}
