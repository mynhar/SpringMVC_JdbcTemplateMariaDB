/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mynharcorp.controller.persona;

import com.mynharcorp.util.ConectarBD_MariaDB;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Harold M Bonilla L
 */
public class DeleteController {
    
    private JdbcTemplate jdbcTemplate;

    public DeleteController() {
        ConectarBD_MariaDB con = new ConectarBD_MariaDB();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("delete.htm")
    public ModelAndView home(HttpServletRequest request){
        
        int id = Integer.parseInt(request.getParameter("id"));
        String sql = "delete from persona where id = ?";        
        this.jdbcTemplate.update(sql,id);
        
        return new ModelAndView("redirect:/list.htm");
                
    }
    
}
