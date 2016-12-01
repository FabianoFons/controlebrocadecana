/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.annotations.Expose;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Fabiano
 */
@Entity
@Table(name = "analiseentomologica")
public class AnaliseEntomologica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "idtalhao")
    private Talhao talhao;
    private Integer corte;
    private Date dataAnalise;
    private Float longitude;
    private Float latitude;
    @Expose
    private Integer totalNos;
    @Expose
    private Integer brocados;
    @Expose
    private Integer podridaoVermelha;
    @Expose
    private Integer brocaPequena;
    @Expose
    private Integer brocaGrande;
    @Expose
    private Integer crisalida;
    @Expose
    private Integer pupas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Talhao getTalhao() {
        return talhao;
    }

    public void setTalhao(Talhao talhao) {
        this.talhao = talhao;
    }

    public Integer getCorte() {
        return corte;
    }

    public void setCorte(Integer corte) {
        this.corte = corte;
    }

    public Date getDataAnalise() {
        return dataAnalise;
    }

    public void setDataAnalise(Date dataAnalise) {
        this.dataAnalise = dataAnalise;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Integer getTotalNos() {
        return totalNos;
    }

    public void setTotalNos(Integer totalNos) {
        this.totalNos = totalNos;
    }

    public Integer getBrocados() {
        return brocados;
    }

    public void setBrocados(Integer brocados) {
        this.brocados = brocados;
    }

    public Integer getPodridaoVermelha() {
        return podridaoVermelha;
    }

    public void setPodridaoVermelha(Integer podridaoVermelha) {
        this.podridaoVermelha = podridaoVermelha;
    }

    public Integer getBrocaPequena() {
        return brocaPequena;
    }

    public void setBrocaPequena(Integer brocaPequena) {
        this.brocaPequena = brocaPequena;
    }

    public Integer getBrocaGrande() {
        return brocaGrande;
    }

    public void setBrocaGrande(Integer brocaGrande) {
        this.brocaGrande = brocaGrande;
    }

    public Integer getCrisalida() {
        return crisalida;
    }

    public void setCrisalida(Integer crisalida) {
        this.crisalida = crisalida;
    }

    public Integer getPupas() {
        return pupas;
    }

    public void setPupas(Integer pupas) {
        this.pupas = pupas;
    }
    
    
}
