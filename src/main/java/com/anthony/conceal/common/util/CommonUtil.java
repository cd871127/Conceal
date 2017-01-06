package com.anthony.conceal.common.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * Created by CHENDONG239 on 2017-01-06.
 */
public class CommonUtil {
    public static void printRequestParaMap(HttpServletRequest request)
    {
        System.out.println("print request:");
        Map m=request.getParameterMap();
        Set<Map.Entry<String, String>> set = m.entrySet();
        for(Map.Entry entry : set)
        {
            System.out.println(entry.getKey() + ":" + Arrays.toString((String[])entry.getValue()));
        }
    }
}
