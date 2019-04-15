package com.dao.impl;

import com.dao.IDistrictDao;
import com.pojo.City;
import com.pojo.SysplDistrict;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class DistrictDaoImpl extends HibernateDaoSupport implements IDistrictDao {
    @Override
    public List <SysplDistrict> getAllDistrict() {
        List <SysplDistrict> districtList = this.getHibernateTemplate ().loadAll ( SysplDistrict.class );
        return districtList;
    }

    @Override
    public List <SysplDistrict> findChild(SysplDistrict district) {
        HibernateTemplate template = this.getHibernateTemplate ();
        List <SysplDistrict> list = (List <SysplDistrict>) template.find ( "from SysplDistrict where sysplDistrict = ?",district);
        return list;
    }
}
