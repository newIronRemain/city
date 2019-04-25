package com.service;

import com.action.TreeModel;
import com.pojo.SysplDistrict;

import java.util.List;

public interface IDistrictService {
    List<TreeModel> getDistrictTree();

    List<SysplDistrict> findBySql(String sql);

    SysplDistrict findById(String districtId);

    void save(List<SysplDistrict> districtList);

    List<SysplDistrict> findByParentId(Long districtId);

    List<SysplDistrict> findByParent(SysplDistrict sysplDistrict);
}
