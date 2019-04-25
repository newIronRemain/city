package com.dao.impl;

import com.dao.IDistrictDao;
import com.pojo.City;
import com.pojo.SysplDistrict;
import org.hibernate.Session;
import org.hibernate.Transaction;
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

    @Override
    public void save(SysplDistrict district) {
        this.getHibernateTemplate ().save ( district );
    }

    @Override
    public List <SysplDistrict> findByHql(String s) {
        return (List <SysplDistrict>) this.getHibernateTemplate ().find ( s );
    }

    @Override
    public SysplDistrict findById(String districtId) {
        return this.getHibernateTemplate ().load ( SysplDistrict.class,new Long ( districtId ) );
    }

    @Override
    public void save(List <SysplDistrict> districtList) {

        Session session = this.getHibernateTemplate().getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        for (SysplDistrict district : districtList) {
            session.save(district);

            session.flush();
            session.clear();

        }
        transaction.commit();
        session.close();
    }

    @Override
    public List <SysplDistrict> findByParentId(Long districtId) {
        return (List <SysplDistrict>) this.getHibernateTemplate ().find ( "from SysplDistrict where sysplDistrict = ? order by districtName",findById(districtId.toString ()) );
    }

    @Override
    public List <SysplDistrict> findByParent(SysplDistrict sysplDistrict) {
        return (List <SysplDistrict>) this.getHibernateTemplate ().find ( "from SysplDistrict where sysplDistrict = ? order by districtName",sysplDistrict );
    }
}
