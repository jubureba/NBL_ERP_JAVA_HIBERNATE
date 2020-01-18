/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cachacajambu.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ength
 */
@Entity
@Table(name = "presale")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Presale.findAll", query = "SELECT p FROM Presale p"),
   @NamedQuery(name = "Presale.findByIdpresale", query = "SELECT p FROM Presale p WHERE p.idpresale = :idpresale")})
public class Presale implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(name = "idpresale")
   private Integer idpresale;
   @JoinColumn(name = "idsale", referencedColumnName = "idsale")
   @ManyToOne
   private Sale idsale;
   @JoinColumn(name = "idsaleproducts", referencedColumnName = "idsaleproducts")
   @ManyToOne
   private Saleproducts idsaleproducts;

   public Presale() {
   }

   public Presale(Integer idpresale) {
      this.idpresale = idpresale;
   }

   public Integer getIdpresale() {
      return idpresale;
   }

   public void setIdpresale(Integer idpresale) {
      this.idpresale = idpresale;
   }

   public Sale getIdsale() {
      return idsale;
   }

   public void setIdsale(Sale idsale) {
      this.idsale = idsale;
   }

   public Saleproducts getIdsaleproducts() {
      return idsaleproducts;
   }

   public void setIdsaleproducts(Saleproducts idsaleproducts) {
      this.idsaleproducts = idsaleproducts;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (idpresale != null ? idpresale.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Presale)) {
         return false;
      }
      Presale other = (Presale) object;
      if ((this.idpresale == null && other.idpresale != null) || (this.idpresale != null && !this.idpresale.equals(other.idpresale))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "com.cachacajambu.entity.Presale[ idpresale=" + idpresale + " ]";
   }
   
}
