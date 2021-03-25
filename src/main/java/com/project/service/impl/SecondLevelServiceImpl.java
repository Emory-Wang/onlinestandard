package com.project.service.impl;

import com.project.entity.FirstLevel;
import com.project.entity.SecondLevel;
import com.project.mapper.secondLevelMapper;
import com.project.service.ISecondLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecondLevelServiceImpl implements ISecondLevelService {

    @Autowired
    private secondLevelMapper SecondLevelMapper;

    @Override
    public List<SecondLevel> selectByFirstLevel(int firstId) {
        return SecondLevelMapper.selectByFirstLevel(firstId);
    }

    @Override
    public int insert(SecondLevel secondLevel) {
        return SecondLevelMapper.insert(secondLevel);
    }

    @Override
    public int update(SecondLevel secondLevel) {
        return SecondLevelMapper.updateByPrimaryKey(secondLevel);
    }

    @Override
    public int delete(int id) {
        return SecondLevelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByFirstLevel(int firstId) {
        List<SecondLevel> secondLevelList = selectByFirstLevel(firstId);
        for(SecondLevel sl: secondLevelList){
            delete(sl.getId());
        }
        return 1;
    }
}
