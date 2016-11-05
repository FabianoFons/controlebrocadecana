/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;



import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class Dao {
    public void inserir(Object object){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t =  session.beginTransaction();
        try{
            session.persist(object);
            t.commit();
        }catch(Exception ex){
            ex.printStackTrace();
            t.rollback();
        }finally{
            session.close();
        }
    }    
}