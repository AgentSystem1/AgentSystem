package com.csdj.servlet.System;

import com.csdj.entity.Keywords;
import com.csdj.entity.SystemConfig;
import com.csdj.service.System.SystemkeywordService;
import com.csdj.util.JsonToolsGet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 系统管理 -   -   关键词审核  控制器
 */

@Controller
@RequestMapping(value = "keyword")
public class keywordController {

    @Resource
    private SystemkeywordService keywordService;

    /**
     * 当完成操作后执行的跳转jsp
     * @return
     */
    @RequestMapping(value = "/keywordss.html")
    public String keywordss(){
        return "systemmanagement/key/keywords";
    }


    /**
     * 查询到全部系统配置信息
     * @return
     */
    @RequestMapping(value = "/keywords.html")
    @ResponseBody
    public List<SystemConfig> keywords(){
        List<SystemConfig> systemConfigList = keywordService.show_all_systemConfig();
        return systemConfigList;
    }

    /**
     * 显示全部关键词
     * @param page
     * @param limit
     * @param keywords
     * @return
     */
    @RequestMapping(value = "/showKeywords.json",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> showKeywords(@RequestParam int page, @RequestParam int limit,
                                            @RequestParam(required = false)String keywords){
        return JsonToolsGet.jsonData(keywordService.show_keywords_Count(), keywordService.show_All_Keywords(page,limit,keywords));
    }

    /**
     *  修改关键词信息
     * @param keywords
     * @return
     */
    @RequestMapping(value = "/updKeywords.html",method = RequestMethod.POST)
    public String updKeywords(Keywords keywords){
        keywordService.upd_Keywords(keywords);
        return "redirect:/keyword/keywordss.html";
    }

    /**
     * 删除关键词
     * @param id
     * @param isUse
     * @return
     */
    @RequestMapping(value = "/updStatus.html",method = RequestMethod.GET)
    public String updStatus(@RequestParam int id,@RequestParam int isUse){
        keywordService.del_Keywords(id,isUse);
        return "redirect:/keyword/keywordss.html";
    }


}
