package com.csdj.mapper.User;

import com.csdj.entity.AccountDetail;
import com.csdj.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户登录
 */

public interface UserMapper {

    /**
     * 验证用户登录信息
     * @param userCode
     * @param userPassword
     * @return
     */
    User UserLogin(@Param("userCode") String userCode, @Param("userPassword") String userPassword);

    /**
     * 查询账户余额
     */
    AccountDetail AccountDetailMoney(@Param("userId") int userId);

    /**
     * 修改密码
     */
    int UpdatePass(@Param("userId") int userId , @Param("againUserPass") String againUserPass);

    /**
     * 查询账户明细
     */
    List<AccountDetail> AccountDetailDetails(@Param("userId") int userId);
}
