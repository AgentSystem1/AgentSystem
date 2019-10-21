package com.csdj.servlet;

import com.csdj.entity.SystemConfig;
import com.csdj.service.SystemConfigService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


@Controller
@RequestMapping("/controller")
public class SystemConfigController {

	@Resource
    private SystemConfigService systemConfigService;
    private Logger logger = Logger.getLogger(SystemConfigController.class);

    @Autowired
    public void setNews_detailService(SystemConfigService systemConfigService) {
        this.systemConfigService = systemConfigService;
    }

	//账务类型
	@RequestMapping("accountingTypeList")
	@ResponseBody
	public List<SystemConfig> get_AccountingTypeInfo() {
		List<SystemConfig> accountingTypes = systemConfigService.get_AccountingTypeInfo();
		logger.debug("accountingTypes------------------------->" + accountingTypes.size());
		return accountingTypes;
	}

	@RequestMapping("accountingTypeAdd")
	public String add_AccountingTypeInfo(@RequestParam("configTypeName") String configTypeName, @RequestParam("isStart") int isStart) {
		logger.debug("configTypeName------------------------->" + configTypeName);
		logger.debug("isStart------------------------->" + isStart);
		if (systemConfigService.add_AccountingTypeInfo(configTypeName, isStart) > 0) {
			return "SystemConfigManager/AccountingType";
		}
		return "SystemConfigManager/AccountingType";
	}

	@RequestMapping("accountingTypeDel")
	public String del_AccountingTypeInfo(@RequestParam("id") Integer id) {
		logger.debug("id------------------------->" + id);
		if (systemConfigService.del_AccountingTypeInfo(id) > 0) {
			return "SystemConfigManager/AccountingType";
		}
		return "SystemConfigManager/AccountingType";
	}

	@RequestMapping("accountingTypeUpd")
	public String Upd_AccountingTypeInfo(SystemConfig systemConfig) {
		logger.debug("systemConfig------------------------->" + systemConfig.getId());
		if (systemConfigService.upd_AccountingTypeInfo(systemConfig) > 0) {
			return "SystemConfigManager/AccountingType";
		}
		return "SystemConfigManager/AccountingType";
	}


	//服务类型
	@RequestMapping("serveTypeList")
	@ResponseBody
	public List<SystemConfig> get_ServeTypeInfo() {
		List<SystemConfig> serveTypes = systemConfigService.get_ServeTypeInfo();
		logger.debug("serveTypes------------------------->" + serveTypes.size());
		return serveTypes;
	}

	@RequestMapping("serveTypeAdd")
	public String add_ServeTypeInfo(SystemConfig systemConfig) {
		logger.debug("systemConfig------------------------->" + systemConfig.getId());
		if (systemConfigService.add_ServeTypeInfo(systemConfig) > 0) {
			return "SystemConfigManager/ServeType";
		}
		return "SystemConfigManager/ServeType";
	}

	@RequestMapping("serveTypeUpd")
	public String upd_ServeTypeInfo(SystemConfig systemConfig) {
		logger.debug("systemConfig------------------------->" + systemConfig.getId());
		if (systemConfigService.upd_ServeTypeInfo(systemConfig) > 0) {
			return "SystemConfigManager/ServeType";
		}
		return "SystemConfigManager/ServeType";
	}


	//客户类型
	@RequestMapping("clientTypeList")
	@ResponseBody
	public List<SystemConfig> get_ClientTypeInfo() {
		List<SystemConfig> clientTypes = systemConfigService.get_ClientTypeInfo();
		logger.debug("clientTypes------------------------->" + clientTypes.size());
		return clientTypes;
	}

	@RequestMapping("clientTypeAdd")
	public String add_ClientTypeInfo(SystemConfig systemConfig) {
		logger.debug("systemConfig------------------------->" + systemConfig.getId());
		if (systemConfigService.add_ClientTypeInfo(systemConfig) > 0) {
			return "SystemConfigManager/ClientType";
		}
		return "SystemConfigManager/ClientType";
	}

	@RequestMapping("clientTypeUpd")
	public String upd_ClientTypeInfo(SystemConfig systemConfig) {
		logger.debug("systemConfig------------------------->" + systemConfig.getId());
		if (systemConfigService.upd_ClientTypeInfo(systemConfig) > 0) {
			return "SystemConfigManager/ClientType";
		}
		return "SystemConfigManager/ClientType";
	}

	@RequestMapping("clientTypeDel")
	public String del_ClientTypeInfo(@RequestParam("id") Integer id) {
		logger.debug("id------------------------->" + id);
		if (systemConfigService.del_ClientTypeInfo(id) > 0) {
			return "SystemConfigManager/ClientType";
		}
		return "SystemConfigManager/ClientType";
	}


