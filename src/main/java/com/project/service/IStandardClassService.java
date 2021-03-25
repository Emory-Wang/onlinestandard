package com.project.service;

import com.project.entity.Business;
import com.project.entity.StandardClass;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface IStandardClassService {

    List<StandardClass> findAll();
}
