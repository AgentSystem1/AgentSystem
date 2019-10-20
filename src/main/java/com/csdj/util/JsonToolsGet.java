package com.csdj.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * layui的Json数据封装
 */
public class JsonToolsGet {

    private static Map<String,Object> jsonMap = new HashMap<>();

    public static Map<String,Object> jsonData(int count, List<?> data){
        jsonMap.put("code",0);
        jsonMap.put("msg","");
        jsonMap.put("count",count);
        jsonMap.put("data",data);
        return jsonMap;
    }

    public Map<String, Object> getJsonMap() {
        return jsonMap;
    }
    public void setJsonMap(Map<String, Object> jsonMap) {
        this.jsonMap = jsonMap;
    }

}
