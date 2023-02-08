package com.example.pedra_papel_tesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.SQLOutput;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pedraSelecionado(View view){
        System.out.println("Selecionado Pedra");
        this.opcaoSelecionada("pedra");
    }
    public void tesouraSelecionado(View view){
        System.out.println("Selecionado Tesoura");
        this.opcaoSelecionada("pedra");
    }
    public void papelSelecionado(View view){
        System.out.println("Selecionado Papel");
        this.opcaoSelecionada("papel");
    }

    public void opcaoSelecionada(String escolhaUsuario){
        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textResultado);
        int numero =  new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String escolhaApp = opcoes[numero];
        switch (escolhaApp){
            case "pedra":
            imageResultado.setImageResource(R.drawable.pedra);
            break;
            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }
        if(
                escolhaApp == "tesoura" && escolhaUsuario =="papel" ||
                        escolhaApp == "pedra" && escolhaUsuario == "tesoura"||
                        escolhaApp == "papel" && escolhaUsuario == "pedra"
        ){
            textoResultado.setText("Você perdeu :(");
        }else if(
                escolhaUsuario == "tesoura" && escolhaApp =="papel" ||
                        escolhaUsuario == "pedra" && escolhaApp == "tesoura"||
                        escolhaUsuario == "papel" && escolhaApp == "pedra"
        ){
            textoResultado.setText("Você ganhou :) !");
        }

        else{
            textoResultado.setText("Empatamos :|");
        }
        System.out.println("item clicado: "+escolhaApp);

    }
}