/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mynharcorp.controller.persona;

import com.mynharcorp.modelo.persona.Persona;
import com.mynharcorp.modelo.persona.PersonaValidar;
import com.mynharcorp.util.ConectarBD_MariaDB;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Harold M Bonilla L
 */
@Controller
@RequestMapping("add.htm")
public class AddController {
    
    private PersonaValidar personaValidar;
    private JdbcTemplate jdbcTemplate;

    public AddController() {
        this.personaValidar = new PersonaValidar();
        ConectarBD_MariaDB con = new ConectarBD_MariaDB();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form(){
    
        ModelAndView mav = new ModelAndView();
        mav.setViewName("add");
        mav.addObject("persona", new Persona());
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form(@ModelAttribute("persona") Persona obj, BindingResult result, SessionStatus status){
        
        this.personaValidar.validate(obj, result);
        if(result.hasErrors()){
            
            // Volvemos al formulario, porque los datos no son correctos...
            ModelAndView mav = new ModelAndView();
            mav.setViewName("add");
            mav.addObject("persona", new Persona());
            return mav;
        
        }else{
            // datos son correctos...
            String sql = "insert into persona (nombre,correo,telefono,pais) values (?,?,?,?)";

            this.jdbcTemplate.update(sql,obj.getNombre(),obj.getCorreo(),obj.getTelefono(),obj.getPais());
          
            return new ModelAndView("redirect:/list.htm");
        }        
    }
    
    /**
     * metodo para cargar combo Paises...
     * @return 
     */
    @ModelAttribute("paisLista")
    public Map<String,String> listadoPaises(){
        
        Map<String,String> pais = new LinkedHashMap<>();
        pais.put("1", "Chile");
        pais.put("2", "México");
        pais.put("3", "Colombia");
        pais.put("4", "Bolivia");
        pais.put("5", "España");
        pais.put("6", "Costa Rica");
        return pais;
    }    

}
