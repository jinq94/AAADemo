package com.zjq.aaademo.tools.json;

/**
 * Created  in 2021/4/27.
 */

public class JsonException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public JsonException() {
        super("json转换异常！");
    }

    public JsonException(String message) {
        super(message);
    }
}
