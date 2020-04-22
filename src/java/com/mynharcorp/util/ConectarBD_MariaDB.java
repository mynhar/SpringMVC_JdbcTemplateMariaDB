/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mynharcorp.util;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Harold M Bonilla L
 */
public class ConectarBD_MariaDB {
    
    public DriverManagerDataSource conectar(){
    
        String url = "jdbc:mysql://localhost/pruebasHibernate";
        String usuario = "root";
	String contrasena = "123";
                
        DriverManagerDataSource dataSource = new DriverManagerDataSource();        
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername(usuario);
        dataSource.setPassword(contrasena);
        
        return dataSource;
    }
    
}
