package com.csdj.servlet;
import com.csdj.entity.*;
import com.csdj.service.AccountDetailService;
import com.csdj.service.AgentService;
import com.csdj.service.KeywordsService;
import com.csdj.service.LogsService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/controller")
public class AgentController {
    @Resource
    private KeywordsService keywordsService;
    @Resource
    private AccountDetailService accountDetailService;
    @Resource
    private AgentService agentService;
    @Resource
    private LogsService logsService;
    @Autowired
    public void setKeywordsService(KeywordsService keywordsService) {
        this.keywordsService = keywordsService;
    }

    @Autowired
    public void setAccountDetailService(AccountDetailService accountDetailService) {
        this.accountDetailService = accountDetailService;
    }


    private Logger logger = Logger.getLogger(AgentController.class);

    @Autowired
    public void setAgentService(AgentService agentService) {
        this.agentService = agentService;
    }

    //代理商客户管理
    @RequestMapping("agentClientList")
    @ResponseBody
        public List<Custom> get_news_detailList(@RequestParam(value = "customName", required = false) String customName) {
            logger.debug("customName------------------------->" + customName);
            List<Custom> customs= agentService.get_AgentClientInfo(customName);
            logger.debug("customs------------------------->" + customs.size());
            return customs;
        }

    @RequestMapping("set_client")
    public String set_client(Custom custom){
        int cus=custom.getCustomType();
        int card=custom.getCardType();
        custom.setCountry("中国");
        Map<String,String> map=transitiondata(cus,card);
        custom.setCustomTypeName(map.get("cusname"));
        custom.setCardTypeName(map.get("cardname"));
        custom.setAgentId(2);
        custom.setAgentName("admin");
        System.out.println(custom.toString());
        List<Contact> list=null;
        boolean pa=false;
        try {
            //如果没有list为空 size方法会出现异常
            list =custom.getList();
            pa=list.size()>0?true:false;
        }catch (Exception e){
            pa=false;
        }

        try {
            agentService.addCustom(custom);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int clientid=0;
        if (pa){
            try {
                Custom custom1= agentService.getCustomBySearch(custom);
                clientid=custom1.getId();
                for (Contact contact:list) {
                    //如果前段传来数据为空就结束本轮循环
                    if (contact.getContactName()==null || contact.getContactName().trim()=="" ){
                        continue;
                    }
                    Contact con=contact;
                    contact.setCustomId(clientid);
                    agentService.add_ContactInfo(contact);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return  "AgentManager/AgentClientManager";
    }

    public Map<String,String> transitiondata(int cus,int card){
        String cusname="数值空";
        String cardname="数值空";
        Map<String,String> map=new HashMap<>();
        switch (cus){
            case 16:
                cusname="企业";
                break;
            case 17:
                cusname="个人";
                break;
            case 18:
                cusname="政府";
                break;
        }

        switch (card){
            case 19:
                cardname="国内身份证";
                break;
            case 20:
                cardname="境外身份证";
                break;
            case 21:
                cardname="营业执照";
                break;
            case 22:
                cardname="其他证件";
                break;

        }
        map.put("cusname",cusname);
        map.put("cardname",cardname);
        return map;
    }

    @RequestMapping("update_client/{item}")
    public String update_client(@PathVariable int[] item, Custom custom) throws Exception {
        int cus=custom.getCustomType();
        int card=custom.getCardType();
        Map<String,String> map=transitiondata(cus,card);
        custom.setCustomTypeName(map.get("cusname"));
        custom.setCardTypeName(map.get("cardname"));

        System.out.println(custom.toString());
        List<Contact> list=null;
        boolean pa=false;
        try {
            //如果没有list为空 size方法会出现异常
            list =custom.getList();
            pa=list.size()>0?true:false;
        }catch (Exception e){
            pa=false;
        }
        try {
            agentService.modifyCustom(custom);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int clientid=0;
        if (pa){
            try {
                Custom custom1= agentService.getCustomBySearch(custom);
                clientid=custom1.getId();
                for (Contact contact:list) {
                    //如果前段传来数据为空就结束本轮循环
                    if (contact.getContactName()==null || contact.getContactName().trim()=="" ){
                        continue;
                    }
                    Contact con=contact;
                    contact.setCustomId(clientid);
                    agentService.add_ContactInfo(contact);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("----------------------------------------删除集合第一个下标值"+item[0]);
        if (item[0]!=-1){
            for (int i=0;i<item.length;i++){
                Contact contact=new Contact();
                contact.setId(item[i]);
                agentService.del_ContactInfo(contact);
            }
        }
        return  "AgentManager/AgentClientManager";
    }

    @RequestMapping("update_Custom/{item}")
    @ResponseBody
    public Object update_Custom(@PathVariable int[] item){
        Custom custom=new Custom();
        System.out.println("---------------------------------得到数据主键ID"+item[0]+"-------------->改变类型"+item[1]);
        custom.setId(item[0]);
        custom.setCustomStatus(item[1]);
        int i=0;
        try {
            i=agentService.modifyCustomStatus(custom);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @RequestMapping("getAccountDetailList")
    @ResponseBody
    public List<AccountDetail> getAccountDetailList(@RequestParam(value = "begin",required = false) Object begin, @RequestParam(value = "finish",required = false) Object finish){
        boolean account;
        try {
            account =begin.equals(null) || null==begin;
        }catch (Exception e){
            account=true;
        }
        List<AccountDetail> list= null;
        AccountDetail accountDetail=new AccountDetail();
        try {
            if (!account){
                DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                System.out.println("-------------------------------------得到数据"+begin+""+finish);
                accountDetail.setStartTime(format1.parse(begin.toString()));
                accountDetail.setEndTime(format1.parse(finish.toString()));
            }
            System.out.println("查询方法进入I");
            list = accountDetailService.getAccountDetail(accountDetail);
        } catch (Exception e) {
            System.out.println("--------------------------------------------得到数据出现异常");
            e.printStackTrace();
        }
        return  list;
    }

    @Test
    public void test_list(){
        List<Contact> list=null;
        try {
            list=agentService.get_ContactInfo(null);
        }catch (Exception e){
            System.out.println("客户联系人查询异常");
        }

    }

    @RequestMapping("getcustomername")
    @ResponseBody
    public List<String> getcustomername(){
        System.out.println("方法进入");
        List<String> list=agentService.getcustomername();
        return list;
    }

    @RequestMapping("addkeywords")

    public String addkeywords(Keywords keywords) throws Exception {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        Date date1=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, +keywords.getServiceYears());
        date = calendar.getTime();
        calendar.add(Calendar.DATE, -7);
        date1=calendar.getTime();
        System.out.println(sdf.format(date1));
        keywords.setCustomId(2);
        keywords.setOpenApp(0);
        keywords.setAppUserName("admin");
        keywords.setAppPassword("888888");
        keywords.setPreRegDatetime(new Date());
        keywords.setRegPassDatetime(date1);
        keywords.setRegDatetime(new Date());
        keywords.setRegPassDatetime(date);
        keywords.setIsUse(1);
        keywords.setIsPass(2);
        keywords.setPreRegFrozenMoney(new BigDecimal(50000));
        keywords.setAgentId(2);
        keywords.setAgentName("admin");
        int count=keywordsService.addKeywords(keywords);
        if(count>0){
            return "systemmanagement/key/keywords";
        }
        return "DoorManager/KeywordDapplyfor";
    }

        //代理商客户联系人
    @RequestMapping("contactList")
    @ResponseBody
    public List<Contact> get_ContactsInfo(@RequestParam(value = "customId", required = false) Integer customId){
        logger.debug("customId------------------------->" + customId);
        List<Contact> contacts=null;
        try {
            contacts=agentService.get_ContactInfo(customId);
        }catch (Exception e){
            System.out.println("客户联系人查询异常");
        }
        return contacts;
    }

    @RequestMapping(value = "logs/getLogs.json")
    @ResponseBody
    public List<Logs> getLogsInfo(){

        return logsService.getLogsInfo();

    }


}
