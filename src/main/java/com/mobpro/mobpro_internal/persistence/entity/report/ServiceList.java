package com.mobpro.mobpro_internal.persistence.entity.report;

public enum ServiceList {

    CCTV("admin"),
    CA("ca"),
    SDG("sdg"),
    SADI("sadi"),
    SADIR("sadir"),
    OTHER("other");

    private String service;

    ServiceList(String service){
        this.service = service;
    }

    public String getService() {
        return service;
    }
}
