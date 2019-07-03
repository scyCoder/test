package com.scy.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Set;

/**
 * @Author: sunchuanyin
 * @Date: 2019/6/12 16:17
 */
public class FormatJson {

    /**
     * 新建JSONObjcet对象，用来存储转换后的数据
     */
    private JSONObject newJsonObjcet = new JSONObject();

    private String key = "";

    /**
     * 将多级的json串转成一级
     *
     * @param jsonObject
     */
    public void formatJson(JSONObject jsonObject) {

        // 获得第一级的key集合
        Set<String> firstKeys = jsonObject.keySet();
        for (String firstKey : firstKeys) {
            Object firstKeyValue = jsonObject.get(firstKey);
            /**
             *  第一级的key所对应的value有三种情况
             *      第一种：JSONObjcect对象
             *      第二种：JSONArray数组（集合）
             *      第三种：String字符串（数值）
             */
            // 判断value，确定是哪一种情况
            if (firstKeyValue instanceof JSONObject) {
                // value是JSONObjcet对象
                key = firstKey + "_";

                formatJson((JSONObject) firstKeyValue);

            } else if (firstKeyValue instanceof JSONArray) {
                // value是一个集合
            } else {
                // value是一个普通的字符串
                newJsonObjcet.put(key + firstKey, jsonObject.get(firstKey));

            }

        }
    }

    @Test
    public void helloTest() {
        String json = "{\n" +
                "    \"msg\": \"成功\",\n" +
                "    \"code\": 1000,\n" +
                "    \"data\": {\n" +
                "        \"score\": -1,\n" +
                "        \"phone\": \"13554946338\",\n" +
                "        \"service\": \"zxyh_huiyan18\",\n" +
                "        \"name\": \"蒋秋成\"\n" +
                "    },\n" +
                "    \"responseTimestamp\": 1529552080900\n" +
                "}";
        JSONObject jsonObject = JSONObject.parseObject(json);
        formatJson(jsonObject);
        System.out.println(newJsonObjcet.toJSONString());

    }

    public static void main(String[] args) {
        System.out.println("hello");
        try {
            System.out.println("world");
            int i = 1 / 0;
            System.out.println("hehe");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("111111");
    }
}
