/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.parameter;

/**
 *
 * @author mati
 */

import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import net.daw.bean.ActividadBean;

public class ActividadParam {
     private HttpServletRequest request;

    public ActividadParam(HttpServletRequest request) throws Exception {
        this.request = request;
    }

     public ActividadBean loadId(ActividadBean oActividad) throws NumberFormatException {
        try {
            if (request.getParameter("id") != null) {
                oActividad.setId(Integer.parseInt(request.getParameter("id")));
            } else {
                oActividad.setId(0);
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Controller: Error: Load: Formato de datos en parámetros incorrecto " + e.getMessage());
        }
        return oActividad;
    }

    public ActividadBean load(ActividadBean oActividad) throws NumberFormatException {
        try {
            if ((request.getParameter("enunciado") != null)) {
                oActividad.setEnunciado(request.getParameter("enunciado"));
            }
            if ((request.getParameter("fecha") != null)) {
                oActividad.setFecha(Date.valueOf(request.getParameter("fecha")));
            }
            if ((request.getParameter("evaluacion") != null)) {
                oActividad.setEvaluacion(Integer.parseInt(request.getParameter("evaluacion")));
               
            }
            if ((request.getParameter("activo") != null)) {
                oActividad.setActivo(Boolean.parseBoolean(request.getParameter("activo")));
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Controller: Error: Load: Formato de datos en parámetros incorrecto " + e.getMessage());
        }
        return oActividad;
    }
    
}
