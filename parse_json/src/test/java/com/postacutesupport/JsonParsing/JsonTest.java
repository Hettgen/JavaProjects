package com.postacutesupport.JsonParsing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.postacutesupport.JsonParsing.pojo.SimpleTestCaseJson;

public class JsonTest {

    private String firstTestCaseJsonSource = "{ \"title\": \"Coder From Scratch\", \"author\": \"Stefan\"}";


    @Test
    void testParse() throws JsonMappingException, JsonProcessingException {

        JsonNode node = Json.parse(firstTestCaseJsonSource);

        assertEquals(node.get("title").asText(), "Coder From Scratch");
    }

    @Test
    public void fromJson() throws JsonProcessingException, IllegalArgumentException{

        JsonNode node = Json.parse(firstTestCaseJsonSource);
        SimpleTestCaseJson testCase1 = Json.fromJson(node, SimpleTestCaseJson.class);

        System.out.println("testCase1 title" + testCase1.title);
    }
}


