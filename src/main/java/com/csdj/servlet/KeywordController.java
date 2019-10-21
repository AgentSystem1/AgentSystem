package com.csdj.servlet;
;





import com.csdj.entity.*;


import com.csdj.service.KeywordsService;
import com.csdj.service.SystemConfigService;


import com.csdj.util.JsonTools;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

/*import com.csdj.util.JsonTools;*/


import java.util.HashMap;

import java.util.List;

import java.util.Map;

    /**

     * 关键词业务分配器

     */

    @Controller
    @RequestMapping("/controller")
    public class KeywordController {

        private Logger logger = Logger.getLogger(AgentController.class);

        @Autowired

        private KeywordsService keywordsService;



        @Autowired

        private SystemConfigService systemConfigService;



        @RequestMapping(value = "/keyword/checkInfoById.html/{id}")

        public ModelAndView getkeywordInfo(@PathVariable("id") Integer id,ModelAndView mv){

            Keywords keywords = keywordsService.getKeywordInfoById(id);

            Custom custom =keywordsService.getCustom(id);

            logger.debug("id dashabi-----------------------"+id);
            logger.debug("keywords size-----------------------"+keywords.getAgentName());
            logger.debug("custom size-----------------------"+custom.getAgentName());
            if (custom != null) {

                List<Contact>  contactList=keywordsService.getContactes(custom.getId());
                String province =keywordsService.getProvinces(custom.getProvince());
                String area =keywordsService.getAreas(custom.getArea());
                String city=keywordsService.getCities(custom.getCity());

                mv.addObject("contactList",contactList);

                mv.addObject("area",area);

                mv.addObject("city",city);

                mv.addObject("province",province);

            }

            mv.addObject("custom",custom);

            mv.addObject("keywords",keywords);

            mv.setViewName("/DoorManager/PMCheckInfo");

            return mv;

        }



        @RequestMapping(value = "/keyword/upKeywordsInfoById.html")

        public String upKeywordsInfoById(Keywords keywords){

            System.out.println(keywords.getAppUserName()+"asfasfasf");

            boolean flag = keywordsService.updKeywordsInfo(keywords);

            if(flag){

                return "/DoorManager/PMCheckInfo";

            }else{

                return "redirect:/keyword/upInfoById.html/" + keywords.getId();

            }

        }













        @RequestMapping(value = "/keyword/upInfoById.html/{id}")

        public ModelAndView upInfoById(@PathVariable("id")Integer id,ModelAndView mv){

            Keywords keywords = keywordsService.getKeywordInfoById(id);

            Custom custom =keywordsService.getCustom(id);

            if (custom != null) {

                List<Contact>  contactList=keywordsService.getContactes(custom.getId());

                String province =keywordsService.getProvinces(custom.getProvince());

                String area =keywordsService.getAreas(custom.getArea());

                String city=keywordsService.getCities(custom.getCity());

                mv.addObject("contactList",contactList);

                mv.addObject("area",area);

                mv.addObject("city",city);

                mv.addObject("province",province);

            }

            mv.addObject("custom",custom);

            mv.addObject("keywords",keywords);

            mv.setViewName("/DoorManager/PMUpdInfo");

            return mv;

        }

        @RequestMapping(value = "/keyword/getList.json")

        @ResponseBody

        public Map<String,Object> getList(Integer page,Integer limit){

            page= (page - 1) *limit ;

            System.out.println(limit);

            System.out.println(page);

            List<Keywords> keywordsList = keywordsService.getAllKeywordsList(page, limit);

            Map<String,Object> map = new HashMap<>();

            map.put("code" , 0);

            map.put("mas" ,"");

            map.put("count",keywordsService.show_keywords_Count());

            map.put("data",keywordsList);

            return map;

        }



        @RequestMapping(value = "/keyword/getListByName.json")

        @ResponseBody

        public Map<String,Object> getListByName(@RequestParam("page") Integer page,@RequestParam("limit")Integer limit,@RequestParam(value = "keywords",required = false)String keywords,@RequestParam(value = "customName",required = false)String customName){

            page= (page - 1) *limit ;

            System.out.println(limit);

            System.out.println(page);

            List<Keywords> keywordsList = keywordsService.getListByName(page,limit,keywords,customName);

            Map<String,Object> map = new HashMap<>();

            map.put("code" , 0);

            map.put("mas" ,"");

            map.put("count",keywordsService.show_keywords_Count());

            map.put("data",keywordsList);

            System.out.println("asdasdasfasfasdasd"+keywordsList);

            return map;

        }





        @RequestMapping(value = "/keywords.html",method = RequestMethod.GET)

        public String keywords(@ModelAttribute Keywords keywords, Model model){

            model.addAttribute("systemConfigs",systemConfigService.show_all_systemConfig());

            return "keywords";

        }



        @RequestMapping(value = "/showKeywords.json",method = RequestMethod.GET)

        @ResponseBody

        public Map<String, Object> showKeywords(@RequestParam int page,@RequestParam int limit,

                                                @RequestParam(required = false)String keywords){

            return JsonTools.jsonData(keywordsService.show_keywords_Count(), keywordsService.show_All_Keywords(page,limit,keywords));

        }


        @RequestMapping(value = "/updKeywords.html",method = RequestMethod.POST)

        public String updKeywords(Keywords keywords){

            keywordsService.upd_Keywords(keywords);

            return "keywords";

        }



        @RequestMapping(value = "/updStatus.html",method = RequestMethod.GET)

        public String updStatus(@RequestParam int id,@RequestParam int isUse){

            keywordsService.del_Keywords(id,isUse);

            return "redirect:/keywords.html";

        }

}
