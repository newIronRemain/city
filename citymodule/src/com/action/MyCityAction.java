package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pojo.City;
import com.service.ICityService;

import java.util.List;

public class MyCityAction extends ActionSupport implements ModelDriven<City> {

    private City city = new City ();

    @Override
    public City getModel() {
        return city;
    }

    private ICityService cityService;

    public void setCityService(ICityService cityService) {
        this.cityService = cityService;
    }


    public String getCityTree(){

        List <TreeModel> list = cityService.getCityTree();
        ActionContext.getContext().getValueStack().push(list);
        return SUCCESS;
    }
}
