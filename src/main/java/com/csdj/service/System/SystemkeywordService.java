package com.csdj.service.System;

import com.csdj.entity.Keywords;
import com.csdj.entity.SystemConfig;

import java.util.List;

/**
 * 系统管理 -   - 关键词审核 Service接口
 */

public interface SystemkeywordService {

    /**
     * 显示全部系统配置信息
     * @return 系统配置信息
     */
    List<SystemConfig> show_all_systemConfig();

    /**
     * 显示全部关键词
     * @return 关键词
     */
    List<Keywords> show_All_Keywords(int page, int limit, String keywords);

    /**
     * 显示关键词数量
     * @return 数量
     */
    int show_keywords_Count();

    /**
     * 修改关键词信息
     * @param keywords 关键词信息
     * @return 成功，失败
     */
    boolean upd_Keywords(Keywords keywords);

    /**
     * 删除关键词
     * @param id 关键词id
     * @param isUse 状态
     * @return 成功，失败
     */
    boolean del_Keywords(int id,int isUse);

}
