package com.dao;

import com.pojo.City;
import com.pojo.User;

import java.util.List;

public interface ICityDao {

    List<City> getAllCity();

    void save(City city);

    void save(List<City> cityList);

    City find(String name, String code, String type);

    List <City> findChild(City city);

    List <City> findByHql(String s);
}
