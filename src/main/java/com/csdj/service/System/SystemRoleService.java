package com.csdj.service.System;

import com.csdj.entity.Role;

import java.util.List;

/**
 * 系统管理 - -  角色管理Service接口
 */

public interface SystemRoleService {

    /**
     * 查询Role角色表全部信息
     * @return
     */
    List<Role> GetRoleStart();

    /**
     * 进行修改角色功能
     * @param roleName
     * @param isStart
     * @param id
     * @return
     */
    int UpdateRole(String roleName,int isStart,int id);

    /**
     * 进行删除角色功能
     * @param id
     * @return
     */
    int DeleteRole(int id);

    /**
     * 进行角色新增功能
     * @return
     */
    int AddRole(String roleName,String creationTime,String createdBy,int isStart);

}
