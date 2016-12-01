/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoAnaliseEntomologica;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.AnaliseEntomologica;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;


/**
 *
 * @author Fabiano
 */
@ManagedBean
@ViewScoped
public class MapaController implements Serializable{
    
    private MapModel mapModel;
    private String centerLat;
    private String centerLong;
    
    public MapaController() {
    }
    
    @PostConstruct
    public void init(){
        mapModel = new DefaultMapModel();

        DaoAnaliseEntomologica daoAnaliseEntomologica = new DaoAnaliseEntomologica();
        List<AnaliseEntomologica> listAnaliseEntomologica = daoAnaliseEntomologica.listar();
        if (listAnaliseEntomologica.size() > 0){
            AnaliseEntomologica analiseEntomologica = listAnaliseEntomologica.get(0);
            centerLat = analiseEntomologica.getLatitude().toString();
            centerLong = analiseEntomologica.getLongitude().toString();
        }
        for(AnaliseEntomologica ae: listAnaliseEntomologica){
            
            Marker marker = new Marker(
                    new LatLng(  (ae.getLatitude()), (ae.getLongitude())  ),
                    "Total Nos: "+ae.getTotalNos().getClass()+"\n"+
                    "Brocados: "+ae.getBrocados().getClass()+"\n"+
                    "Recipientes: "+ae.getCorte().getClass());
            if (ae.getBrocados() > 0)
                marker.setIcon("http://maps.google.com/mapfiles/ms/icons/red-dot.png");
            else
                marker.setIcon("http://maps.google.com/mapfiles/ms/icons/green-dot.png");
            
            
            mapModel.addOverlay(marker);        
        }
    }

    public void setMapModel(MapModel mapModel) {
        this.mapModel = mapModel;
    }

    public MapModel getMapModel() {
        return mapModel;
    }
    
     public void voltar(){
        try {
            util.Util.redirecionar("principal.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(MapaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getCenterLat() {
        return centerLat;
    }

    public void setCenterLat(String centerLat) {
        this.centerLat = centerLat;
    }

    public String getCenterLong() {
        return centerLong;
    }

    public void setCenterLong(String centerLong) {
        this.centerLong = centerLong;
    }
     
     
}