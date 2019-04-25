package com.dao;

import com.pojo.SysplDistrict;

import java.util.List;

public interface IDistrictDao {
    List<SysplDistrict> getAllDistrict();

    List<SysplDistrict> findChild(SysplDistrict district);

    void save(SysplDistrict district);

    List <SysplDistrict> findByHql(String s);

    SysplDistrict findById(String districtId);

    void save(List<SysplDistrict> districtList);

    List<SysplDistrict> findByParentId(Long districtId);

    List<SysplDistrict> findByParent(SysplDistrict sysplDistrict);
}
