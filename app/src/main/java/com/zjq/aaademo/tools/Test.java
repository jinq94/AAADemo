package com.zjq.aaademo.tools;

import com.zjq.aaademo.basetools.DateTimeUtils;
import com.zjq.aaademo.basetools.json.JsonUtils;

import org.apache.commons.lang3.StringUtils;

/**
 * Created  in 2021/4/27.
 */

public class Test {
    public static void main(String[] args) {
       String json="{\"data\":\"测试机\",\"name\":\"小明\"}";
        System.out.println(JsonUtils.getNodeAsTxt(json,"data"));
        System.out.println(DateTimeUtils.dateStrOfPlusDays(10));
        System.out.println(StringUtils.isAnyEmpty("aa","null","",null));
    }

}
