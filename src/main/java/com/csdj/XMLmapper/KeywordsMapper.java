package com.csdj.XMLmapper;

import java.util.List;


import com.csdj.entity.*;

import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Select;



import java.util.List;

public interface KeywordsMapper {
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
	 * getKeywordsByKeyword
	 * @param keywords
	 * @return
	 * @throws Exception
	 */
	public Keywords getKeywordsByKeyword(Keywords keywords) throws Exception;
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
	public int addKeywords(Keywords keywords) throws Exception;
	/**
	 * deleteKeywords
	 * @param keywords
	 * @return
	 */
	public int deleteKeywords(Keywords keywords) throws Exception;
	
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

	 * 查询全部关键词

	 * @return 关键词

	 */

	List<Keywords> getSelect_All_Keywords(@Param("page") int page, @Param("limit") int limit, @Param("keywords")String keywords);



	/**

	 * 查询关键词的数量

	 * @return 数量

	 */

	int getSelect_Keywords_Count();



	/**

	 * 修改关键词信息

	 * @param keywords 关键词信息

	 * @return 成功，失败

	 */

	boolean getUpdate_Keywords(Keywords keywords);



	/**

	 * 修改关键词状态

	 * @param id 关键词id

	 * @return 成功，失败

	 */

	boolean getDelect_Keywords(@Param("id")int id,@Param("isUse")int isUse);

	@Select("SELECT c.* from as_customs as c,as_keywords as k where c.agentId = k.agentId and k.id=${id}")

	Custom getCustom(@Param("id") Integer id);



	@Select("select p.province from hat_province as p where p.provinceID  = #{province}")

	String getProvinces(@Param("province") String province);



	@Select("select a.area from hat_area as a where a.areaID  = #{area}")

	String getAreas(@Param("area") String area);



	@Select("select c.city  from hat_city as c where c.cityID  = #{city}")

	String getCities(@Param("city") String city);



	@Select("select c.* from as_contacts as c where c.customId = #{customId}")

	List<Contact> getContactes(@Param("customId") Integer customId);



	@Select("select * from as_keywords where id =#{id}")

	Keywords getKeywordInfo(@Param("id") Integer id);



	@Select("select k.*,customTypeName from as_keywords as k,as_customs as c where k.agentId=c.id limit #{page},#{limit}")

	List<Keywords> getKeywordsList(@Param("page") Integer page,@Param("limit") Integer limit);



	List<Keywords> getListByName(@Param("page") Integer page,@Param("limit") Integer limit,@Param("keywords") String keywords,@Param("customName") String customName);



	boolean modifyKeywordss(Keywords keywords);
}
