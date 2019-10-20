package com.csdj.servlet;

import com.alibaba.fastjson.JSON;
import com.csdj.entity.AccountDetail;
import com.csdj.entity.User;
import com.csdj.service.User.UserService;
import com.csdj.util.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "user")
public class UserController {

    final Map<String,String> userMap = new HashMap<>();

    @Resource
    private UserService userService;

    /**
     * 登录
     * @param userCode
     * @param userPassword
     * @param session
     * @return
     */
    @RequestMapping(value = "userLogin.html")
    public ModelAndView UserLogin(@RequestParam(value = "userCode" , required = false)String userCode , @RequestParam(value = "userPassword" , required = false)String userPassword , HttpSession session){
        User users = userService.UserLogin(userCode,userPassword);
        System.out.println("userCode = = = "+userCode);
        if (null == userMap.get(userCode) || !userCode.equals(userMap.get(userCode))){
            if (users!=null){
                String userCodeMap = users.getUserCode();
                userMap.put(userCodeMap,users.getUserCode());
                session.setAttribute(Constants.USER_SESSION,users);
                session.setAttribute("user",users);
                session.setAttribute("accountdetailMoney",userService.AccountDetailMoney(users.getId()).getMoney());
                return new ModelAndView("head/AgentSystemHead");
            }
            else{
                session.setAttribute("LoginTips","账号或密码输入错误!");
                return new ModelAndView("AgentSystemSignIn");
            }
        }
        session.setAttribute("LoginTips","此账号已登录!");
        return new ModelAndView("AgentSystemSignIn");
    }

    /**
     * 修改密码
     */
    @RequestMapping(value = "UpdatePass")
    public ModelAndView UpdatePass(@RequestParam(value = "userId",required = false)String usrtId,@RequestParam(value = "againUserPass",required = false) String againUserPass,HttpSession session){
        if (null != usrtId && null != againUserPass){
            int count = userService.UpdatePass(Integer.parseInt(usrtId),againUserPass);
            if (count>0){
                session.setAttribute("LoginTips","密码已修改，请重新登录!");
                User user = (User) session.getAttribute(Constants.USER_SESSION);
                String userCode = user.getUserCode();
                if (userMap.get(userCode) != null){
                    userMap.remove(userCode);
                    return new ModelAndView("AgentSystemSignIn");
                }
            }
        }
        return new ModelAndView("error");
    }

    /**
     * 查看账户明细之表格显示      JSON
     */
    @RequestMapping(value = "AgeAccountDetailList")
    @ResponseBody           //标识
    public List<AccountDetail> AgeAccountDetailList(@RequestParam(value = "userId" , required = false) String userId){
        List<AccountDetail> accountDetailList = userService.AccountDetailDetails(Integer.parseInt(userId));
        if (accountDetailList.size()>0){
            return accountDetailList;
        }
        return null;
    }

    /**
     *
     */
    @RequestMapping(value = "AgentSystemAccountDetails.html")
    public ModelAndView AgentSystemAccountDetailsHtml(@RequestParam(value = "userId" , required = false) String userId,HttpSession session){
        session.setAttribute("userId1",userId);
        return new ModelAndView("user/AgentSystemAccountDetails");
    }

    /**
     * 退出此用户登录
     */
    @RequestMapping(value = "AgentSystemSignOut")
    public ModelAndView AgentSystemSignOut(@RequestParam(value = "userCode",required = false)String userCode,HttpSession session){
        if (null != userCode){
            if (userMap.get(userCode)!=null){
                userMap.remove(userCode);
                session.setAttribute("LoginTips","当前用户已退出登录!");
                return new ModelAndView("AgentSystemSignIn");
            }
        }
        return  new ModelAndView("error");
    }


    /**
     * 直接关闭窗口
     */
    @RequestMapping(value = "AgentSystemSignOuts")
    @ResponseBody
    public JSON AgentSystemSignOuts(@RequestParam(value = "userCode",required = false)String userCode, HttpSession session){
        if (null != userCode){
            if (userMap.get(userCode)!=null){
                userMap.remove(userCode);
            }
        }
        return null;
    }
}
