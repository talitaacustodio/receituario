package com.projectt.aplicativoreceituario.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.projectt.aplicativoreceituario.R;

public class RelatoriosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorios);
    }

    public void gerarRelatorio(View view){
        startActivity(new Intent(this, RelatorioComissao.class));

    }
}
