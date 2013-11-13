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
public class ActividadNew2 {
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/mensaje.jsp");
        ActividadBean oActividadBean = new ActividadBean();
        ActividadDao oActividadDao = new ActividadDao(oContexto.getEnumTipoConexion());
        ActividadParam oActividadParam = new ActividadParam(request);
        oActividadBean = oActividadParam.loadId(oActividadBean);
        try {
            oActividadBean = oActividadParam.load(oActividadBean);
        } catch (NumberFormatException e) {
            return "Tipo de dato incorrecto en uno de los campos del formulario";
        }
        try {
            oActividadDao.set(oActividadBean);
        } catch (Exception e) {
            throw new ServletException("ActividadController: Update Error: Phase 2: " + e.getMessage());
        }
        return "Se ha añadido la información del actividad con id=" + Integer.toString(oActividadBean.getId());
    } 
}
