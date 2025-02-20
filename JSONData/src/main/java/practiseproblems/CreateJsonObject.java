package practiseproblems;

package com.practiceproblems.json;
import org.json.JSONArray;
import org.json.JSONObject;


public class CreateJsonObject {
    public static void main(String[] args) {
        System.out.println(createJsonObject());
    }
    public static String createJsonObject(){
        JSONArray subject = new JSONArray();
        subject.put("Java");
        subject.put("Hindi");
        subject.put("Science");

        JSONObject student = new JSONObject();
        student.put("name", "Naincy");
        student.put("age", 25);
        student.put("subject", subject);

        return student.toString();
    }
}

