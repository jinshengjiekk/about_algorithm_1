package java_example;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JINSHENGJIE on 16/10/15 14:12.
 * ===================================================================
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * ===================================================================
 */
public class RomanToInteger {

    public int romanToIn(String s) {
        int length = s.length();
        if (s == null || length == 0) {
            return 0;
        }
        Map<Character, Integer> m = new HashMap<>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

//从后向前遍历，根据相对大小来判断，结果正确。
        int result = m.get(s.charAt(length - 1));
        for (int i = length - 2; i >= 0; i--) {
            if (m.get(s.charAt(i)) >= m.get(s.charAt(i + 1))) {
                result += m.get(s.charAt(i));
            } else {
                result -= m.get(s.charAt(i));
            }
        }

// 通过从前向后遍历，比较相对大小来判断，结果不正确。
/*
        int result = m.get(s.charAt(0));
        for (int i = 1; i < length; i++) {
            if (m.get(s.charAt(i)) <= m.get(s.charAt(i - 1))) {
                result += m.get(s.charAt(i));
            } else {
                result -= m.get(s.charAt(i));
            }
        }
*/

        return result;
    }

    public static void main(String[] args) {
        String roman1 = "VIII";
        String roman2 = "XIV";

        RomanToInteger rti = new RomanToInteger();
        System.out.println(rti.romanToIn(roman1));
        System.out.println(rti.romanToIn(roman2));

    }
}
