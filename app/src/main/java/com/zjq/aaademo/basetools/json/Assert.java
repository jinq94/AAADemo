package com.zjq.aaademo.basetools.json;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Assert {
    public Assert() {
    }

    public static void isTrue(boolean expression) {
        if (!expression) {
            throw new RuntimeException("expression is not true");
        }
    }

    public static void notTrue(boolean expression) {
        if (expression) {
            throw new RuntimeException("expression is true");
        }
    }

    public static void isNull(Object object) {
        if (object != null) {
            throw new RuntimeException("object is not null");
        }
    }

    public static void notNull(Object object) {
        if (object == null) {
            throw new RuntimeException("object is null");
        }
    }

    public static void isEmpty(String data) {
        if (!StringUtils.isEmpty(data)) {
            throw new RuntimeException("data is not empty");
        }
    }

    public static void notEmpty(String data) {
        if (StringUtils.isEmpty(data)) {
            throw new RuntimeException("data is empty");
        }
    }

    public static void isEmpty(Object[] data) {
        if (ArrayUtils.isEmpty(data)) {
            throw new RuntimeException("data is not empty");
        }
    }

    public static void notEmpty(Object[] data) {
        if (ArrayUtils.isEmpty(data)) {
            throw new RuntimeException("data is empty");
        }
    }

    public static void equals(String s1, String s2) {
        if (!StringUtils.equals(s1, s2)) {
            throw new RuntimeException("数据[" + s1 + "] not equals 数据[" + s2 + "]");
        }
    }

    public static void notEquals(String s1, String s2) {
        if (StringUtils.equals(s1, s2)) {
            throw new RuntimeException("数据[" + s1 + "] equals 数据[" + s2 + "]");
        }
    }

    public static void checkLength(String data, int maxLen) {
        if (data != null && data.getBytes().length > maxLen) {
            throw new RuntimeException("数据[" + data + "]超过" + maxLen + "的最大限制");
        }
    }

    public static void checkLength(String data, int minLen, int maxLen) {
        if (data != null && (data.getBytes().length > maxLen || data.getBytes().length < minLen)) {
            throw new RuntimeException("数据[" + data + "]长度应该在[" + minLen + "," + maxLen + "]之间");
        }
    }

    public static void checkNChar(String data, String errorCode, String message) {
        if (data != null) {
            Pattern pattern = Pattern.compile("\\d*");
            Matcher isNum = pattern.matcher(data);
            if (!isNum.matches()) {
                throw new RuntimeException("数据[" + data + "]包含不合法的数字");
            }
        }

    }

    public static void checkXChar(String data, String errorCode, String message) {
        if (data != null) {
            Pattern pattern = Pattern.compile("(\\w|\\s|#|\\.|,|-|\\(|\\)|/|=|\\+|\\?|!|%|\\*|&|<|>|;|@)*");
            Matcher isNum = pattern.matcher(data);
            if (!isNum.matches()) {
                throw new RuntimeException("数据[" + data + "]包含不合法的字符");
            }
        }

    }

    public static void checkContain(String data, List<?> list, String errorCode, String message) {
        if (data != null && !list.contains(data)) {
            throw new RuntimeException("数据[" + data + "]不在正常值范围");
        }
    }

    public static void checkDateString(String data, String errorCode, String message) {
        if (!StringUtils.isEmpty(data)) {
            try {
                DateFormat format = new SimpleDateFormat("yyyyMMdd");
                format.setLenient(false);
                format.parse(data);
            } catch (Exception var4) {
                throw new RuntimeException("数据[" + data + "]日期格式错误");
            }
        }
    }

    public static void checkDateTimeString(String data, String errorCode, String message) {
        if (!StringUtils.isEmpty(data)) {
            try {
                DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
                format.setLenient(false);
                format.parse(data);
            } catch (Exception var4) {
                throw new RuntimeException("数据[" + data + "]日期时间格式错误");
            }
        }
    }

    public static void checkTimeString(String data, String errorCode, String message) {
        if (!StringUtils.isEmpty(data)) {
            try {
                DateFormat format = new SimpleDateFormat("HHmmss");
                format.setLenient(false);
                format.parse(data);
            } catch (Exception var4) {
                throw new RuntimeException("数据[" + data + "]时间格式错误");
            }
        }
    }

    public static boolean hasChinese(String s) {
        if (StringUtils.isEmpty(s)) {
            return false;
        } else {
            return s.getBytes().length != s.length();
        }
    }
}
