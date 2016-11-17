/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fabiano
 */
public class DaoUsuario extends Dao{
    public Usuario logar(String usuario, String senha){
        Session session = dao.HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Usuario u = null;
        try{
            u = (Usuario)
            session.createQuery(" from Usuario u where u.login = :login and u.senha = :senha")
                    .setParameter("login", usuario)
                    .setParameter("senha", senha)
                    .uniqueResult();
            transaction.commit();
            return u;
        }catch(Exception ex){
            transaction.rollback();
        }
        finally{
            return u;
        }
    }
    
    public List<Usuario> listar(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<Usuario> lista = null;
        try{
            lista = session.createQuery(" from Usuario").list();
            transaction.commit();
        }catch(Exception ex){
            transaction.rollback();
        }finally{
            return lista;
        }
    }
}
