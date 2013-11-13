/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operation;

/**
 *
 * @author mati
 */
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.daw.bean.ActividadBean;
import net.daw.dao.ActividadDao;
import net.daw.helper.Contexto;
import net.daw.parameter.ActividadParam;
public class ActividadDelete2 {
    
      public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/mensaje.jsp");   
        ActividadBean oActividadBean = new ActividadBean(); 
        ActividadParam oActividadParam = new ActividadParam(request);
        oActividadBean = oActividadParam.loadId(oActividadBean);
        try {
            ActividadDao oActividadDao = new ActividadDao(oContexto.getEnumTipoConexion());
            oActividadDao.remove(oActividadBean);
        } catch (Exception e) {
            throw new ServletException("ActividadController: Remove Error: " + e.getMessage());
        }
        String Mensaje = ("Se ha eliminado la información de la actividad con id=" + Integer.toString(oActividadBean.getId()));
        return Mensaje;
    }  
}
