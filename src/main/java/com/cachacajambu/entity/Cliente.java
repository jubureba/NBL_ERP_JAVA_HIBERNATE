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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ength
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
   @NamedQuery(name = "Cliente.findByIdcliente", query = "SELECT c FROM Cliente c WHERE c.idcliente = :idcliente"),
   @NamedQuery(name = "Cliente.findByNome", query = "SELECT c FROM Cliente c WHERE c.nome = :nome"),
   @NamedQuery(name = "Cliente.findByEmail", query = "SELECT c FROM Cliente c WHERE c.email = :email"),
   @NamedQuery(name = "Cliente.findByPhone", query = "SELECT c FROM Cliente c WHERE c.phone = :phone"),
   @NamedQuery(name = "Cliente.findByCpf", query = "SELECT c FROM Cliente c WHERE c.cpf = :cpf"),
   @NamedQuery(name = "Cliente.findByCep", query = "SELECT c FROM Cliente c WHERE c.cep = :cep"),
   @NamedQuery(name = "Cliente.findByMunicipio", query = "SELECT c FROM Cliente c WHERE c.municipio = :municipio"),
   @NamedQuery(name = "Cliente.findByBairro", query = "SELECT c FROM Cliente c WHERE c.bairro = :bairro"),
   @NamedQuery(name = "Cliente.findByLogradouro", query = "SELECT c FROM Cliente c WHERE c.logradouro = :logradouro"),
   @NamedQuery(name = "Cliente.findByUf", query = "SELECT c FROM Cliente c WHERE c.uf = :uf"),
   @NamedQuery(name = "Cliente.findByNumero", query = "SELECT c FROM Cliente c WHERE c.numero = :numero"),
   @NamedQuery(name = "Cliente.findByComplemento", query = "SELECT c FROM Cliente c WHERE c.complemento = :complemento")})
public class Cliente implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(name = "idcliente")
   private Integer idcliente;
   @Basic(optional = false)
   @Column(name = "nome")
   private String nome;
   @Column(name = "email")
   private String email;
   @Column(name = "phone")
   private String phone;
   @Column(name = "cpf")
   private Integer cpf;
   @Column(name = "cep")
   private String cep;
   @Column(name = "municipio")
   private String municipio;
   @Column(name = "bairro")
   private String bairro;
   @Column(name = "logradouro")
   private String logradouro;
   @Column(name = "uf")
   private String uf;
   @Column(name = "numero")
   private Integer numero;
   @Column(name = "complemento")
   private String complemento;

   public Cliente() {
   }

   public Cliente(Integer idcliente) {
      this.idcliente = idcliente;
   }

   public Cliente(Integer idcliente, String nome) {
      this.idcliente = idcliente;
      this.nome = nome;
   }

   public Integer getIdcliente() {
      return idcliente;
   }

   public void setIdcliente(Integer idcliente) {
      this.idcliente = idcliente;
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

   public Integer getCpf() {
      return cpf;
   }

   public void setCpf(Integer cpf) {
      this.cpf = cpf;
   }

   public String getCep() {
      return cep;
   }

   public void setCep(String cep) {
      this.cep = cep;
   }

   public String getMunicipio() {
      return municipio;
   }

   public void setMunicipio(String municipio) {
      this.municipio = municipio;
   }

   public String getBairro() {
      return bairro;
   }

   public void setBairro(String bairro) {
      this.bairro = bairro;
   }

   public String getLogradouro() {
      return logradouro;
   }

   public void setLogradouro(String logradouro) {
      this.logradouro = logradouro;
   }

   public String getUf() {
      return uf;
   }

   public void setUf(String uf) {
      this.uf = uf;
   }

   public Integer getNumero() {
      return numero;
   }

   public void setNumero(Integer numero) {
      this.numero = numero;
   }

   public String getComplemento() {
      return complemento;
   }

   public void setComplemento(String complemento) {
      this.complemento = complemento;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (idcliente != null ? idcliente.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Cliente)) {
         return false;
      }
      Cliente other = (Cliente) object;
      if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "com.cachacajambu.entity.Cliente[ idcliente=" + idcliente + " ]";
   }
   
}
