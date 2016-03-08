import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by JINSHENGJIE on 2016/2/23 with IDEA.
 */
public class SearchForMostOccurence {

    /**
     * 找出英文短文里出现最高频率的单词同时把出现的频率次数也计算出来，请编程把printWordAndFrequecy补充完整并打印出如下预期结果：
     *
     * 单词【a】出现频率最高，频率是【5】次
     */
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("Every human being has a basic instinct, to help each other out. ")
                .append("If a hiker gets lost in the mountains, people will coordinate a search. ")
                .append("If a train crashes, people will line up to give blood. ")
                .append("If an earthquake levels a city, people all over the world will send emergency supplies. ")
                .append("This is so fundamentally human that it is found in every culture without exception. ")
                .append("Yes, there are assholes who just do not care, ")
                .append("but they are massively outnumbered by the people who do.");
        String test = "aaaaaa dgsdggsg kkkkkk";
        printCharAndFrequecy(builder.toString());
        System.out.println("===================================");
        printCharAndFrequecy(test);

        printMostWords(builder.toString());
        String[] strArray = builder.toString().split("\\W+");
        for (int i = 0;i<strArray.length;i++) {
            System.out.println(strArray[i]);
        }
    }

    /**找出一段字符串中出现次数最多的单词，出现最多次数相同的单词同时列出
     * @param s
     */
    private static void printMostWords(String s) {
        String strPattern = "\\w+";// \\w{1} 可分割出单个字符！！！
        Pattern pattern = Pattern.compile(strPattern);
        Matcher matcher = pattern.matcher(s);
        List<String> list = new ArrayList<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        while (matcher.find()) {
//            System.out.println(matcher.group());
            list.add(matcher.group());
        }
        for(String str :list){
            if(map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            }else {
                map.put(str, 1);
            }
        }
        System.out.println(map);
        try {
            List<Map.Entry> mapE =  getMaxKeyValue2(map);
            for(Map.Entry mapEntry:mapE){
                System.out.println(mapEntry.getKey()+"====####====>"+mapEntry.getValue());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 找出出现次数最多的字符，出现最多次数相同的字符同时列出
     * @param str
     */
    /*
     * @param str
     */
    public static void printCharAndFrequecy(String str) {
        // TODO
       /* String strPattern = "[a-zA-Z]{1}";
        Pattern pattern = Pattern.compile(strPattern);*/
        Map map = new HashMap<String,Integer>();
        char[] charArray = str.toLowerCase().toCharArray();
        for (int i = 0; i <charArray.length ; i++) {
            if(Character.isLetter(charArray[i])){
                if(map.containsKey(charArray[i])){
                   int value =  (Integer)map.get(charArray[i]);
                    map.put(charArray[i],value+1);
                }else {
                    map.put(charArray[i],1);
                }
            }
        }
        System.out.println(map);
        Map.Entry maxValueMap = getMaxKeyValue(map);
        System.out.println(maxValueMap.getKey() + "----" + maxValueMap.getValue());

        System.out.println(map);
        List<Map.Entry> listMapEntry = getMaxKeyValue2(map);
        for(Map.Entry mapEntry:listMapEntry){
            System.out.println(mapEntry.getKey()+"====>"+mapEntry.getValue());
        }

    }

    /**找出value值最大的key-->value,最后的结果只有一对，不完美
     * @param map
     * @return
     */
    private static Map.Entry getMaxKeyValue(Map map) {
        Map.Entry maxMap = null;

        if(map ==null){
                return  null;
            }else {
                int maxValue = 0;

                Set<Map.Entry<String, Integer>> mapEntrySet = (Set<Map.Entry<String, Integer>>) map.entrySet();
                Iterator iterator = mapEntrySet.iterator();
                while (iterator.hasNext()) {
                    Map.Entry mapEntry = (Map.Entry) iterator.next();
                    int value2 =  Integer.parseInt(mapEntry.getValue().toString());
                    if(value2>maxValue){
                        maxValue =value2;
                        maxMap = mapEntry;
                    }

                }
            }

        return maxMap;
    }


    /**找出value值最大的key-->value,可以列出最大value相同的key-->value
     * @param map
     * @return
     * @throws IllegalArgumentException
     */
    private static List<Map.Entry> getMaxKeyValue2(Map map) throws IllegalArgumentException{
        List<Map.Entry> listMaxMap = new ArrayList<Map.Entry>();

        if(map ==null){
            throw new IllegalArgumentException("传入参数异常！");
        }else {
            int maxValue = 0;

            Set<Map.Entry<String, Integer>> mapEntrySet = (Set<Map.Entry<String, Integer>>) map.entrySet();
            Iterator iterator = mapEntrySet.iterator();
            while (iterator.hasNext()) {
                Map.Entry mapEntry = (Map.Entry) iterator.next();
                int value2 =  Integer.parseInt(mapEntry.getValue().toString());
                if(value2>maxValue){
                    maxValue =value2;
                    listMaxMap.clear();
                    listMaxMap.add(mapEntry);
                }else if(value2 == maxValue) {
                    listMaxMap.add(mapEntry);
                }

            }
        }

        return listMaxMap;
    }
}
