package com.cachacajambu.util;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "paginator")
public class PaginatorBean {

    private boolean paginatorActive = true;

    public void activatePaginator() {
        paginatorActive = true;
    }

    public void deactivatePaginator() {
        paginatorActive = false;
    }

    public boolean isPaginatorActive() {
        return paginatorActive;
    }
}