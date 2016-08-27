/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author fabia
 */
public class AnaliseEntomologica {
    private Variedade variedade;
    private Talhao talhao;
    private Integer corte;
    private Date dataAnalise;
    private Pessoa amostrador;
    private Float longitude;
    private Float latitude;
    private Integer totalNos;
    private Integer brocados;
    private Integer podridaoVermelha;
    private Integer brocaPequena;
    private Integer brocaGrande;
    private Integer crisalida;
    private Integer pupas;

    public Variedade getVariedade() {
        return variedade;
    }

    public void setVariedade(Variedade variedade) {
        this.variedade = variedade;
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

    public Pessoa getAmostrador() {
        return amostrador;
    }

    public void setAmostrador(Pessoa amostrador) {
        this.amostrador = amostrador;
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
