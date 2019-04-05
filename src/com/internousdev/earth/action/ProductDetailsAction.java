package com.internousdev.earth.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.earth.dao.ProductInfoDAO;
import com.internousdev.earth.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductDetailsAction extends ActionSupport implements SessionAware{
	private int id;
	private Map<String, Object> session;
	private ProductInfoDAO productInfoDAO = new ProductInfoDAO();
	private ArrayList<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
	private ProductInfoDTO dto=new ProductInfoDTO();

	public String execute(){
		String result=ERROR;
		dto=productInfoDAO.selectByProductId(id);

		return result;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public ProductInfoDAO getProductInfoDAO() {
		return productInfoDAO;
	}
	public void setProductInfoDAO(ProductInfoDAO productInfoDAO) {
		this.productInfoDAO = productInfoDAO;
	}
	public ArrayList<ProductInfoDTO> getProductInfoDTOList() {
		return productInfoDTOList;
	}
	public void setProductInfoDTOList(ArrayList<ProductInfoDTO> productInfoDTOList) {
		this.productInfoDTOList = productInfoDTOList;
	}
	public ProductInfoDTO getDto() {
		return dto;
	}
	public void setDto(ProductInfoDTO dto) {
		this.dto = dto;
	}

}
