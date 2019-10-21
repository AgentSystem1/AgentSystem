package com.csdj.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.csdj.entity.SystemConfig;


public interface SystemConfigService {

	//账务类型
	/**
	 * 得到账务类型数据
	 * @return
	 */
	public List<SystemConfig> get_AccountingTypeInfo();
	
	/**
	 * 新增账务类型数据
	 * @return
	 */
	public int add_AccountingTypeInfo(String configTypeName,int isStart);

	/**
	 * 按照id删除账务类型数据
	 * @param id
	 * @return
	 */
	public int del_AccountingTypeInfo(Integer id);

	/**
	 * 修改账务类型数据
	 * @param systemConfig
	 * @return
	 */
	public int upd_AccountingTypeInfo(SystemConfig systemConfig);






	//服务类型
	/**
	 * 得到服务类型数据
	 * @return
	 */
	public List<SystemConfig> get_ServeTypeInfo();

	/**
	 * 新增账务类型数据
	 * @return
	 */
	public int add_ServeTypeInfo(SystemConfig systemConfig);

	/**
	 * 修改服务类型数据
	 * @return
	 */
	public int upd_ServeTypeInfo(SystemConfig systemConfig);






	//客户类型
	/**
	 * 得到客户类型数据
	 * @return
	 */
	public List<SystemConfig> get_ClientTypeInfo();

	/**
	 * 新增客户类型数据
	 * @return
	 */
	public int add_ClientTypeInfo(SystemConfig systemConfig);

	/**
	 * 修改客户类型数据
	 * @return
	 */
	public int upd_ClientTypeInfo(SystemConfig systemConfig);

	/**
	 * 按照id删除客户类型数据
	 * @param id
	 * @return
	 */
	public int del_ClientTypeInfo(@Param("id") Integer id);






	//证件类型
	/**
	 * 得到证件类型数据
	 * @return
	 */
	public List<SystemConfig> get_CredentialsInfo();

	/**
	 * 新增证件类型数据
	 * @return
	 */
	public int add_CredentialsInfo(SystemConfig systemConfig);

	/**
	 * 修改证件类型数据
	 * @return
	 */
	public int upd_CredentialsInfo(SystemConfig systemConfig);

	/**
	 * 按照id删除证件类型数据
	 * @param id
	 * @return
	 */
	public int del_CredentialsInfo(@Param("id") Integer id);






	//优惠类型
	/**
	 * 得到优惠类型数据
	 * @return
	 */
	public List<SystemConfig> get_PreferentialInfo();

	/**
	 * 新增优惠类型数据
	 * @return
	 */
	public int add_PreferentialInfo(SystemConfig systemConfig);

	/**
	 * 修改优惠类型数据
	 * @return
	 */
	public int upd_PreferentialInfo(SystemConfig systemConfig);

	/**
	 * 按照id删除优惠类型数据
	 * @param id
	 * @return
	 */
	public int del_PreferentialInfo(@Param("id") Integer id);






	//服务年限
	/**
	 * 得到服务年限数据
	 * @return
	 */
	public SystemConfig get_ServeYearsInfo();

	/**
	 * 修改服务年限数据
	 * @return
	 */
	public int upd_ServeYearsInfo(String configValue,Integer id);






	//App地址
	/**
	 * 得到App地址数据
	 * @return
	 */
	public SystemConfig get_AppAddressInfo();

	/**
	 * 修改App地址数据
	 * @return
	 */
	public int upd_AppAddressInfo(@Param("configValue")String configValue,@Param("id")Integer id);













	/**

	 * 显示全部系统配置信息

	 * @return 系统配置信息

	 */

	List<SystemConfig> show_all_systemConfig();
}
