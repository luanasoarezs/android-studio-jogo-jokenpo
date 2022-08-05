package com.projeto.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    enum Opcao {
        PEDRA(0, "pedra", R.drawable.pedra), PAPEL(1, "papel", R.drawable.papel), TESOURA(2, "tesoura", R.drawable.tesoura);

        private Integer value;
        private String text;
        private int drawable;

        public static Opcao getOpcao(final int value) {
            if (value == 0) {
                return Opcao.PEDRA;
            } else if (value == 1) {
                return Opcao.PAPEL;
            } else {
                return Opcao.TESOURA;
            }
        }

        public int getDrawable() {
            return this.drawable;
        }

        public String getText() {
            return this.text + "!";
        }

        Opcao(final Integer value, final String text, final int drawable) {
            this.value = value;
            this.text = text;
            this.drawable = drawable;
        }
    }


    public void selecionadoPedra(View view) {

        this.opcaoSelecionada(Opcao.PEDRA);
    }

    public void selecionadoPapel(View view) {

        this.opcaoSelecionada(Opcao.PAPEL);
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada(Opcao.TESOURA);

    }

    public void opcaoSelecionada(final Opcao opcaoSelecionada) {

        final ImageView imageResultado = findViewById(R.id.imageResultado);

        final TextView textResultado = findViewById(R.id.textResultado);

        final int numero = new Random().nextInt(3); // 0 1 2
        final Opcao opcaoApp = Opcao.getOpcao(numero);

        imageResultado.setImageResource(opcaoApp.getDrawable());

        if (
                opcaoApp.equals(Opcao.TESOURA) && opcaoSelecionada.equals(Opcao.PAPEL) ||
                        opcaoApp.equals(Opcao.PAPEL) && opcaoSelecionada.equals(Opcao.PEDRA) ||
                        opcaoApp.equals(Opcao.PEDRA) && opcaoSelecionada.equals(Opcao.TESOURA)
        ) {
            textResultado.setText(R.string.YOU_LOSE);
        } else if (
                opcaoSelecionada.equals(Opcao.TESOURA) && opcaoApp.equals(Opcao.PAPEL) ||
                        opcaoSelecionada.equals(Opcao.PAPEL) && opcaoApp.equals(Opcao.PEDRA) ||
                        opcaoSelecionada.equals(Opcao.PEDRA) && opcaoApp.equals(Opcao.TESOURA)
        ) {
            textResultado.setText(getString(R.string.YOU_WIN, opcaoSelecionada.getText()));
        } else {
            textResultado.setText(R.string.TIE);
        }
    }
}