	//证件类型
	@RequestMapping("credentialsTypeList")
	@ResponseBody
	public List<SystemConfig> get_CredentialsInfo() {
		List<SystemConfig>  credentialsTypes= systemConfigService.get_CredentialsInfo();
		logger.debug("credentialsTypes------------------------->" + credentialsTypes.size());
		return credentialsTypes;
	}

	@RequestMapping("credentialsTypeListAdd")
	public String add_CredentialsInfo(SystemConfig systemConfig) {
		logger.debug("systemConfig------------------------->" + systemConfig.getId());
		if (systemConfigService.add_CredentialsInfo(systemConfig) > 0) {
			return "SystemConfig/CredentialsType";
		}
		return "SystemConfigManager/CredentialsType";
	}

	@RequestMapping("credentialsTypeListUpd")
	public String upd_CredentialsInfo(SystemConfig systemConfig) {
		logger.debug("systemConfig------------------------->" + systemConfig.getId());
		if (systemConfigService.upd_CredentialsInfo(systemConfig) > 0) {
			return "SystemConfig/CredentialsType";
		}
		return "SystemConfigManager/CredentialsType";
	}

	@RequestMapping("credentialsTypeListDel")
	public String del_CredentialsInfo(@RequestParam("id") Integer id) {
		logger.debug("id------------------------->" + id);
		if (systemConfigService.del_CredentialsInfo(id) > 0) {
			return "SystemConfig/CredentialsType";
		}
		return "SystemConfigManager/CredentialsType";
	}


	//优惠类型
	@RequestMapping("preferentialTypeList")
	@ResponseBody
	public List<SystemConfig> get_PreferentialInfo() {
		List<SystemConfig>  preferentialTypes= systemConfigService.get_PreferentialInfo();
		logger.debug("preferentialTypes------------------------->" + preferentialTypes.size());
		return preferentialTypes;
	}

	@RequestMapping("preferentialTypeAdd")
	public String add_PreferentialInfo(SystemConfig systemConfig) {
		logger.debug("systemConfig------------------------->" + systemConfig.getId());
		if (systemConfigService.add_PreferentialInfo(systemConfig) > 0) {
			return "SystemConfigManager/PreferentialType";
		}
		return "SystemConfigManager/PreferentialType";
	}

	@RequestMapping("preferentialTypeUpd")
	public String upd_PreferentialInfo(SystemConfig systemConfig) {
		logger.debug("systemConfig------------------------->" + systemConfig.getId());
		if (systemConfigService.upd_PreferentialInfo(systemConfig) > 0) {
			return "SystemConfigManager/PreferentialType";
		}
		return "SystemConfigManager/PreferentialType";
	}

	@RequestMapping("preferentialTypeDel")
	public String del_PreferentialInfo(@RequestParam("id") Integer id) {
		logger.debug("id------------------------->" + id);
		if (systemConfigService.del_PreferentialInfo(id) > 0) {
			return "SystemConfigManager/PreferentialType";
		}
		return "SystemConfigManager/PreferentialType";
	}


	//服务年限
	@RequestMapping("serveYearsList")
	@ResponseBody
	public SystemConfig get_ServeYearsInfo() {
		SystemConfig  serveYearss= systemConfigService.get_ServeYearsInfo();
		logger.debug("serveYearss------------------------->" + serveYearss.getId());
		return serveYearss;
	}

	@RequestMapping("serveYearsUpd")
	@ResponseBody
	public String upd_ServeYearsInfo(@RequestParam("id") Integer id,@RequestParam("configValue") String configValue) {
		logger.debug("id------------------------->" + id);
		logger.debug("configValue------------------------->" + configValue);
		if (systemConfigService.upd_ServeYearsInfo(configValue,id) > 0) {
			return "true";
		}
		return "false";
	}


	//App地址
	@RequestMapping("appAddressList")
	@ResponseBody
	public SystemConfig get_AppAddressInfo() {
		SystemConfig  appAddresss= systemConfigService.get_AppAddressInfo();
		logger.debug("appAddresss------------------------->" + appAddresss.getId());
		return appAddresss;
	}

	@RequestMapping("appAddressUpd")
	@ResponseBody
	public String upd_AppAddressInfo(@RequestParam("id") Integer id,@RequestParam("configValue") String configValue) {
		logger.debug("id------------------------->" + id);
		logger.debug("configValue------------------------->" + configValue);
		if (systemConfigService.upd_AppAddressInfo(configValue,id) > 0) {
			return "true";
		}
		return "false";
	}
}
