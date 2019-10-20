package com.csdj.service.System;

import com.csdj.entity.Logs;
import com.csdj.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统管理     -   -   用户管理Service业务接口
 */

public interface SystemUserService {

    /**
     *显示全部用户数量
     * @return 用户数量
     */
    int show_User_Count();

    /**
     * 显示全部用户和角色信息
     * @return 用户信息
     */
    List<User> show_All_Users_roleNames(int page, int limit, String userCode, Integer roleId, Integer isStart);

    /**
     * 删除用户信息
     * @param id 用户id
     * @return 成功，失败
     */
    boolean del_User(int id);

    /**
     * 添加用户信息
     * @param user 用户信息
     * @return 成功，失败
     */
    boolean add_User(User user);

    /**
     * 修改用户信息
     * @param user 用户信息
     * @return 成功，失败
     */
    boolean upd_User(User user);

    /**
     * 显示log日志信息
     * @param page 当前页面
     * @param limit 页面显示数据数量
     * @param operateDatetime 数据
     * @return log日志信息
     */
    List<Logs> show_All_Logs(@Param("page") Integer page, @Param("limit") Integer limit, @Param("operateDatetime") String operateDatetime);

    /**
     * 显示log信息数量
     * @return 数量
     */
    int show_Log_Count();

}
