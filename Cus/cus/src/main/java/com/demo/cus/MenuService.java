package com.demo.cus;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
	public class MenuService {
	    @Autowired
	    private MenuRepository repo;
	    
	    public List<Menu> showmenu() {
	        return repo.findAll();
	    }
	    
	    public Menu get(Integer id) {
            return repo.findById(id).get();
           
        }
	    public void save(Menu menu) {
            repo.save(menu);
        }
	    
	}
