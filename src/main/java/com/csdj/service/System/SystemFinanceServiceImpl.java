package com.csdj.service.System;

import com.csdj.entity.AccountDetail;
import com.csdj.entity.SystemConfig;
import com.csdj.entity.User;
import com.csdj.mapper.System.SystemFinanceMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class SystemFinanceServiceImpl implements SystemFinanceService{

    @Resource
    private SystemFinanceMapper financeMapper;

    /**
     * 初始显示userCode
     */
    public List<User> userListCode() {
        return financeMapper.userListCode();
    }

    /**
     * 显示初始信息configTypeName
     */
    public List<SystemConfig> systemConfigListName() {
        return financeMapper.systemConfigListName();
    }

    /**
     * 新增
     */
    public int ACCADD(AccountDetail accountDetail) {
        return financeMapper.ACCADD(accountDetail);
    }
}
