package com.csdj.service;

import java.util.List;


import com.csdj.XMLmapper.AccountDetailDaotS;
import com.csdj.XMLmapper.AgentMapper;
import com.csdj.entity.AccountDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountdetailservice")
public class AccountDetailServiceImpl implements AccountDetailService {
	@Autowired
	private AccountDetailDaotS mapper;

	@Autowired
	AgentMapper agentMapper;


	public List<AccountDetail> getAccountDetailList(AccountDetail accountDetail) throws Exception{
		// TODO Auto-generated method stub
		return mapper.getAccountDetailList(accountDetail);
	}


	public int addAccountDetail(AccountDetail accountDetail)  throws Exception{
		// TODO Auto-generated method stub
		return mapper.addAccountDetail(accountDetail);
	}


	public int modifyAccountDetail(AccountDetail accountDetail)  throws Exception{
		// TODO Auto-generated method stub
		return mapper.modifyAccountDetail(accountDetail);
	}


	public int deleteAccountDetail(AccountDetail accountDetail)  throws Exception{
		// TODO Auto-generated method stub
		return mapper.deleteAccountDetail(accountDetail);
	}



	public List<AccountDetail> getAccountDetail(AccountDetail accountDetail) {
		System.out.println("-----------------查询方法执行------------");
		return agentMapper.getAccountDetail(accountDetail);
	}

	public Integer count(AccountDetail accountDetail)  throws Exception{
		// TODO Auto-generated method stub
		return mapper.count(accountDetail);
	}


	public List<AccountDetail> repostAgentDetail(AccountDetail accountDetail)
			throws Exception {
		// TODO Auto-generated method stub
		return mapper.repostAgentDetail(accountDetail);
	}

}
