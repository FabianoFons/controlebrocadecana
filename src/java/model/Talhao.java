/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.annotations.Expose;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import model.AnaliseEntomologica;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Temporal;

/**
 *
 * @author Fabiano
 */
@Entity
@Table(name = "talhao")
public class Talhao{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Expose
    private Integer id;
    @Expose
    private String identificacao;
    @Expose
    private String area;
    @Expose
    private Date data;
    @Expose
    private String bloco;
    @ManyToOne
    @JoinColumn(name = "idvariedade")
    private Variedade variedade;
    @ManyToOne
    @JoinColumn(name = "idfundoagricola")
    private FundoAgricola fundoAgricola;
    
    @OneToMany(mappedBy = "talhao")
    private List<AnaliseEntomologica> analises = new ArrayList<AnaliseEntomologica>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Variedade getVariedade() {
        return variedade;
    }

    public void setVariedade(Variedade variedade) {
        this.variedade = variedade;
    }

    public FundoAgricola getFundoAgricola() {
        return fundoAgricola;
    }

    public void setFundoAgricola(FundoAgricola fundoAgricola) {
        this.fundoAgricola = fundoAgricola;
    }

    public List<AnaliseEntomologica> getAnalises() {
        return analises;
    }

    public void setAnalises(List<AnaliseEntomologica> analises) {
        this.analises = analises;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }
    
    
}
