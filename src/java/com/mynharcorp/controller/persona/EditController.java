/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mynharcorp.controller.persona;

import com.mynharcorp.modelo.persona.Persona;
import com.mynharcorp.modelo.persona.PersonaValidar;
import com.mynharcorp.util.ConectarBD_MariaDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
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
public class EditController {
    
    private PersonaValidar personaValidar;
    private JdbcTemplate jdbcTemplate;

    public EditController() {
        this.personaValidar = new PersonaValidar();
        ConectarBD_MariaDB con = new ConectarBD_MariaDB();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
     @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request){
        
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        Persona obj = this.selectPersona(id);
        mav.setViewName("edit");
        mav.addObject("persona", new Persona(id, obj.getNombre(),obj.getCorreo(),obj.getPais(),obj.getTelefono()));
        return mav;    
    }
    
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form(@ModelAttribute("persona") Persona obj, BindingResult result, SessionStatus status, HttpServletRequest request){
        
        this.personaValidar.validate(obj, result);
        if(result.hasErrors()){
            
            // Volvemos al formulario, porque los datos no son correctos...
            ModelAndView mav = new ModelAndView();
            int id = Integer.parseInt(request.getParameter("id"));
            Persona persona = this.selectPersona(id);            
            mav.setViewName("edit");
            mav.addObject("persona", new Persona(id,persona.getNombre(),persona.getCorreo(),persona.getPais(),persona.getTelefono()));
            return mav;
        
        }else{
            // datos son correctos...
            int id = Integer.parseInt(request.getParameter("id"));
            String sql = "update persona set nombre=?,correo=?,telefono=?,pais=? where id=?";

            this.jdbcTemplate.update(sql,obj.getNombre(),obj.getCorreo(),obj.getTelefono(),obj.getPais(),id);
          
            return new ModelAndView("redirect:/list.htm");
        }        
    }
    
    
    public Persona selectPersona(int id){
        final Persona obj = new Persona();
        String sql = "select * from persona where id = '"+id+"'";
        
        return (Persona) this.jdbcTemplate.query(sql, new ResultSetExtractor<Persona>(){
            @Override
            public Persona extractData(ResultSet rs) throws SQLException, DataAccessException {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                if(rs.next()){
                    obj.setNombre(rs.getString("nombre"));
                    obj.setCorreo(rs.getString("correo"));                    
                    obj.setPais(rs.getInt("pais"));
                    obj.setTelefono(rs.getString("telefono"));
                }                
                return obj;
            }        
        });
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
