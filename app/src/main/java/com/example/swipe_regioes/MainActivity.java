package com.example.swipe_regioes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private LinearLayout LayoutTotal;
    private TextView Regioes;
    private TextView Estados;

    private LinearLayout layout;
    private int contR = 0;
    private int contE = 1;


    public String[][] regioes = new String[][]{
            {"Centro Oeste", "Brasília", "Góias", "Mato Grosso", "Mato Grosso do Sul"},
            {"Nordeste", "Alagoas", "Bahia", "Ceará", "Maranhão", "Paraíba", "Pernambuco", "Piauí", "Rio Grande do Norte", "Sergipe"},
            {"Norte", "Acre", "Amapá", "Amazonas", "Pará", "Rondônia", "Roraima", "Tocantins"},
            {"Sudeste", "Espirito Santo", "Minas Gerais", "Rio de Janeiro", "São Paulo"},
            {"Sul", "Paraná", "Rio Grande do Sul", "Santa Catarina"}};


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutTotal = (LinearLayout) findViewById(R.id.LayoutTotal);
        Regioes = (TextView) findViewById(R.id.Regiao);
        Estados = (TextView) findViewById(R.id.Estados);



        layout.setOnTouchListener(new OnSwipeTouchListener(this) {

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                if (contE > 1 ) {
                    contE--;
                }
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                if (contE <= regioes[contR][contE].length() || contE<9) {
                    contE++;
                }
            }

            @Override
            public void onSwipeTop() {
                super.onSwipeTop();
                contE=1;
                if (contR > 0) {
                    contR--;
                }
            }

            @Override
            public void onSwipeBottom() {
                super.onSwipeBottom();
                contE=1;
                if (contR < 5) {
                    contR++;
                }
            }


        });

    }


}
