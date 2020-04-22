/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mynharcorp.modelo.persona;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Harold M Bonilla L
 */
public class PersonaValidar implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return Persona.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Persona obj = (Persona)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "required.nombre","Nombre es obligatorio!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "correo", "required.correo","E-Mail es obligatorio!");
        
        
        if(obj.getPais()==0){
            errors.rejectValue("pais", "required.pais", "Seleccione un país!");
        }        
    }
    
}
