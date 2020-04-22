<%-- 
    Document   : add
    Created on : 19/04/2020, 02:25:08 PM
    Author     : Harold M Bonilla L
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Persona</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    </head>
    <body>        
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="/list.htm" />">Listado de productos</a></li>
                <li class="active">Editar</li>
            </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Agregar</div>
                <div class="panel-body">
                    <form:form method="post" commandName="persona">
                        <h1>Complete el formulario</h1>

                        <form:errors path="*" element="div" cssClass="alert alert-danger" />

                        <p>
                            <form:label path="nombre">Nombre</form:label>
                            <form:input path="nombre" cssClass="form-control" />
                            <form:errors path="nombre" />
                        </p>
                        <p>
                            <form:label path="correo">E-mail</form:label>
                            <form:input path="correo" cssClass="form-control" />
                        </p>
                        <p>
                            <form:label path="telefono">Teléfono</form:label>
                            <form:input path="telefono" cssClass="form-control" />
                        </p>
                        <p>
                            <form:label path="pais">Pais</form:label>
                            <form:select path="pais" cssClass="form-control" >
                                <form:option value="0">Selecciona...</form:option>
                                <form:options items="${paisLista}" />
                            </form:select>
                        </p>
                        <hr/>
                        <input type="submit" value="Enviar" class="btn btn-danger" />
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
