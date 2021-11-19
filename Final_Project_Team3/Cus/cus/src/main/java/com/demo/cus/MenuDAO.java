package com.demo.cus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
	public class MenuDAO {
	    @Autowired
	    
	    JdbcTemplate jdbc;  
	    
	    public Menu searchMenu(int menuId) {
	        String cmd = "select * from Menu where menuid=?";
	        List<Menu> menuList=jdbc.query(cmd,new Object[] {menuId}, new RowMapper<Menu>() {
	            @Override
	            public Menu mapRow(ResultSet rs, int arg1) throws SQLException {
	                Menu menu = new Menu();
	                menu.setMenuid(rs.getInt("menuid"));
	                menu.setMenuitem(rs.getString("menuitem"));
	                menu.setMenuprice(rs.getDouble("menuprice"));
	                menu.setMenuspeciality(rs.getString("menuspeciality"));
	              
	                return menu;
	            }
	            
	        });
	        return menuList.get(0);
	    }
	    public int generateMenuId() {
	        String cmd = "select case when max(menuid) is NULL then 1 else max(menuid)+1 end mid FROM Menu ";
	        List str=jdbc.query(cmd,new Object[] {}, new RowMapper() {
	            @Override
	            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	                // TODO Auto-generated method stub
	                return rs.getInt("mid");
	            }
	            
	        });
	        return (int) str.get(0);
	    }
}
