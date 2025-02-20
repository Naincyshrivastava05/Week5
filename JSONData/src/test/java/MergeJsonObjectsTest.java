package com.practiceproblems.json;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MergeJsonObjectsTest {

    @Test
    void testJsonMerge() {
        JSONObject json1 = new JSONObject();
        json1.put("name", "Naincy Shrivastava");
        json1.put("email", "naincy123@gmail.com");

        JSONObject json2 = new JSONObject();
        json2.put("age", 25);
        json2.put("city", "Bhopal");

        JSONObject mergedJson = new JSONObject(json1, JSONObject.getNames(json1));
        for (String key : JSONObject.getNames(json2)) {
            mergedJson.put(key, json2.get(key));
        }

        assertEquals("Naincy Shrivastava", mergedJson.getString("name"));
        assertEquals("naincy123@gmail.com", mergedJson.getString("email"));
        assertEquals(25, mergedJson.getInt("age"));
        assertEquals("Bhopal", mergedJson.getString("city"));
        assertEquals(4, mergedJson.length());
    }
}