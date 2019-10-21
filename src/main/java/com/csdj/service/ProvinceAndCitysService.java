package com.csdj.service;


import com.csdj.entity.Area;
import com.csdj.entity.City;
import com.csdj.entity.Province;
import org.springframework.stereotype.Service;

import java.util.List;




public interface ProvinceAndCitysService {

	/**
	 * getProvinceList
	 * @return
	 */
	public List<Province> getProvinceList() throws Exception;
	/**
	 * getCitys
	 * @param province
	 * @return
	 */
	public List<City> getCitys(Province province) throws Exception;
	/**
	 * getAreas
	 * @param city
	 * @return
	 */
	public List<Area> getAreas(City city) throws Exception;
}
