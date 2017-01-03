package com.anthony.conceal.service;

import com.anthony.conceal.dao.CommonMapper;
import com.anthony.conceal.dto.DataDictDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CHENDONG239 on 2017-01-03.
 */
@Service
public class CommonService {
    @Resource
    private CommonMapper commonMapper;

    public Map<String, Map<String, String>> getDictMapByColumnName(List<String> columnName) {
        List<DataDictDTO> resList = commonMapper.getDictMapByColumnName(columnName);
        Map<String, Map<String, String>> resMap = new HashMap<>();
        for (String cName : columnName) {
            Map<String, String> tmpMap = new HashMap<>();
            resMap.put(cName, tmpMap);
        }

        for (DataDictDTO dataDictDTO : resList) {
            Map<String, String> tmpMap = resMap.get(dataDictDTO.getColumnName());
            tmpMap.put(dataDictDTO.getColumnCode(), dataDictDTO.getColumnDesc());
        }
        return resMap;
    }
}
