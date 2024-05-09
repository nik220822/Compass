package com.nicode.cardinaldirections.model;

import java.util.HashMap;
import java.util.Map;

public class Compass {
    private static Map<String, String> compassMap = new HashMap<>();
    private static final Compass instance = new Compass();

    public static Compass getInstance() {
        return instance;
    }

    public Map<String, String> getCompassMap() {
        return compassMap;
    }

    public void setCompassMap(Map<String, String> map) {
        compassMap = map;
    }

    public String getSide(String degree) {
        int degreeInt = Integer.parseInt(degree);
        int start;
        int end;
        for (String key : compassMap.keySet()) {
            start = Integer.parseInt(compassMap.get(key).split("-")[0]);
            end = Integer.parseInt(compassMap.get(key).split("-")[1]);
            if (degreeInt >= start && degreeInt <= end) {
                return key;
            }
        }
        return "No side with this coordinate was found";
    }
}
