/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operation;

import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.ActividadBean;
import net.daw.dao.ActividadDao;
import net.daw.helper.Contexto;

/**
 *
 * @author mati
 */
public class ActividadList1 {

    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/cliente/list.jsp");
        try {
            ActividadDao oActividadDAO = new ActividadDao(oContexto.getEnumTipoConexion());
            Integer intPages = oActividadDAO.getPages(oContexto.getNrpp(), oContexto.getHmFilter(), oContexto.getHmOrder());
            if (oContexto.getPage() >= intPages) {
                oContexto.setPage(intPages);
            }
            if (oContexto.getPage() < 1) {
                oContexto.setPage(1);
            }
            ArrayList<ActividadBean> listado = (ArrayList<ActividadBean>) oActividadDAO.getPage(oContexto.getNrpp(), oContexto.getPage(), oContexto.getHmFilter(), oContexto.getHmOrder());
            String strUrl = "<a href=\"Controller?" + oContexto.getSerializedParamsExceptPage() + "&page=";            
            ArrayList<String> botoneraActividad = (ArrayList<String>) oActividadDAO.getNeighborhood(strUrl, oContexto.getPage(), intPages, 2);
            ArrayList<Object> a = new ArrayList<>();
            a.add(listado);
            a.add(botoneraActividad);
            return a;
        } catch (Exception e) {
            throw new ServletException("ClienteList1: View Error: " + e.getMessage());
        }
    }
}
