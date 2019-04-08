package com.internousdev.earth.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.earth.dao.ProductInfoDAO;
import com.internousdev.earth.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductDetailsAction extends ActionSupport implements SessionAware {
	private int id;
	private Map<String, Object> session;
	private ProductInfoDAO productInfoDAO = new ProductInfoDAO();
	private ArrayList<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
	private ProductInfoDTO dto = new ProductInfoDTO();
	private List<ProductInfoDTO> selectRelativeList;
	private List<Integer> countList;

	public String execute() {
		String result = ERROR;
		dto = productInfoDAO.selectByProductId(id);

		// 関連商品
		selectRelativeList = productInfoDAO.selectRelative(dto.getCategoryId());

		// 商品一覧
		dto = productInfoDAO.selectByProductId(dto.getCategoryId());

		// 購入個数のリストを作成
		countList = new ArrayList<Integer>();
		for (int i = 1; i <= 5; i++) {
			countList.add(i);
		}

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

	public List<Integer> getCountList() {
		return countList;
	}

	public void setCountList(List<Integer> countList) {
		this.countList = countList;
	}

	public List<ProductInfoDTO> getSelectRelativeList() {
		return selectRelativeList;
	}

	public void setSelectRelativeList(List<ProductInfoDTO> selectRelativeList) {
		this.selectRelativeList = selectRelativeList;
	}
}
