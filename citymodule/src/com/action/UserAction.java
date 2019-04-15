package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pojo.User;
import com.service.IUserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {

    private User user = new User ();

    @Override
    public User getModel() {
        return user;
    }


    private IUserService userService;

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }


    public String getUser(){
        User result = userService.getUser ( this.user.getId () );
        ActionContext.getContext().getValueStack().push(result);
        return SUCCESS;
    }
}
