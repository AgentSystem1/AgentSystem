package com.csdj.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.csdj.XMLmapper.KeywordsMapper;
import com.csdj.entity.Contact;
import com.csdj.entity.Custom;
import com.csdj.entity.Keywords;
import com.csdj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("keywordsservice")
public class KeywordsServiceImpl implements KeywordsService {

	@Autowired
	private KeywordsMapper keywordsMapper;


	@Override
	public List<Keywords> getList() throws Exception {
		return keywordsMapper.getList();
	}

	@Override
	public Integer count(Keywords keywords) throws Exception {
		return keywordsMapper.count(keywords);
	}

	@Override
	public Keywords getKeywordsById(Keywords keywords) throws Exception {
		return keywordsMapper.getKeywordsById(keywords);
	}

	@Override
	public List<Keywords> getKeywordsBySearch(Keywords keywords) throws Exception {
		return keywordsMapper.getKeywordsBySearch(keywords);
	}

	@Override
	public int modifyKeywords(Keywords keywords) throws Exception {
		return keywordsMapper.modifyKeywords(keywords);
	}

	@Override
	public int addKeywords(Keywords keywords) throws Exception {
		return keywordsMapper.addKeywords(keywords);

	}

	@Override
	public int deleteKeywords(Keywords keywords) throws Exception {
		return keywordsMapper.deleteKeywords(keywords);
	}

	@Override
	public Keywords getKeywordsByKeyword(Keywords keywords) throws Exception {
		return keywordsMapper.getKeywordsByKeyword(keywords);
	}

	@Override
	public void hl_SaveKeywords(Keywords keywords, User user, Date date) throws Exception {

	}

	@Override
	public void hl_changeStatusToOK(Keywords keywords, User user, Date date) throws Exception {

	}

	@Override
	public void hl_changeStatusToNo(Keywords keywords, User user, Date date) throws Exception {

	}

	@Override
	public void hl_keywordsXuFei(Keywords keywords, String productType, String xufeiYears, BigDecimal price, Date date) throws Exception {

	}

	@Override
	public int portalcount(Keywords keywords) throws Exception {
		return keywordsMapper.portalcount(keywords);
	}

	@Override
	public List<Keywords> getPortalBySearch(Keywords keywords) throws Exception {
		return keywordsMapper.getPortalBySearch(keywords);
	}
	@Override

	public List<Keywords> show_All_Keywords(int page,int limit, String keywords) {

		return keywordsMapper.getSelect_All_Keywords((page-1)*limit,limit,keywords);

	}



	@Override

	public boolean updKeywordsInfo(Keywords keywords) {

		return keywordsMapper.modifyKeywordss(keywords);

	}



	@Override

	public String getProvinces(String provinces) {

		return keywordsMapper.getProvinces(provinces);

	}



	@Override

	public List<Contact> getContactes(Integer customId) {

		return keywordsMapper.getContactes(customId);

	}



	@Override

	public String getAreas(String area) {

		return keywordsMapper.getAreas(area);

	}



	@Override

	public String getCities(String city) {

		return keywordsMapper.getCities(city);

	}



	@Override

	public Custom getCustom(Integer id) {

		return keywordsMapper.getCustom(id);

	}



	@Override

	public List<Keywords> getAllKeywordsList(Integer page, Integer limit) {

		return keywordsMapper.getKeywordsList(page,limit);

	}



	@Override

	public Keywords getKeywordInfoById(Integer id) {

		return keywordsMapper.getKeywordInfo(id);

	}



	@Override

	public List<Keywords> getListByName(Integer page, Integer limit, String keywords, String customeName) {

		return keywordsMapper.getListByName(page,limit,keywords,customeName);

	}



	@Override

	public int show_keywords_Count() {

		return keywordsMapper.getSelect_Keywords_Count();

	}



	@Override

	public boolean upd_Keywords(Keywords keywords) {

		return keywordsMapper.getUpdate_Keywords(keywords);

	}



	@Override

	public boolean del_Keywords(int id,int isUse) {

		return keywordsMapper.getDelect_Keywords(id,isUse);

	}


}
