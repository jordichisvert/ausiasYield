/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.ActividadBean;
import net.daw.dao.ActividadDao;
import net.daw.helper.Contexto;
import net.daw.parameter.ActividadParam;

/**
 *
 * @author mati
 */
public class ActividadUpdate1 {
     public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/actividad/form.jsp");
        ActividadBean oActividadBean;
        ActividadDao oActividadDao;
        oActividadBean = new ActividadBean();
        ActividadParam oActividadParam = new ActividadParam(request);
        oActividadBean = oActividadParam.loadId(oActividadBean);
        oActividadDao = new ActividadDao(oContexto.getEnumTipoConexion());
        try {
            oActividadBean = oActividadDao.get(oActividadBean);
        } catch (Exception e) {
            throw new ServletException("Controller: Update Error: Phase 1: " + e.getMessage());
        }
        try {
            oActividadBean = oActividadParam.load(oActividadBean);
        } catch (NumberFormatException e) {
            oContexto.setVista("jsp/mensaje.jsp");
            return "Tipo de dato incorrecto en uno de los campos del formulario";
        }
        return oActividadBean;
    }  
}
