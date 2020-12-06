/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jose.hospitalbd.ejb;

import com.jose.hospitalbd.entity.Medicamentos;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Jose Luis
 */
@Stateless
public class MedicamentoFacade extends AbstractFacade<Medicamentos>{
    
    @Inject
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }
    public MedicamentoFacade()
    {
        super(Medicamentos.class);
    }
    public Medicamentos un_medicamento(String cadena)
    {
        Medicamentos cs= new Medicamentos();
        try
        {
             cs= (Medicamentos) em.createNativeQuery("SELECT * FROM medicamentos WHERE id= "+cadena+"",Medicamentos.class).getSingleResult();
            //Query query= em.createNativeQuery("SELECT * FROM medicamentos WHERE id= "+cadena+"",Medicamentos.class);
            //cs= (Medicamentos) query.getSingleResult();
            //cs= (Medicamentos) em.createNamedQuery("Medicamentos.findById").setParameter("id",cadena).getSingleResult();
        
        }catch(Exception e)
        {
            throw e;
        }
        return cs;
    }
    public List<Medicamentos> medicamentos()
    {
        try
        {
             return (List<Medicamentos>)em.createNativeQuery("SELECT * FROM medicamentos",Medicamentos.class).getResultList();
        }catch(Exception e)
        {
            throw e;
        }
    }
    public Boolean actualizar(Medicamentos m)
    {
        //Medicamentos cs= new Medicamentos();
        System.out.println("entre");
        System.out.println(m.getId());
        try
        {
            em.createNativeQuery("UPDATE medicamentos SET nombre= ?1, cantidad= ?2 , descripcion= ?3 WHERE id= ?4")
                    .setParameter(1, m.getNombre())
                    .setParameter(2, m.getCantidad())
                    .setParameter(3, m.getDescripcion())
                    .setParameter(4, m.getId())
                    .executeUpdate();
            return true;
        }catch(Exception e)
        {
            throw e;
        }
    }
    public Boolean elimina(String id)
    {
        //Medicamentos cs= new Medicamentos();
        try
        {
            em.createNativeQuery("DELETE FROM medicamentos WHERE id= ?1")
                    .setParameter(1,id)
                    .executeUpdate();
            return true;
        }catch(Exception e)
        {
            throw e;
        }
    }
}
