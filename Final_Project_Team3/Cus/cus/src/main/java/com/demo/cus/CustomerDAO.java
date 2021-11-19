package com.demo.cus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO {
	@Autowired  
    JdbcTemplate jdbc;  
    
    public String authenticate(String user,String pwd) {
        String cmd = "select count(*) cnt from Customer where customerusername=? "
                + " AND customerpassword=?";
        List str=jdbc.query(cmd,new Object[] {user,pwd}, new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                // TODO Auto-generated method stub
                return rs.getInt("cnt");
            }
            
        });
        return str.get(0).toString();

}
    public String mailofcustomer(int id) {
        String cmd = "select customeremail from Customer where customerid=? ";
        List str=jdbc.query(cmd,new Object[] {id}, new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                // TODO Auto-generated method stub
                return rs.getString("customeremail");
            }
            
        });
        return str.get(0).toString();}

public Customer showonecustomer(String user) {
	String cmd = "select * from Customer where customerusername=? ";
    List<Customer> str=jdbc.query(cmd,new Object[] {user}, new RowMapper<Customer>() {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            // TODO Auto-generated method stub
        	Customer customer = new Customer();
    		    customer.setCustomerid(rs.getInt("customerid"));
    		    customer.setCustomername(rs.getString("customername"));
    		    customer.setCustomerphonenumber(rs.getString("customerphonenumber"));
    		    customer.setCustomerusername(rs.getString("customerusername"));
    		    customer.setCustomeremail(rs.getString("customeremail"));

    			
    		
    		return customer;
        }
        
    });
    return str.get(0);
}
public int generateCustomerId() {
    String cmd = "select case when max(customerid) is NULL then 1 else max(customerid)+1 end cid FROM Customer ";
    List str=jdbc.query(cmd,new Object[] {}, new RowMapper() {
        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            // TODO Auto-generated method stub
            return rs.getInt("cid");
        }
        
    });
    return (int) str.get(0);
}
}