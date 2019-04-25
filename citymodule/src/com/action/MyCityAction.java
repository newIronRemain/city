package com.action;

import com.common.Result;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pojo.City;
import com.pojo.SysplDistrict;
import com.service.ICityService;
import com.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MyCityAction extends ActionSupport implements ModelDriven<City> {

    private City city = new City ();

    @Override
    public City getModel() {
        return city;
    }

    private ICityService cityService;

    private IDistrictService districtService;

    public void setCityService(ICityService cityService) {
        this.cityService = cityService;
    }


    public String getCityTree(){

        List <TreeModel> list = cityService.getCityTree();
        ActionContext.getContext().getValueStack().push(list);
        return SUCCESS;
    }

    public String syncCity(){
        System.out.println ("cityIds:"+cityIds);
        System.out.println ("districtId:"+districtId);
        System.out.println ("cityType:"+cityType);

//        cityIds: ["11858","11857","11853","11854","11851","11852","11855","11856","11861","11850","11849","11860","11859"]
//        districtId: 20190416010
//        cityType: state

        cityIds = cityIds.replace ( "[","(" );
        cityIds = cityIds.replace ( "]",")" );
        cityIds = cityIds.replace ( "\"","'" );
        System.out.println ("cityIds:"+cityIds);


        SysplDistrict district = districtService.findById(districtId);
        System.out.println (district.getDistrictId ());
        String citySql = "from City where id in "+cityIds;
        List <City> cities = cityService.findByHql ( citySql );

        List<SysplDistrict> districtList = new ArrayList <> (  );
        for (City city1 : cities) {
            //System.out.println (city1.getName ());
            SysplDistrict newDistrict = new SysplDistrict (  );
            newDistrict.setDistrictLevel ( cityType );
            newDistrict.setStatus ( "test" );
            newDistrict.setDistrictName ( city1.getName () );
            newDistrict.setMemo ( "sync" );
            newDistrict.setSysplDistrict ( district );
            districtList.add ( newDistrict );

        }

        districtService.save(districtList);

        Result result = new Result ();
        result.setMsg ( "ok" );
        result.setSuccess ( true );
        ActionContext.getContext().getValueStack().push(result);
        return SUCCESS;
    }

//    子节点（city）数据ids<input type="text" name="cityIds"><br>
//    父节点（district）id<input type="text" name="districtId"><br>
//    类型（type）id<input type="text" name="type"><br>
    private String cityIds;
    private String districtId;
    private String cityType;

    public void setCityType(String cityType) {
        this.cityType = cityType;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }


    public void setCityIds(String cityIds) {
        this.cityIds = cityIds;
    }

    public void setDistrictService(IDistrictService districtService) {
        this.districtService = districtService;
    }
}
