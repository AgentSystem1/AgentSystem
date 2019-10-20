package com.csdj.servlet.System;

import com.csdj.entity.Premission;
import com.csdj.entity.Role;
import com.csdj.service.System.SystemAuthorityService;
import com.csdj.util.JsonToolsGet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *  角色权限配置
 */
@Controller
@RequestMapping(value = "authority")
public class AuthorityController {

    @Resource
    private SystemAuthorityService authorityService;

    /**
     * 用于修改等操作完成后的jsp跳转
     * @return
     */
    @RequestMapping(value = "/authority.html")
    public String authority(){
        return "systemmanagement/author/authority";
    }

    /**
     * 初始信息查询   ajax方式
     * @return
     */
    @RequestMapping(value = "GetRoleName")
    @ResponseBody
    public List<Role> GetRoleName(){
        return authorityService.GetRoleName();
    }

    /**
     * 显示用户是否启用功能
     * @param roleId
     * @return
     */
    @RequestMapping(value = "/showFunctionId.json")
    @ResponseBody
    public List<Integer> showFunction(@RequestParam int roleId){
        return authorityService.show_FunctionId(roleId);
    }

    /**
     *显示角色全部权限
     * @return
     */
    @RequestMapping(value = "/showFunction.json")
    @ResponseBody
    public Map<String,Object> showFunction(){
        return JsonToolsGet.jsonData(authorityService.show_All_Function().size(),authorityService.show_All_Function());
    }

    /**
     *修改        ---     添加角色权限
     * @param premission
     * @return
     */
    @RequestMapping(value = "/updFunction.html")
    public String updFunction(Premission premission){
        //查询权限id
        Integer id = authorityService.show_Id(premission.getRoleId(),premission.getFunctionId());
        if (id!=null && premission.getIsStart()==0){
            authorityService.del_Premission(id);
        }else if (id==null){
            premission.setCreatedBy("admin");
            premission.setCreationTime(new Date());
            authorityService.add_Premission(premission);        //
        }
        return "redirect:/authority/authority.html";
    }


}
