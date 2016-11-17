/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fabiano
 */
public class Dao {
    public void inserir(Object object){
        Session session = dao.HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t =  session.beginTransaction();
        try{
            session.persist(object);
            t.commit();
        }catch(Exception ex){
            ex.printStackTrace();
            t.rollback();
        }
    } 
    
    public void atualizar(Object object){
        Session session = dao.HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t =  session.beginTransaction();
        try{
            session.update(object);
            t.commit();
        }catch(Exception ex){
            ex.printStackTrace();
            t.rollback();
        }
    }

    public void excluir(Object object){
        Session session = dao.HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t =  session.beginTransaction();
        try{
            session.delete(object);
            t.commit();
        }catch(Exception ex){
            ex.printStackTrace();
            t.rollback();
        }
    }
}
