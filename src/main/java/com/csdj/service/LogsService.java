package com.csdj.service;



import com.csdj.entity.Logs;

import java.util.List;



public interface LogsService {
	/**
	 * getList
	 * @return
	 */
	public List<Logs> getList(Logs logs) throws Exception;
	/**
	 * addLogs
	 * @param logs
	 * @return
	 */
	public int hladdLogs(Logs logs) throws Exception;
	
	/**
	 * @param logs
	 * @return
	 * @throws Exception
	 */
	public int count(Logs logs) throws Exception;

	public List<Logs> getLogsInfo();

}
