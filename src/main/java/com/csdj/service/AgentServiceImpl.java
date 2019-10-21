package com.csdj.service;

import com.csdj.XMLmapper.AgentMapper;
import com.csdj.entity.Contact;
import com.csdj.entity.Custom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("agentService")
public class AgentServiceImpl implements AgentService {
    @Autowired
    private AgentMapper agentMapper;

    public void setAgentMapper(AgentMapper agentMapper) {
        this.agentMapper = agentMapper;
    }

    //代理商客户管理
    @Override
    public List<Custom> get_AgentClientInfo(String customName) {
        return agentMapper.get_AgentClientInfo(customName);
    }

    public Custom getCustomById(Custom custom)  throws Exception{
        // TODO Auto-generated method stub
        return agentMapper.getCustomById(custom);
    }

    public Custom getCustomBySearch(Custom custom)  throws Exception{
        // TODO Auto-generated method stub
        return agentMapper.getCustomBySearch(custom);
    }

    public int modifyCustom(Custom custom)  throws Exception{
        // TODO Auto-generated method stub
        return agentMapper.modifyCustom(custom);
    }

    public int addCustom(Custom custom)  throws Exception{
        // TODO Auto-generated method stub
        return agentMapper.addCustom(custom);
    }

    public int deleteCustom(Custom custom)  throws Exception{
        // TODO Auto-generated method stub
        return agentMapper.deleteCustom(custom);
    }

    public boolean hl_addCustomContact(Custom custom, List<Contact> contactList) throws Exception{
        int addCustomId = 0;
        agentMapper.addCustom(custom);
        addCustomId = agentMapper.getAddCustomId();
        if(null != contactList && contactList.size() > 0 && addCustomId != 0){
            for(int i = 0; i <  contactList.size(); i++){
                if(null != contactList.get(i)
                        && null != contactList.get(i).getContactName() && !contactList.get(i).getContactName().equals("")
                        && null != contactList.get(i).getContactTel() && !contactList.get(i).getContactTel().equals("")){
                    contactList.get(i).setCustomId(addCustomId);
                    agentMapper.add_ContactInfo(contactList.get(i));
                }
            }
        }
        return true;
    }

    @Override
    public int getAddCustomId()  throws Exception{
        // TODO Auto-generated method stub
        return agentMapper.getAddCustomId();
    }

    @Override
    public int modifyCustomStatus(Custom custom) throws Exception {
        // TODO Auto-generated method stub
        return agentMapper.modifyCustomStatus(custom);
    }

    @Override
    public Custom get_ListByName(Custom custom) throws Exception {
        return agentMapper.get_ListByName(custom);
    }

    @Override
    public boolean hl_modifyCustomContact(Custom custom,
                                          List<Contact> contactList) throws Exception {
        // TODO Auto-generated method stub
        agentMapper.modifyCustom(custom);
        int cid = custom.getId();
        Contact contact = new Contact();
        contact.setCustomId(cid);
        agentMapper.del_ContactInfo(contact);
        if(null != contactList){
            for(int i = 0; i < contactList.size(); i++){
                if(null != contactList.get(i)
                        && null != contactList.get(i).getContactName() && !contactList.get(i).getContactName().equals("")
                        && null != contactList.get(i).getContactTel() && !contactList.get(i).getContactTel().equals("")){
                    contactList.get(i).setCustomId(cid);
                    agentMapper.add_ContactInfo(contactList.get(i));
                }
            }
        }
        return false;
    }

    @Override
    public int count(Custom custom) throws Exception {
        // TODO Auto-generated method stub
        return agentMapper.count(custom);
    }

    @Override
    public List<String> getcustomername(){
        System.out.println("--------------方法进入");
        return agentMapper.getcustomername();
    }
    @Override
    public int isExitCustomName(Custom custom) throws Exception {
        // TODO Auto-generated method stub
        return agentMapper.isExitCustomName(custom);
    }


    //代理商客户联系人
    @Override
    public List<Contact> get_ContactInfo(Integer customId) {
        return agentMapper.get_ContactInfo(customId);
    }

    @Override
    public int add_ContactInfo(Contact contact) {
        return agentMapper.add_ContactInfo(contact);
    }

    @Override
    public int upd_ContactInfo(Contact contact) {
        return agentMapper.upd_ContactInfo(contact);
    }

    @Override
    public int del_ContactInfo(Contact contact) {
        return agentMapper.del_ContactInfo(contact);
    }
}
