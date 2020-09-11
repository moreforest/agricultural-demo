package com.example.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Cao
 * @Description: 日期格式化工具类
 * @Date: 2020/9/11
 **/
public class DateUtil {
    /**
     * 不带时分秒的日期字符串转化
     *
     * @return 输出的日期，不带时分秒
     */
    public static String formattedDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //时间转为字符串（格式化）
        return sdf.format(date);
    }

}
