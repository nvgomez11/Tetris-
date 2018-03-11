package com.example.nelson.tetris;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GameActivity extends AppCompatActivity {
    Tetris tetris = new Tetris();
    final Handler handler = new Handler();

    final Palito palito = new Palito(1,"#64DD17",1,0,4,1,4,2,4,3,4);
    final Ese_invertida ese_invertida = new Ese_invertida(2,"#64DD17",1,0,4,0,5,1,5,1,6);
    final Ese ese = new Ese(3,"#64DD17",1,0,5,0,4,1,4,1,3);
    final Cuadrado cuadrado = new Cuadrado(4,"#64DD17",1,0,4,0,5,1,4,1,5);
    final Ele ele = new Ele(5,"#64DD17",1,0,5,1,5,2,5,2,6);
    final Ele_invertida ele_invertida = new Ele_invertida(6,"#64DD17",1,0,5,1,5,2,5,2,4);
    final Te te = new Te(7,"#64DD17",1,0,4,0,5,0,6,1,5);

    int randomNum_mueve =(int) (Math.random() * 7) + 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();

        final Handler handler = new Handler();
        // Define the code block to be executed
        Runnable runnableCode = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<14; i++){
                    for(int j=0; j<10; j++){
                        int [][] matriz_tetris_aux = tetris.getMatrizTetris();
                        if(matriz_tetris_aux[i][j]==1){
                            dibujaEnPantalla(1,i,j);
                        }else{
                            dibujaEnPantalla(0,i,j);
                        }
                    }
                }
                Log.d("Handlers_MOPOOOOPP", "Called on main thread");
                handler.postDelayed(this,1000);
            }
        };
        handler.postDelayed(runnableCode,1000);



        final CountDownTimer bajaFichas;
        bajaFichas = new CountDownTimer(60000,1000) {
            @Override
            public void onTick(long l) {
                switch(randomNum_mueve){
                    case 1:
                        int matrizPalito_aux1[][];
                        matrizPalito_aux1 = palito.getCuadritosOcupa();
                        tetris.ocupaCuadritos(matrizPalito_aux1[0][0],matrizPalito_aux1[0][1],matrizPalito_aux1[1][0],matrizPalito_aux1[1][1],matrizPalito_aux1[2][0],matrizPalito_aux1[2][1],matrizPalito_aux1[3][0],matrizPalito_aux1[3][1]);
                        tetris.desocupaCuadritos(matrizPalito_aux1[0][0],matrizPalito_aux1[0][1],matrizPalito_aux1[1][0],matrizPalito_aux1[1][1],matrizPalito_aux1[2][0],matrizPalito_aux1[2][1],matrizPalito_aux1[3][0],matrizPalito_aux1[3][1]);
                        if(tetris.puedeMoverFichaAbajo(palito)==true){
                            tetris.moverFicha_abajo(palito);
                            randomNum_mueve = 1;
                        }else{
                            tetris.ocupaCuadritos(matrizPalito_aux1[0][0],matrizPalito_aux1[0][1],matrizPalito_aux1[1][0],matrizPalito_aux1[1][1],matrizPalito_aux1[2][0],matrizPalito_aux1[2][1],matrizPalito_aux1[3][0],matrizPalito_aux1[3][1]);
                            onFinish();
                        }
                        break;
                    case 2:
                        int matrizEseInv_aux1[][];
                        matrizEseInv_aux1 = ese_invertida.getCuadritosOcupa();
                        tetris.ocupaCuadritos(matrizEseInv_aux1[0][0],matrizEseInv_aux1[0][1],matrizEseInv_aux1[1][0],matrizEseInv_aux1[1][1],matrizEseInv_aux1[2][0],matrizEseInv_aux1[2][1],matrizEseInv_aux1[3][0],matrizEseInv_aux1[3][1]);
                        tetris.desocupaCuadritos(matrizEseInv_aux1[0][0],matrizEseInv_aux1[0][1],matrizEseInv_aux1[1][0],matrizEseInv_aux1[1][1],matrizEseInv_aux1[2][0],matrizEseInv_aux1[2][1],matrizEseInv_aux1[3][0],matrizEseInv_aux1[3][1]);
                        if(tetris.puedeMoverFichaAbajo(ese_invertida)==true){
                            tetris.moverFicha_abajo(ese_invertida);
                            randomNum_mueve = 2;
                        }else{
                            tetris.ocupaCuadritos(matrizEseInv_aux1[0][0],matrizEseInv_aux1[0][1],matrizEseInv_aux1[1][0],matrizEseInv_aux1[1][1],matrizEseInv_aux1[2][0],matrizEseInv_aux1[2][1],matrizEseInv_aux1[3][0],matrizEseInv_aux1[3][1]);
                            onFinish();
                        }
                        break;
                    case 3:
                        int matrizEse_aux1[][];
                        matrizEse_aux1 = ese.getCuadritosOcupa();
                        tetris.ocupaCuadritos(matrizEse_aux1[0][0],matrizEse_aux1[0][1],matrizEse_aux1[1][0],matrizEse_aux1[1][1],matrizEse_aux1[2][0],matrizEse_aux1[2][1],matrizEse_aux1[3][0],matrizEse_aux1[3][1]);
                        tetris.desocupaCuadritos(matrizEse_aux1[0][0],matrizEse_aux1[0][1],matrizEse_aux1[1][0],matrizEse_aux1[1][1],matrizEse_aux1[2][0],matrizEse_aux1[2][1],matrizEse_aux1[3][0],matrizEse_aux1[3][1]);
                        if(tetris.puedeMoverFichaAbajo(ese)==true){
                            tetris.moverFicha_abajo(ese);
                            randomNum_mueve = 3;

                        }else{
                            tetris.ocupaCuadritos(matrizEse_aux1[0][0],matrizEse_aux1[0][1],matrizEse_aux1[1][0],matrizEse_aux1[1][1],matrizEse_aux1[2][0],matrizEse_aux1[2][1],matrizEse_aux1[3][0],matrizEse_aux1[3][1]);
                            onFinish();
                        }
                        break;
                    case 4:
                        int matrizCuadrado_aux1[][];
                        matrizCuadrado_aux1 = cuadrado.getCuadritosOcupa();
                        tetris.ocupaCuadritos(matrizCuadrado_aux1[0][0],matrizCuadrado_aux1[0][1],matrizCuadrado_aux1[1][0],matrizCuadrado_aux1[1][1],matrizCuadrado_aux1[2][0],matrizCuadrado_aux1[2][1],matrizCuadrado_aux1[3][0],matrizCuadrado_aux1[3][1]);
                        tetris.desocupaCuadritos(matrizCuadrado_aux1[0][0],matrizCuadrado_aux1[0][1],matrizCuadrado_aux1[1][0],matrizCuadrado_aux1[1][1],matrizCuadrado_aux1[2][0],matrizCuadrado_aux1[2][1],matrizCuadrado_aux1[3][0],matrizCuadrado_aux1[3][1]);
                        if(tetris.puedeMoverFichaAbajo(cuadrado)==true){
                            tetris.moverFicha_abajo(cuadrado);
                            randomNum_mueve = 4;
                        }else{
                            tetris.ocupaCuadritos(matrizCuadrado_aux1[0][0],matrizCuadrado_aux1[0][1],matrizCuadrado_aux1[1][0],matrizCuadrado_aux1[1][1],matrizCuadrado_aux1[2][0],matrizCuadrado_aux1[2][1],matrizCuadrado_aux1[3][0],matrizCuadrado_aux1[3][1]);
                            onFinish();
                        }
                        break;
                    case 5:
                        int matrizEle_aux1[][];
                        matrizEle_aux1 = ele.getCuadritosOcupa();
                        tetris.ocupaCuadritos(matrizEle_aux1[0][0],matrizEle_aux1[0][1],matrizEle_aux1[1][0],matrizEle_aux1[1][1],matrizEle_aux1[2][0],matrizEle_aux1[2][1],matrizEle_aux1[3][0],matrizEle_aux1[3][1]);
                        tetris.desocupaCuadritos(matrizEle_aux1[0][0],matrizEle_aux1[0][1],matrizEle_aux1[1][0],matrizEle_aux1[1][1],matrizEle_aux1[2][0],matrizEle_aux1[2][1],matrizEle_aux1[3][0],matrizEle_aux1[3][1]);
                        if(tetris.puedeMoverFichaAbajo(ele)==true){
                            tetris.moverFicha_abajo(ele);
                            randomNum_mueve = 5;
                        }else{
                            tetris.ocupaCuadritos(matrizEle_aux1[0][0],matrizEle_aux1[0][1],matrizEle_aux1[1][0],matrizEle_aux1[1][1],matrizEle_aux1[2][0],matrizEle_aux1[2][1],matrizEle_aux1[3][0],matrizEle_aux1[3][1]);
                            onFinish();
                        }
                        break;
                    case 6:
                        int matrizEleInv_aux1[][];
                        matrizEleInv_aux1 = ele_invertida.getCuadritosOcupa();
                        tetris.ocupaCuadritos(matrizEleInv_aux1[0][0],matrizEleInv_aux1[0][1],matrizEleInv_aux1[1][0],matrizEleInv_aux1[1][1],matrizEleInv_aux1[2][0],matrizEleInv_aux1[2][1],matrizEleInv_aux1[3][0],matrizEleInv_aux1[3][1]);
                        tetris.desocupaCuadritos(matrizEleInv_aux1[0][0],matrizEleInv_aux1[0][1],matrizEleInv_aux1[1][0],matrizEleInv_aux1[1][1],matrizEleInv_aux1[2][0],matrizEleInv_aux1[2][1],matrizEleInv_aux1[3][0],matrizEleInv_aux1[3][1]);
                        if(tetris.puedeMoverFichaAbajo(ele_invertida)==true){
                            tetris.moverFicha_abajo(ele_invertida);
                            randomNum_mueve = 6;
                        }else{
                            tetris.ocupaCuadritos(matrizEleInv_aux1[0][0],matrizEleInv_aux1[0][1],matrizEleInv_aux1[1][0],matrizEleInv_aux1[1][1],matrizEleInv_aux1[2][0],matrizEleInv_aux1[2][1],matrizEleInv_aux1[3][0],matrizEleInv_aux1[3][1]);
                            onFinish();
                        }
                        break;
                    case 7:
                        int matrizTe_aux1[][];
                        matrizTe_aux1 = te.getCuadritosOcupa();
                        tetris.ocupaCuadritos(matrizTe_aux1[0][0],matrizTe_aux1[0][1],matrizTe_aux1[1][0],matrizTe_aux1[1][1],matrizTe_aux1[2][0],matrizTe_aux1[2][1],matrizTe_aux1[3][0],matrizTe_aux1[3][1]);
                        tetris.desocupaCuadritos(matrizTe_aux1[0][0],matrizTe_aux1[0][1],matrizTe_aux1[1][0],matrizTe_aux1[1][1],matrizTe_aux1[2][0],matrizTe_aux1[2][1],matrizTe_aux1[3][0],matrizTe_aux1[3][1]);
                        if(tetris.puedeMoverFichaAbajo(te)==true){
                            tetris.moverFicha_abajo(te);
                            randomNum_mueve = 7;
                        }else{
                            tetris.ocupaCuadritos(matrizTe_aux1[0][0],matrizTe_aux1[0][1],matrizTe_aux1[1][0],matrizTe_aux1[1][1],matrizTe_aux1[2][0],matrizTe_aux1[2][1],matrizTe_aux1[3][0],matrizTe_aux1[3][1]);
                            onFinish();
                        }
                        break;
                }
            }
            @Override
            public void onFinish() {
                randomNum_mueve =(int) (Math.random() * 7) + 1;
                final int randomNum = (int) (Math.random() * 7) + 1;
                Log.d("Numero aleatorioooooo", Integer.toString(randomNum));
                switch(randomNum_mueve){
                    case 1:
                        palito.setCuadritosOcupaEle(0,4,1,4,2,4,3,4);
                        final int matrizPalito_aux[][] = palito.getCuadritosOcupa();
                        if(tetris.estanCuadritosVacios(matrizPalito_aux[0][0],matrizPalito_aux[0][1],matrizPalito_aux[1][0],matrizPalito_aux[1][1],matrizPalito_aux[2][0],matrizPalito_aux[2][1],matrizPalito_aux[3][0],matrizPalito_aux[3][1])==true){
                            int matrizPalito_aux1[][] = palito.getCuadritosOcupa();
                            tetris.ocupaCuadritos(matrizPalito_aux1[0][0],matrizPalito_aux1[0][1],matrizPalito_aux1[1][0],matrizPalito_aux1[1][1],matrizPalito_aux1[2][0],matrizPalito_aux1[2][1],matrizPalito_aux1[3][0],matrizPalito_aux1[3][1]);
                            onTick(1000);
                        }
                        break;
                    case 2:
                        ese_invertida.setCuadritosOcupaEle(0,4,0,5,1,5,1,6);
                        final int matrizEseInv_aux[][] = ese_invertida.getCuadritosOcupa();
                        if(tetris.estanCuadritosVacios(matrizEseInv_aux[0][0],matrizEseInv_aux[0][1],matrizEseInv_aux[1][0],matrizEseInv_aux[1][1],matrizEseInv_aux[2][0],matrizEseInv_aux[2][1],matrizEseInv_aux[3][0],matrizEseInv_aux[3][1])==true){
                            int matrizEseInv_aux1[][] = ese_invertida.getCuadritosOcupa();
                            tetris.ocupaCuadritos(matrizEseInv_aux1[0][0],matrizEseInv_aux1[0][1],matrizEseInv_aux1[1][0],matrizEseInv_aux1[1][1],matrizEseInv_aux1[2][0],matrizEseInv_aux1[2][1],matrizEseInv_aux1[3][0],matrizEseInv_aux1[3][1]);
                            onTick(1000);
                        }
                        break;
                    case 3:
                        ese.setCuadritosOcupaEle(0,5,0,4,1,4,1,3);
                        final int matrizEse_aux[][] = ese.getCuadritosOcupa();
                        if(tetris.estanCuadritosVacios(matrizEse_aux[0][0],matrizEse_aux[0][1],matrizEse_aux[1][0],matrizEse_aux[1][1],matrizEse_aux[2][0],matrizEse_aux[2][1],matrizEse_aux[3][0],matrizEse_aux[3][1])==true){
                            int matrizEse_aux1[][] = ese.getCuadritosOcupa();
                            tetris.ocupaCuadritos(matrizEse_aux1[0][0],matrizEse_aux1[0][1],matrizEse_aux1[1][0],matrizEse_aux1[1][1],matrizEse_aux1[2][0],matrizEse_aux1[2][1],matrizEse_aux1[3][0],matrizEse_aux1[3][1]);
                            onTick(1000);
                        }
                        break;
                    case 4:
                        cuadrado.setCuadritosOcupaEle(0,4,0,5,1,4,1,5);
                        final int matrizCuadrado_aux[][] = cuadrado.getCuadritosOcupa();
                        if(tetris.estanCuadritosVacios(matrizCuadrado_aux[0][0],matrizCuadrado_aux[0][1],matrizCuadrado_aux[1][0],matrizCuadrado_aux[1][1],matrizCuadrado_aux[2][0],matrizCuadrado_aux[2][1],matrizCuadrado_aux[3][0],matrizCuadrado_aux[3][1])==true){
                            int matrizCuadrado_aux1[][] = cuadrado.getCuadritosOcupa();
                            tetris.ocupaCuadritos(matrizCuadrado_aux1[0][0],matrizCuadrado_aux1[0][1],matrizCuadrado_aux1[1][0],matrizCuadrado_aux1[1][1],matrizCuadrado_aux1[2][0],matrizCuadrado_aux1[2][1],matrizCuadrado_aux1[3][0],matrizCuadrado_aux1[3][1]);
                            onTick(1000);
                        }
                        break;
                    case 5:
                        ele.setCuadritosOcupaEle(0,5,1,5,2,5,2,6);
                        final int matrizEle_aux[][] = ele.getCuadritosOcupa();
                        if(tetris.estanCuadritosVacios(matrizEle_aux[0][0],matrizEle_aux[0][1],matrizEle_aux[1][0],matrizEle_aux[1][1],matrizEle_aux[2][0],matrizEle_aux[2][1],matrizEle_aux[3][0],matrizEle_aux[3][1])==true){
                            int matrizEle_aux2[][] = ele.getCuadritosOcupa();
                            tetris.ocupaCuadritos(matrizEle_aux2[0][0],matrizEle_aux2[0][1],matrizEle_aux2[1][0],matrizEle_aux2[1][1],matrizEle_aux2[2][0],matrizEle_aux2[2][1],matrizEle_aux2[3][0],matrizEle_aux2[3][1]);
                            onTick(1000);
                        }
                        break;
                    case 6:
                        ele_invertida.setCuadritosOcupaEle(0,4,1,4,2,4,2,3);
                        final int matrizEleInv_aux[][] = ele_invertida.getCuadritosOcupa();
                        if(tetris.estanCuadritosVacios(matrizEleInv_aux[0][0],matrizEleInv_aux[0][1],matrizEleInv_aux[1][0],matrizEleInv_aux[1][1],matrizEleInv_aux[2][0],matrizEleInv_aux[2][1],matrizEleInv_aux[3][0],matrizEleInv_aux[3][1])==true){
                            int matrizEleInv_aux1[][] = ele_invertida.getCuadritosOcupa();
                            tetris.ocupaCuadritos(matrizEleInv_aux1[0][0],matrizEleInv_aux1[0][1],matrizEleInv_aux1[1][0],matrizEleInv_aux1[1][1],matrizEleInv_aux1[2][0],matrizEleInv_aux1[2][1],matrizEleInv_aux1[3][0],matrizEleInv_aux1[3][1]);
                            onTick(1000);
                        }
                        break;
                    case 7:
                        te.setCuadritosOcupaEle(0,4,0,5,0,6,1,5);
                        final int matrizTe_aux[][] = te.getCuadritosOcupa();
                        if(tetris.estanCuadritosVacios(matrizTe_aux[0][0],matrizTe_aux[0][1],matrizTe_aux[1][0],matrizTe_aux[1][1],matrizTe_aux[2][0],matrizTe_aux[2][1],matrizTe_aux[3][0],matrizTe_aux[3][1])==true){
                            int matrizTe_aux1[][] = te.getCuadritosOcupa();
                            tetris.ocupaCuadritos(matrizTe_aux1[0][0],matrizTe_aux1[0][1],matrizTe_aux1[1][0],matrizTe_aux1[1][1],matrizTe_aux1[2][0],matrizTe_aux1[2][1],matrizTe_aux1[3][0],matrizTe_aux1[3][1]);
                            onTick(1000);
                        }
                        break;
                }
            }
        };
        bajaFichas.start();
    }


    public void mueveLeft(View view) {
        Button button_left = view.findViewById(R.id.left_button);
        switch(randomNum_mueve){
            case 1:
                int [][] cuadritosOcupa_aux1 = palito.getCuadritosOcupa();
                tetris.desocupaCuadritos(cuadritosOcupa_aux1[0][0],cuadritosOcupa_aux1[0][1], cuadritosOcupa_aux1[1][0],cuadritosOcupa_aux1[1][1], cuadritosOcupa_aux1[2][0],cuadritosOcupa_aux1[2][1], cuadritosOcupa_aux1[3][0],cuadritosOcupa_aux1[3][1]);
                palito.mueveIzquierda();
                cuadritosOcupa_aux1=palito.getCuadritosOcupa();
                tetris.ocupaCuadritos(cuadritosOcupa_aux1[0][0],cuadritosOcupa_aux1[0][1], cuadritosOcupa_aux1[1][0],cuadritosOcupa_aux1[1][1], cuadritosOcupa_aux1[2][0],cuadritosOcupa_aux1[2][1], cuadritosOcupa_aux1[3][0],cuadritosOcupa_aux1[3][1]);
                break;

            case 2:
                int [][] cuadritosOcupa_aux2 = ese_invertida.getCuadritosOcupa();
                tetris.desocupaCuadritos(cuadritosOcupa_aux2[0][0],cuadritosOcupa_aux2[0][1], cuadritosOcupa_aux2[1][0],cuadritosOcupa_aux2[1][1], cuadritosOcupa_aux2[2][0],cuadritosOcupa_aux2[2][1], cuadritosOcupa_aux2[3][0],cuadritosOcupa_aux2[3][1]);
                ese_invertida.mueveIzquierda();
                cuadritosOcupa_aux2=ese_invertida.getCuadritosOcupa();
                tetris.ocupaCuadritos(cuadritosOcupa_aux2[0][0],cuadritosOcupa_aux2[0][1], cuadritosOcupa_aux2[1][0],cuadritosOcupa_aux2[1][1], cuadritosOcupa_aux2[2][0],cuadritosOcupa_aux2[2][1], cuadritosOcupa_aux2[3][0],cuadritosOcupa_aux2[3][1]);
                break;

            case 3:
                int [][] cuadritosOcupa_aux3 = ese.getCuadritosOcupa();
                tetris.desocupaCuadritos(cuadritosOcupa_aux3[0][0],cuadritosOcupa_aux3[0][1], cuadritosOcupa_aux3[1][0],cuadritosOcupa_aux3[1][1], cuadritosOcupa_aux3[2][0],cuadritosOcupa_aux3[2][1], cuadritosOcupa_aux3[3][0],cuadritosOcupa_aux3[3][1]);
                ese.mueveIzquierda();
                cuadritosOcupa_aux3=ese.getCuadritosOcupa();
                tetris.ocupaCuadritos(cuadritosOcupa_aux3[0][0],cuadritosOcupa_aux3[0][1], cuadritosOcupa_aux3[1][0],cuadritosOcupa_aux3[1][1], cuadritosOcupa_aux3[2][0],cuadritosOcupa_aux3[2][1], cuadritosOcupa_aux3[3][0],cuadritosOcupa_aux3[3][1]);
                break;
            case 4:
                int [][] cuadritosOcupa_aux4 = cuadrado.getCuadritosOcupa();
                tetris.desocupaCuadritos(cuadritosOcupa_aux4[0][0],cuadritosOcupa_aux4[0][1], cuadritosOcupa_aux4[1][0],cuadritosOcupa_aux4[1][1], cuadritosOcupa_aux4[2][0],cuadritosOcupa_aux4[2][1], cuadritosOcupa_aux4[3][0],cuadritosOcupa_aux4[3][1]);
                cuadrado.mueveIzquierda();
                cuadritosOcupa_aux4=cuadrado.getCuadritosOcupa();
                tetris.ocupaCuadritos(cuadritosOcupa_aux4[0][0],cuadritosOcupa_aux4[0][1], cuadritosOcupa_aux4[1][0],cuadritosOcupa_aux4[1][1], cuadritosOcupa_aux4[2][0],cuadritosOcupa_aux4[2][1], cuadritosOcupa_aux4[3][0],cuadritosOcupa_aux4[3][1]);
                break;

            case 5:
                int [][] cuadritosOcupa_aux5 = ele.getCuadritosOcupa();
                tetris.desocupaCuadritos(cuadritosOcupa_aux5[0][0],cuadritosOcupa_aux5[0][1], cuadritosOcupa_aux5[1][0],cuadritosOcupa_aux5[1][1], cuadritosOcupa_aux5[2][0],cuadritosOcupa_aux5[2][1], cuadritosOcupa_aux5[3][0],cuadritosOcupa_aux5[3][1]);
                ele.mueveIzquierda();
                cuadritosOcupa_aux5=ele.getCuadritosOcupa();
                tetris.ocupaCuadritos(cuadritosOcupa_aux5[0][0],cuadritosOcupa_aux5[0][1], cuadritosOcupa_aux5[1][0],cuadritosOcupa_aux5[1][1], cuadritosOcupa_aux5[2][0],cuadritosOcupa_aux5[2][1], cuadritosOcupa_aux5[3][0],cuadritosOcupa_aux5[3][1]);
                break;
            case 6:
                int [][] cuadritosOcupa_aux6 = ele_invertida.getCuadritosOcupa();
                tetris.desocupaCuadritos(cuadritosOcupa_aux6[0][0],cuadritosOcupa_aux6[0][1], cuadritosOcupa_aux6[1][0],cuadritosOcupa_aux6[1][1], cuadritosOcupa_aux6[2][0],cuadritosOcupa_aux6[2][1], cuadritosOcupa_aux6[3][0],cuadritosOcupa_aux6[3][1]);
                ele_invertida.mueveIzquierda();
                cuadritosOcupa_aux6=ele_invertida.getCuadritosOcupa();
                tetris.ocupaCuadritos(cuadritosOcupa_aux6[0][0],cuadritosOcupa_aux6[0][1], cuadritosOcupa_aux6[1][0],cuadritosOcupa_aux6[1][1], cuadritosOcupa_aux6[2][0],cuadritosOcupa_aux6[2][1], cuadritosOcupa_aux6[3][0],cuadritosOcupa_aux6[3][1]);
                break;
            case 7:
                int [][] cuadritosOcupa_aux7 = te.getCuadritosOcupa();
                tetris.desocupaCuadritos(cuadritosOcupa_aux7[0][0],cuadritosOcupa_aux7[0][1], cuadritosOcupa_aux7[1][0],cuadritosOcupa_aux7[1][1], cuadritosOcupa_aux7[2][0],cuadritosOcupa_aux7[2][1], cuadritosOcupa_aux7[3][0],cuadritosOcupa_aux7[3][1]);
                te.mueveIzquierda();
                cuadritosOcupa_aux7=te.getCuadritosOcupa();
                tetris.ocupaCuadritos(cuadritosOcupa_aux7[0][0],cuadritosOcupa_aux7[0][1], cuadritosOcupa_aux7[1][0],cuadritosOcupa_aux7[1][1], cuadritosOcupa_aux7[2][0],cuadritosOcupa_aux7[2][1], cuadritosOcupa_aux7[3][0],cuadritosOcupa_aux7[3][1]);
                break;
        }


    }

    public void mueveRight(View view){
        Button button_left = view.findViewById(R.id.right_button);
        switch(randomNum_mueve){
            case 1:
                int [][] cuadritosOcupa_aux1 = palito.getCuadritosOcupa();
                tetris.desocupaCuadritos(cuadritosOcupa_aux1[0][0],cuadritosOcupa_aux1[0][1], cuadritosOcupa_aux1[1][0],cuadritosOcupa_aux1[1][1], cuadritosOcupa_aux1[2][0],cuadritosOcupa_aux1[2][1], cuadritosOcupa_aux1[3][0],cuadritosOcupa_aux1[3][1]);
                palito.mueveDerecha();
                cuadritosOcupa_aux1=palito.getCuadritosOcupa();
                tetris.ocupaCuadritos(cuadritosOcupa_aux1[0][0],cuadritosOcupa_aux1[0][1], cuadritosOcupa_aux1[1][0],cuadritosOcupa_aux1[1][1], cuadritosOcupa_aux1[2][0],cuadritosOcupa_aux1[2][1], cuadritosOcupa_aux1[3][0],cuadritosOcupa_aux1[3][1]);
                break;

            case 2:
                int [][] cuadritosOcupa_aux2 = ese_invertida.getCuadritosOcupa();
                tetris.desocupaCuadritos(cuadritosOcupa_aux2[0][0],cuadritosOcupa_aux2[0][1], cuadritosOcupa_aux2[1][0],cuadritosOcupa_aux2[1][1], cuadritosOcupa_aux2[2][0],cuadritosOcupa_aux2[2][1], cuadritosOcupa_aux2[3][0],cuadritosOcupa_aux2[3][1]);
                ese_invertida.mueveDerecha();
                cuadritosOcupa_aux2=ese_invertida.getCuadritosOcupa();
                tetris.ocupaCuadritos(cuadritosOcupa_aux2[0][0],cuadritosOcupa_aux2[0][1], cuadritosOcupa_aux2[1][0],cuadritosOcupa_aux2[1][1], cuadritosOcupa_aux2[2][0],cuadritosOcupa_aux2[2][1], cuadritosOcupa_aux2[3][0],cuadritosOcupa_aux2[3][1]);
                break;

            case 3:
                int [][] cuadritosOcupa_aux3 = ese.getCuadritosOcupa();
                tetris.desocupaCuadritos(cuadritosOcupa_aux3[0][0],cuadritosOcupa_aux3[0][1], cuadritosOcupa_aux3[1][0],cuadritosOcupa_aux3[1][1], cuadritosOcupa_aux3[2][0],cuadritosOcupa_aux3[2][1], cuadritosOcupa_aux3[3][0],cuadritosOcupa_aux3[3][1]);
                ese.mueveDerecha();
                cuadritosOcupa_aux3=ese.getCuadritosOcupa();
                tetris.ocupaCuadritos(cuadritosOcupa_aux3[0][0],cuadritosOcupa_aux3[0][1], cuadritosOcupa_aux3[1][0],cuadritosOcupa_aux3[1][1], cuadritosOcupa_aux3[2][0],cuadritosOcupa_aux3[2][1], cuadritosOcupa_aux3[3][0],cuadritosOcupa_aux3[3][1]);
                break;
            case 4:
                int [][] cuadritosOcupa_aux4 = cuadrado.getCuadritosOcupa();
                tetris.desocupaCuadritos(cuadritosOcupa_aux4[0][0],cuadritosOcupa_aux4[0][1], cuadritosOcupa_aux4[1][0],cuadritosOcupa_aux4[1][1], cuadritosOcupa_aux4[2][0],cuadritosOcupa_aux4[2][1], cuadritosOcupa_aux4[3][0],cuadritosOcupa_aux4[3][1]);
                cuadrado.mueveDerecha();
                cuadritosOcupa_aux4=cuadrado.getCuadritosOcupa();
                tetris.ocupaCuadritos(cuadritosOcupa_aux4[0][0],cuadritosOcupa_aux4[0][1], cuadritosOcupa_aux4[1][0],cuadritosOcupa_aux4[1][1], cuadritosOcupa_aux4[2][0],cuadritosOcupa_aux4[2][1], cuadritosOcupa_aux4[3][0],cuadritosOcupa_aux4[3][1]);
                break;

            case 5:
                int [][] cuadritosOcupa_aux5 = ele.getCuadritosOcupa();
                tetris.desocupaCuadritos(cuadritosOcupa_aux5[0][0],cuadritosOcupa_aux5[0][1], cuadritosOcupa_aux5[1][0],cuadritosOcupa_aux5[1][1], cuadritosOcupa_aux5[2][0],cuadritosOcupa_aux5[2][1], cuadritosOcupa_aux5[3][0],cuadritosOcupa_aux5[3][1]);
                ele.mueveDerecha();
                cuadritosOcupa_aux5=ele.getCuadritosOcupa();
                tetris.ocupaCuadritos(cuadritosOcupa_aux5[0][0],cuadritosOcupa_aux5[0][1], cuadritosOcupa_aux5[1][0],cuadritosOcupa_aux5[1][1], cuadritosOcupa_aux5[2][0],cuadritosOcupa_aux5[2][1], cuadritosOcupa_aux5[3][0],cuadritosOcupa_aux5[3][1]);
                break;
            case 6:
                int [][] cuadritosOcupa_aux6 = ele_invertida.getCuadritosOcupa();
                tetris.desocupaCuadritos(cuadritosOcupa_aux6[0][0],cuadritosOcupa_aux6[0][1], cuadritosOcupa_aux6[1][0],cuadritosOcupa_aux6[1][1], cuadritosOcupa_aux6[2][0],cuadritosOcupa_aux6[2][1], cuadritosOcupa_aux6[3][0],cuadritosOcupa_aux6[3][1]);
                ele_invertida.mueveDerecha();
                cuadritosOcupa_aux6=ele_invertida.getCuadritosOcupa();
                tetris.ocupaCuadritos(cuadritosOcupa_aux6[0][0],cuadritosOcupa_aux6[0][1], cuadritosOcupa_aux6[1][0],cuadritosOcupa_aux6[1][1], cuadritosOcupa_aux6[2][0],cuadritosOcupa_aux6[2][1], cuadritosOcupa_aux6[3][0],cuadritosOcupa_aux6[3][1]);
                break;
            case 7:
                int [][] cuadritosOcupa_aux7 = te.getCuadritosOcupa();
                tetris.desocupaCuadritos(cuadritosOcupa_aux7[0][0],cuadritosOcupa_aux7[0][1], cuadritosOcupa_aux7[1][0],cuadritosOcupa_aux7[1][1], cuadritosOcupa_aux7[2][0],cuadritosOcupa_aux7[2][1], cuadritosOcupa_aux7[3][0],cuadritosOcupa_aux7[3][1]);
                te.mueveDerecha();
                cuadritosOcupa_aux7=te.getCuadritosOcupa();
                tetris.ocupaCuadritos(cuadritosOcupa_aux7[0][0],cuadritosOcupa_aux7[0][1], cuadritosOcupa_aux7[1][0],cuadritosOcupa_aux7[1][1], cuadritosOcupa_aux7[2][0],cuadritosOcupa_aux7[2][1], cuadritosOcupa_aux7[3][0],cuadritosOcupa_aux7[3][1]);
                break;
        }
    }

    public void dibujaEnPantalla(int opcion,int fila, int columna){
        switch(fila){
            case 0:
                switch(columna){
                    case 0:
                        ImageView imageViewEle0_0 = findViewById(R.id.imageEleView0_0);
                        if(opcion==1){
                            imageViewEle0_0.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle0_0.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 1:
                        ImageView imageViewEle0_1 = findViewById(R.id.imageEleView0_1);
                        if(opcion==1){
                            imageViewEle0_1.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle0_1.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 2:
                        ImageView imageViewEle0_2 = findViewById(R.id.imageEleView0_2);
                        if(opcion==1){
                            imageViewEle0_2.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle0_2.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 3:
                        ImageView imageViewEle0_3 = findViewById(R.id.imageEleView0_3);
                        if(opcion==1){
                            imageViewEle0_3.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle0_3.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 4:
                        ImageView imageViewEle0_4 = findViewById(R.id.imageEleView0_4);
                        if(opcion==1){
                            imageViewEle0_4.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle0_4.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 5:
                        ImageView imageViewEle0_5 = findViewById(R.id.imageEleView0_5);
                        if(opcion==1){
                            imageViewEle0_5.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle0_5.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 6:
                        ImageView imageViewEle0_6 = findViewById(R.id.imageEleView0_6);
                        if(opcion==1){
                            imageViewEle0_6.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle0_6.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 7:
                        ImageView imageViewEle0_7 = findViewById(R.id.imageEleView0_7);
                        if(opcion==1){
                            imageViewEle0_7.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle0_7.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 8:
                        ImageView imageViewEle0_8 = findViewById(R.id.imageEleView0_8);
                        if(opcion==1){
                            imageViewEle0_8.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle0_8.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 9:
                        ImageView imageViewEle0_9 = findViewById(R.id.imageEleView0_9);
                        if(opcion==1){
                            imageViewEle0_9.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle0_9.setVisibility(View.INVISIBLE);
                        }
                        break;
                }

                break;
            case 1:
                switch(columna){
                    case 0:
                        ImageView imageViewEle1_0 = findViewById(R.id.imageEleView1_0);
                        if(opcion==1){
                            imageViewEle1_0.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle1_0.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 1:
                        ImageView imageViewEle1_1 = findViewById(R.id.imageEleView1_1);
                        if(opcion==1){
                            imageViewEle1_1.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle1_1.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 2:
                        ImageView imageViewEle1_2 = findViewById(R.id.imageEleView1_2);
                        if(opcion==1){
                            imageViewEle1_2.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle1_2.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 3:
                        ImageView imageViewEle1_3 = findViewById(R.id.imageEleView1_3);
                        if(opcion==1){
                            imageViewEle1_3.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle1_3.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 4:
                        ImageView imageViewEle1_4 = findViewById(R.id.imageEleView1_4);
                        if(opcion==1){
                            imageViewEle1_4.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle1_4.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 5:
                        ImageView imageViewEle1_5 = findViewById(R.id.imageEleView1_5);
                        if(opcion==1){
                            imageViewEle1_5.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle1_5.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 6:
                        ImageView imageViewEle1_6 = findViewById(R.id.imageEleView1_6);
                        if(opcion==1){
                            imageViewEle1_6.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle1_6.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 7:
                        ImageView imageViewEle1_7 = findViewById(R.id.imageEleView1_7);
                        if(opcion==1){
                            imageViewEle1_7.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle1_7.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 8:
                        ImageView imageViewEle1_8 = findViewById(R.id.imageEleView1_8);
                        if(opcion==1){
                            imageViewEle1_8.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle1_8.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 9:
                        ImageView imageViewEle1_9 = findViewById(R.id.imageEleView1_9);
                        if(opcion==1){
                            imageViewEle1_9.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle1_9.setVisibility(View.INVISIBLE);
                        }
                        break;
                }

                break;
            case 2:
                switch(columna){
                    case 0:
                        ImageView imageViewEle2_0 = findViewById(R.id.imageEleView2_0);
                        if(opcion==1){
                            imageViewEle2_0.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle2_0.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 1:
                        ImageView imageViewEle2_1 = findViewById(R.id.imageEleView2_1);
                        if(opcion==1){
                            imageViewEle2_1.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle2_1.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 2:
                        ImageView imageViewEle2_2 = findViewById(R.id.imageEleView2_2);
                        if(opcion==1){
                            imageViewEle2_2.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle2_2.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 3:
                        ImageView imageViewEle2_3 = findViewById(R.id.imageEleView2_3);
                        if(opcion==1){
                            imageViewEle2_3.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle2_3.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 4:
                        ImageView imageViewEle2_4 = findViewById(R.id.imageEleView2_4);
                        if(opcion==1){
                            imageViewEle2_4.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle2_4.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 5:
                        ImageView imageViewEle2_5 = findViewById(R.id.imageEleView2_5);
                        if(opcion==1){
                            imageViewEle2_5.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle2_5.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 6:
                        ImageView imageViewEle2_6 = findViewById(R.id.imageEleView2_6);
                        if(opcion==1){
                            imageViewEle2_6.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle2_6.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 7:
                        ImageView imageViewEle2_7 = findViewById(R.id.imageEleView2_7);
                        if(opcion==1){
                            imageViewEle2_7.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle2_7.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 8:
                        ImageView imageViewEle2_8 = findViewById(R.id.imageEleView2_8);
                        if(opcion==1){
                            imageViewEle2_8.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle2_8.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 9:
                        ImageView imageViewEle2_9 = findViewById(R.id.imageEleView2_9);
                        if(opcion==1){
                            imageViewEle2_9.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle2_9.setVisibility(View.INVISIBLE);
                        }
                        break;
                }

                break;
            case 3:
                switch(columna){
                    case 0:
                        ImageView imageViewEle3_0 = findViewById(R.id.imageEleView3_0);
                        if(opcion==1){
                            imageViewEle3_0.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle3_0.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 1:
                        ImageView imageViewEle3_1 = findViewById(R.id.imageEleView3_1);
                        if(opcion==1){
                            imageViewEle3_1.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle3_1.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 2:
                        ImageView imageViewEle3_2 = findViewById(R.id.imageEleView3_2);
                        if(opcion==1){
                            imageViewEle3_2.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle3_2.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 3:
                        ImageView imageViewEle3_3 = findViewById(R.id.imageEleView3_3);
                        if(opcion==1){
                            imageViewEle3_3.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle3_3.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 4:
                        ImageView imageViewEle3_4 = findViewById(R.id.imageEleView3_4);
                        if(opcion==1){
                            imageViewEle3_4.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle3_4.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 5:
                        ImageView imageViewEle3_5 = findViewById(R.id.imageEleView3_5);
                        if(opcion==1){
                            imageViewEle3_5.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle3_5.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 6:
                        ImageView imageViewEle3_6 = findViewById(R.id.imageEleView3_6);
                        if(opcion==1){
                            imageViewEle3_6.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle3_6.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 7:
                        ImageView imageViewEle3_7 = findViewById(R.id.imageEleView3_7);
                        if(opcion==1){
                            imageViewEle3_7.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle3_7.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 8:
                        ImageView imageViewEle3_8 = findViewById(R.id.imageEleView3_8);
                        if(opcion==1){
                            imageViewEle3_8.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle3_8.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 9:
                        ImageView imageViewEle3_9 = findViewById(R.id.imageEleView3_9);
                        if(opcion==1){
                            imageViewEle3_9.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle3_9.setVisibility(View.INVISIBLE);
                        }
                        break;
                }

                break;
            case 4:
                switch(columna){
                    case 0:
                        ImageView imageViewEle4_0 = findViewById(R.id.imageEleView4_0);
                        if(opcion==1){
                            imageViewEle4_0.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle4_0.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 1:
                        ImageView imageViewEle4_1 = findViewById(R.id.imageEleView4_1);
                        if(opcion==1){
                            imageViewEle4_1.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle4_1.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 2:
                        ImageView imageViewEle4_2 = findViewById(R.id.imageEleView4_2);
                        if(opcion==1){
                            imageViewEle4_2.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle4_2.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 3:
                        ImageView imageViewEle4_3 = findViewById(R.id.imageEleView4_3);
                        if(opcion==1){
                            imageViewEle4_3.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle4_3.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 4:
                        ImageView imageViewEle4_4 = findViewById(R.id.imageEleView4_4);
                        if(opcion==1){
                            imageViewEle4_4.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle4_4.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 5:
                        ImageView imageViewEle4_5 = findViewById(R.id.imageEleView4_5);
                        if(opcion==1){
                            imageViewEle4_5.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle4_5.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 6:
                        ImageView imageViewEle4_6 = findViewById(R.id.imageEleView4_6);
                        if(opcion==1){
                            imageViewEle4_6.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle4_6.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 7:
                        ImageView imageViewEle4_7 = findViewById(R.id.imageEleView4_7);
                        if(opcion==1){
                            imageViewEle4_7.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle4_7.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 8:
                        ImageView imageViewEle4_8 = findViewById(R.id.imageEleView4_8);
                        if(opcion==1){
                            imageViewEle4_8.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle4_8.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 9:
                        ImageView imageViewEle4_9 = findViewById(R.id.imageEleView4_9);
                        if(opcion==1){
                            imageViewEle4_9.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle4_9.setVisibility(View.INVISIBLE);
                        }
                        break;
                }

                break;
            case 5:
                switch(columna){
                    case 0:
                        ImageView imageViewEle5_0 = findViewById(R.id.imageEleView5_0);
                        if(opcion==1){
                            imageViewEle5_0.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle5_0.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 1:
                        ImageView imageViewEle5_1 = findViewById(R.id.imageEleView5_1);
                        if(opcion==1){
                            imageViewEle5_1.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle5_1.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 2:
                        ImageView imageViewEle5_2 = findViewById(R.id.imageEleView5_2);
                        if(opcion==1){
                            imageViewEle5_2.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle5_2.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 3:
                        ImageView imageViewEle5_3 = findViewById(R.id.imageEleView5_3);
                        if(opcion==1){
                            imageViewEle5_3.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle5_3.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 4:
                        ImageView imageViewEle5_4 = findViewById(R.id.imageEleView5_4);
                        if(opcion==1){
                            imageViewEle5_4.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle5_4.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 5:
                        ImageView imageViewEle5_5 = findViewById(R.id.imageEleView5_5);
                        if(opcion==1){
                            imageViewEle5_5.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle5_5.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 6:
                        ImageView imageViewEle5_6 = findViewById(R.id.imageEleView5_6);
                        if(opcion==1){
                            imageViewEle5_6.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle5_6.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 7:
                        ImageView imageViewEle5_7 = findViewById(R.id.imageEleView5_7);
                        if(opcion==1){
                            imageViewEle5_7.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle5_7.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 8:
                        ImageView imageViewEle5_8 = findViewById(R.id.imageEleView5_8);
                        if(opcion==1){
                            imageViewEle5_8.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle5_8.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 9:
                        ImageView imageViewEle5_9 = findViewById(R.id.imageEleView5_9);
                        if(opcion==1){
                            imageViewEle5_9.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle5_9.setVisibility(View.INVISIBLE);
                        }
                        break;
                }

                break;
            case 6:
                switch(columna){
                    case 0:
                        ImageView imageViewEle6_0 = findViewById(R.id.imageEleView6_0);
                        if(opcion==1){
                            imageViewEle6_0.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle6_0.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 1:
                        ImageView imageViewEle6_1 = findViewById(R.id.imageEleView6_1);
                        if(opcion==1){
                            imageViewEle6_1.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle6_1.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 2:
                        ImageView imageViewEle6_2 = findViewById(R.id.imageEleView6_2);
                        if(opcion==1){
                            imageViewEle6_2.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle6_2.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 3:
                        ImageView imageViewEle6_3 = findViewById(R.id.imageEleView6_3);
                        if(opcion==1){
                            imageViewEle6_3.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle6_3.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 4:
                        ImageView imageViewEle6_4 = findViewById(R.id.imageEleView6_4);
                        if(opcion==1){
                            imageViewEle6_4.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle6_4.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 5:
                        ImageView imageViewEle6_5 = findViewById(R.id.imageEleView6_5);
                        if(opcion==1){
                            imageViewEle6_5.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle6_5.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 6:
                        ImageView imageViewEle6_6 = findViewById(R.id.imageEleView6_6);
                        if(opcion==1){
                            imageViewEle6_6.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle6_6.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 7:
                        ImageView imageViewEle6_7 = findViewById(R.id.imageEleView6_7);
                        if(opcion==1){
                            imageViewEle6_7.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle6_7.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 8:
                        ImageView imageViewEle6_8 = findViewById(R.id.imageEleView6_8);
                        if(opcion==1){
                            imageViewEle6_8.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle6_8.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 9:
                        ImageView imageViewEle6_9 = findViewById(R.id.imageEleView6_9);
                        if(opcion==1){
                            imageViewEle6_9.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle6_9.setVisibility(View.INVISIBLE);
                        }
                        break;
                }

                break;
            case 7:
                switch(columna){
                    case 0:
                        ImageView imageViewEle7_0 = findViewById(R.id.imageEleView7_0);
                        if(opcion==1){
                            imageViewEle7_0.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle7_0.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 1:
                        ImageView imageViewEle7_1 = findViewById(R.id.imageEleView7_1);
                        if(opcion==1){
                            imageViewEle7_1.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle7_1.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 2:
                        ImageView imageViewEle7_2 = findViewById(R.id.imageEleView7_2);
                        if(opcion==1){
                            imageViewEle7_2.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle7_2.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 3:
                        ImageView imageViewEle7_3 = findViewById(R.id.imageEleView7_3);
                        if(opcion==1){
                            imageViewEle7_3.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle7_3.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 4:
                        ImageView imageViewEle7_4 = findViewById(R.id.imageEleView7_4);
                        if(opcion==1){
                            imageViewEle7_4.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle7_4.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 5:
                        ImageView imageViewEle7_5 = findViewById(R.id.imageEleView7_5);
                        if(opcion==1){
                            imageViewEle7_5.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle7_5.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 6:
                        ImageView imageViewEle7_6 = findViewById(R.id.imageEleView7_6);
                        if(opcion==1){
                            imageViewEle7_6.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle7_6.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 7:
                        ImageView imageViewEle7_7 = findViewById(R.id.imageEleView7_7);
                        if(opcion==1){
                            imageViewEle7_7.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle7_7.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 8:
                        ImageView imageViewEle7_8 = findViewById(R.id.imageEleView7_8);
                        if(opcion==1){
                            imageViewEle7_8.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle7_8.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 9:
                        ImageView imageViewEle7_9 = findViewById(R.id.imageEleView7_9);
                        if(opcion==1){
                            imageViewEle7_9.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle7_9.setVisibility(View.INVISIBLE);
                        }
                        break;
                }

                break;
            case 8:
                switch(columna){
                    case 0:
                        ImageView imageViewEle8_0 = findViewById(R.id.imageEleView8_0);
                        if(opcion==1){
                            imageViewEle8_0.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle8_0.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 1:
                        ImageView imageViewEle8_1 = findViewById(R.id.imageEleView8_1);
                        if(opcion==1){
                            imageViewEle8_1.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle8_1.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 2:
                        ImageView imageViewEle8_2 = findViewById(R.id.imageEleView8_2);
                        if(opcion==1){
                            imageViewEle8_2.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle8_2.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 3:
                        ImageView imageViewEle8_3 = findViewById(R.id.imageEleView8_3);
                        if(opcion==1){
                            imageViewEle8_3.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle8_3.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 4:
                        ImageView imageViewEle8_4 = findViewById(R.id.imageEleView8_4);
                        if(opcion==1){
                            imageViewEle8_4.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle8_4.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 5:
                        ImageView imageViewEle8_5 = findViewById(R.id.imageEleView8_5);
                        if(opcion==1){
                            imageViewEle8_5.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle8_5.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 6:
                        ImageView imageViewEle8_6 = findViewById(R.id.imageEleView8_6);
                        if(opcion==1){
                            imageViewEle8_6.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle8_6.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 7:
                        ImageView imageViewEle8_7 = findViewById(R.id.imageEleView8_7);
                        if(opcion==1){
                            imageViewEle8_7.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle8_7.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 8:
                        ImageView imageViewEle8_8 = findViewById(R.id.imageEleView8_8);
                        if(opcion==1){
                            imageViewEle8_8.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle8_8.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 9:
                        ImageView imageViewEle8_9 = findViewById(R.id.imageEleView8_9);
                        if(opcion==1){
                            imageViewEle8_9.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle8_9.setVisibility(View.INVISIBLE);
                        }
                        break;
                }

                break;
            case 9:
                switch(columna){
                    case 0:
                        ImageView imageViewEle9_0 = findViewById(R.id.imageEleView9_0);
                        if(opcion==1){
                            imageViewEle9_0.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle9_0.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 1:
                        ImageView imageViewEle9_1 = findViewById(R.id.imageEleView9_1);
                        if(opcion==1){
                            imageViewEle9_1.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle9_1.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 2:
                        ImageView imageViewEle9_2 = findViewById(R.id.imageEleView9_2);
                        if(opcion==1){
                            imageViewEle9_2.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle9_2.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 3:
                        ImageView imageViewEle9_3 = findViewById(R.id.imageEleView9_3);
                        if(opcion==1){
                            imageViewEle9_3.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle9_3.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 4:
                        ImageView imageViewEle9_4 = findViewById(R.id.imageEleView9_4);
                        if(opcion==1){
                            imageViewEle9_4.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle9_4.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 5:
                        ImageView imageViewEle9_5 = findViewById(R.id.imageEleView9_5);
                        if(opcion==1){
                            imageViewEle9_5.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle9_5.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 6:
                        ImageView imageViewEle9_6 = findViewById(R.id.imageEleView9_6);
                        if(opcion==1){
                            imageViewEle9_6.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle9_6.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 7:
                        ImageView imageViewEle9_7 = findViewById(R.id.imageEleView9_7);
                        if(opcion==1){
                            imageViewEle9_7.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle9_7.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 8:
                        ImageView imageViewEle9_8 = findViewById(R.id.imageEleView9_8);
                        if(opcion==1){
                            imageViewEle9_8.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle9_8.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 9:
                        ImageView imageViewEle9_9 = findViewById(R.id.imageEleView9_9);
                        if(opcion==1){
                            imageViewEle9_9.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle9_9.setVisibility(View.INVISIBLE);
                        }
                        break;
                }
                break;
            case 10:
                switch(columna){
                    case 0:
                        ImageView imageViewEle10_0 = findViewById(R.id.imageEleView10_0);
                        if(opcion==1){
                            imageViewEle10_0.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle10_0.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 1:
                        ImageView imageViewEle10_1 = findViewById(R.id.imageEleView10_1);
                        if(opcion==1){
                            imageViewEle10_1.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle10_1.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 2:
                        ImageView imageViewEle10_2 = findViewById(R.id.imageEleView10_2);
                        if(opcion==1){
                            imageViewEle10_2.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle10_2.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 3:
                        ImageView imageViewEle10_3 = findViewById(R.id.imageEleView10_3);
                        if(opcion==1){
                            imageViewEle10_3.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle10_3.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 4:
                        ImageView imageViewEle10_4 = findViewById(R.id.imageEleView10_4);
                        if(opcion==1){
                            imageViewEle10_4.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle10_4.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 5:
                        ImageView imageViewEle10_5 = findViewById(R.id.imageEleView10_5);
                        if(opcion==1){
                            imageViewEle10_5.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle10_5.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 6:
                        ImageView imageViewEle10_6 = findViewById(R.id.imageEleView10_6);
                        if(opcion==1){
                            imageViewEle10_6.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle10_6.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 7:
                        ImageView imageViewEle10_7 = findViewById(R.id.imageEleView10_7);
                        if(opcion==1){
                            imageViewEle10_7.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle10_7.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 8:
                        ImageView imageViewEle10_8 = findViewById(R.id.imageEleView10_8);
                        if(opcion==1){
                            imageViewEle10_8.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle10_8.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 9:
                        ImageView imageViewEle10_9 = findViewById(R.id.imageEleView10_9);
                        if(opcion==1){
                            imageViewEle10_9.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle10_9.setVisibility(View.INVISIBLE);
                        }
                        break;
                }


                break;
            case 11:
                switch(columna){
                    case 0:
                        ImageView imageViewEle11_0 = findViewById(R.id.imageEleView11_0);
                        if(opcion==1){
                            imageViewEle11_0.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle11_0.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 1:
                        ImageView imageViewEle11_1 = findViewById(R.id.imageEleView11_1);
                        if(opcion==1){
                            imageViewEle11_1.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle11_1.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 2:
                        ImageView imageViewEle11_2 = findViewById(R.id.imageEleView11_2);
                        if(opcion==1){
                            imageViewEle11_2.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle11_2.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 3:
                        ImageView imageViewEle11_3 = findViewById(R.id.imageEleView11_3);
                        if(opcion==1){
                            imageViewEle11_3.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle11_3.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 4:
                        ImageView imageViewEle11_4 = findViewById(R.id.imageEleView11_4);
                        if(opcion==1){
                            imageViewEle11_4.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle11_4.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 5:
                        ImageView imageViewEle11_5 = findViewById(R.id.imageEleView11_5);
                        if(opcion==1){
                            imageViewEle11_5.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle11_5.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 6:
                        ImageView imageViewEle11_6 = findViewById(R.id.imageEleView11_6);
                        if(opcion==1){
                            imageViewEle11_6.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle11_6.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 7:
                        ImageView imageViewEle11_7 = findViewById(R.id.imageEleView11_7);
                        if(opcion==1){
                            imageViewEle11_7.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle11_7.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 8:
                        ImageView imageViewEle11_8 = findViewById(R.id.imageEleView11_8);
                        if(opcion==1){
                            imageViewEle11_8.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle11_8.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 9:
                        ImageView imageViewEle11_9 = findViewById(R.id.imageEleView11_9);
                        if(opcion==1){
                            imageViewEle11_9.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle11_9.setVisibility(View.INVISIBLE);
                        }
                        break;
                }

                break;
            case 12:
                switch(columna){
                    case 0:
                        ImageView imageViewEle12_0 = findViewById(R.id.imageEleView12_0);
                        if(opcion==1){
                            imageViewEle12_0.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle12_0.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 1:
                        ImageView imageViewEle12_1 = findViewById(R.id.imageEleView12_1);
                        if(opcion==1){
                            imageViewEle12_1.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle12_1.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 2:
                        ImageView imageViewEle12_2 = findViewById(R.id.imageEleView12_2);
                        if(opcion==1){
                            imageViewEle12_2.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle12_2.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 3:
                        ImageView imageViewEle12_3 = findViewById(R.id.imageEleView12_3);
                        if(opcion==1){
                            imageViewEle12_3.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle12_3.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 4:
                        ImageView imageViewEle12_4 = findViewById(R.id.imageEleView12_4);
                        if(opcion==1){
                            imageViewEle12_4.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle12_4.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 5:
                        ImageView imageViewEle12_5 = findViewById(R.id.imageEleView12_5);
                        if(opcion==1){
                            imageViewEle12_5.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle12_5.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 6:
                        ImageView imageViewEle12_6 = findViewById(R.id.imageEleView12_6);
                        if(opcion==1){
                            imageViewEle12_6.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle12_6.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 7:
                        ImageView imageViewEle12_7 = findViewById(R.id.imageEleView12_7);
                        if(opcion==1){
                            imageViewEle12_7.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle12_7.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 8:
                        ImageView imageViewEle12_8 = findViewById(R.id.imageEleView12_8);
                        if(opcion==1){
                            imageViewEle12_8.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle12_8.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 9:
                        ImageView imageViewEle12_9 = findViewById(R.id.imageEleView12_9);
                        if(opcion==1){
                            imageViewEle12_9.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle12_9.setVisibility(View.INVISIBLE);
                        }
                        break;
                }

                break;
            case 13:
                switch(columna){
                    case 0:
                        ImageView imageViewEle13_0 = findViewById(R.id.imageEleView13_0);
                        if(opcion==1){
                            imageViewEle13_0.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle13_0.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 1:
                        ImageView imageViewEle13_1 = findViewById(R.id.imageEleView13_1);
                        if(opcion==1){
                            imageViewEle13_1.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle13_1.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 2:
                        ImageView imageViewEle13_2 = findViewById(R.id.imageEleView13_2);
                        if(opcion==1){
                            imageViewEle13_2.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle13_2.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 3:
                        ImageView imageViewEle13_3 = findViewById(R.id.imageEleView13_3);
                        if(opcion==1){
                            imageViewEle13_3.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle13_3.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 4:
                        ImageView imageViewEle13_4 = findViewById(R.id.imageEleView13_4);
                        if(opcion==1){
                            imageViewEle13_4.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle13_4.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 5:
                        ImageView imageViewEle13_5 = findViewById(R.id.imageEleView13_5);
                        if(opcion==1){
                            imageViewEle13_5.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle13_5.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 6:
                        ImageView imageViewEle13_6 = findViewById(R.id.imageEleView13_6);
                        if(opcion==1){
                            imageViewEle13_6.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle13_6.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 7:
                        ImageView imageViewEle13_7 = findViewById(R.id.imageEleView13_7);
                        if(opcion==1){
                            imageViewEle13_7.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle13_7.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 8:
                        ImageView imageViewEle13_8 = findViewById(R.id.imageEleView13_8);
                        if(opcion==1){
                            imageViewEle13_8.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle13_8.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 9:
                        ImageView imageViewEle13_9 = findViewById(R.id.imageEleView13_9);
                        if(opcion==1){
                            imageViewEle13_9.setVisibility(View.VISIBLE);
                        }else{
                            imageViewEle13_9.setVisibility(View.INVISIBLE);
                        }
                        break;
                }
                break;
        }
    }

}




