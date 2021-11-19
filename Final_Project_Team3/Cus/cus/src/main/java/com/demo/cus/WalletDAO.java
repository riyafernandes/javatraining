package com.demo.cus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class WalletDAO {
	@Autowired  
	JdbcTemplate jdbc; 
//modified
	public String updateWallet(int custId, String walType, int walAmount) {
		walType=walType.toUpperCase();
        String cmd = "Update Wallet set walletamt=walletamt-? "
                + " WHERE customerid=? AND upper(walletsource)=?";
        jdbc.update(cmd, new Object[] {walAmount,custId,walType});
        return "Amount Debited from Wallet...";
    }

	
	
	
	public List<Wallet> customerWallet(int id) {
	    String cmd = "select * from Wallet where customerid=? ";
	    List str=jdbc.query(cmd,new Object[] {id}, new RowMapper<Wallet>() {
	        @Override
	        public Wallet mapRow(ResultSet rs, int rowNum) throws SQLException {
	            // TODO Auto-generated method stub
	        	Wallet wallet=new Wallet();
	        	
	        	wallet.setCustomerid(rs.getInt("customerid"));
	        	wallet.setWalletid(rs.getInt("walletid"));
	        	wallet.setWalletamt(rs.getInt("walletamt"));
	        	wallet.setWalletsource(rs.getString("walletsource"));

	            return wallet;
	        }
	        
	    });
	    return str;
	}

	public Wallet onewallet(int id, String source ) {
		source=source.toUpperCase();
	    String cmd = "select * from Wallet where customerid=? and upper(walletsource)=?";
	    List<Wallet> str=jdbc.query(cmd,new Object[] {id,source}, new RowMapper<Wallet>() {
	        @Override
	        public Wallet mapRow(ResultSet rs, int rowNum) throws SQLException {
	            // TODO Auto-generated method stub
	        	Wallet wallet=new Wallet();
	        	wallet.setCustomerid(rs.getInt("customerid"));
	        	wallet.setWalletid(rs.getInt("walletid"));
	        	wallet.setWalletamt(rs.getInt("walletamt"));
	        	wallet.setWalletsource(rs.getString("walletsource"));
	        	   	
	            return wallet;
	        }
	        
	    });
	    return  str.get(0);
	}
	public String refundWallet(int custId, String walType, int walAmount) {
		walType=walType.toUpperCase();
		String cmd = "Update Wallet set walletamt=walletamt+?  WHERE customerid=? AND upper(walletsource)=? ";
			//	+ " WHERE customerid=? AND upper(walletsource)=?";
		jdbc.update(cmd, new Object[] {walAmount,custId,walType});
		return "Amount Debited from Wallet...";
	}
	public int WalletID() {
	    String cmd = "select case when max(walletid) is NULL then 1 else max(walletid)+1 end wid from wallet ";
	    List str=jdbc.query(cmd,new Object[] {}, new RowMapper() {
	        @Override
	        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	            // TODO Auto-generated method stub
	            return rs.getInt("wid");
	        }
	        
	    });
	    return (int) str.get(0);
	}
}
