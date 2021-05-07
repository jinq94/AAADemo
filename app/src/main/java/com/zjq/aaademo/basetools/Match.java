package com.zjq.aaademo.basetools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 10048 on 2018/11/29.
 */

public class Match {
    /**
     * 正则表达式匹配判断
     *
     * @param patternStr 匹配规则
     * @param input      需要做匹配操作的字符串
     * @return true if matched, else false
     */
    public static boolean isMatchered(String patternStr, CharSequence input) {
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
    //判断密码是否合格(6-16位包含数字字母，区分大小写)
    public static boolean isPassNO(String pass) {
        Pattern p = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$");
        Matcher m = p.matcher(pass);
        return m.matches();
    }

    //判断email是否合格
    public static boolean isEmail(String pass) {
        Pattern p = Pattern.compile("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+[\\.][a-zA-Z0-9_-]+$");

        Matcher m = p.matcher(pass);

        return m.matches();

    }

    /**
     * 判断是否是手机号
     *
     * @param mobile
     * @return
     */
    public static boolean isMobileNO(String mobile) {
        String regex = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(mobile);
        return m.matches();
    }
    /**
     * 18位身份证校验,粗略的校验
     * @author lyl
     * @param idCard
     * @return
     */
    public static boolean isIdCard(String idCard){
        if (idCard==null||idCard.length()==0){
            return true;
        }
        Pattern pattern1 = Pattern.compile("^(\\d{6})(19|20)(\\d{2})(1[0-2]|0[1-9])(0[1-9]|[1-2][0-9]|3[0-1])(\\d{3})(\\d|X|x)?$"); //粗略的校验
        Matcher matcher = pattern1.matcher(idCard);
        return matcher.matches();
    }
}
