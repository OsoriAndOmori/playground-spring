package com.osori.applicationbatch.ds;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class HashMapTest {
    @Test
    void name() {
        HashMap<String, String> map = new HashMap<>();
        map.put("test1", "test1");
        map.put("test2", "test1");
        map.put("test3", "test1");
        map.put("test4", "test1");
        map.put("test5", "test1");
        map.put("test6", "test1");
        map.put("test7", "test1");
        map.put("test8", "test1");
        map.put("test9", "test1");
        map.put("test10", "test1");
        map.put("test11", "test1");
        map.put("test12", "test1");
        map.put("test13", "test1");
        map.put("test14", "test1");
        map.put("test15", "test1");
        map.put("test16", "test1");
        map.put("test17", "test1");
        System.out.println(map);

        int a = 2 ^ 3;
        System.out.println(a);
    }

    @Test
    void name1() {
        MyMap<String, String> mymap = new MyMap<>();

        int test = MyMap.hash("test");
        System.out.println(test);
    }
}
