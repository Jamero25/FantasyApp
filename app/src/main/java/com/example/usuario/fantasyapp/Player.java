package com.example.usuario.fantasyapp;

/**
 * Created by Usuario on 05/05/2015.
 */
public class Player {


    private Integer id;

    private String urlImagen;
    private String name;
    private String team;
    private String valor;

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }



    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getValor() {
        return valor;
    }
}
