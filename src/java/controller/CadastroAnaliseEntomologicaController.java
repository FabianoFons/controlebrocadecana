/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoAnaliseEntomologica;
import dao.DaoTalhao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import model.AnaliseEntomologica;
import model.Talhao;



/**
 *
 * @author Fabiano
 */
@ManagedBean(name = "cadastroAnaliseEntomologicaController")
@SessionScoped

public class CadastroAnaliseEntomologicaController {
    private AnaliseEntomologica analiseEntomologica;
    private Talhao talhao;
    private List<SelectItem> ana;
    private List<AnaliseEntomologica> lista;
    /**
     * Creates a new instance of CadastroAmostradorController
     */
    public CadastroAnaliseEntomologicaController() {
    }
    
    @PostConstruct
    public void init(){
        analiseEntomologica = new AnaliseEntomologica();
        
        DaoAnaliseEntomologica daoAnaliseEntomologica = new DaoAnaliseEntomologica();
        lista = daoAnaliseEntomologica.listar();
        
        ana = new ArrayList<SelectItem>();
        DaoTalhao daoTalhao = new DaoTalhao();
        List<Talhao> list = daoTalhao.listar();
        for(Talhao t: list){
            ana.add(new SelectItem(t,t.getIdentificacao()));
        }
        
        
        /*analiseEntomologica = new AnaliseEntomologica();
        DaoAnaliseEntomologica daoAnaliseEntomologica = new DaoAnaliseEntomologica();
        lista = daoAnaliseEntomologica.listar();*/
    }

    public AnaliseEntomologica getAnaliseEntomologica() {
        return analiseEntomologica;
    }

    public void setAnaliseEntomologica(AnaliseEntomologica analiseEntomologica) {
        this.analiseEntomologica = analiseEntomologica;
    }

    public List<AnaliseEntomologica> getLista() {
        return lista;
    }

    public void setLista(List<AnaliseEntomologica> lista) {
        this.lista = lista;
    }

    public Talhao getTalhao() {
        return talhao;
    }

    public void setTalhao(Talhao talhao) {
        this.talhao = talhao;
    }

    public List<SelectItem> getAna() {
        return ana;
    }

    public void setAna(List<SelectItem> ana) {
        this.ana = ana;
    }
    
    

   
    
    public void salvar(){
        DaoAnaliseEntomologica daoAnaliseEntomologica = new DaoAnaliseEntomologica();
        if (this.analiseEntomologica.getId()== null){
            daoAnaliseEntomologica.inserir(this.analiseEntomologica);
            this.lista.add(analiseEntomologica);
        }else{
            daoAnaliseEntomologica.atualizar(this.analiseEntomologica);
            int index = this.lista.indexOf(this.analiseEntomologica);
            this.lista.set(index, this.analiseEntomologica);
        }
        this.analiseEntomologica = new AnaliseEntomologica();
    }

    
    
    public void excluir(AnaliseEntomologica analiseEntomologica){
        DaoAnaliseEntomologica daoAnaliseEntomologica = new DaoAnaliseEntomologica();
        daoAnaliseEntomologica.excluir(analiseEntomologica);
        this.lista.remove(analiseEntomologica);
    }
    
    public void alterar(AnaliseEntomologica analiseEntomologica){
        this.analiseEntomologica = analiseEntomologica;
    }
    
    
    public void voltar(){
        try {
            util.Util.redirecionar("principal.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(CadastroAnaliseEntomologicaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
