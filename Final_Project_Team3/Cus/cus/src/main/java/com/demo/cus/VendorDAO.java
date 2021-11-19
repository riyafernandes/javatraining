package com.demo.cus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class VendorDAO {
	@Autowired  
    JdbcTemplate jdbc;  
    
    public String authenticate(String user,String pwd) {
        String cmd = "select count(*) cnt from Vendor where vendorusername=? "
                + " AND vendorpassword=?";
        List str=jdbc.query(cmd,new Object[] {user,pwd}, new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                // TODO Auto-generated method stub
                return rs.getInt("cnt");
            }
            
        });
        return str.get(0).toString();
}

public Vendor showonevendor(String user) {
	String cmd = "select * from Vendor where vendorusername=? ";
    List<Vendor> str=jdbc.query(cmd,new Object[] {user}, new RowMapper<Vendor>() {
        @Override
        public Vendor mapRow(ResultSet rs, int rowNum) throws SQLException {
            // TODO Auto-generated method stub
        	Vendor vendor = new Vendor();
        	
        	vendor.setVendorid(rs.getInt("vendorid"));
        	vendor.setVendorname(rs.getString("vendorname"));
        	vendor.setVendorphonenumber(rs.getString("vendorphonenumber"));
        	vendor.setVendorusername(rs.getString("vendorusername"));
        	vendor.setVendoremail(rs.getString("vendoremail"));

    			
    		
    		return vendor;
        }
        
    });
    return str.get(0);
}
public int generateVendorId() {
    String cmd = "select case when max(vendorid) is NULL then 1 else max(vendorid)+1 end vid FROM Vendor ";
    List str=jdbc.query(cmd,new Object[] {}, new RowMapper() {
        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            // TODO Auto-generated method stub
            return rs.getInt("vid");
        }
        
    });
    return (int) str.get(0);
}}