package com.csdj.servlet.System;

import com.csdj.entity.AccountDetail;
import com.csdj.entity.SystemConfig;
import com.csdj.entity.User;
import com.csdj.service.System.SystemFinanceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 系统管理     -       -   财务管理
 */

@Controller
@RequestMapping(value = "finance")
public class financeController {

    @Resource
    private SystemFinanceService financeService;

    @RequestMapping(value = "Getfinance")
    @ResponseBody
    public List<User> Getfinance(){
        List<User> userList = financeService.userListCode();
        if (null != userList){

            return userList;
        }
        return userList;
    }

    @RequestMapping(value = "Getfinances")
    @ResponseBody
    public List<SystemConfig> Getfinances(){
        List<SystemConfig> systemConfigList = financeService.systemConfigListName();
        if (null != systemConfigList){
            return systemConfigList;
        }
        return systemConfigList;
    }

    @RequestMapping(value = "addFinance.html")
    public ModelAndView addFinanceHtml(HttpSession session,@RequestParam(value = "userId",required = false) String userId,@RequestParam(value = "detailType",required = false) String detailType
                                       ,@RequestParam(value = "accountMoney",required = false) String accountMoney,@RequestParam(value = "memo",required = false) String memo){
        String detailTypeName = null;
        List<SystemConfig> systemConfigList = financeService.systemConfigListName();
        for (int i = 0;i<systemConfigList.size();i++){
            if (systemConfigList.get(i).getId() == Integer.parseInt(detailType)){
                detailTypeName = systemConfigList.get(i).getConfigTypeName();
            }
        }

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        AccountDetail accountDetail = new AccountDetail(Integer.parseInt(userId),Integer.parseInt(detailType),detailTypeName,Integer.parseInt(accountMoney),Integer.parseInt(accountMoney),memo,new Date());
        int count = financeService.ACCADD(accountDetail);
        if (count>0){
            session.setAttribute("show","提交成功");
            return new ModelAndView("systemmanagement/finance/finance");
        }
        return null;
    }
}
