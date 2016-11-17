/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoTalhao;
import java.io.IOException;
import java.util.List;
import java.util.logging.*;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import model.Talhao;

/**
 *
 * @author Fabiano
 */
@Named(value = "cadastroTalhaoController")
@Dependent
public class CadastroTalhaoController {
    private Talhao talhao;
    private List<Talhao> lista;
    

    public Talhao getTalhao() {
        return talhao;
    }

    public void setTalhao(Talhao talhao) {
        this.talhao = talhao;
    }

        
    public CadastroTalhaoController() {
    }
    
    @PostConstruct
     public void init(){
        talhao = new Talhao();
    }
    
    public void salvar(){
        DaoTalhao daoTalhao = new DaoTalhao();
        daoTalhao.inserir(this.talhao);
        
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
}