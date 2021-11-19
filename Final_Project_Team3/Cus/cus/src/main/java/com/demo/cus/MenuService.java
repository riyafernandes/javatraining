package com.demo.cus;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
	public class MenuService {
	    @Autowired
	    private MenuRepository mrepo;
	    
	    public List<Menu> showmenu() {
	        return mrepo.findAll();
	    }
	    
	    public Menu get(Integer id) {
            return mrepo.findById(id).get();
           
        }
	    @Autowired
	    private MenuDAO dao;
	    public void save(Menu menu) {
	    	menu.setMenuid(dao.generateMenuId());//auto
            mrepo.save(menu);
        }
	}
