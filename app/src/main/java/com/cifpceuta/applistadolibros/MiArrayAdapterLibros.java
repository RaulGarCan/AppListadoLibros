package com.cifpceuta.applistadolibros;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MiArrayAdapterLibros extends ArrayAdapter<Libro> {

    private Activity context;
    private ArrayList<Libro> libros;
    public MiArrayAdapterLibros(Activity context, ArrayList<Libro> libros){
        super(context,R.layout.layout_libro_item,libros);
        this.context=context;
        this.libros=libros;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.layout_libro_item,parent,false);

        Libro libro = libros.get(position);

        TextView tvTitulo,tvPaginas;
        ImageView ivLibro;
        tvTitulo = rowView.findViewById(R.id.tv_titulo);
        tvPaginas = rowView.findViewById(R.id.tv_paginas);
        ivLibro = rowView.findViewById(R.id.iv_libro);

        tvTitulo.setText(libro.getTitulo());
        tvPaginas.setText("num. páginas: "+libro.getnPaginas());
        ivLibro.setImageResource(libro.getImagen());

        return rowView;
    }
}
