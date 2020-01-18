/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cachacajambu.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ength
 */
@Entity
@Table(name = "sale")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Sale.findAll", query = "SELECT s FROM Sale s"),
   @NamedQuery(name = "Sale.findByIdsale", query = "SELECT s FROM Sale s WHERE s.idsale = :idsale"),
   @NamedQuery(name = "Sale.findByDateVenda", query = "SELECT s FROM Sale s WHERE s.dateVenda = :dateVenda"),
   @NamedQuery(name = "Sale.findBySituation", query = "SELECT s FROM Sale s WHERE s.situation = :situation"),
   @NamedQuery(name = "Sale.findByIdclient", query = "SELECT s FROM Sale s WHERE s.idclient = :idclient"),
   @NamedQuery(name = "Sale.findByPricetotal", query = "SELECT s FROM Sale s WHERE s.pricetotal = :pricetotal")})
public class Sale implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(name = "idsale")
   private Integer idsale;
   @Column(name = "date_venda")
   @Temporal(TemporalType.TIMESTAMP)
   private Date dateVenda;
   @Column(name = "situation")
   private Boolean situation;
   @Column(name = "idclient")
   private Integer idclient;
   // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
   @Column(name = "pricetotal")
   private Double pricetotal;
   @JoinColumn(name = "idusers", referencedColumnName = "idusers")
   @ManyToOne
   private Users idusers;
   @OneToMany(mappedBy = "idsale")
   private List<Presale> presaleList;

   public Sale() {
   }

   public Sale(Integer idsale) {
      this.idsale = idsale;
   }

   public Integer getIdsale() {
      return idsale;
   }

   public void setIdsale(Integer idsale) {
      this.idsale = idsale;
   }

   public Date getDateVenda() {
      return dateVenda;
   }

   public void setDateVenda(Date dateVenda) {
      this.dateVenda = dateVenda;
   }

   public Boolean getSituation() {
      return situation;
   }

   public void setSituation(Boolean situation) {
      this.situation = situation;
   }

   public Integer getIdclient() {
      return idclient;
   }

   public void setIdclient(Integer idclient) {
      this.idclient = idclient;
   }

   public Double getPricetotal() {
      return pricetotal;
   }

   public void setPricetotal(Double pricetotal) {
      this.pricetotal = pricetotal;
   }

   public Users getIdusers() {
      return idusers;
   }

   public void setIdusers(Users idusers) {
      this.idusers = idusers;
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
      hash += (idsale != null ? idsale.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Sale)) {
         return false;
      }
      Sale other = (Sale) object;
      if ((this.idsale == null && other.idsale != null) || (this.idsale != null && !this.idsale.equals(other.idsale))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "com.cachacajambu.entity.Sale[ idsale=" + idsale + " ]";
   }
   
}
