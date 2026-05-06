package org.java.client;

import java.util.Map;

public record HttpResponse<T> (int statusCode,Map<String,String> headers,String body){
//    public String getBody(){
//        ObjectMapper
//    }
}
