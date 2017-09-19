package com.zrx.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * @author 张日雄
 * @date 2017-09-08 0:28
 * @since 1.0
 */
public class YnJsonUtils {
    private static final Logger logger = LoggerFactory
            .getLogger(YnJsonUtils.class);

    private YnJsonUtils() {
    }

    /**
     * ObjectMapper 提供单例供全局使用
     */
    private static class SingletonHolder {
        private static ObjectMapper mapper;
        static {
            mapper = new ObjectMapper();
            mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
                    Locale.CHINESE));
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            // 忽略在JSON字符串中存在但Java对象实际没有的属性
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        }
    }

    public static ObjectMapper getMapper() {
        return SingletonHolder.mapper;
    }

    /** Json转换字符串 */
    public static String toJsonString(Object pojo) {
        try {
            return getMapper().writeValueAsString(pojo);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    /** 字符串转换Json */
    public static JsonNode parseJson(String input) {
        try {
            return getMapper().readTree(input);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    /** 字符串转换对象 */
    public static <T> T jsonToObject(String jsonString, Class<T> valueType)
            throws IOException {
        return (T) getMapper().readValue(jsonString, valueType);
    }

    /**
     * 将json字符串转为集合类型 List、Map等
     *
     * @param jsonStr
     *            json字符串
     * @param collectionClass
     *            集合类型
     * @param elementClasses
     *            泛型类型
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    public static <T> T jsonToObject(String jsonStr, Class<?> collectionClass,
                                     Class<?>... elementClasses) throws IOException {
        JavaType javaType = getMapper().getTypeFactory()
                .constructParametricType(collectionClass, elementClasses);
        return getMapper().readValue(jsonStr, javaType);
    }

    public static ObjectNode createObjectNode() {
        return getMapper().createObjectNode();
    }

    public static ArrayNode createArrayNode() {
        return getMapper().createArrayNode();
    }

    /**
     * 根据json字符以及给定的key，获取对应的value
     *
     * @param json
     * @param key
     * @return
     */
    public static JsonNode getJsonValue(String json, String key) {
        JsonNode jsonNode = parseJson(json);
        return jsonNode.get(key);
    }

    /**
     * 根据json字符、指定的外层key、外层key中的key获取外层key中的key对应的value（这么拗口）
     * String json ="{\"Code\":1000,\"DataList\":[{\"Rate\":0,\"Time\":\"2015-08-06 17:11:09\"}]}"
     * JsonNode jsonStr = JsonUtil.getChildJsonValue(json, "DataList","Time");
     * 得到jsonStr = 2015-08-06 17:11:09
     * @param json
     * @param parent
     * @param child
     * @return
     */
    public static JsonNode getChildJsonValue(String json, String parent,
                                             String child) {
        // 判断待改进！！
        if (json == null || "".equals(json) || parent == null
                || "".equals(parent) || child == null || "".equals(child)) {
            return null;
        }
        JsonNode parentJson = getJsonValue(json, parent);
        if (parentJson != null) {
            String temp = parentJson.toString().substring(1,
                    (parentJson.toString().length() - 1));
            JsonNode childJsonNode = parseJson(temp);

            return childJsonNode.get(child);
        }
        return null;
    }
}
