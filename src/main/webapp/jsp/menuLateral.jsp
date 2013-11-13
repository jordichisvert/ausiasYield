<%@page import="net.daw.helper.Contexto"%>
<% Contexto oContexto = (Contexto) request.getAttribute("contexto"); %>
<%
    String menu = "<div class=\"well sidebar-nav\"><ul class=\"nav nav-list\">";

    menu += "<li class=\"nav-header\">Usuario</li>";

    if (oContexto.getClase().equals("usuario") && oContexto.getMetodo().equals("ocioso")) {
        menu += "<li class=\"active\">";
    } else {
        menu += "<li>";
    }
    menu += "<a href=\"Controller\">Home</a></li>";

    if (!oContexto.getHaySesion()) {
        if (oContexto.getClase().equals("usuario") && oContexto.getMetodo().equals("login")) {
            menu += "<li class=\"active\">";
        } else {
            menu += "<li>";
        }
        menu += "<a href=\"Controller?class=usuario&method=login\">Login</a></li>";
    } else {
        if (oContexto.getClase().equals("usuario") && oContexto.getMetodo().equals("logout")) {
            menu += "<li class=\"active\">";
        } else {
            menu += "<li>";
        }
        menu += "<a href=\"Controller?class=usuario&method=logout\">Logout</a></li>";
    }
     menu += "<li class=\"nav-header\">Actividad</li>";

    if (oContexto.getClase().equals("actividad") && oContexto.getMetodo().equals("new")) {
        menu += "<li class=\"active\">";
    } else {
        menu += "<li>";
    }
    menu += "<a href=\"Controller?class=actividad&method=new\">Crear</a></li>";

    if (oContexto.getClase().equals("actividad") && oContexto.getMetodo().equals("list")) {
        menu += "<li class=\"active\">";
    } else {
        menu += "<li>";
    }
    menu += "<a href=\"Controller?class=actividad&method=list\">Listar</a></li>";

    if (oContexto.getClase().equals("actividad") && oContexto.getMetodo().equals("update")) {
        menu += "<li class=\"active\">";
    } else {
        menu += "<li>";
    }
    menu += "<a href=\"Controller?class=actividad&method=update\">Update</a></li>";

    if (oContexto.getClase().equals("actividad") && oContexto.getMetodo().equals("delete")) {
        menu += "<li class=\"active\">";
    } else {
        menu += "<li>";
    }
    menu += "<a href=\"Controller?class=actividad&method=delete\">Delete</a></li>";
    menu += "</ul></div>";
%>
<%=menu%>