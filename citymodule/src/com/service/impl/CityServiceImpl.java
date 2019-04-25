package com.service.impl;

import com.action.TreeModel;
import com.dao.ICityDao;
import com.pojo.City;
import com.service.ICityService;

import java.util.ArrayList;
import java.util.List;

public class CityServiceImpl implements ICityService {

    private ICityDao cityDao;

    public void setCityDao(ICityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public List <TreeModel> getCityTree() {

        //List <City> cityList = cityDao.getAllCity();

        List <City> cityList = cityDao.findByHql ( "from City order by name asc" );

        List <TreeModel> list = new ArrayList <TreeModel> (  );

        for (City city : cityList) {

            TreeModel model = new TreeModel ();

            model.setId ( city.getId ().toString () );

            model.setpId ( city.getCity () ==null ? "0":city.getCity ().getId ().toString ());

            model.setName ( city.getName () );

            boolean open = false;

            boolean isParent = false;


            if (findIsParent(city)){
                open = true;
                isParent = true;
            }

            model.setOpen ( open );
            model.setParent ( isParent );

            list.add ( model );

        }

        return list;
    }

    @Override
    public void save(City city) {
        cityDao.save(city);
    }

    @Override
    public void save(List <City> cityList) {
        cityDao.save ( cityList );
    }

    @Override
    public City find(String name, String code, String type) {
        return cityDao.find( name,  code,  type);
    }

    @Override
    public List<City> findByHql(String sql) {
        return cityDao.findByHql ( sql );
    }


    public boolean findIsParent(City city){
        boolean flag = false;

        List <City> child = cityDao.findChild ( city );
        if (child.size ()>0){
            flag = true;
        }
        return flag;
    }
}
