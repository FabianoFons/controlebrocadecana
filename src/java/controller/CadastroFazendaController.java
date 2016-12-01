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
    private FundoAgricola fundoAgricola;
    private List<FundoAgricola> lista;
    /**
     * Creates a new instance of CadastroAmostradorController
     */
    public CadastroFazendaController() {
    }
    
    @PostConstruct
    public void init(){
        fundoAgricola = new FundoAgricola();
        DaoFazenda daoFundoAgricola = new DaoFazenda();
        lista = daoFundoAgricola.listar();
    }

    public FundoAgricola getFundoAgricola() {
        return fundoAgricola;
    }

    public void setFundoAgricola(FundoAgricola fundoAgricola) {
        this.fundoAgricola = fundoAgricola;
    }
    
    public void salvar(){
        DaoFazenda daoFundoAgricola = new DaoFazenda();
        if (this.fundoAgricola.getId() == null){
            daoFundoAgricola.inserir(this.fundoAgricola);
            this.lista.add(fundoAgricola);
        }else{
            daoFundoAgricola.atualizar(this.fundoAgricola);
            int index = this.lista.indexOf(this.fundoAgricola);
            this.lista.set(index, this.fundoAgricola);
        }
        this.fundoAgricola = new FundoAgricola();
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
    
    public void alterar(FundoAgricola fundoAgricola){
        this.fundoAgricola = fundoAgricola;
    }
    
    public void voltar(){
        try {
            util.Util.redirecionar("principal.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(CadastroFazendaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
