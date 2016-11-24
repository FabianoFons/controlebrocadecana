/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoFazenda;
import dao.DaoTalhao;
import dao.DaoVariedade;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import model.FundoAgricola;
import model.Talhao;
import model.Variedade;

/**
 *
 * @author Fabiano
 */
@ManagedBean(name = "cadastroTalhaoController")
@ViewScoped
public class CadastroTalhaoController {
    private Talhao talhao;
    private List<Talhao> lista;
    private List<SelectItem> fas;
    private List<SelectItem> variedades;
    private FundoAgricola fundoAgricola;
    private Variedade variedade;
    

    @PostConstruct
    public void init(){
        talhao = new Talhao();
        
        DaoTalhao daoTalhao = new DaoTalhao();
        lista = daoTalhao.listar();
        
        fas = new ArrayList<SelectItem>();
        DaoFazenda daoFazenda = new DaoFazenda();
        List<FundoAgricola> lista = daoFazenda.listar();
        for(FundoAgricola f: lista){
            fas.add(new SelectItem(f,f.getNome()));
        }
        
        variedades = new ArrayList<SelectItem>();
        DaoVariedade daoVariedade = new DaoVariedade();
        List<Variedade> l = daoVariedade.listar();
        for(Variedade f: l){
            variedades.add(new SelectItem(f,f.getNome()));
        }        
    }
    
    public Talhao getTalhao() {
        return talhao;
    }

    public void setTalhao(Talhao talhao) {
        this.talhao = talhao;
    }

    public List<Talhao> getLista() {
        return lista;
    }

    public void setLista(List<Talhao> lista) {
        this.lista = lista;
    }    
           
    public CadastroTalhaoController() {
    }
    
    public void salvar(){
        DaoTalhao daoTalhao = new DaoTalhao();
        if (this.talhao.getId() == null){
            daoTalhao.inserir(this.talhao);
            this.lista.add(talhao);
        }else{
            daoTalhao.atualizar(this.talhao);
            int index = this.lista.indexOf(this.talhao);
            this.lista.set(index, this.talhao);
        }        
        this.talhao = new Talhao();
    }
    
    public void excluir(Talhao talhao){
        DaoTalhao daoTalhao = new DaoTalhao();
        daoTalhao.excluir(talhao);
        this.lista.remove(talhao);
    }
    
    public void alterar(Talhao talhao){
        this.talhao = talhao;
    }
    
    public void voltar(){
        try {
            util.Util.redirecionar("principal.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(CadastroFazendaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<SelectItem> getFas() {
        return fas;
    }

    public void setFas(List<SelectItem> fas) {
        this.fas = fas;
    }

    public FundoAgricola getFundoAgricola() {
        return fundoAgricola;
    }

    public void setFundoAgricola(FundoAgricola fundoAgricola) {
        this.fundoAgricola = fundoAgricola;
    }

    public List<SelectItem> getVariedades() {
        return variedades;
    }

    public void setVariedades(List<SelectItem> variedades) {
        this.variedades = variedades;
    }

    public Variedade getVariedade() {
        return variedade;
    }

    public void setVariedade(Variedade variedade) {
        this.variedade = variedade;
    }
    
    
}
