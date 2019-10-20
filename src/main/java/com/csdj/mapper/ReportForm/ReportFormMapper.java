package com.csdj.mapper.ReportForm;

import com.csdj.entity.AccountDetail;
import com.csdj.entity.SystemConfig;
import com.csdj.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 报表管理
 */

public interface ReportFormMapper {
    /**
     * 代理商余额查询
     */
    List<User> GetAgentBalance();

    /**
     * 预付款、代理商流水报表
     * @return
     */
    List<AccountDetail> GetPayment();

    /**
     * 产品分类数量/金额总汇
     */
    List<SystemConfig> Totalsummoney();
}
