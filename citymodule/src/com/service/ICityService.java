package com.service;

import com.action.TreeModel;
import com.pojo.City;

import java.util.List;

public interface ICityService {
    public List<TreeModel> getCityTree();

    public void save(City city);

    void save(List<City> cityList);

    City find(String name, String code, String type);
}
