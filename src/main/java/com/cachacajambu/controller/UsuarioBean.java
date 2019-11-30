package com.cachacajambu.controller;

import java.util.List;
import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.cachacajambu.dao.UsersDAO;
import com.cachacajambu.entity.Users;

@Named("bean") //se não colocar nada... é o nome da classe minusculo
@ViewScoped
public class UsuarioBean implements Serializable{


	//atributos
	private List<Users> list ;
	//@Inject
	private Users users;
	private UsersDAO dao;

	//CONSTRUTOR
	public UsuarioBean () { }

	public void save() {
		dao = new UsersDAO();
		dao.salvar(users);

		inicializaTela();

	}

	@PostConstruct
	public void inicializaTela() {
		dao = new UsersDAO();
		list = dao.listar();
		limpar();
	}

	public void limpar() {
		users = new Users();
	}

//SETTERS E GETERES
	public List<Users> getList() {
		return list;
	}

	public void setList(List<Users> list) {
		this.list = list;
	}

	public Users getUsers() {
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
