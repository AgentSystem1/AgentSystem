package com.csdj.service.System;

import com.csdj.entity.Role;
import com.csdj.mapper.System.SystemRoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统管理 - -  角色管理Service业务实现
 */

@Service
public class SystemRoleServiceImpl implements SystemRoleService{

    @Resource
    private SystemRoleMapper roleMapper;

    /**
     * 查询Role角色表全部信息
     * @return
     */
    public List<Role> GetRoleStart() {
        return roleMapper.GetRoleStart();
    }

    /**
     * 进行修改角色功能
     * @param roleName
     * @param isStart
     * @param id
     * @return
     */
    public int UpdateRole(String roleName, int isStart, int id) {
        return roleMapper.UpdateRole(roleName,isStart,id);
    }

    /**
     * 进行删除角色功能
     * @param id
     * @return
     */
    public int DeleteRole(int id) {
        return roleMapper.DeleteRole(id);
    }

    /**
     * 进行角色新增功能
     * @return
     */
    public int AddRole(String roleName, String creationTime, String createdBy, int isStart) {
        return roleMapper.AddRole(roleName,creationTime,createdBy,isStart);
    }
}
