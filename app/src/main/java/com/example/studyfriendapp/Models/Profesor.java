package com.example.studyfriendapp.Models;

public class Profesor {

    private String name, materia, telefono;
    private int image;

    public Profesor(String name, String materia, String telefono, int image) {
        this.name = name;
        this.materia = materia;
        this.telefono = telefono;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
