package com.csdj.service.User;

import com.csdj.entity.AccountDetail;
import com.csdj.entity.User;

import java.util.List;

/**
 * User用户登录的业务接口
 */
public interface UserService {
    /**
     * 验证用户登录信息
     * @param userCode
     * @param userPassword
     * @return
     */
    User UserLogin(String userCode, String userPassword);

    /**
     * 查询账户余额
     */
    AccountDetail AccountDetailMoney(int userId);

    /**
     * 修改密码
     */
    int UpdatePass(int userId , String againUserPass);

    /**
     * 查询账户明细
     */
    List<AccountDetail> AccountDetailDetails(int userId);
}
