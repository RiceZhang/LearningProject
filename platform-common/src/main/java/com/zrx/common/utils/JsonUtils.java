package com.zrx.common.utils;

import java.util.Map;

import com.zrx.common.exceptions.BizException;
import org.apache.commons.lang3.StringUtils;
import com.alibaba.fastjson.JSON;


/**
 * @author 张日雄
 * @date 2017-09-08 0:20
 * @since 1.0
 */
public class JsonUtils {
    /**
     * 检查接口传入json参数是否正确统一check方法
     *
     * @param data
     *            json字符串数据
     * @return
     */
    public static Map<String, Object> checkJsonData(String data) {
        if (StringUtils.isBlank(data)) {
            throw BizException.JSON_PARAM_IS_NULL;
        }
        try {
            @SuppressWarnings("unchecked")
            Map<String, Object> dataMap = (Map<String, Object>) JSON.parse(data);
            return dataMap;
        } catch (Exception e) {
            throw BizException.JSON_PARAM_FORMAT_ERROR;
        }
    }

    public static String toJson(Object obj) {
        if (obj == null) {
            throw BizException.JSON_PARAM_IS_NULL;
        }
        try {
            return JSON.toJSONString(obj);
        } catch (Exception e) {
            throw BizException.JSON_PARAM_FORMAT_ERROR;
        }
    }
}
