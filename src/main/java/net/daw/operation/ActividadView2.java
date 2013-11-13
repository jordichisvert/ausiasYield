/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.helper.Contexto;

/**
 *
 * @author mati
 */
public class ActividadView2 {
      public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/actividad/list.jsp");
        oContexto.setClase("actividad");
        oContexto.setMetodo("list");
        oContexto.setFase("1");
        ActividadList1 oOperacion = new ActividadList1();
        return oOperacion.execute(request, response);
    }
}
