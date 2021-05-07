package com.zjq.aaademo.tools.json;

/**
 * Created  in 2021/4/27.
 */


import android.util.Log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class JsonUtils {
    private static final String TAG = "json";
    private static ObjectMapper objectMapper = new ObjectMapper();

    private JsonUtils() {
    }

    public static String toJson(Object value) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException var2) {
            Log.e(TAG, var2.getMessage());
            throw new JsonException(var2.getMessage());
        }
    }

    public static <T> T toObject(String json, Class<T> valueType) {
        Assert.notEmpty(json);
        Assert.notNull(valueType);
        try {
            return objectMapper.readValue(json, valueType);
        } catch (Exception var3) {
            Log.e(TAG, var3.getMessage());
            throw new JsonException(var3.getMessage());
        }
    }

    public static <T> T toObject(String json, TypeReference<?> typeReference) {
        Assert.notEmpty(json);
        Assert.notNull(typeReference);

        try {
            return objectMapper.readValue(json, typeReference);
        } catch (Exception var3) {
            Log.e(TAG, var3.getMessage());
            throw new JsonException(var3.getMessage());
        }
    }

    public static <T> T toObject(String json, JavaType javaType) {
        Assert.notEmpty(json);
        Assert.notNull(javaType);

        try {
            return objectMapper.readValue(json, javaType);
        } catch (Exception var3) {
            Log.e(TAG, var3.getMessage());
            throw new JsonException(var3.getMessage());
        }
    }

    public static <T> List<T> toList(String json, Class<T> clz) {
        Assert.notEmpty(json);
        Assert.notNull(clz);

        try {
            JavaType javaType = TypeFactory.defaultInstance().constructCollectionType(List.class, clz);
            return (List) objectMapper.readValue(json, javaType);
        } catch (Exception var3) {
            Log.e(TAG, var3.getMessage());
            throw new JsonException(var3.getMessage());
        }
    }

    public static <T, S> Map<T, S> toMap(String json, Class<T> keyClass, Class<S> valueClass) {
        Assert.notEmpty(json);
        Assert.notNull(keyClass);
        Assert.notNull(valueClass);

        try {
            JavaType javaType = TypeFactory.defaultInstance().constructMapType(HashMap.class, keyClass, valueClass);
            return (Map) objectMapper.readValue(json, javaType);
        } catch (Exception var4) {
            Log.e(TAG, var4.getMessage());
            throw new JsonException(var4.getMessage());
        }
    }

    public static Map<String, Object> toMap(String json) {
        Assert.notEmpty(json);

        try {
            JavaType javaType = TypeFactory.defaultInstance().constructMapType(HashMap.class, String.class, Object.class);
            return (Map) objectMapper.readValue(json, javaType);
        } catch (Exception var2) {
            Log.e(TAG, var2.getMessage());
            throw new JsonException(var2.getMessage());
        }
    }

    public static String getNode(String json, String fieldName) {
        Assert.notEmpty(json);
        Assert.notEmpty(fieldName);

        try {
            return objectMapper.readTree(json).get(fieldName).toString();
        } catch (Exception var3) {
            Log.e(TAG, var3.getMessage());
            throw new JsonException(var3.getMessage());
        }
    }

    public static String getNodeAsTxt(String json, String fieldName) {
        Assert.notEmpty(json);
        Assert.notEmpty(fieldName);

        try {
            return objectMapper.readTree(json).get(fieldName).asText();
        } catch (Exception var3) {
            Log.e(TAG, var3.getMessage());
            throw new JsonException(var3.getMessage());
        }
    }

    public static boolean getNodeAsBoolean(String json, String fieldName) {
        Assert.notEmpty(json);
        Assert.notEmpty(fieldName);

        try {
            return objectMapper.readTree(json).get(fieldName).asBoolean();
        } catch (Exception var3) {
            Log.e(TAG, var3.getMessage());
            throw new JsonException(var3.getMessage());
        }
    }

    public static double getNodeAsDouble(String json, String fieldName) {
        Assert.notEmpty(json);
        Assert.notEmpty(fieldName);

        try {
            return objectMapper.readTree(json).get(fieldName).asDouble();
        } catch (Exception var3) {
            Log.e(TAG, var3.getMessage());
            throw new JsonException(var3.getMessage());
        }
    }

    public static int getNodeAsInt(String json, String fieldName) {
        Assert.notEmpty(json);
        Assert.notEmpty(fieldName);

        try {
            return objectMapper.readTree(json).get(fieldName).asInt();
        } catch (Exception var3) {
            Log.e(TAG, var3.getMessage());
            throw new JsonException(var3.getMessage());
        }
    }

    public static long getNodeAsLong(String json, String fieldName) {
        Assert.notEmpty(json);
        Assert.notEmpty(fieldName);

        try {
            return objectMapper.readTree(json).get(fieldName).asLong();
        } catch (Exception var3) {
            Log.e(TAG, var3.getMessage());
            throw new JsonException(var3.getMessage());
        }
    }

    public static boolean has(String json, String fieldName) {
        Assert.notEmpty(json);
        Assert.notEmpty(fieldName);

        try {
            return objectMapper.readTree(json).has(fieldName);
        } catch (Exception var3) {
            Log.e(TAG, var3.getMessage());
            throw new JsonException(var3.getMessage());
        }
    }

    public static void writeValue(Writer writer, Object value) {
        try {
            objectMapper.writeValue(writer, value);
        } catch (Exception var3) {
            Log.e(TAG, var3.getMessage());
            throw new JsonException(var3.getMessage());
        }
    }
}
