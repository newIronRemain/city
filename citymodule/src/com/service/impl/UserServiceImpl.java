package com.service.impl;

import com.dao.IUserDao;
import com.pojo.User;
import com.service.IUserService;

public class UserServiceImpl implements IUserService {

    private IUserDao userDao;

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }
}
