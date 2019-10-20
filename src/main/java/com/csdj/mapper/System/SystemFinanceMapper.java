package com.csdj.mapper.System;

import com.csdj.entity.AccountDetail;
import com.csdj.entity.SystemConfig;
import com.csdj.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统管理 -   -   财务管理
 */

public interface SystemFinanceMapper {

    /**
     * 初始显示userCode
     */
    List<User> userListCode();

    /**
     * 显示初始信息configTypeName
     */
    List<SystemConfig> systemConfigListName();

    /**
     * 新增
     */
    int ACCADD(AccountDetail accountDetail);
}
