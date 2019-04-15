package com.service.impl;

import com.action.TreeModel;
import com.dao.IDistrictDao;
import com.pojo.City;
import com.pojo.SysplDistrict;
import com.service.IDistrictService;

import java.util.ArrayList;
import java.util.List;

public class DistrictServiceImpl implements IDistrictService {

    private IDistrictDao districtDao;

    public void setDistrictDao(IDistrictDao districtDao) {
        this.districtDao = districtDao;
    }

    @Override
    public List <TreeModel> getDistrictTree() {
        List <SysplDistrict> districtList = districtDao.getAllDistrict();

        List <TreeModel> list = new ArrayList <TreeModel> (  );

        for (SysplDistrict district : districtList) {

            TreeModel model = new TreeModel ();

            model.setId ( district.getDistrictId ().toString () );

            model.setpId ( district.getSysplDistrict () ==null ? "0":district.getSysplDistrict ().getDistrictId ().toString ());

            model.setName ( district.getDistrictName () );

            boolean open = false;

            boolean isParent = false;


            if (findIsParent(district)){

                isParent = true;
            }

            model.setOpen ( open );
            model.setParent ( isParent );

            list.add ( model );

        }

        return list;
    }

    private boolean findIsParent(SysplDistrict district) {

        boolean flag = false;


        List <SysplDistrict> child = districtDao.findChild ( district );
        if (child.size ()>0){
            flag = true;
        }

        return flag;
    }
}
