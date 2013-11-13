<%@page import="java.util.Date"%>
<%@page import="net.daw.helper.Contexto"%>
<%@page import="net.daw.bean.ActividadBean"%>
<% Contexto oContexto = (Contexto) request.getAttribute("contexto");
    String strTitulo = "";
    String strControlEnabled = "";
    String strValueBoton = "Enviar";
    Integer id = 0;
    String enunciado = "";
    Date fecha = null;
    Integer evaluacion = 0;
    Boolean activo = false;
    if (oContexto.getMetodo().equals("update") || oContexto.getMetodo().equals("view")) {
        ActividadBean oActividadBean = (ActividadBean) oContexto.getParametro();
        id = oActividadBean.getId();
        enunciado = oActividadBean.getEnunciado();
        fecha = oActividadBean.getFecha();
        evaluacion = oActividadBean.getEvaluacion();
        activo = oActividadBean.getActivo();
    }
    if (oContexto.getMetodo().equals("view")) {
        strTitulo = "Vista";
        strControlEnabled = "disabled=\"true\"";
        strValueBoton = "Cerrar";
    }
    if (oContexto.getMetodo().equals("update")) {
        strTitulo = "Edición";
        strValueBoton = "Modificar";
    }
    if (oContexto.getMetodo().equals("new")) {
        strTitulo = "Alta";
        strValueBoton = "Crear";
    }
%>
<h1><%=strTitulo%> de cliente</h1>
<form class="form-horizontal" action="Controller" method="post" id="clienteForm">
    <fieldset>
        <legend>Formulario de cliente</legend>
        <input type="hidden" name="id" value="<%=id%>" /> 
        <input type="hidden" name="class" value="cliente" /> 
        <input type="hidden" name="method" value="<%=oContexto.getMetodo()%>" /> 
        <input type="hidden" name="phase" value="2" />
        <div class="control-group">
            <label class="control-label" for="enunciado">Enunciado: </label> 
            <div class="controls">
                <input <%=strControlEnabled%> id="enunciado" name="enunciado" type="text" size="30" maxlength="50" autofocus="autofocus" value="<%=enunciado%>" /><br />
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="fecha">Primer Fecha: </label>
            <div class="controls">
                <input <%=strControlEnabled%> id="fecha" name="fecha" type="text" size="30" maxlength="50" value="<%=fecha%>" /><br />
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="evaluacion">Evaluacion: </label> 
            <div class="controls">
                <input <%=strControlEnabled%> id="evaluacion" name="evaluacion" type="text" size="30" maxlength="50" value="<%=evaluacion%>" /> <br />
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="activo">activo: </label> 
            <div class="controls">
                <input <%=strControlEnabled%> id="activo" name="activo" type="text" size="30" maxlength="50" value="<%=activo%>" /><br />
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <input type="submit" name="enviar" value="<%=strValueBoton%>" />
            </div>
        </div>   
    </fieldset>
</form>

