/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Talhao;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fabiano
 */
public class DaoTalhao extends Dao{
     public List<Talhao> listar(){
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         Transaction transaction = session.beginTransaction();
        List<Talhao> lista = null;
        try{
            lista = session.createQuery(" from Talhao").list();
            transaction.commit();
        }catch(Exception ex){
            transaction.rollback();
        }finally{
            return lista;
        }
    }
     
     public Object getById(Integer id){
        Session session = dao.HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Talhao talhao = null;
        try{
            talhao = (Talhao) session.get(Talhao.class, id);
            t.commit();
        }catch(Exception ex){
            ex.printStackTrace();
            t.rollback();
        }finally{
            return talhao;
        }
    }     
}
