package com.cachacajambu.controller;

import com.cachacajambu.dao.ClienteDao;
import com.cachacajambu.entity.Cliente;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;

@ManagedBean(name = "cb")
@SessionScoped
public class ClienteBean {

    private List<Cliente> list;
    private ClienteDao dao;
    public String cpfcnpj = "CPF";

    @Inject
    private Cliente cliente;

    public ClienteBean(){}

    @PostConstruct
    public void init () {
        try {
            dao = new ClienteDao();
            list = dao.listar();
            limpar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void limpar() {
        cliente = new Cliente();
    }

    public void save() {
        try {
            if(cliente.getIdcliente() == null) {
                dao = new ClienteDao();
                dao.salvar(cliente);
                saveMessage();
            } else {
                cliente = new Cliente();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            init();
        }
    }


    private void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("New user registered successfully!", "Novo item registrado com sucesso!"));
    }
    private void updateMensage() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("User successfully changed!", "Usuário Alterado com sucesso!"));
    }
    private void deleteMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("User successfully removed!", "Usuário Deletado com sucesso!"));
    }



    //GETTERS E SETTERS
    public List<Cliente> getList() {
        return list;
    }

    public void setList(List<Cliente> list) {
        this.list = list;
    }

    public ClienteDao getDao() {
        return dao;
    }

    public void setDao(ClienteDao dao) {
        this.dao = dao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getCpfcnpj() {
        return cpfcnpj;
    }

    public void setCpfcnpj(String cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
    }
}
