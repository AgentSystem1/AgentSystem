package com.csdj.service.System;

import com.csdj.entity.Function;
import com.csdj.entity.Premission;
import com.csdj.entity.Role;
import com.csdj.mapper.System.SystemAuthorityMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统管理 -   - 角色权限配置Service业务实现
 */

@Service
public class SystemAuthorityServiceImpl implements SystemAuthorityService{

    @Resource
    private SystemAuthorityMapper authorityMapper;

    /**
     * 所有角色供选择
     * @return
     */
    public List<Role> GetRoleName() {
        return authorityMapper.GetRoleName();
    }

    /**
     * 显示角色是否启用功能
     * @param roleId 角色
     * @return 角色启动的功能id
     */
    public List<Integer> show_FunctionId(int roleId) {
        return authorityMapper.getSelect_FunctionId(roleId);
    }

    /**
     * 显示全部功能权限
     * @return 功能权限
     */
    public List<Function> show_All_Function() {
        return authorityMapper.getSelect_All_Function();
    }

    /**
     * 查询权限id
     * @param roleId 角色id
     * @param functionId 功能id
     * @return 权限id
     */
    public Integer show_Id(Integer roleId, Integer functionId) {
        return authorityMapper.getSelect_Id(roleId,functionId);
    }
    /**
     * 删除角色权限
     * @param id 角色权限id
     * @return 成功，失败
     */
    public boolean del_Premission(Integer id) {
        return authorityMapper.getDelete_Premission(id);
    }

    /**
     * 添加角色权限
     * @param premission 角色权限
     * @return 成功，失败
     */
    public boolean add_Premission(Premission premission) {
        return authorityMapper.getInsert_Premission(premission);
    }

}
