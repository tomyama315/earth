package com.internousdev.earth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.earth.dto.ProductInfoDTO;
import com.internousdev.earth.util.DBConnector;

public class ProductInfoDAO {
	public ArrayList<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();

	// Product_InfoDTOの中身を全て取得
	public ArrayList<ProductInfoDTO> selectAll() {
		DBConnector db = new DBConnector();
		Connection ct = db.getConnection();
		String sql = "SELECT * FROM product_info order by id asc";
		try {
			PreparedStatement preparedStatement = ct.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ProductInfoDTO productInfoDTO = new ProductInfoDTO();
				productInfoDTO.setId(resultSet.getInt("id"));
				productInfoDTO.setProductId(resultSet.getInt("product_id"));
				productInfoDTO.setProductName(resultSet.getString("product_name"));
				productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDTO.setProductDescription(resultSet.getString("product_description"));
				productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				productInfoDTO.setPrice(resultSet.getInt("price"));
				productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.setReleaseDate(resultSet.getDate("release_date"));
				productInfoDTO.setReleaseCompany(resultSet.getString("release_company"));
				productInfoDTO.setStatus(resultSet.getInt("status"));
				productInfoDTO.setRegistDate(resultSet.getDate("resist_date"));
				productInfoDTO.setUpDate(resultSet.getDate("update_date"));
				productInfoDTOList.add(productInfoDTO);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		try {
			ct.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return productInfoDTOList;
	}

	// ProductID(商品ID)に応じてDTOとる
	public ProductInfoDTO selectByProductId(int productId) {
		DBConnector db = new DBConnector();
		Connection ct = db.getConnection();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();
		String sql = "SELECT * FROM product_info WHERE product_id = ?";
		try {
			PreparedStatement ps = ct.prepareStatement(sql);
			ps.setInt(1, productId);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				productInfoDTO = new ProductInfoDTO();
				productInfoDTO.setId(resultSet.getInt("id"));
				productInfoDTO.setProductId(resultSet.getInt("product_id"));
				productInfoDTO.setProductName(resultSet.getString("product_name"));
				productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDTO.setProductDescription(resultSet.getString("product_description"));
				productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				productInfoDTO.setPrice(resultSet.getInt("price"));
				productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.setReleaseDate(resultSet.getDate("release_date"));
				productInfoDTO.setReleaseCompany(resultSet.getString("release_company"));
				productInfoDTO.setStatus(resultSet.getInt("status"));
				productInfoDTO.setRegistDate(resultSet.getDate("regist_Date"));
				productInfoDTO.setUpDate(resultSet.getDate("update_date"));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		try {
			ct.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return productInfoDTO;
	}

	// CategoryIDに応じたDTO取得
	public ArrayList<ProductInfoDTO> selectByCategoryId(int categoryId) {
		DBConnector db = new DBConnector();
		Connection ct = db.getConnection();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();
		if (categoryId == 1) {
			productInfoDTOList = this.selectAll();
		} else {
			String sql = "SELECT *  FROM product_info WHERE category_id = ?";
			try {
				PreparedStatement ps = ct.prepareStatement(sql);
				ps.setInt(1, categoryId);
				ResultSet resultSet = ps.executeQuery();
				while (resultSet.next()) {
					productInfoDTO = new ProductInfoDTO();
					productInfoDTO.setId(resultSet.getInt("id"));
					productInfoDTO.setProductId(resultSet.getInt("product_id"));
					productInfoDTO.setProductName(resultSet.getString("product_name"));
					productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
					productInfoDTO.setProductDescription(resultSet.getString("product_description"));
					productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
					productInfoDTO.setPrice(resultSet.getInt("price"));
					productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
					productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
					productInfoDTO.setReleaseDate(resultSet.getDate("release_date"));
					productInfoDTO.setReleaseCompany(resultSet.getString("release_company"));
					productInfoDTO.setStatus(resultSet.getShort("status"));
					productInfoDTO.setRegistDate(resultSet.getDate("regist_date"));
					productInfoDTO.setUpDate(resultSet.getDate("up_date"));
					productInfoDTOList.add(productInfoDTO);
				}

			} catch (SQLException e) {
				e.printStackTrace();

			}

			try {
				ct.close();

			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		return productInfoDTOList;
	}

	// キーワードに応じてDTO取得
	public ArrayList<ProductInfoDTO> selectByKeyWord(String keyword) {
		DBConnector db = new DBConnector();
		Connection ct = db.getConnection();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();

		String sql = "SELECT *  FROM product_info WHERE product_name LIKE '%" + keyword
				+ "%' OR product_name_kana LIKE '%" + keyword + "%'";
		try {
			PreparedStatement ps = ct.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				productInfoDTO = new ProductInfoDTO();
				productInfoDTO.setId(resultSet.getInt("id"));
				productInfoDTO.setProductId(resultSet.getInt("product_id"));
				productInfoDTO.setProductName(resultSet.getString("product_name"));
				productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDTO.setProductDescription(resultSet.getString("product_description"));
				productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				productInfoDTO.setPrice(resultSet.getInt("price"));
				productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.setReleaseDate(resultSet.getDate("release_date"));
				productInfoDTO.setReleaseCompany(resultSet.getString("release_company"));
				productInfoDTO.setStatus(resultSet.getShort("status"));
				productInfoDTO.setRegistDate(resultSet.getDate("regist_date"));
				productInfoDTO.setUpDate(resultSet.getDate("up_date"));
				productInfoDTOList.add(productInfoDTO);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		try {
			ct.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return productInfoDTOList;
	}

	// 複数のキーワードに応じてDTO取得
	public ArrayList<ProductInfoDTO> selectByKeyWords(String[] keywords) {
		DBConnector db = new DBConnector();
		Connection ct = db.getConnection();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();
		String sql = "SELECT *  FROM product_info WHERE ";

		for (int key = 0; key < keywords.length; key++) {
			if (key != 0) {
				sql = sql + " AND (product_name LIKE '%" + keywords[key] + "%' OR product_name_kana LIKE '%"
						+ keywords[key] + "%') ";
			} else {
				sql = sql + " (product_name LIKE '%" + keywords[key] + "%' OR product_name_kana LIKE '%" + keywords[key]
						+ "%') ";
			}
		}
		try {
			PreparedStatement ps = ct.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				productInfoDTO = new ProductInfoDTO();
				productInfoDTO.setId(resultSet.getInt("id"));
				productInfoDTO.setProductId(resultSet.getInt("product_id"));
				productInfoDTO.setProductName(resultSet.getString("product_name"));
				productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDTO.setProductDescription(resultSet.getString("product_description"));
				productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				productInfoDTO.setPrice(resultSet.getInt("price"));
				productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.setReleaseDate(resultSet.getDate("release_date"));
				productInfoDTO.setReleaseCompany(resultSet.getString("release_company"));
				productInfoDTO.setStatus(resultSet.getShort("status"));
				productInfoDTO.setRegistDate(resultSet.getDate("regist_date"));
				productInfoDTO.setUpDate(resultSet.getDate("up_date"));
				productInfoDTOList.add(productInfoDTO);

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		try {
			ct.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return productInfoDTOList;
	}

	// 関連商品
	public ArrayList<ProductInfoDTO> selectByCategotyId(int categoryId, int productId, int limitOffset,
			int limitRowCount) {
		DBConnector db = new DBConnector();
		Connection ct = db.getConnection();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();
		String sql = "SELECT * FROM product_info where category_id=? and product_id not in(?) order by rand() limit ?,?";
		try {
			PreparedStatement preparedStatement = ct.prepareStatement(sql);
			preparedStatement.setInt(1, categoryId);
			preparedStatement.setInt(2, productId);
			preparedStatement.setInt(3, limitOffset);
			preparedStatement.setInt(4, limitRowCount);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				productInfoDTO = new ProductInfoDTO();
				productInfoDTO.setId(resultSet.getInt("id"));
				productInfoDTO.setProductId(resultSet.getInt("product_id"));
				productInfoDTO.setProductName(resultSet.getString("product_name"));
				productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDTO.setProductDescription(resultSet.getString("product_description"));
				productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				productInfoDTO.setPrice(resultSet.getInt("price"));
				productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.setReleaseDate(resultSet.getDate("release_date"));
				productInfoDTO.setReleaseCompany(resultSet.getString("release_company"));
				productInfoDTOList.add(productInfoDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ct.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return productInfoDTOList;
	}
}
