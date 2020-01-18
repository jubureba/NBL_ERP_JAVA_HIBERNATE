package com.cachacajambu.entity;

public enum Cargo {

    admin("admin"),
    user("user");

    private String label;

    Cargo(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
 }