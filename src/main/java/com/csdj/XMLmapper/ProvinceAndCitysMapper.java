package com.csdj.XMLmapper;

import java.util.List;

import com.csdj.entity.Area;
import com.csdj.entity.City;
import com.csdj.entity.Province;


public interface ProvinceAndCitysMapper {

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
