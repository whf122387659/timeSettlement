package com.dbb.base;




import com.alibaba.fastjson.JSONObject;
import com.dbb.util.DataUtil;
import com.dbb.util.GatewayUtil;

public class Test {


    public static void main(String[] args) {
        float f1 = (float)10.1;
        int f2 = 3;
        System.out.println(f1/f2);
        System.out.println(DataUtil.divide(f1,f2));
    }
}
