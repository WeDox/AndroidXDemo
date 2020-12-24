package com.onedream.androidxdemo.framework.utils.json_parse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author jdallen
 * @since 2020/11/5
 */
public class JsonToMapHelper {

    private JsonToMapHelper() {

    }

    public static Map<String, String> setMap(Map<String, String> map1, Map<String, String> map2) {
        if (map2 == null) {
            map2 = new HashMap();
        }
        for (String key : map1.keySet()) {
            String value = (String) map1.get(key);
            map2.put(key, value);
        }
        return map2;
    }

    public static final Map<String, String> jsonToMap(JSONObject jsonObj) {
        Map map = new HashMap();
        Iterator keys = jsonObj.keys();
        JSONObject jo = null;
        JSONArray ja = null;

        while (keys.hasNext()) {
            String key = (String) keys.next();
            try {
                Object o = jsonObj.get(key);
                if ((o instanceof String)) {
                    map.put(key, (String) o);
                } else if ((o instanceof JSONObject)) {
                    jo = (JSONObject) o;
                    if (jo.keys().hasNext())
                        map = setMap(jsonToMap(jo), map);
                } else if ((o instanceof JSONArray)) {
                    ja = (JSONArray) o;
                    for (int i = 0; i < ja.length(); i++) {
                        jo = ja.getJSONObject(i);
                        if (jo.keys().hasNext())
                            map = setMap(jsonToMap(jo), map);
                    }
                } else {
                    map.put(key, o);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        return map;
    }
}
