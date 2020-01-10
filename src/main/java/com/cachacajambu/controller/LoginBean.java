package com.cachacajambu.controller;

import com.cachacajambu.dao.UsersDAO;
import com.cachacajambu.entity.Users;
import com.cachacajambu.session.SessionContext;
import com.cachacajambu.util.ConvertMD5;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Date;
import java.util.Enumeration;

@ManagedBean(name = "login")//se não colocar nada... é o nome da classe minusculo
@SessionScoped
public class LoginBean implements Serializable {

    //Atributos
    private UsersDAO dao = new UsersDAO();
    private Users user = new Users();
    private ConvertMD5 md5 = new ConvertMD5();
    //Construtor
    public LoginBean(){}

    //Metodo para Enviar Informações de Login para o UserDao
    public String enviaInfoLogin() {
        try {
            System.out.println(user);

            if (user == null) {

                return null;
            } else {
                user.setSenha(md5.convertStringToMd5(user.getSenha()));
                Users usuarioLogado = dao.Login(user);
                SessionContext.getInstance().setAttribute("usuarioId", usuarioLogado.getIdusers());
                SessionContext.getInstance().setAttribute("usuario", usuarioLogado.getNome());
                SessionContext.getInstance().setAttribute("dataCriacao", usuarioLogado.getDataCriacao());
                FacesContext facesContext = FacesContext.getCurrentInstance();
                HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
                Enumeration e = session.getAttributeNames();

                return "/pages/index.xhtml?faces-redirect=true";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    //Metodo que retorna o nome de  usuário na sessão
    public String getUserSession() {
        try {
            return (String) SessionContext.getInstance().getAttribute("usuario");
        }catch (Exception e){
            return null;
        }
    }

    public Date getDateCriation() {
        try {
            return (Date) SessionContext.getInstance().getAttribute("dataCriacao");
        } catch (Exception e) {
            return null;
        }
    }

    public String closeSession() {
        SessionContext.getInstance().encerrarSessao();
        return "/login.xhtml?faces-redirect=true";
    }



    //Getters e Setters
    public Users getUser() {
        return user;
    }
    public void setUser(Users user) {
        this.user = user;
    }
}
