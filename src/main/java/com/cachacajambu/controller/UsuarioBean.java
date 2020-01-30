package com.cachacajambu.controller;

import com.cachacajambu.dao.UsersDAO;
import com.cachacajambu.entity.Cargo;
import com.cachacajambu.entity.Users;
import com.cachacajambu.util.ConvertMD5;
import org.primefaces.event.SelectEvent;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@ManagedBean(name = "user")//se não colocar nada... é o nome da classe minusculo
@SessionScoped

public class UsuarioBean implements Serializable{

	//atributos
	private List<Users> list;
	private List<Users> filterList;

	private UsersDAO dao;
	private ConvertMD5 md5 = new ConvertMD5();

	@Inject
	private Users users;

	//CONSTRUTOR
	public UsuarioBean () {
	}
	public Cargo[] getCargo() {
		return Cargo.values();
	}

	@PostConstruct
	public void inicializaTela() {
		try {
			dao = new UsersDAO();
			list = dao.listar();
			limpar();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	private void limpar() {
		users = new Users();
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

	public void save() {
		try {
			if (users.getIdusers() == null) {
				dao = new UsersDAO();
				users.setSenha(md5.convertStringToMd5(users.getSenha())); //Converter a senha para md5
				Date data = new Date();
				System.out.println(data);
				users.setDataCriacao(data);
				dao.salvar(users);
				saveMessage();
			} else {
				users = new Users();
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			inicializaTela();
		}
	}

	public void select(Users e){
		users=e;
	}

	public void update() {
		try {
			dao = new UsersDAO();
			users.setSenha(md5.convertStringToMd5(users.getSenha()));
			dao.update(users);
			updateMensage();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			inicializaTela();
		}
	}

	//datatable select row
	/*public void onRowSelect(SelectEvent event) {
		try {
			event.getObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	public void delete(int id) {
		try {
			dao.removerById(id);
			deleteMessage();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			inicializaTela();
		}
	}


	//SETTERS E Getters
	public List<Users> getList() {
		return list;
	}

	public void setList(List<Users> list) {
		this.list = list;
	}

	public void setFilterList(List<Users> filterList) {
		this.filterList = filterList;
	}

	public List<Users> getFilterList() {
		return filterList;
	}

	public Users getUsers() {
		if(users == null ) {
			users = new Users();
		}
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public UsersDAO getDao() {
		return dao;
	}

	public void setDao(UsersDAO dao) {
		this.dao = dao;
	}


}
