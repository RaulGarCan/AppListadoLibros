package com.cifpceuta.applistadolibros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listaLibros;
    private MiArrayAdapterLibros adapterLibros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaLibros = findViewById(R.id.lv_lista_libros);

        ArrayList<Libro> libros = new ArrayList<>();

        libros.add(new Libro("Acceso a datos",424,R.drawable.acceso_datos,"El libro está dividido en 6 capítulos que se corresponden con los contenidos del título. El libro tiene una orientación práctica; se exponen los contenidos teóricos seguidos de ejemplos y actividades diseñadas para facilitar la comprensión de los mismos. Se parte de los conocimientos previos que el alumno ha adquirido en el primer curso en los módulos profesionales de Bases de datos, Programación (Java), Lenguajes de marcas y sistemas de gestión de información y Entornos de desarrollo."));
        libros.add(new Libro("Lenguaje de marcas y sistemas de gestión de la información",416,R.drawable.lenguaje_marcas,"En este libro se desarrollan los contenidos del módulo profesional Lenguajes de marcas y sistemas de gestión de información de los Ciclos Formativos de Grado Superior de Desarrollo de Aplicaciones Multiplataforma, Desarrollo de Aplicaciones Web y Administración de Sistemas Informáticos en Red, pertenecientes a la familia profesional de Informática y Comunicaciones."));
        libros.add(new Libro("Sistemas informáticos y redes locales",226,R.drawable.sistemas_informaticos,"Este libro desarrolla los contenidos del módulo profesional de Sistemas Informáticos y Redes Locales, del Ciclo Formativo de grado superior de Sistemas de Telecomunicaciones e Informáticos, de la familia profesional de Electricidad y Electrónica."));
        libros.add(new Libro("Entornos de desarrollo",378,R.drawable.entornos,"El contenido de este libro tiene una orientación práctica. En el Capítulo 1 se estudian los procesos, actividades y tareas involucradas en el desarrollo, explotación y mantenimiento de un producto de software. Se estudia la relación entre un programa informático y los distintos componentes del ordenador, se analizan diferentes lenguajes de programación, se estudian los diferentes estados por los que pasa un programa desde que se escribe hasta que se ejecuta en el ordenador, se introduce el concepto de máquina virtual."));
        libros.add(new Libro("Administración de sistemas gestores de bases de datos",314,R.drawable.administracion_bases,"Este texto incluye, como parte de la automatización de tareas (scripts), los backups y restores de bases de datos. Además, se ha explicado extensamente el Recovery Manager (rman) de Oracle, que se considera fundamental en la formación de cualquier DBA. En cualquier caso, el objetivo se mantiene: la formación de administradores de bases de datos actualizados, versátiles y competentes."));

        adapterLibros = new MiArrayAdapterLibros(this,libros);
        listaLibros.setAdapter(adapterLibros);

        listaLibros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                detallesLibro(view, position);
            }
        });
    }
    public void detallesLibro(View view, int position){
        int imagenLibro = adapterLibros.getItem(position).getImagen();
        String tituloLibro = adapterLibros.getItem(position).getTitulo();
        String nPaginasLibro = String.valueOf(adapterLibros.getItem(position).getnPaginas());
        String descripcionLibro = adapterLibros.getItem(position).getDescripcion();

        Intent i = new Intent(this, DetallesLibro.class);
        i.putExtra("imagenLibro",imagenLibro);
        i.putExtra("tituloLibro",tituloLibro);
        i.putExtra("nPaginasLibro",nPaginasLibro);
        i.putExtra("descripcionLibro",descripcionLibro);
        startActivity(i);
    }
}