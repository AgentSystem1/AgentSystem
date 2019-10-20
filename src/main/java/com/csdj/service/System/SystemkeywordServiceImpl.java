package com.csdj.service.System;

import com.csdj.entity.Keywords;
import com.csdj.entity.SystemConfig;
import com.csdj.mapper.System.SystemkeywordMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统管理 -   -   关键词审核Service接口实现
 */

@Service
public class SystemkeywordServiceImpl implements  SystemkeywordService{

    @Resource
    private SystemkeywordMapper keywordMapper;

    /**
     * 显示全部系统配置信息
     * @return 系统配置信息
     */
    public List<SystemConfig> show_all_systemConfig() {
        return keywordMapper.getSelect_All_SystemConfig();
    }

    /**
     * 显示全部关键词
     * @return 关键词
     */
    public List<Keywords> show_All_Keywords(int page, int limit, String keywords) {
        return keywordMapper.getSelect_All_Keywords((page-1)*limit,limit,keywords);
    }

    /**
     * 显示关键词数量
     * @return 数量
     */
    public int show_keywords_Count() {
        return keywordMapper.getSelect_Keywords_Count();
    }

    /**
     * 修改关键词信息
     * @param keywords 关键词信息
     * @return 成功，失败
     */
    public boolean upd_Keywords(Keywords keywords) {
        return keywordMapper.getUpdate_Keywords(keywords);
    }

    /**
     * 删除关键词
     * @param id 关键词id
     * @param isUse 状态
     * @return 成功，失败
     */
    public boolean del_Keywords(int id,int isUse) {
        return keywordMapper.getDelect_Keywords(id,isUse);
    }


}
