package com.dao.impl;

import com.dao.ICityDao;
import com.dao.IUserDao;
import com.pojo.City;
import com.pojo.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class CityDaoImpl extends HibernateDaoSupport implements ICityDao {


    @Override
    public List <City> getAllCity() {
        return this.getHibernateTemplate ().loadAll ( City.class );
    }

    @Override
    public void save(City city) {
        this.getHibernateTemplate ().save ( city );
    }

    @Override
    public void save(List <City> cityList) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        for (City city : cityList) {
            session.save(city);

            session.flush();
            session.clear();

        }
        transaction.commit();
        session.close();
    }

    @Override
    public City find(String name, String code, String type) {
        HibernateTemplate template = this.getHibernateTemplate ();
        List <City> list = (List <City>) template.find ( "from City where code=? and name =? and type=?", code, name, type );
        return list.get ( 0 );
    }

    @Override
    public List <City> findChild(City city) {
        HibernateTemplate template = this.getHibernateTemplate ();
        List <City> list = (List <City>) template.find ( "FROM City where city =?", city );
        return list;
    }

    @Override
    public List <City> findByHql(String s) {
        return (List <City>) this.getHibernateTemplate ().find ( s );
    }
}
