/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.FundoAgricola;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fabiano
 */
public class DaoFazenda extends Dao{
     public List<FundoAgricola> listar(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<FundoAgricola> lista = null;
        try{
            lista = session.createQuery(" from FundoAgricola").list();
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
        FundoAgricola fundoAgricola = null;
        try{
            fundoAgricola = (FundoAgricola) session.get(FundoAgricola.class, id);
            t.commit();
        }catch(Exception ex){
            ex.printStackTrace();
            t.rollback();
        }finally{
            return fundoAgricola;
        }
    }     
}
