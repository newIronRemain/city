package com.dao.impl;

import com.dao.IUserDao;
import com.pojo.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class UserDaoImpl extends HibernateDaoSupport implements IUserDao {

    @Override
    public User getUser(int id) {
        return this.getHibernateTemplate ().get ( User.class,id );
    }
}
