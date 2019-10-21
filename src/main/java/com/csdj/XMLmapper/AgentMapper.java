package com.csdj.XMLmapper;

import com.csdj.entity.AccountDetail;
import com.csdj.entity.Contact;
import com.csdj.entity.Custom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AgentMapper {

    //代理商客户管理
    /**
     * 得到代理商客户数据
     * @return
     */
    public List<Custom> get_AgentClientInfo(@Param("customName")String customName);

    /**
     * count
     * @return
     * @throws Exception
     */
    public int count(Custom custom) throws Exception;

    /**
     * isExitCustomName
     * @return
     * @throws Exception
     */
    public int isExitCustomName(Custom custom) throws Exception;

    /**
     * getCustomById
     * @param custom
     * @return
     */
    public Custom getCustomById(Custom custom) throws Exception;

    /**
     * getCustomBySearch
     * @param custom
     * @return
     */
    public Custom getCustomBySearch(Custom custom) throws Exception;

    /**
     * modifyCustom
     * @param custom
     * @return
     */
    public int modifyCustom(Custom custom) throws Exception;

    /**
     * addCustom
     * @param custom
     * @return
     */
    public int addCustom(Custom custom) throws Exception;

    /**
     * deleteCustom
     * @param custom
     * @return
     */
    public int deleteCustom(Custom custom) throws Exception;

    /**
     * getAddCustomId
     * @return
     */
    public int getAddCustomId() throws Exception;

    /**
     * @param custom
     * @return
     * @throws Exception
     */
    public int modifyCustomStatus(Custom custom) throws Exception;


    public Custom get_ListByName(Custom custom) throws Exception;


    public List<AccountDetail> getAccountDetail(AccountDetail accountDetail);


    public List<String> getcustomername();






    //代理商客户联系人
    /**
     * 得到代理商客户联系人数据
     * @return
     */
    public List<Contact> get_ContactInfo(@Param("customId")Integer customId);

    /**
     * 新增代理商客户联系人数据
     * @param contact
     * @return
     */
    public int add_ContactInfo(Contact contact) ;

    /**
     * 修改代理商客户联系人数据
     * @param contact
     * @return
     */
    public int upd_ContactInfo(Contact contact) ;

    /**
     * 删除代理商客户联系人数据
     * @param contact
     * @return
     */
    public int del_ContactInfo(Contact contact);
}
