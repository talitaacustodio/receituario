package com.projectt.aplicativoreceituario.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.adapters.SeekBarBindingAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
import com.projectt.aplicativoreceituario.R;
import com.projectt.aplicativoreceituario.activity.CadastroActivity;
import com.projectt.aplicativoreceituario.activity.LoginActivity;
import com.projectt.aplicativoreceituario.config.ConfiguracaoFirebase;

public class MainActivity extends IntroActivity {

    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        setButtonBackVisible(false);
        setButtonNextVisible(false);

        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.holo_blue_light)
                .fragment(R.layout.intro1)
                .build());
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.holo_blue_light)
                .fragment(R.layout.intro2)
                .build());
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.holo_blue_light)
                .fragment(R.layout.intro_cadastro)
                .canGoForward(false)
                .build());
    }

    @Override
    protected void onStart() {
        super.onStart();
        verificarUsuarioLogado();
    }

    public void btEntrar(View view){
        startActivity(new Intent(this, LoginActivity.class));
    }
    public void btCadastar(View view){
        startActivity(new Intent(this, CadastroActivity.class));
    }
    public void verificarUsuarioLogado(){
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.signOut();

        if( autenticacao.getCurrentUser() != null ){
            abrirTelaPrincipal();
        }
    };
    public void abrirTelaPrincipal(){

        startActivity(new Intent(this,PrincipalActivity.class));
    }
}
