package com.dbb.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DataUtil {
    /**
     * 两个浮点值相加
     * @param d1
     * @param d2
     * @return
     */
    public static float add(float d1,float d2){
        BigDecimal b1 = new BigDecimal(Float.toString(d1)+"");
        BigDecimal b2 = new BigDecimal(Float.toString(d2)+"");
        return b2.add(b1).floatValue();
    }
    /**
     * 两个浮点值相乘保留两位有效数字
     * @param d1
     * @param d2
     * @return
     */
    public static float mul(float d1,float d2){
        float mulVal = (float) (Math.round(Double.parseDouble(d1+"")*d2*100))/100;
        return mulVal;
    }
    /**
     * 两个浮点值相除保留两位有效数字
     * @param d1
     * @param d2
     * @return
     */
    public static float divide(float d1,float d2){
        float divideVal = (float) (Math.round(Double.parseDouble(d1+"")/d2*100))/100;
        return divideVal;
    }

    /**
     * 获取当前年月
     * @return
     */
    public static String getNowYearMonth(){
        Calendar cal = Calendar.getInstance();
        //int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
   /*     int dow = cal.get(Calendar.DAY_OF_WEEK);
        int dom = cal.get(Calendar.DAY_OF_MONTH);
        int doy = cal.get(Calendar.DAY_OF_YEAR);*/
        if (month<10){
            return year+"0"+month;
        }else {
            return year + "" + month;
        }
    }
    /**
     * 获取当前年月日
     * @return
     */
    public static String getNowYMD(long time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        long timeStamp= new Long(time+"000");
        Date date = new Date(timeStamp);
        String ymdtime= simpleDateFormat.format(date);
        return ymdtime;

    }

    /**
     * 判断时间是否在时间段内 
     * @param times
     * @param strDateBegin
     * @param strDateEnd
     * @return
     */
    public static boolean isInDate(String times, String strDateBegin, String strDateEnd) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        long longTimeStamp = new Long(new Long(times) * 1000);
        Date date = new Date(longTimeStamp);
        String strDate = sdf.format(date);  //
// 截取当前时间时分秒 转成整型
        int tempDate=Integer.parseInt(strDate.substring(11, 13)+strDate.substring(14, 16)+strDate.substring(17, 19));
// 截取开始时间时分秒  转成整型
        int tempDateBegin=Integer.parseInt(strDateBegin.substring(0, 2)+strDateBegin.substring(3, 5)+"00");
// 截取结束时间时分秒  转成整型
        int tempDateEnd=Integer.parseInt(strDateEnd.substring(0, 2)+strDateEnd.substring(3, 5)+"00");

        if ((tempDate >= tempDateBegin && tempDate <= tempDateEnd)) {
            return true;
        } else {
            return false;
        }
    }
    /**
     *
     * @Description: 获得“今天”零点时间戳
     * @Date:
     */
    public static Long getTodayZeroPointTimestamps(){
        Long currentTimestamps=System.currentTimeMillis();
        Long oneDayTimestamps= Long.valueOf(60*60*24*1000);
        return (currentTimestamps-(currentTimestamps+60*60*8*1000)%oneDayTimestamps)/1000;
    }
}
