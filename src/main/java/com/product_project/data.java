package com.product_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class data {
	
	Connection getconnection() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mySql://localhost:3306/newdatabase","root","root");
	}
	
	int insert (ProductDetail p1) throws SQLException, ClassNotFoundException {
		Connection con=getconnection();
		PreparedStatement pst=con.prepareStatement("insert into product values(?,?,?,?)");
		pst.setInt(1,p1.getId());
		pst.setString(2,p1.getBrand());
		pst.setDouble(3,p1.getPrice());
		pst.setDouble(4,p1.getDiscount());
		return pst.executeUpdate();
		
	}
	int delete(int id) throws ClassNotFoundException, SQLException {
		Connection con=getconnection();
		PreparedStatement pst=con.prepareStatement("delete from product where id=?");
		pst.setInt(1,id);
		return pst.executeUpdate();
	}
	ProductDetail fetch(int id) throws ClassNotFoundException, SQLException {
		Connection con=getconnection();
		PreparedStatement pst=con.prepareStatement("select * from product where id=?");
		pst.setInt(1, id);
		ResultSet rs=pst.executeQuery();
		rs.next();
		ProductDetail p1=new ProductDetail(rs.getInt("id"),rs.getString("brand"),rs.getDouble("price"),rs.getDouble("discount"));
		return p1;
	}
	List<ProductDetail>fetchall() throws SQLException, ClassNotFoundException {
		List<ProductDetail> li=new ArrayList<ProductDetail>();
		Connection con=getconnection();
		PreparedStatement pst=con.prepareStatement("select * from product");
		ResultSet rs=pst.executeQuery();
		
		while(rs.next()) {
			ProductDetail p1=new ProductDetail(rs.getInt("id"),rs.getString("brand"),rs.getDouble("price"),rs.getDouble("discount"));
			li.add(p1);
		}
		return li;+
	}
		

}