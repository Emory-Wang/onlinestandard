package com.project.service;

import com.project.entity.City;
import com.project.entity.StandardItem;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface IStandardItemService {

    //查询所有
    public int insertOne(StandardItem standardItem);
    public int insertMulti(List<StandardItem> standardItems);
    public void delete(Integer id);
    public List<StandardItem> findRequired(Integer standardId,Integer itemId);
    void edit(StandardItem standardItem);
}
