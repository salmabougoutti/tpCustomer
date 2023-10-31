/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.emsi.tpcutomerbougoutti.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import ma.emsi.tpcutomerbougoutti.entity.Discount;

@RequestScoped
public class DiscountManger {

    /**
     *
     */
    @PersistenceContext
    private EntityManager em;

    /**
     *
     * @return
     */
    public List<Discount> getAllDiscounts() {
        Query query = em.createNamedQuery("Discount.findAll");
        return query.getResultList();
    }

    /**
     *
     * @param code
     * @return
     */
    public Discount findById(String code) {
        return em.find(Discount.class, code);
    }

    /**
     *
     * @param discount
     */
    @Transactional
    public void persist(Discount discount) {
        em.persist(discount);
    }
    
}