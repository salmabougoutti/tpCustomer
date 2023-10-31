/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.emsi.tpcutomerbougoutti.jsf;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import ma.emsi.tpcutomerbougoutti.entity.Customer;
import ma.emsi.tpcutomerbougoutti.entity.Discount;
import ma.emsi.tpcutomerbougoutti.service.CustomerManager;
import ma.emsi.tpcutomerbougoutti.service.DiscountManger;


/**
 *
 * @author M2B PRO
 */
@Named
@ViewScoped
public class CustomerDetailsBean implements Serializable{
   private int idCustomer;

    /**
     *
     */
    private Customer customer;

    /**
     *
     */
    @Inject
  private CustomerManager customerManager;

    /**
     *
     */
    @Inject
  private DiscountManger discountManger;
  
    /**
     *
     * @return
     */
    public int getIdCustomer() {
    return idCustomer;
  }

    /**
     *
     * @param idCustomer
     */
    public void setIdCustomer(int idCustomer) {
    this.idCustomer = idCustomer;
  }

  /**
   * Retourne les détails du client courant (contenu dans l'attribut customer de
   * cette classe).
     * @return 
   */
    public Customer getCustomer() {
      return customer;
    }

  /**
   * Action handler - met à jour dans la base de données les données du client
   * contenu dans la variable d'instance customer.
   * @return la prochaine page à afficher, celle qui affiche la liste des clients.
   */
  public String update() {
    // Modifie la base de données.
    // Il faut affecter à customer (sera expliqué dans le cours).
    customer = customerManager.update(customer);
    return "customerList";
  }

    /**
     *
     */
    public void loadCustomer() {
    this.customer = customerManager.findById(idCustomer);
  }
  /**
   * Retourne la liste de tous les Discount.
     * @return 
   */
  public List<Discount> getDiscounts() {
    return discountManger.getAllDiscounts();
  }
}
