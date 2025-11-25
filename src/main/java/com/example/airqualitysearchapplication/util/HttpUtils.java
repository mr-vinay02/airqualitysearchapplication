package com.example.airqualitysearchapplication.util;

import java.util.List;
import java.util.Map;

public class HttpUtils {

    public static Map<String, Object> getMap(Map<String, Object> source, String key) {
        Object value = source.get(key);
        if (value instanceof Map<?, ?> map) {
            return (Map<String, Object>) map;
        }
        return null;
    }

    public static List<Object> getList(Map<String, Object> source, String key) {
        Object value = source.get(key);
        if (value instanceof List<?> list) {
            return (List<Object>) list;
        }
        return null;
    }

    public static Double getDouble(Object value) {
        if (value == null) return null;
        if (value instanceof Number num) return num.doubleValue();
        try {
            return Double.parseDouble(value.toString());
        } catch (Exception e) {
            return null;
        }
    }

    public static Integer getInteger(Object value) {
        if (value == null) return null;
        if (value instanceof Number num) return num.intValue();
        try {
            return Integer.parseInt(value.toString());
        } catch (Exception e) {
            return null;
        }
    }

    public static Double getGeo(List<Double> geo, int index) {
        if (geo == null || geo.size() <= index) return null;
        return geo.get(index);
    }
}
