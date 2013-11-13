package net.daw.operation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.ActividadBean;
import net.daw.helper.Contexto;
import net.daw.parameter.ActividadParam;

public class ActividadDelete1 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/confirmForm.jsp");
        ActividadBean oActividadBean = new ActividadBean();   
        ActividadParam oActividadParam = new ActividadParam(request);
        oActividadBean  = oActividadParam.loadId(oActividadBean);
        return "Borrar al actividad " + oActividadBean.getId();

    }
}