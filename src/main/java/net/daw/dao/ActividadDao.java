/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.daw.bean.ActividadBean;
import net.daw.data.Mysql;

/**
 *
 * @author mati
 */
public class ActividadDao {
    private final Mysql oMysql;
    private final net.daw.helper.Enum.Connection enumTipoConexion;

    public ActividadDao(net.daw.helper.Enum.Connection tipoConexion) throws Exception {
        oMysql = new Mysql();
        enumTipoConexion = tipoConexion;
    }
    
     public int getPages(int intRegsPerPag,HashMap<String, String> hmFilter, HashMap<String, String> hmOrder) throws Exception {
        int pages;
        try {
            oMysql.conexion(enumTipoConexion);
            pages = oMysql.getPages("actividad", intRegsPerPag, hmFilter, hmOrder);
            oMysql.desconexion();
            return pages;
        } catch (Exception e) {
            throw new Exception("ActividadDao.getPages: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }

    public ArrayList<ActividadBean> getPage(int intRegsPerPag, int intPage,HashMap<String, String> hmFilter, HashMap<String, String> hmOrder) throws Exception {
        ArrayList<Integer> arrId;
        ArrayList<ActividadBean> arrActividad = new ArrayList<>();
        try {
            oMysql.conexion(enumTipoConexion);
            arrId = oMysql.getPage("actividad", intRegsPerPag, intPage,hmFilter, hmOrder);
            Iterator<Integer> iterador = arrId.listIterator();
            while (iterador.hasNext()) {
                ActividadBean oActividadBean = new ActividadBean(iterador.next());
                arrActividad.add(this.get(oActividadBean));
            }
            oMysql.desconexion();
            return arrActividad;
        } catch (Exception e) {
            throw new Exception("ActividadDao.getPage: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }

    public ArrayList<String> getNeighborhood(String strLink, int intPageNumber, int intTotalPages, int intNeighborhood) throws Exception {
        oMysql.conexion(enumTipoConexion);        
        ArrayList<String> n = oMysql.getNeighborhood(strLink, intPageNumber, intTotalPages, intNeighborhood);
        oMysql.desconexion();
        return n;
    }

    public ActividadBean get(ActividadBean oActividadBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oActividadBean.setEnunciado(oMysql.getOne("actividad", "enunciado", oActividadBean.getId()));
            oActividadBean.setActivo(Boolean.parseBoolean(oMysql.getOne("actividad", "activo", oActividadBean.getId())));
            oActividadBean.setEvaluacion(Integer.parseInt(oMysql.getOne("actividad", "evaluacion", oActividadBean.getId())));
            oActividadBean.setFecha(Date.valueOf(oMysql.getOne("actividad", "fecha", oActividadBean.getId())));
            oMysql.desconexion();
        } catch (Exception e) {
            throw new Exception("ActividadDao.getActividad: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
        return oActividadBean;
    }


    
    public void set(ActividadBean oActividadBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oMysql.initTrans();
            if (oActividadBean.getId() == 0) {
                oActividadBean.setId(oMysql.insertOne("actividad"));
            }
            oMysql.updateOne(oActividadBean.getId(), "actividad", "enunciado", oActividadBean.getEnunciado());
            oMysql.updateOne(oActividadBean.getId(), "actividad", "activo", oActividadBean.getActivo().toString());
            oMysql.updateOne(oActividadBean.getId(), "actividad", "evaluacion", oActividadBean.getEvaluacion().toString());
            oMysql.updateOne(oActividadBean.getId(), "actividad", "fecha", oActividadBean.getFecha().toString());
            oMysql.commitTrans();
        } catch (Exception e) {
            oMysql.rollbackTrans();
            throw new Exception("ActividadDao.setActividad: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }

    public void remove(ActividadBean oClienteBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oMysql.removeOne(oClienteBean.getId(), "actividad");
            oMysql.desconexion();
        } catch (Exception e) {
            throw new Exception("ActividadDao.removeActividad: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }
}
