package com.demo.cus;

import java.sql.Date;
import java.util.List;

import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class OrdersService {
	@Autowired
	private OrdersRepository repo;
	
	public List<Orders> showOrders() {
        return repo.findAll();
    }
	public Orders get(Integer id) {
        return repo.findById(id).get();
    }
	public void save(Orders orders) {
        repo.save(orders);
    }
	@Autowired
    private OrdersDAO dao;
    //modified
	@Autowired 
    private MenuDAO mdao;
    
    @Autowired 
    private WalletDAO wdao;
    @Autowired
    private CustomerDAO cdao;
    //
    
    //modified
    public String placeOrder(Orders order) {
        Menu menu = mdao.searchMenu(order.getMenuid());
        Wallet wallet = wdao.onewallet(order.getCustomerid(), order.getWalletsource());
        String cemail=cdao.mailofcustomer(order.getCustomerid()); 
        int balance = wallet.getWalletamt();
        int billAmount = (int) (order.getOrderquantity()*menu.getMenuprice());
        System.out.println(balance);
        System.out.println(billAmount);
        if (balance-billAmount > 0) {
        	order.setOrderid(dao.generateOrderId());    // id
            order.setOrderstatus("PENDING");
            order.setOrderbillamount((int) (order.getOrderquantity()*menu.getMenuprice()));
            order.setORD_DATE( (Date) order.getORD_DATE());
            repo.save(order);
            wdao.updateWallet(order.getCustomerid(), order.getWalletsource(), billAmount);
        MailAlert.ordermail(cemail);
            return "Order Placed Successfully...and Amount Debited";
        }
       
        return "Insufficient Funds...";
    
        }

    
    
    
    
    public List<Orders> vendorallOrders(int id) {
        return dao.vendorOrders(id);
    }
    
    public List<Orders> vendorallPendingOrders(int id) {
        return dao.vendorpendingOrders(id);
    }
    
    
    public List<Orders> customerallOrders(int id) {
        return dao.customerOrders(id);
    }
    
    public List<Orders> customerallPendingOrders(int id) {
        return dao.customerpendingOrders(id);
    }
    public String acceptOrRejectOrder(int ordId,int venId,String status) {
		Orders orders = dao.searchByOrderId(ordId);
		String cemail=cdao.mailofcustomer(orders.getCustomerid());
		int vid = orders.getVendorid();
		int cid = orders.getCustomerid();
		String walType = orders.getWalletsource();
		int billAmount = orders.getOrderbillamount();
		if (vid!=venId) {
			return "You are unauthorized vendor...";
		} 
		if (status.toUpperCase().equals("YES")) {
			MailAlert.acceptmail(cemail);
			return dao.updateStatus(ordId,"ACCEPTED");
		} else {
			dao.updateStatus(ordId, "DENIED");
			wdao.refundWallet(cid, walType, billAmount);
			MailAlert.rejectmail(cemail);
			return "Order Rejected and Amount Refunded...";
		}
	}
}
