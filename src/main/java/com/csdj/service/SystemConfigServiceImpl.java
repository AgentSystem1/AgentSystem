package com.csdj.service;

import java.util.List;

import com.csdj.entity.SystemConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csdj.XMLmapper.SystemConfigMapper;

@Service("systemConfigService")
public class SystemConfigServiceImpl implements SystemConfigService {
	@Autowired
	private SystemConfigMapper systemConfigMapper;

	public void setMapper(SystemConfigMapper systemConfigMapper) {
		this.systemConfigMapper = systemConfigMapper;
	}

	//账务类型
	@Override
	public List<SystemConfig> get_AccountingTypeInfo() {
		return systemConfigMapper.get_AccountingTypeInfo();
	}

	@Override
	public int add_AccountingTypeInfo(String configTypeName, int isStart) {
			return systemConfigMapper.add_AccountingTypeInfo(configTypeName,isStart);
	}

	@Override
	public int del_AccountingTypeInfo(Integer id) {
		return systemConfigMapper.del_AccountingTypeInfo(id);
	}

	@Override
	public int upd_AccountingTypeInfo(SystemConfig systemConfig) {
		return systemConfigMapper.upd_AccountingTypeInfo(systemConfig);
	}


	//服务类型
	@Override
	public List<SystemConfig> get_ServeTypeInfo() {
		return systemConfigMapper.get_ServeTypeInfo();
	}

	@Override
	public int add_ServeTypeInfo(SystemConfig systemConfig) {
		return systemConfigMapper.add_ServeTypeInfo(systemConfig);
	}

	@Override
	public int upd_ServeTypeInfo(SystemConfig systemConfig) {
		return systemConfigMapper.upd_ServeTypeInfo(systemConfig);
	}


	//客户类型
	@Override
	public List<SystemConfig> get_ClientTypeInfo() {
		return systemConfigMapper.get_ClientTypeInfo();
	}

	@Override
	public int add_ClientTypeInfo(SystemConfig systemConfig) {
		return systemConfigMapper.add_ClientTypeInfo(systemConfig);
	}

	@Override
	public int upd_ClientTypeInfo(SystemConfig systemConfig) {
		return systemConfigMapper.upd_ClientTypeInfo(systemConfig);
	}

	@Override
	public int del_ClientTypeInfo(Integer id) {
		return systemConfigMapper.del_ClientTypeInfo(id);
	}


	//证件类型
	@Override
	public List<SystemConfig> get_CredentialsInfo() {
		return systemConfigMapper.get_CredentialsInfo();
	}

	@Override
	public int add_CredentialsInfo(SystemConfig systemConfig) {
		return systemConfigMapper.add_CredentialsInfo(systemConfig);
	}

	@Override
	public int upd_CredentialsInfo(SystemConfig systemConfig) {
		return systemConfigMapper.upd_CredentialsInfo(systemConfig);
	}

	@Override
	public int del_CredentialsInfo(Integer id) {
		return systemConfigMapper.del_CredentialsInfo(id);
	}


	//优惠类型
	@Override
	public List<SystemConfig> get_PreferentialInfo() {
		return systemConfigMapper.get_PreferentialInfo();
	}

	@Override
	public int add_PreferentialInfo(SystemConfig systemConfig) {
		return systemConfigMapper.add_PreferentialInfo(systemConfig);
	}

	@Override
	public int upd_PreferentialInfo(SystemConfig systemConfig) {
		return systemConfigMapper.upd_PreferentialInfo(systemConfig);
	}

	@Override
	public int del_PreferentialInfo(Integer id) {
		return systemConfigMapper.del_PreferentialInfo(id);
	}



	//服务年限
	@Override
	public SystemConfig get_ServeYearsInfo() {
		return systemConfigMapper.get_ServeYearsInfo();
	}

	@Override
	public int upd_ServeYearsInfo(String configValue, Integer id) {
		return systemConfigMapper.upd_ServeYearsInfo(configValue,id);
	}



	//App地址
	@Override
	public SystemConfig get_AppAddressInfo() {
		return systemConfigMapper.get_AppAddressInfo();
	}

	@Override
	public int upd_AppAddressInfo(String configValue, Integer id) {
		return systemConfigMapper.upd_AppAddressInfo(configValue,id);
	}

	@Override
	public List<SystemConfig> show_all_systemConfig() {
		return systemConfigMapper.getSelect_All_SystemConfig();
	}

}
