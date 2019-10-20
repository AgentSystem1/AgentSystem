package com.csdj.service.User;

import com.csdj.entity.AccountDetail;
import com.csdj.entity.User;
import com.csdj.mapper.User.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * User业务接口的实现类
 */

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;


    //验证用户登录信息
    public User UserLogin(String userCode, String userPassword) {
        return userMapper.UserLogin(userCode,userPassword);
    }

    /**
     * 查询账户余额
     */
    public AccountDetail AccountDetailMoney(int userId){
        return userMapper.AccountDetailMoney(userId);
    };

    /**
     * 修改密码
     */
    public int UpdatePass(int userId, String againUserPass){
        return userMapper.UpdatePass(userId,againUserPass);
    };

    /**
     * 查询账户明细
     */
    public List<AccountDetail> AccountDetailDetails(int userId){
        return userMapper.AccountDetailDetails(userId);
    };
}
