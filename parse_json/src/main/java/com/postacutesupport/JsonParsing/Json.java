package com.postacutesupport.JsonParsing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {

    private static ObjectMapper objectMapper = getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper(){
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return defaultObjectMapper;
    }
    
    public static JsonNode parse(String src) throws JsonMappingException, JsonProcessingException{
        
        return objectMapper.readTree(src);


    }


    public static <A> A fromJson(JsonNode node, Class<A> classType) throws JsonProcessingException, IllegalArgumentException{

        return objectMapper.treeToValue(node, classType);

    }
}
