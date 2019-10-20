package com.csdj.mapper.System;

import com.csdj.entity.Function;
import com.csdj.entity.Premission;
import com.csdj.entity.Role;
import com.csdj.entity.SystemConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *角色权限配置    接口
 */

public interface SystemAuthorityMapper {

    /**
     * 所有角色供选择
     * @return
     */
    List<Role> GetRoleName();

    /**
     * 查询角色是否启用功能
     * @param roleId 角色
     * @return 角色启动的功能id
     */
    List<Integer> getSelect_FunctionId(@Param("roleId")int roleId);

    /**
     * 查询全部功能权限
     * @return 功能权限
     */
    List<Function> getSelect_All_Function();

    /**
     * 查询权限id
     * @param roleId 角色id
     * @param functionId 功能id
     * @return 权限id
     */
    Integer getSelect_Id(@Param("roleId")Integer roleId,@Param("functionId")Integer functionId);

    /**
     * 添加角色权限
     * @param premission 角色权限信息
     * @return 成功，失败
     */
    boolean getInsert_Premission(Premission premission);

    /**
     * 删除角色权限
     * @param id 角色权限id
     * @return 成功，失败
     */
    boolean getDelete_Premission(@Param("id") Integer id);

}
