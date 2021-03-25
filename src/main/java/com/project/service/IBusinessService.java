package com.project.service;

import com.project.entity.Business;
import com.project.entity.Standard;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface IBusinessService {

    List<Business> getBusiness();
    int getBusinessId(String name);
}
