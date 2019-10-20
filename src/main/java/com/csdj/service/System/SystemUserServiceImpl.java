package com.csdj.service.System;

import com.csdj.entity.Logs;
import com.csdj.entity.User;
import com.csdj.mapper.System.SystemUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统管理     -   -   用户管理业务实现
 */

@Service
public class SystemUserServiceImpl implements SystemUserService{

    @Resource
    private SystemUserMapper userMapper1;

    public int show_User_Count() {
        return userMapper1.getSelect_User_Count();
    }

    public List<User> show_All_Users_roleNames(int page, int limit, String userCode, Integer roleId, Integer isStart) {
        return userMapper1.getSelect_All_Users_roleNames((page-1)*limit,limit,userCode,roleId,isStart);
    }



    public boolean del_User(int id) {
        return userMapper1.getDelete_User(id);
    }


    public boolean add_User(User user) {
        return userMapper1.getInsert_User(user);
    }


    public boolean upd_User(User user) {
        return userMapper1.getUpdate_User(user);
    }


    public List<Logs> show_All_Logs(Integer page, Integer limit, String operateDatetime) {
        return userMapper1.getSelect_All_Logs((page-1)*limit,limit,operateDatetime);
    }


    public int show_Log_Count() {
        return userMapper1.getSelect_Log_Count();
    }

}
