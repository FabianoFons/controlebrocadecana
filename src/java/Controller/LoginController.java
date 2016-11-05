/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.DaoUsuario;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Usuario;

/**
 *
 * @author Fabiano
 */
@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController {

    private String login;
    private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void logar() throws IOException{
        if (!this.login.equals("") &&
            !this.senha.equals("")){
            DaoUsuario daoUsuario = new DaoUsuario();
            Usuario u = daoUsuario.logar(login, senha);
            if (u != null){
                util.Util.redirecionar("principal.xhtml");
            }
        }
    }
    
    
    
}