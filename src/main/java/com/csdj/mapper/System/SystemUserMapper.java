package com.csdj.mapper.System;

import com.csdj.entity.Logs;
import com.csdj.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统管理     -   -   用户管理接口
 */

public interface SystemUserMapper {

    /**
     * 查询用户数量
     * @return 数量
     */
    int getSelect_User_Count();

    /**
     * 查询全部用户信息和角色名称
     * @param page 当前页面
     * @param limit 显示数量
     * @param userCode 用户CODE
     * @param roleId 角色id
     * @param isStart 是否启动1为启用0为不启用
     * @return 查询全部用户信息和角色名称
     */
    List<User> getSelect_All_Users_roleNames(@Param("page") int page, @Param("limit") int limit,
                                             @Param("userCode")String userCode,
                                             @Param("roleId")Integer roleId,
                                             @Param("isStart")Integer isStart);

    /**
     * 删除用户信息
     * @param id 用户id
     * @return 成功，失败
     */
    boolean getDelete_User(@Param("id") Integer id);

    /**
     * 添加用户信息
     * @param user 用户信息
     * @return 成功，失败
     */
    boolean getInsert_User(User user);

    /**
     * 修改用户信息
     * @param user 用户信息
     * @return 成功，失败
     */
    boolean getUpdate_User(User user);

    /**
     * 查询log日志信息
     * @param page 当前页面
     * @param limit 页面显示数据数量
     * @param operateDatetime 数据
     * @return log日志信息
     */
    List<Logs> getSelect_All_Logs(@Param("page")Integer page, @Param("limit")Integer limit, @Param("operateDatetime")String operateDatetime);

    /**
     * 查询Log信息数量
     * @return 数量
     */
    int getSelect_Log_Count();

}
