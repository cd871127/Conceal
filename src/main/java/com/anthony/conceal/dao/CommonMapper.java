package com.anthony.conceal.dao;

import com.anthony.conceal.dto.DataDictDTO;

import java.util.List;

/**
 * Created by CHENDONG239 on 2017-01-03.
 */
public interface CommonMapper {
    List<DataDictDTO> getDictMapByColumnName(List<String> columnName);
}
