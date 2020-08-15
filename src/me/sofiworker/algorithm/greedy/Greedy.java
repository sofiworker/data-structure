package me.sofiworker.algorithm.greedy;

import java.util.*;

/**
 * @author sofiworker
 * @date 2020/8/15
 * 贪婪算法 - 集合覆盖问题
 */
public class Greedy {

    public static void main(String[] args) {
        // 创建
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        HashSet<String> set1 = new HashSet<>();
        set1.add("北京");
        set1.add("上海");
        set1.add("天津");

        HashSet<String> set2 = new HashSet<>();
        set2.add("广州");
        set2.add("北京");
        set2.add("深圳");

        HashSet<String> set3 = new HashSet<>();
        set3.add("成都");
        set3.add("上海");
        set3.add("杭州");

        HashSet<String> set4 = new HashSet<>();
        set4.add("上海");
        set4.add("天津");

        HashSet<String> set5 = new HashSet<>();
        set5.add("杭州");
        set5.add("大连");

        broadcasts.put("k1", set1);
        broadcasts.put("k2", set2);
        broadcasts.put("k3", set3);
        broadcasts.put("k4", set4);
        broadcasts.put("k5", set5);

        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        List<String> selects = new ArrayList<>();
        HashSet<String> tempSet = new HashSet<>();
        String maxKey;

        while (!allAreas.isEmpty()) {
            maxKey = null;
            for (String key : broadcasts.keySet()) {
                tempSet.clear();
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                // 求交集
                tempSet.retainAll(allAreas);
                if (tempSet.size() > 0 &&
                        (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())) {
                    maxKey = key;
                }
            }
            if (maxKey != null) {
                selects.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }

        System.out.println(selects);
    }
}
