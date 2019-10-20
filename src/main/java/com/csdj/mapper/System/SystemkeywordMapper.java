package com.csdj.mapper.System;

import com.csdj.entity.Keywords;
import com.csdj.entity.SystemConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统管理 -   - 关键词审核 接口
 */

public interface SystemkeywordMapper {

    /**
     * 查询全部系统配置信息
     * @return 系统配置信息
     */
    List<SystemConfig> getSelect_All_SystemConfig();

    /**
     * 查询全部关键词
     * @return 关键词
     */
    List<Keywords> getSelect_All_Keywords(@Param("page") int page,@Param("limit") int limit,@Param("keywords")String keywords);

    /**
     * 查询关键词的数量
     * @return 数量
     */
    int getSelect_Keywords_Count();

    /**
     * 修改关键词信息
     * @param keywords 关键词信息
     * @return 成功，失败
     */
    boolean getUpdate_Keywords(Keywords keywords);

    /**
     * 修改关键词状态
     * @param id 关键词id
     * @return 成功，失败
     */
    boolean getDelect_Keywords(@Param("id")int id, @Param("isUse")int isUse);
}
