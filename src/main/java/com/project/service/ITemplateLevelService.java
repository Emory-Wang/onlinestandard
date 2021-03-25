package com.project.service;

import com.project.entity.FirstLevel;
import com.project.entity.SecondLevel;
import com.project.entity.TemplateLevel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITemplateLevelService {
    public List<TemplateLevel> selectByTempId(int tempId);

    public List<FirstLevel> findThree(int tempId);

    List<FirstLevel> findFirstRemainder(List<TemplateLevel> tlList);

    List<SecondLevel> findSecondRemainder(int firstId,List<TemplateLevel> tlList);

    public int insert(TemplateLevel templateLevel);

    public int deleteSecondLevel(int tempId,int secondId);

    public int deleteFirstLevel(int tempId,List<SecondLevel> secondLevels);
}
