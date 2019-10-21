package com.csdj.service;

import java.util.List;


import com.csdj.entity.Area;
import com.csdj.entity.City;
import com.csdj.entity.Province;
import com.csdj.XMLmapper.ProvinceAndCitysMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("provinceandCitysservice")
public class ProvinceAndCitysServiceImpl implements ProvinceAndCitysService {

	@Autowired
	private ProvinceAndCitysMapper mapper;
	
	@Override
	public List<Province> getProvinceList()  throws Exception{
		// TODO Auto-generated method stub
		return mapper.getProvinceList();
	}

	@Override
	public List<City> getCitys(Province province)  throws Exception{
		// TODO Auto-generated method stub
		return mapper.getCitys(province);
	}

	@Override
	public List<Area> getAreas(City city)  throws Exception{
		// TODO Auto-generated method stub
		return mapper.getAreas(city);
	}

}
