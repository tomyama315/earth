package com.internousdev.earth.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.earth.dao.PurchaseHistoryInfoDAO;
import com.internousdev.earth.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PurchaseHistoryAction extends ActionSupport implements SessionAware{
	private List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList;
	private Map<String,Object> session;

	public String execute(){
		//タイムアウトのチェック
		if(session.isEmpty()){
			return "sessionTimeout";
		}

		PurchaseHistoryInfoDAO purchaseHistoryInfoDAO = new PurchaseHistoryInfoDAO();
		purchaseHistoryInfoDTOList = purchaseHistoryInfoDAO.getPurchaseHistoryList(String.valueOf(session.get("loginuserid")));

		return SUCCESS;
	}
	public List<PurchaseHistoryInfoDTO> getPurchaseHistoryInfoDTOList(){
		return purchaseHistoryInfoDTOList;
	}

	public void setPurchaseHistoryInfoDTOList(List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList){
		this.purchaseHistoryInfoDTOList = purchaseHistoryInfoDTOList;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
