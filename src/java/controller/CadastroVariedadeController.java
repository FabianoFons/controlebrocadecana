/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import model.Variedade;
import dao.DaoVariedade;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.annotation.PostConstruct;





/**
 *
 * @author Fabiano
 */
@Named(value = "cadastroVariedadeController")
@Dependent
public class CadastroVariedadeController {
    private Variedade variedade;
    private List<Variedade> lista;
        
    public CadastroVariedadeController() {
    }
    
    @PostConstruct
    public void init(){
        variedade = new Variedade();
        DaoVariedade daoVariedade = new DaoVariedade();
        lista = daoVariedade.listar();
    }

    public Variedade getVariedade() {
        return variedade;
    }

    public void setVariedade(Variedade variedade) {
        this.variedade = variedade;
    }

    public List<Variedade> getLista() {
        return lista;
    }

    public void setLista(List<Variedade> lista) {
        this.lista = lista;
    }    
        
    public void salvar(){
        DaoVariedade daoVariedade = new DaoVariedade();
        if (this.variedade.getId() == null){
            daoVariedade.inserir(this.variedade);
            this.lista.add(variedade);
        }else{
            daoVariedade.atualizar(this.variedade);
            int index = this.lista.indexOf(this.variedade);
            this.lista.set(index, this.variedade);
        }
        this.variedade = new Variedade();
    }
    
     public void excluir(Variedade variedade){
        DaoVariedade daoVariedade = new DaoVariedade();
        daoVariedade.excluir(variedade);
        this.lista.remove(variedade);
    }
    
    public void alterar(Variedade variedade){
        this.variedade = variedade;
    }
    
    public void voltar(){
        try {
            util.Util.redirecionar("principal.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
