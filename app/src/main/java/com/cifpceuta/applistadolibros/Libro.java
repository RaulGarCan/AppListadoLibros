package com.cifpceuta.applistadolibros;

public class Libro {
    private String titulo;
    private int nPaginas;
    private int imagen;
    private String descripcion;
    public Libro(String titulo, int nPaginas, int imagen, String descripcion){
        this.titulo=titulo;
        this.nPaginas=nPaginas;
        this.imagen=imagen;
        this.descripcion=descripcion;
    }

    public int getnPaginas() {
        return nPaginas;
    }

    public void setnPaginas(int nPaginas) {
        this.nPaginas = nPaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getImagen() {
        return imagen;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
