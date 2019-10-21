package com.csdj.XMLmapper;

import com.csdj.entity.Logs;
;

import java.util.List;


/**
 * 操作日志
 */
public interface LogsMapper {
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
	public int addLogs(Logs logs) throws Exception;
	
	/**
	 * @param logs
	 * @return
	 * @throws Exception
	 */
	public int count(Logs logs) throws Exception;



	public List<Logs> getLogsInfo();
}
