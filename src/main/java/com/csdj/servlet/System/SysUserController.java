package com.csdj.servlet.System;

import com.csdj.entity.Role;
import com.csdj.entity.User;
import com.csdj.service.System.SystemRoleService;
import com.csdj.service.System.SystemUserService;
import com.csdj.service.System.SystemkeywordService;
import com.csdj.util.JsonToolsGet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 系统管理 -   -   用户管理
 */

@Controller
@RequestMapping(value = "users")
public class SysUserController {

    @Resource
    private SystemUserService userService;

    @Resource
    private SystemRoleService roleService;

    @Resource
    private SystemkeywordService keywordService;


    /**
     * 执行增删改操作后的jsp跳转
     * @return
     */
    @RequestMapping(value = "/user.htmls")
    public String users(){
        return "systemmanagement/user/user";
    }

    /**
     * 显示初始值
     * @return
     */
    @RequestMapping(value = "/user.html")
    @ResponseBody
    public List<Role> user(){
        return roleService.GetRoleStart();
    }

    /**
     * 显示查询数据
     * @param page
     * @param limit
     * @param userCode
     * @param roleId
     * @param isStart
     * @return
     */
    @RequestMapping(value = "/showUser.json")
    @ResponseBody
    public Map<String,Object> showUser(@RequestParam int page, @RequestParam int limit,
                                       @RequestParam(required = false) String userCode,
                                       @RequestParam(required = false) Integer roleId,
                                       @RequestParam(required = false) Integer isStart){
        return JsonToolsGet.jsonData(userService.show_User_Count(), userService.show_All_Users_roleNames(page,limit,userCode,roleId,isStart));
    }

    /**
     * 修改
     * @param user
     * @return
     */
    @RequestMapping(value = "/updUser.html",method = RequestMethod.POST)
    public String updUser(User user){
        user.setLastUpdateTime(new Date());
        userService.upd_User(user);
        return "redirect:/users/user.htmls";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/delUser.html/{id}",method = RequestMethod.GET)
    public String delUser(@PathVariable int id){
        userService.del_User(id);
        return "redirect:/users/user.htmls";
    }

    /**
     * 新增
     * @param user
     * @return
     */
    @RequestMapping(value = "/addUser.html",method = RequestMethod.POST)
    public String addUser(User user){
        user.setCreatedBy("admin");
        user.setCreationTime(new Date());
        userService.add_User(user);
        return "redirect:/users/user.htmls";
    }


    //跳转Log.jsp查询数据
    @RequestMapping(value = "/log.html",method = RequestMethod.GET)
    public String log(@RequestParam String userName, Model model){
        model.addAttribute("userName",userName);
        return "systemmanagement/user/LogPay/log";
    }


    /**
     * 已到Log.jsp
     */
    @RequestMapping(value = "/showLog.json",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> showLog(@RequestParam int page, @RequestParam int limit, @RequestParam(required = false)String operateDatetime){
        return JsonToolsGet.jsonData(userService.show_Log_Count(), userService.show_All_Logs(page,limit,operateDatetime));
    }
}
