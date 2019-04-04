package com.internousdev.earth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.internousdev.earth.dto.CartInfoDTO;
import com.internousdev.earth.util.DBConnector;

public class CartInfoDAO {
	private ArrayList<CartInfoDTO> toTransList;


	//カート情報取得
	public ArrayList<CartInfoDTO> getCartContents(String UserId) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		CartInfoDTO dto = new CartInfoDTO();

		String sql = "SELECT * FROM cart_info where user_id=? left outer join product_info on cart_info.product_id=product_info.product_id";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, UserId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				dto.setUserId(rs.getString("user_id"));
				dto.setTempId(rs.getString("temp_user_id"));
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductCount(rs.getInt("product_count"));
				dto.setPrice(rs.getInt("price"));
				dto.setResistDate(rs.getString("resist_date"));
				dto.setUpdateDate(rs.getString("update_date"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductNameKana(rs.getString("product_name_kana"));
				dto.setImagePath(rs.getString("image_file_path"));
				dto.setImageName(rs.getString("image_file_name"));
				dto.setReleaseComp(rs.getString("release_company"));
				dto.setReleaseDate(rs.getString("release_date"));
				int sum=rs.getInt("price")*rs.getInt("product_count");
				dto.setSum(sum);
				toTransList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return toTransList;
	}


	//カートに追加-受け取る値は要考慮
	public int add(String UserId,ProductInfoDTO dto){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		int result=0;
		String sql = "insert into cart_info(user_id,temp_user_id,product_id,product_count,price,resist_date) values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, UserId);
			ps.setString(2,dto.getTempId() );
			ps.setInt(3,dto.getProductId() );
			ps.setInt(4, dto.getProductCount());
			ps.setInt(5, dto.getPrice());
			ps.setString(6,LocalDate.now().toString());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}


	//重複更新
	public int update(int TotalCount,String UserId,int ProductId){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		int result=0;
		String sql = "update cart_info set product_count=? update_date=? where user_id=? product_id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,TotalCount );
			ps.setString(2, LocalDate.now().toString());
			ps.setString(3, UserId);
			ps.setInt(4, ProductId);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}


	 //カートから個別削除
	public int delete(String UserId,int ProductId) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		int result=0;
		String sql = "delete * FROM cart_info where user_id=? product_id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, UserId);
			ps.setInt(2, ProductId);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}


	//決済時カートから全削除
	public int deleteAll(String UserId) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		int result;
		String sql = "delete * FROM cart_info where user_id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, UserId);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}
}
