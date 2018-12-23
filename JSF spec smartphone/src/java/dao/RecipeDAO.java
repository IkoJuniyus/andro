/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Projekmyspek;
import util.HibernateUtil;

/**
 *
 * @author Acer
 */
public class RecipeDAO {
        public void addImage(Projekmyspek imageObj) {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        try {
            transObj = sessionObj.beginTransaction();
            sessionObj.save(imageObj);
            System.out.println("Berhasil memasukkan data Gambar..");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("berhasilsimpan", imageObj.getId());
            transObj.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transObj.rollback();
        } finally {
            sessionObj.close();
        }
    }

        public void addSpek(Projekmyspek spekObj) {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        try {
            transObj = sessionObj.beginTransaction();
            sessionObj.save(spekObj);
            System.out.println("Berhasil memasukkan data spek..");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("berhasilsimpan", spekObj.getId());
            transObj.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transObj.rollback();
        } finally {
            sessionObj.flush();
            sessionObj.close();
        }
    }
        
    public void destroyspek(Projekmyspek spekObj) {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        try {
            transObj = sessionObj.beginTransaction();
            sessionObj.delete(spekObj);
            System.out.println("Berhasil menghapus data student..");
            transObj.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transObj.rollback();
        } finally {
            sessionObj.flush();
            sessionObj.close();

        }
    }
    
    public List<Projekmyspek> retrievespek() {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        List listStudent = new ArrayList();
        try {
            transObj = sessionObj.beginTransaction();
            Query query = sessionObj.createQuery("from Projekmyspek");
            listStudent = query.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            transObj.commit();
        }
        return listStudent;
    }
    
        public List<Projekmyspek> retrievespekid() {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        List listStudent = new ArrayList();
        try {
            transObj = sessionObj.beginTransaction();
            Query query = sessionObj.createQuery("select id from Projekmyspek");
            listStudent = query.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            transObj.commit();
        }
        return listStudent;
    }
        
    public List<Projekmyspek> getbyID(int id) {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        List<Projekmyspek> listspek = new ArrayList();
        try {
            transObj = sessionObj.beginTransaction();
            Query query = sessionObj.createQuery("from Projekmyspek where id = :id");
            query.setInteger("id", id);
            listspek = query.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            transObj.commit();
        }
        return listspek;
    }
        
        public void updatespek(Projekmyspek spekObj) {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        try {
            transObj = sessionObj.beginTransaction();
            sessionObj.update(spekObj);
            System.out.println("Berhasil mengubah data spek..");
            transObj.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transObj.rollback();
        } finally {
            sessionObj.flush();
            sessionObj.close();
        }
    }
        
        
        public List<Projekmyspek> getAllImg() {
        Transaction transObj = null;
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        List<Projekmyspek> list = null;
        try {
            transObj = sessionObj.beginTransaction();
            Query q = sessionObj.createQuery("From Projekmyspek");
            list = q.list();
            transObj.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transObj.rollback();
        } finally {
            sessionObj.flush();
            sessionObj.close();
        }
        return list;
    }
}
