package service;

import java.util.HashMap;
import java.util.Map;

public class Ajax {
    public static Map<String,Object> successResponse (Object object){
        Map<String,Object> response = new HashMap<String,Object>();
        response.put("result","success");
        response.put("data",object);
        return response;
    }

    public static Map<String,Object> emptyResponse (){
        Map<String,Object> response = new HashMap<String,Object>();
        response.put("result","success");
        return response;
    }

    public static Map<String,Object> errorResponse (Object object){
        Map<String,Object> response = new HashMap<String,Object>();
        response.put("result","error");
        response.put("message",object);
        return response;
    }

}
