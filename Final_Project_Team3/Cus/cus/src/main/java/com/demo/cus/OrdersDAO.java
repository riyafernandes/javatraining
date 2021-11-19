package com.demo.cus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class OrdersDAO {
	@Autowired  
	JdbcTemplate jdbc; 
	public Orders searchByOrderId(int ordId) {
        String cmd = "select * from Orders where orderid=?";
        List<Orders> ordersList=null;
        ordersList=jdbc.query(cmd,new Object[] {ordId}, new RowMapper<Orders>() {
            @Override
            public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
                Orders orders = new Orders();
                orders.setVendorid(rs.getInt("vendorid"));
	        	orders.setOrderid(rs.getInt("orderid"));
	        	orders.setCustomerid(rs.getInt("customerid"));
	        	orders.setMenuid(rs.getInt("menuid"));
	        	orders.setWalletsource(rs.getString("walletsource"));
	        	orders.setOrderquantity(rs.getInt("orderquantity"));
	        	orders.setOrderbillamount(rs.getInt("orderbillamount"));
	        	orders.setOrderstatus(rs.getString("orderstatus"));
	        	orders.setOdercommands(rs.getString("odercommands"));
	        	orders.setORD_DATE(rs.getDate("ORD_DATE"));

                return orders;
            }
            
        });
        return ordersList.get(0);
    }
//	public Orders searchByOrderId(int ordId) {
//		String cmd = "select * from Orders where ord_id=?";
//		List<Orders> ordersList=null;
//		ordersList=jdbc.query(cmd,new Object[] {ordId}, new RowMapper<Orders>() {
//
//			@Override
//			public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Orders orders = new Orders();
//				orders.setOrdId(rs.getInt("ORD_ID"));
//				orders.setCusId(rs.getInt("CUS_ID"));
//				orders.setVenId(rs.getInt("VEN_ID"));
//				orders.setWalSource(rs.getString("WAL_SOURCE"));
//				orders.setMenId(rs.getInt("MEN_ID"));
//				orders.setOrdDate(rs.getDate("ORD_DATE"));
//				orders.setOrdBillamount(rs.getDouble("ORD_BILLAMOUNT"));
//				orders.setOrdStatus(rs.getString("ORD_STATUS"));
//				orders.setOrdComments(rs.getString("ORD_COMMENTS"));
//				return orders;
//			}
//			
//		});
//		return ordersList.get(0);
//	}
	public List<Orders> customerOrders(int id) {
	    String cmd = "select * from Orders where customerid=? ";
	    List<Orders> str=jdbc.query(cmd,new Object[] {id}, new RowMapper<Orders>() {
	        @Override
	        public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
	            // TODO Auto-generated method stub
	        	Orders orders=new Orders();
	        	orders.setVendorid(rs.getInt("vendorid"));
	        	orders.setOrderid(rs.getInt("orderid"));
	        	orders.setCustomerid(rs.getInt("customerid"));
	        	orders.setMenuid(rs.getInt("menuid"));
	        	orders.setWalletsource(rs.getString("walletsource"));
	        	orders.setOrderquantity(rs.getInt("orderquantity"));
	        	orders.setOrderbillamount(rs.getInt("orderbillamount"));
	        	orders.setOrderstatus(rs.getString("orderstatus"));
	        	orders.setOdercommands(rs.getString("odercommands"));
	        	orders.setORD_DATE(rs.getDate("ORD_DATE"));

	        	
	            return orders;
	        }
	        
	    });
	    return str;
	}

	public List<Orders> customerpendingOrders(int id) {
	    String cmd = "select * from Orders where customerid=? and upper(orderstatus)='PENDING' ";
	    List<Orders> str=jdbc.query(cmd,new Object[] {id}, new RowMapper<Orders>() {
	        @Override
	        public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
	            // TODO Auto-generated method stub
	        	Orders orders=new Orders();
	        	orders.setVendorid(rs.getInt("vendorid"));
	        	orders.setOrderid(rs.getInt("orderid"));
	        	orders.setCustomerid(rs.getInt("customerid"));
	        	orders.setMenuid(rs.getInt("menuid"));
	        	orders.setWalletsource(rs.getString("walletsource"));
	        	orders.setOrderquantity(rs.getInt("orderquantity"));
	        	orders.setOrderbillamount(rs.getInt("orderbillamount"));
	        	orders.setOrderstatus(rs.getString("orderstatus"));
	        	orders.setOdercommands(rs.getString("odercommands"));
	        	orders.setORD_DATE(rs.getDate("ORD_DATE"));

	        	
	            return orders;
	        }
	        
	    });
	    return str;
	}

	
	
	
	
	
	
	public List<Orders> vendorOrders(int id) {
	    String cmd = "select * from Orders where vendorid=? ";
	    List<Orders> str=jdbc.query(cmd,new Object[] {id}, new RowMapper<Orders>() {
	        @Override
	        public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
	            // TODO Auto-generated method stub
	        	Orders orders=new Orders();
	        	orders.setVendorid(rs.getInt("vendorid"));
	        	orders.setOrderid(rs.getInt("orderid"));
	        	orders.setCustomerid(rs.getInt("customerid"));
	        	orders.setMenuid(rs.getInt("menuid"));
	        	orders.setWalletsource(rs.getString("walletsource"));
	        	orders.setOrderquantity(rs.getInt("orderquantity"));
	        	orders.setOrderbillamount(rs.getInt("orderbillamount"));
	        	orders.setOrderstatus(rs.getString("orderstatus"));
	        	orders.setOdercommands(rs.getString("odercommands"));
	        	orders.setORD_DATE(rs.getDate("ORD_DATE"));

	        	
	            return orders;
	        }
	        
	    });
	    return str;
	}

	public List<Orders> vendorpendingOrders(int id) {
	    String cmd = "select * from Orders where vendorid=? and upper(orderstatus)='PENDING' ";
	    List<Orders> str=jdbc.query(cmd,new Object[] {id}, new RowMapper<Orders>() {
	        @Override
	        public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
	            // TODO Auto-generated method stub
	        	Orders orders=new Orders();
	        	orders.setVendorid(rs.getInt("vendorid"));
	        	orders.setOrderid(rs.getInt("orderid"));
	        	orders.setCustomerid(rs.getInt("customerid"));
	        	orders.setMenuid(rs.getInt("menuid"));
	        	orders.setWalletsource(rs.getString("walletsource"));
	        	orders.setOrderquantity(rs.getInt("orderquantity"));
	        	orders.setOrderbillamount(rs.getInt("orderbillamount"));
	        	orders.setOrderstatus(rs.getString("orderstatus"));
	        	orders.setOdercommands(rs.getString("odercommands"));
	        	orders.setORD_DATE(rs.getDate("ORD_DATE"));

	        	
	            return orders;
	        }
	        
	    });
	    return str;
	}
	
	//id
	public int generateOrderId() {
	    String cmd = "select case when max(orderid) is NULL then 1 else max(orderid)+1 end oid from Orders ";
	    List str=jdbc.query(cmd,new Object[] {}, new RowMapper() {
	        @Override
	        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	            // TODO Auto-generated method stub
	            return rs.getInt("oid");
	        }
	        
	    });
	    return (int) str.get(0);
	}
	
	
	public String updateStatus(int ordId,String ordStatus) {
		ordStatus=ordStatus.toUpperCase();
		String cmd = "update orders set orderstatus=? where orderid=?";
		jdbc.update(cmd, new Object[] {ordStatus,ordId});
		return "Order Accepted...";
	}
}
