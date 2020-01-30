/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cachacajambu.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ength
 */
@Entity
@Table(name = "provider")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Provider.findAll", query = "SELECT p FROM Provider p"),
   @NamedQuery(name = "Provider.findByIdprovider", query = "SELECT p FROM Provider p WHERE p.idprovider = :idprovider"),
   @NamedQuery(name = "Provider.findByRazaoSocial", query = "SELECT p FROM Provider p WHERE p.razaoSocial = :razaoSocial"),
   @NamedQuery(name = "Provider.findByNomeFantasia", query = "SELECT p FROM Provider p WHERE p.nomeFantasia = :nomeFantasia"),
   @NamedQuery(name = "Provider.findByInscricaoEstadual", query = "SELECT p FROM Provider p WHERE p.inscricaoEstadual = :inscricaoEstadual"),
   @NamedQuery(name = "Provider.findByCnpj", query = "SELECT p FROM Provider p WHERE p.cnpj = :cnpj"),
   @NamedQuery(name = "Provider.findByEmail", query = "SELECT p FROM Provider p WHERE p.email = :email"),
   @NamedQuery(name = "Provider.findByPhone", query = "SELECT p FROM Provider p WHERE p.phone = :phone"),
   @NamedQuery(name = "Provider.findByCep", query = "SELECT p FROM Provider p WHERE p.cep = :cep"),
   @NamedQuery(name = "Provider.findByMunicipio", query = "SELECT p FROM Provider p WHERE p.municipio = :municipio"),
   @NamedQuery(name = "Provider.findByBairro", query = "SELECT p FROM Provider p WHERE p.bairro = :bairro"),
   @NamedQuery(name = "Provider.findByLogradouro", query = "SELECT p FROM Provider p WHERE p.logradouro = :logradouro"),
   @NamedQuery(name = "Provider.findByUf", query = "SELECT p FROM Provider p WHERE p.uf = :uf"),
   @NamedQuery(name = "Provider.findByNumero", query = "SELECT p FROM Provider p WHERE p.numero = :numero"),
   @NamedQuery(name = "Provider.findByComplemento", query = "SELECT p FROM Provider p WHERE p.complemento = :complemento")})
public class Provider implements Serializable {

   @Column(name = "cpf")
   private BigInteger cpf;
   @Column(name = "data_criacao")
   @Temporal(TemporalType.TIMESTAMP)
   private Date dataCriacao;

   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(name = "idprovider")
   private Integer idprovider;
   @Basic(optional = false)
   @Column(name = "razao_social")
   private String razaoSocial;
   @Column(name = "nome_fantasia")
   private String nomeFantasia;
   @Column(name = "inscricao_estadual")
   private String inscricaoEstadual;
   @Column(name = "cnpj")
   private BigInteger cnpj;
   @Column(name = "email")
   private String email;
   @Column(name = "phone")
   private String phone;
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

   public Provider() {
   }

   public Provider(Integer idprovider) {
      this.idprovider = idprovider;
   }

   public Provider(Integer idprovider, String razaoSocial) {
      this.idprovider = idprovider;
      this.razaoSocial = razaoSocial;
   }

   public Integer getIdprovider() {
      return idprovider;
   }

   public void setIdprovider(Integer idprovider) {
      this.idprovider = idprovider;
   }

   public String getRazaoSocial() {
      return razaoSocial;
   }

   public void setRazaoSocial(String razaoSocial) {
      this.razaoSocial = razaoSocial;
   }

   public String getNomeFantasia() {
      return nomeFantasia;
   }

   public void setNomeFantasia(String nomeFantasia) {
      this.nomeFantasia = nomeFantasia;
   }

   public String getInscricaoEstadual() {
      return inscricaoEstadual;
   }

   public void setInscricaoEstadual(String inscricaoEstadual) {
      this.inscricaoEstadual = inscricaoEstadual;
   }

   public BigInteger getCnpj() {
      return cnpj;
   }

   public void setCnpj(BigInteger cnpj) {
      this.cnpj = cnpj;
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
      hash += (idprovider != null ? idprovider.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Provider)) {
         return false;
      }
      Provider other = (Provider) object;
      if ((this.idprovider == null && other.idprovider != null) || (this.idprovider != null && !this.idprovider.equals(other.idprovider))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "com.cachacajambu.entity.Provider[ idprovider=" + idprovider + " ]";
   }

   public BigInteger getCpf() {
      return cpf;
   }

   public void setCpf(BigInteger cpf) {
      this.cpf = cpf;
   }

   public Date getDataCriacao() {
      return dataCriacao;
   }

   public void setDataCriacao(Date dataCriacao) {
      this.dataCriacao = dataCriacao;
   }
   
}
