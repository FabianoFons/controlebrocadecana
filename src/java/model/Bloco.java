/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.List;

/**
 *
 * @author fabia
 */
public class Bloco {
    private Integer id;
    private String descricao;
    private FundoAgricola fundoAgricola;
    private List talhao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public FundoAgricola getFundoAgricola() {
        return fundoAgricola;
    }

    public void setFundoAgricola(FundoAgricola fundoAgricola) {
        this.fundoAgricola = fundoAgricola;
    }

    public List getTalhao() {
        return talhao;
    }

    public void setTalhao(List talhao) {
        this.talhao = talhao;
    }
    
    
}
