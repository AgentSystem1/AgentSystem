package com.csdj.service.System;

import com.csdj.entity.Function;
import com.csdj.entity.Premission;
import com.csdj.entity.Role;

import java.util.List;

/**
 * 系统管理 -   - 角色权限配置Service接口
 */

public interface SystemAuthorityService {
    /**
     * 所有角色供选择
     * @return
     */
    List<Role> GetRoleName();

    /**
     * 显示角色是否启用功能
     * @param roleId 角色
     * @return 角色启动的功能id
     */
    List<Integer> show_FunctionId(int roleId);

    /**
     * 显示全部功能权限
     * @return 功能权限
     */
    List<Function> show_All_Function();

    /**
     * 添加角色权限
     * @param premission 角色权限
     * @return 成功，失败
     */
    boolean add_Premission(Premission premission);

    /**
     * 查询权限id
     * @param roleId 角色id
     * @param functionId 功能id
     * @return 权限id
     */
    Integer show_Id(Integer roleId,Integer functionId);

    /**
     * 删除角色权限
     * @param id 角色权限id
     * @return 成功，失败
     */
    boolean del_Premission(Integer id);

}
