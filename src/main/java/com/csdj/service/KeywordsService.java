package com.csdj.service;

import com.csdj.entity.Contact;
import com.csdj.entity.Custom;
import com.csdj.entity.Keywords;
import com.csdj.entity.User;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



public interface KeywordsService {
	/**
	 * getList
	 * @return
	 */
	public List<Keywords> getList() throws Exception;
	/**
	 * 
	 * @param keywords
	 * @return
	 * @throws Exception
	 */
	public Integer count(Keywords keywords) throws Exception;
	/**
	 * getKeywordsById
	 * @param keywords
	 * @return
	 */
	public Keywords getKeywordsById(Keywords keywords) throws Exception;
	/**
	 * getKeywordsBySearch
	 * @param keywords
	 * @return
	 */
	public List<Keywords> getKeywordsBySearch(Keywords keywords) throws Exception;
	/**
	 * modifyKeywords
	 * @param keywords
	 * @return
	 */
	public int modifyKeywords(Keywords keywords) throws Exception;
	/**
	 * addKeywords
	 * @param keywords
	 * @return
	 */
	public int addKeywords(Keywords keywords)  throws Exception;
	/**
	 * deleteKeywords
	 * @param keywords
	 * @return
	 */
	public int deleteKeywords(Keywords keywords)  throws Exception;
	/**
	 * getKeywordsByKeyword
	 * @param keywords
	 * @return
	 * @throws Exception
	 */
	public Keywords getKeywordsByKeyword(Keywords keywords) throws Exception;
	/**
	 * hl_SaveKeywords
	 * @throws Exception
	 */
	public void hl_SaveKeywords(Keywords keywords, User user, Date date) throws Exception;
	/**
	 * hl_changeStatusToOK
	 * @param keywords
	 * @param user
	 * @param date
	 * @throws Exception
	 */
	public void hl_changeStatusToOK(Keywords keywords, User user, Date date) throws Exception;
	/**
	 * hl_changeStatusToNo
	 * @param keywords
	 * @param user
	 * @param date
	 * @throws Exception
	 */
	public void hl_changeStatusToNo(Keywords keywords, User user, Date date) throws Exception;
	/**
	 * hl_keywordsXuFei
	 * @param keywords
	 * @param date
	 * @throws Exception
	 */
	public void hl_keywordsXuFei(Keywords keywords, String productType, String xufeiYears, BigDecimal price, Date date)throws Exception;
	
	/**
	 * portalcount
	 * @param keywords
	 * @return
	 * @throws Exception
	 */
	public int portalcount(Keywords keywords) throws Exception;
	
	/**
	 * getPortalBySearch
	 * @param keywords
	 * @return
	 * @throws Exception
	 */
	public List<Keywords> getPortalBySearch(Keywords keywords) throws Exception;



	/**

	 * 显示全部关键词

	 * @return 关键词

	 */

	List<Keywords> show_All_Keywords(int page,int limit,String keywords);



	boolean updKeywordsInfo(Keywords keywords);



	String getProvinces(String provinces);

	List<Contact> getContactes(Integer customId);

	String getAreas(String area);

	String getCities(String city);

	Custom getCustom(Integer id);

	List<Keywords> getAllKeywordsList(Integer page,Integer limit);



	Keywords getKeywordInfoById(Integer id);

	List<Keywords> getListByName(Integer page,Integer limit,String keywords,String customName);

	/**

	 * 显示关键词数量

	 * @return 数量

	 */

	int show_keywords_Count();



	/**

	 * 修改关键词信息

	 * @param keywords 关键词信息

	 * @return 成功，失败

	 */

	boolean upd_Keywords(Keywords keywords);



	/**

	 * 修改关键词状态

	 * @param id 关键词id

	 * @param isUse 状态

	 * @return 成功，失败

	 */

	boolean del_Keywords(int id,int isUse);













}
