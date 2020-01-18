/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cachacajambu.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ength
 */
@Entity
@Table(name = "saleproducts")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Saleproducts.findAll", query = "SELECT s FROM Saleproducts s"),
   @NamedQuery(name = "Saleproducts.findByIdsaleproducts", query = "SELECT s FROM Saleproducts s WHERE s.idsaleproducts = :idsaleproducts"),
   @NamedQuery(name = "Saleproducts.findByDescricao", query = "SELECT s FROM Saleproducts s WHERE s.descricao = :descricao"),
   @NamedQuery(name = "Saleproducts.findByQuantity", query = "SELECT s FROM Saleproducts s WHERE s.quantity = :quantity"),
   @NamedQuery(name = "Saleproducts.findByPrice", query = "SELECT s FROM Saleproducts s WHERE s.price = :price")})
public class Saleproducts implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(name = "idsaleproducts")
   private Integer idsaleproducts;
   @Basic(optional = false)
   @Column(name = "descricao")
   private String descricao;
   @Basic(optional = false)
   @Column(name = "quantity")
   private int quantity;
   @Basic(optional = false)
   @Column(name = "price")
   private double price;
   @OneToMany(mappedBy = "idsaleproducts")
   private List<Presale> presaleList;

   public Saleproducts() {
   }

   public Saleproducts(Integer idsaleproducts) {
      this.idsaleproducts = idsaleproducts;
   }

   public Saleproducts(Integer idsaleproducts, String descricao, int quantity, double price) {
      this.idsaleproducts = idsaleproducts;
      this.descricao = descricao;
      this.quantity = quantity;
      this.price = price;
   }

   public Integer getIdsaleproducts() {
      return idsaleproducts;
   }

   public void setIdsaleproducts(Integer idsaleproducts) {
      this.idsaleproducts = idsaleproducts;
   }

   public String getDescricao() {
      return descricao;
   }

   public void setDescricao(String descricao) {
      this.descricao = descricao;
   }

   public int getQuantity() {
      return quantity;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   @XmlTransient
   public List<Presale> getPresaleList() {
      return presaleList;
   }

   public void setPresaleList(List<Presale> presaleList) {
      this.presaleList = presaleList;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (idsaleproducts != null ? idsaleproducts.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Saleproducts)) {
         return false;
      }
      Saleproducts other = (Saleproducts) object;
      if ((this.idsaleproducts == null && other.idsaleproducts != null) || (this.idsaleproducts != null && !this.idsaleproducts.equals(other.idsaleproducts))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "com.cachacajambu.entity.Saleproducts[ idsaleproducts=" + idsaleproducts + " ]";
   }
   
}
