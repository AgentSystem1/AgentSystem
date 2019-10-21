package com.csdj.service;

import java.util.List;


import com.csdj.XMLmapper.LogsMapper;
import com.csdj.entity.Logs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("logsservice")
public class LogsServiceImpl implements LogsService {

	@Autowired
	private LogsMapper mapper;
	

	public List<Logs> getList(Logs logs)  throws Exception{
		// TODO Auto-generated method stub
		return mapper.getList(logs);
	}


	public int hladdLogs(Logs logs)  throws Exception{
		// TODO Auto-generated method stub
		return mapper.addLogs(logs);
	}


	public int count(Logs logs) throws Exception {
		// TODO Auto-generated method stub
		return mapper.count(logs);
	}

	@Override
	public List<Logs> getLogsInfo() {
		return mapper.getLogsInfo();
	}

}
