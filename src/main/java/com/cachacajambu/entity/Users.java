/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cachacajambu.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ength
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
   @NamedQuery(name = "Users.findByIdusers", query = "SELECT u FROM Users u WHERE u.idusers = :idusers"),
   @NamedQuery(name = "Users.findByCargo", query = "SELECT u FROM Users u WHERE u.cargo = :cargo"),
   @NamedQuery(name = "Users.findByNome", query = "SELECT u FROM Users u WHERE u.nome = :nome"),
   @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
   @NamedQuery(name = "Users.findByPhone", query = "SELECT u FROM Users u WHERE u.phone = :phone"),
   @NamedQuery(name = "Users.findByLogin", query = "SELECT u FROM Users u WHERE u.login = :login"),
   @NamedQuery(name = "Users.findBySenha", query = "SELECT u FROM Users u WHERE u.senha = :senha"),
   @NamedQuery(name = "Users.findByDataCriacao", query = "SELECT u FROM Users u WHERE u.dataCriacao = :dataCriacao")})
public class Users implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(name = "idusers")
   private Integer idusers;
   @Basic(optional = false)
   @Column(name = "cargo")
   @Enumerated(EnumType.STRING)
   private Cargo cargo;
   @Basic(optional = false)
   @Column(name = "nome")
   private String nome;
   @Column(name = "email")
   private String email;
   @Column(name = "phone")
   private String phone;
   @Basic(optional = false)
   @Column(name = "login",  unique=true)
   private String login;
   @Basic(optional = false)
   @Column(name = "senha")
   private String senha;
   @Column(name = "data_criacao", columnDefinition = "datetime default current_timestamp")
   @Temporal(TemporalType.TIMESTAMP)
   private Date dataCriacao;
   @OneToMany(mappedBy = "idusers")
   private List<Sale> saleList;

   public Users() {
   }

   public Users(Integer idusers) {
      this.idusers = idusers;
   }

   public Users(Integer idusers, Cargo cargo, String nome, String login, String senha) {
      this.idusers = idusers;
      this.cargo = cargo;
      this.nome = nome;
      this.login = login;
      this.senha = senha;
   }

   public Integer getIdusers() {
      return idusers;
   }

   public void setIdusers(Integer idusers) {
      this.idusers = idusers;
   }

   public Cargo getCargo() {
      return cargo;
   }

   public void setCargo(Cargo cargo) {
      this.cargo = cargo;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getLogin() {
      return login;
   }

   public void setLogin(String login) {
      this.login = login;
   }

   public String getSenha() {
      return senha;
   }

   public void setSenha(String senha) {
      this.senha = senha;
   }

   public Date getDataCriacao() {
      return dataCriacao;
   }

   public void setDataCriacao(Date dataCriacao) {
      this.dataCriacao = dataCriacao;
   }

   @XmlTransient
   public List<Sale> getSaleList() {
      return saleList;
   }

   public void setSaleList(List<Sale> saleList) {
      this.saleList = saleList;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (idusers != null ? idusers.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Users)) {
         return false;
      }
      Users other = (Users) object;
      if ((this.idusers == null && other.idusers != null) || (this.idusers != null && !this.idusers.equals(other.idusers))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "com.cachacajambu.entity.Users[ idusers=" + idusers + " ]";
   }
   
}
