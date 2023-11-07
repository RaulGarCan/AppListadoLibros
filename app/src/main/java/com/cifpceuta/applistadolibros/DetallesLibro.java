package com.cifpceuta.applistadolibros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetallesLibro extends AppCompatActivity {
    private Intent infoLibro;
    private ImageView ivLibro;
    private TextView tvTitulo, tvNPaginas, tvDescripcion;
    private Button btnVolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_libro);

        ivLibro = findViewById(R.id.iv_libro_detalles);
        tvTitulo = findViewById(R.id.tv_titulo_detalles);
        tvNPaginas = findViewById(R.id.tv_npaginas_detalles);
        tvDescripcion = findViewById(R.id.tv_descripcion_detalles);
        btnVolver = findViewById(R.id.btn_volver_detalles);

        infoLibro=this.getIntent();
        if(infoLibro!=null){
            ivLibro.setImageResource(infoLibro.getIntExtra("imagenLibro",0));
            tvTitulo.setText(infoLibro.getStringExtra("tituloLibro"));
            tvNPaginas.setText("Num. páginas: "+infoLibro.getStringExtra("nPaginasLibro"));
            tvDescripcion.setText(infoLibro.getStringExtra("descripcionLibro"));
        }

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volver(v);
            }
        });
    }
    public void volver(View v){
        startActivity(new Intent(this, MainActivity.class));
    }
}