package com.practiceproblems.json;
import org.junit.jupiter.api.Test;
import practiseproblems.CreateJsonObject;

import static org.junit.jupiter.api.Assertions.*;

class CreateJsonObjectTest {

    @Test
    void testJsonObjectCreation() {
        String ans="{\"subject\":[\"Java\",\"Hindi\",\"Science\"],\"name\":\"Alice\",\"age\":25}";
        assertEquals(CreateJsonObject.createJsonObject(),ans);
    }
}