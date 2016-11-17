package util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import javax.faces.context.FacesContext;

/**
 *
 * @author Fabiano
 */
public class Util {
    public static void redirecionar(String pagina) throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().
                redirect(FacesContext.getCurrentInstance().
                        getExternalContext().getRequestContextPath()+"/"+pagina);
    }
}
