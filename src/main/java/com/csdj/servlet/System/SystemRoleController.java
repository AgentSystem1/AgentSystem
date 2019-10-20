package com.csdj.servlet.System;

import com.csdj.entity.Role;
import com.csdj.entity.User;
import com.csdj.service.System.SystemRoleService;
import com.csdj.util.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统管理 - -  角色管理   控制器
 */

@Controller
@RequestMapping(value = "systemrole")
public class SystemRoleController {

    @Resource
    private SystemRoleService roleService;

    @RequestMapping(value = "GetRoleStart")
    @ResponseBody
    public List<Role> GetRoleStart(HttpSession session){

        List<Role> roleList = roleService.GetRoleStart();
        if (roleList.size()>0){
            session.setAttribute("roleList",roleList);
            return roleList;
        }else {
            return null;
        }
    }


    @RequestMapping(value = "UpdateRole")
    @ResponseBody
    public Map<String,String> UpdateRole(@RequestParam(value = "roleName",required = false) String roleName, @RequestParam(value = "isStart",required = false) String isStart,
                          @RequestParam(value = "roleId",required = false) String roleId, HttpSession session){
        System.out.println("进来了");
        int count = roleService.UpdateRole(roleName,Integer.parseInt(isStart),Integer.parseInt(roleId));
        Map<String,String> roleMap = new HashMap<>();
        if (count>0){
            roleMap.put("roleIf","yes");
            return roleMap;
        }
        roleMap.put("roleIf","no");
        return roleMap;
    }

    @RequestMapping(value = "DeleteRole")
    @ResponseBody
    public Map<String,String> DeleteRole( @RequestParam(value = "roleId",required = false) String roleId, HttpSession session){
        System.out.println("1231312312");
        int count = roleService.DeleteRole(Integer.parseInt(roleId));
        Map<String,String> map = new HashMap<>();
        if (count>0){
            System.out.println("-----");
            map.put("deleteIf","yes");
            return  map;
        }
        map.put("deleteIf","no");
        return  map;
    }

    @RequestMapping(value = "AddRole")
    @ResponseBody
    public Map<String,String> AddRole( @RequestParam(value = "roleNameAdd",required = false) String roleNameAdd,
                                       @RequestParam(value = "isStartAdd",required = false) String isStartAdd,HttpSession session){
        Map<String,String> map = new HashMap<>();
        User user = (User) session.getAttribute(Constants.USER_SESSION);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        int count = roleService.AddRole(roleNameAdd,df.format(new Date()), user.getUserCode(),Integer.parseInt(isStartAdd));// new Date()为获取当前系统时间
        if (count>0){
            map.put("addIf","yes");
            return  map;
        }
        map.put("addIf","no");
        return  map;
    }
}
