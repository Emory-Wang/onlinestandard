package com.project.service.impl;

import com.project.entity.FirstLevel;
import com.project.entity.SecondLevel;
import com.project.entity.TemplateLevel;
import com.project.mapper.templateLevelMapper;
import com.project.mapper.templateMapper;
import com.project.service.ITemplateLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateLevelServiceImpl implements ITemplateLevelService {
    @Autowired
    private templateLevelMapper TemplateLevelMapper;

    @Override
    public List<TemplateLevel> selectByTempId(int tempId) {
        return TemplateLevelMapper.selectByTempId(tempId);
    }

    @Override
    public List<FirstLevel> findThree(int tempId) {
        return TemplateLevelMapper.findThree(tempId);
    }

    @Override
    public List<FirstLevel> findFirstRemainder(List<TemplateLevel> tlList) {
        return TemplateLevelMapper.findFirstRemainder(tlList);
    }

    @Override
    public List<SecondLevel> findSecondRemainder(int firstId,List<TemplateLevel> tlList) {
        return TemplateLevelMapper.findSecondRemainder(firstId,tlList);
    }

    @Override
    public int insert(TemplateLevel templateLevel) {
        return TemplateLevelMapper.insert(templateLevel);
    }

    @Override
    public int deleteSecondLevel(int tempId, int secondId) {
        return TemplateLevelMapper.deleteSecondLevel(tempId,secondId);
    }

    @Override
    public int deleteFirstLevel(int tempId, List<SecondLevel> secondLevels) {
        return TemplateLevelMapper.deleteFirstLevel(tempId,secondLevels);
    }

}
