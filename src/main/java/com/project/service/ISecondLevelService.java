package com.project.service;

import com.project.entity.FirstLevel;
import com.project.entity.SecondLevel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISecondLevelService {
    public List<SecondLevel> selectByFirstLevel(int firstId);

    public int insert(SecondLevel secondLevel);

    public int update(SecondLevel secondLevel);

    public int delete(int id);

    public int deleteByFirstLevel(int firstId);
}
