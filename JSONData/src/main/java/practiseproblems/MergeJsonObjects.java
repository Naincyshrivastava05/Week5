package practiseproblems;

package com.practiceproblems.json;
import org.json.JSONObject;

public class MergeJsonObjects {
    public static void main(String[] args) {
        JSONObject json1 = new JSONObject();
        json1.put("name", "Abhishek Kumar");
        json1.put("email", "abhishek@example.com");

        JSONObject json2 = new JSONObject();
        json2.put("age", 25);
        json2.put("city", "Bhopal");

        JSONObject mergedJson = new JSONObject(json1, JSONObject.getNames(json1));
        for (String key : JSONObject.getNames(json2)) {
            mergedJson.put(key, json2.get(key));
        }

        System.out.println(mergedJson.toString(2));
    }
}
