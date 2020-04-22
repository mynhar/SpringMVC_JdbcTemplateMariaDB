/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mynharcorp.controller.persona;

import com.mynharcorp.util.ConectarBD_MariaDB;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Harold M Bonilla L
 */
public class ListController {
    
    private JdbcTemplate jdbcTemplate;

    public ListController() {
        ConectarBD_MariaDB con = new ConectarBD_MariaDB();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("list.htm")
    public ModelAndView list(){
    
        ModelAndView mav = new ModelAndView();
        
        String sql = "select * from Persona order by id desc";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("list");        
        return mav;
    }
    
    
}
