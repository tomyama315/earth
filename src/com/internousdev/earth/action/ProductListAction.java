package com.internousdev.earth.action;a

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.earth.dao.ProductInfoDAO;
import com.internousdev.earth.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

	public class ProductListAction extends ActionSupport implements SessionAware{
		// 商品一覧
		private ArrayList<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
		// 商品情報
		private ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		private Map<String, Object> session;

		public String execute() {
	              productInfoDTOList = productInfoDAO.selectAll();
	                      return SUCCESS;
	            }



	//return productInfoDTOList
		public ArrayList<ProductInfoDTO> getProductInfoDTOList() {
			return productInfoDTOList;
		}

		// productInfoDTOList セット
		public void setProductInfoDTOList(ArrayList<ProductInfoDTO> productInfoDTOList) {
			this.productInfoDTOList = productInfoDTOList;
		}

		// return productInfoDAO
		public ProductInfoDAO getProductInfodao() {
			return productInfoDAO;
		}

		// productInfoDAO セットする
		public void setProductInfodao(ProductInfoDAO productInfodao) {
			this.productInfoDAO = productInfodao;
		}



		public Map<String, Object> getSession() {
			return session;
		}



		public void setSession(Map<String, Object> session) {
			this.session = session;
		}


	}
