package com.csdj.mapper.System;

import com.csdj.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统管理接口       --角色管理
 */

public interface SystemRoleMapper {
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
    int UpdateRole(@Param(value = "roleName")String roleName,@Param(value = "isStart")int isStart,@Param(value = "id")int id);

    /**
     * 进行删除角色功能
     * @param id
     * @return
     */
    int DeleteRole(@Param(value = "id")int id);

    /**
     * 进行角色新增功能
     * @return
     */
    int AddRole(@Param(value = "roleName")String roleName,@Param(value = "creationTime")String creationTime,@Param(value = "createdBy")String createdBy,@Param(value = "isStart")int isStart);
}
