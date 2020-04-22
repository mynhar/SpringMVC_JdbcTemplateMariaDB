<%-- 
    Document   : home
    Created on : 18/04/2020, 05:01:16 PM
    Author     : Harold M Bonilla L
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>SpringMVC_JdbcTemplateMariaDB</title>        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    </head>
    <body>        
        <div class="container">
            <div class="row">
              <h1>SpringMVC_JdbcTemplateMariaDB</h1>
              </hr>
              <p>
                  <a href="<c:url value="add.htm" />" class="btn btn-success"><span class="glyphicon glyphicon-plus"></span>Agregar</a>                  
              </p>
              <table class="table table-striped table-bordered table-hover table-condensed">
                  <thead>
                      <tr>
                          <th>Id</th>
                          <th>Nombre</th>
                          <th>E-Mail</th>
                          <th>Teléfono</th>
                          <th>Acciones</th>
                      </tr>
                  </thead>
                  <tbody>
                      <c:forEach items="${datos}" var="dato">
                          <tr>
                              <td><c:out value="${dato.Id}" /></td>
                              <td><c:out value="${dato.Nombre}" /></td>
                              <td><c:out value="${dato.Correo}" /></td>
                              <td><c:out value="${dato.Telefono}" /></td>
                              <td>
                                  <a href="<c:url value="edit.htm?id=${dato.Id}" />" ><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                  <a href="<c:url value="delete.htm?id=${dato.Id}" />" ><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                              </td>                              
                          </tr>
                      </c:forEach>
                  </tbody>
              </table>
            </div>            
        </div>        
    </body>
</html>
