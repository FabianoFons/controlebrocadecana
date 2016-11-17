/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoFazenda;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.FundoAgricola;

/**
 *
 * @author Fabiano
 */
@ManagedBean(name = "cadastroFazendaController")
@SessionScoped
public class CadastroFazendaController {
    private FundoAgricola usuario;
    private List<FundoAgricola> lista;
    /**
     * Creates a new instance of CadastroAmostradorController
     */
    public CadastroFazendaController() {
    }
    
    @PostConstruct
    public void init(){
        usuario = new FundoAgricola();
        DaoFazenda daoFundoAgricola = new DaoFazenda();
        lista = daoFundoAgricola.listar();
    }

    public FundoAgricola getFundoAgricola() {
        return usuario;
    }

    public void setFundoAgricola(FundoAgricola usuario) {
        this.usuario = usuario;
    }
    
    public void salvar(){
        DaoFazenda daoFundoAgricola = new DaoFazenda();
        if (this.usuario.getId() == null){
            daoFundoAgricola.inserir(this.usuario);
            this.lista.add(usuario);
        }else{
            daoFundoAgricola.atualizar(this.usuario);
            int index = this.lista.indexOf(this.usuario);
            this.lista.set(index, this.usuario);
        }
        this.usuario = new FundoAgricola();
    }

    public List<FundoAgricola> getLista() {
        return lista;
    }

    public void setLista(List<FundoAgricola> lista) {
        this.lista = lista;
    }
    
    public void excluir(FundoAgricola usuario){
        DaoFazenda daoFundoAgricola = new DaoFazenda();
        daoFundoAgricola.excluir(usuario);
        this.lista.remove(usuario);
    }
    
    public void alterar(FundoAgricola usuario){
        this.usuario = usuario;
    }
    
    public void voltar(){
        try {
            util.Util.redirecionar("principal.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(CadastroFazendaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
