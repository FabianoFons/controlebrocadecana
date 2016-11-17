/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoUsuario;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Usuario;

/**
 *
 * @author Fabiano
 */
@ManagedBean(name = "usuarioController")
@SessionScoped
public class UsuarioController {
    private Usuario usuario;
    private List<Usuario> lista;
    /**
     * Creates a new instance of CadastroAmostradorController
     */
    public UsuarioController() {
    }
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
        DaoUsuario daoUsuario = new DaoUsuario();
        lista = daoUsuario.listar();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void salvar(){
        DaoUsuario daoUsuario = new DaoUsuario();
        if (this.usuario.getId() == null){
            daoUsuario.inserir(this.usuario);
            this.lista.add(usuario);
        }else{
            daoUsuario.atualizar(this.usuario);
            int index = this.lista.indexOf(this.usuario);
            this.lista.set(index, this.usuario);
        }
        this.usuario = new Usuario();
    }

    public List<Usuario> getLista() {
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }
    
    public void excluir(Usuario usuario){
        DaoUsuario daoUsuario = new DaoUsuario();
        daoUsuario.excluir(usuario);
        this.lista.remove(usuario);
    }
    
    public void alterar(Usuario usuario){
        this.usuario = usuario;
    }
    
    public void voltar(){
        try {
            util.Util.redirecionar("principal.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
