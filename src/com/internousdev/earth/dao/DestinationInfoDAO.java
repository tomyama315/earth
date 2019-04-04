package com.internousdev.earth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.earth.util.DBConnector;

public class DestinationInfoDAO {

	public int insert(String userId, String familyName, String firstName,String familyNameKana, String firstNameKana,
		String userAddress, String email, String telNumber) throws SQLException{
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		int count = 0;

		String sql = "INSERT INTO destination_info "
				+	 "(user_id, family_name, first_name, family_name_kana, first_name_kana, "
				+	 "user_address, email, tel_number, regist_date, update_date)"
				+ "VALUES(?,?,?,?,?,?,?,?now(),now())";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,userId);
			preparedStatement.setString(2,familyName);
			preparedStatement.setString(3,firstName);
			preparedStatement.setString(4,familyNameKana);
			preparedStatement.setString(5,firstNameKana);
			preparedStatement.setString(6,userAddress);
			preparedStatement.setString(7,email);
			preparedStatement.setString(8,telNumber);
			count=preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
}
