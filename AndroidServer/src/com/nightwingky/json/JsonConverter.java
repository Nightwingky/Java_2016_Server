package com.nightwingky.json;

import net.sf.json.JSONArray;

import java.util.List;

/**
 * Created by nightwingky on 16-12-31.
 */
public class JsonConverter {

    public static String convert(Object object) {
        JSONArray jsonArray = JSONArray.fromObject(object);

        String jsonString = "{\"status\":1,\"data\":" + jsonArray.toString() + ",\"msg\":\"android\"}";

        return jsonString;
    }

    public static String convert(List list) {
        JSONArray jsonArray = JSONArray.fromObject(list);

        String jsonString = "{\"status\":1,\"data\":" + jsonArray.toString() + ",\"msg\":\"android\"}";

        return jsonString;
    }
}
