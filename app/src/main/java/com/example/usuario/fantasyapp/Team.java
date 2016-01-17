package com.example.usuario.fantasyapp;

/**
 * Created by Usuario on 28/04/2015.
 */
public class Team {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    private Integer id;
    private String urlImagen;
    private String nameTeam;



}
