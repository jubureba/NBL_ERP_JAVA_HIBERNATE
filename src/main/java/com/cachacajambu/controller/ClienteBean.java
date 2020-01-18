package com.cachacajambu.controller;

import com.cachacajambu.dao.ClienteDao;
import com.cachacajambu.entity.Cliente;
import com.cachacajambu.util.CepWebService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "cb")
@SessionScoped
public class ClienteBean implements Serializable {

    private List<Cliente> list;
    private ClienteDao dao;
    public String cpfcnpj = "CPF";
    private String cep;
    private String mascara;
    private String tipoDocumento;
    private String tipos;

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
                System.out.println(cliente.getCpf());
                System.out.println(cliente.getComplemento());
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

    public void delete(int id) {
        try {
            dao.removerById(id);
            deleteMessage();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            init();
        }
    }

    public void encontraCEP() {
        CepWebService cepWebService = new CepWebService(cliente.getCep());
        System.out.println(cliente.getCep());
        if (cepWebService.getResultado() == 1) {
            cliente.setLogradouro(cepWebService.getTipoLogradouro() + " " + cepWebService.getLogradouro());
            cliente.setMunicipio(cepWebService.getCidade());
            cliente.setBairro(cepWebService.getBairro());
            cliente.setCep(cliente.getCep());
            cliente.setUf(cepWebService.getEstado());
            System.out.println(cliente.getCep() + " 11111111111111111111111");
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Cep não encontrado",
                            "Cep não encontrado"));
        }
    }



    public void mudarMascara(){
        if (tipos.equals("CPF")) {
            mascara = "999.999.999-99";
        }else if (tipos.equals("CNPJ")) {

        }
        //TODO: Continue seu código aqui
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getMascara() {
        return mascara;
    }

    public void setMascara(String mascara) {
        this.mascara = mascara;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getTipos() {
        return tipos;
    }

    public void setTipos(String tipos) {
        this.tipos = tipos;
    }
}
