package com.cachacajambu.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class ChangePageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name="/pages/indexcontent/info.xhtml";

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}