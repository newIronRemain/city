package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pojo.City;
import com.pojo.SysplDistrict;
import com.service.IDistrictService;

import java.util.List;

public class DistrictAction extends ActionSupport implements ModelDriven <SysplDistrict> {

    private SysplDistrict district = new SysplDistrict ();

    @Override
    public SysplDistrict getModel() {
        return district;
    }

    private IDistrictService districtService;

    public void setDistrictService(IDistrictService districtService) {
        this.districtService = districtService;
    }

    public String getDistrictTree(){

        List <TreeModel> list = districtService.getDistrictTree();
        ActionContext.getContext().getValueStack().push(list);
        return SUCCESS;
    }
}
