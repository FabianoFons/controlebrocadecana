/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import javafx.scene.chart.PieChart;

/**
 *
 * @author fabia
 */
public class Talhao {
    private Integer id;
    private String identificacao;
    private String area;
    private Date data;
    private Variedade variedade;

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
    
    
}
