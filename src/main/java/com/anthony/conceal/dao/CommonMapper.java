package com.anthony.conceal.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by CHENDONG239 on 2017-01-03.
 */
public interface CommonMapper {
    Map<String,Map<String,String>> queryDataDict(Map<String,String> paraMap);

    Map<String,String> getDictMapByColumnName(String columnName);
}
