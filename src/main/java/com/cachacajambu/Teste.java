package com.cachacajambu;

import com.cachacajambu.dao.UsersDAO;
import com.cachacajambu.entity.Cargo;
import com.cachacajambu.entity.Users;

public class Teste {
    public  void  asd(){


        Users user = new Users();

        user.setNome("testeNome");
        user.setEmail("testeEmail");
        user.setLogin("Teste");
        user.setSenha("Teste");
        user.setCargo(Cargo.admin);

        UsersDAO con = new UsersDAO();
        con.salvar(user);
    }
}
