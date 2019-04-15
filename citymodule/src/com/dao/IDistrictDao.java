package com.dao;

import com.pojo.SysplDistrict;

import java.util.List;

public interface IDistrictDao {
    List<SysplDistrict> getAllDistrict();

    List<SysplDistrict> findChild(SysplDistrict district);
}
