package com.example.nelson.tetris;

import android.util.Log;

/**
 * Created by Nelson on 9/3/2018.
 */

public class Tetris {
    private int matrizTetris[][] = new int[14][10];
    private boolean perdio = false;

    public Tetris() {
        for (int i = 0; i<14; i++) {
            for (int j = 0; j<10; j++) {
                matrizTetris[i][j] = 0;
                //Log.d("Fila es:",String.valueOf(i));
                //Log.d("Columna es:",String.valueOf(j));
            }
        }
    }

    int[][] getMatrizTetris(){
        return matrizTetris;
    }

    protected void insertaFigura(Figura figura) {
        int tipoFigura = figura.getId();
        switch (tipoFigura) {
            case 1:
                if (estanCuadritosVacios(0, 7, 1, 7, 2, 7, 3, 7) == true) {
                    matrizTetris[0][7] = 1;
                    matrizTetris[1][7] = 1;
                    matrizTetris[2][7] = 1;
                    matrizTetris[3][8] = 1;
                }
                break;
            case 2:
                if (estanCuadritosVacios(0, 7, 0, 6, 1, 7, 1, 8) == true) {
                    matrizTetris[0][7] = 1;
                    matrizTetris[0][6] = 1;
                    matrizTetris[1][7] = 1;
                    matrizTetris[1][8] = 1;
                }
                break;
            case 3:
                if (estanCuadritosVacios(0, 7, 0, 8, 1, 7, 1, 6) == true) {
                    matrizTetris[0][7] = 1;
                    matrizTetris[0][8] = 1;
                    matrizTetris[1][7] = 1;
                    matrizTetris[1][6] = 1;
                }
                break;
            case 4:
                if (estanCuadritosVacios(0, 7, 0, 8, 1, 7, 1, 8) == true) {
                    matrizTetris[0][7] = 1;
                    matrizTetris[0][6] = 1;
                    matrizTetris[1][7] = 1;
                    matrizTetris[1][8] = 1;
                }
                break;
            case 5:
                if (estanCuadritosVacios(0, 7, 1, 7, 2, 7, 2, 8) == true) {
                    matrizTetris[0][7] = 1;
                    matrizTetris[1][7] = 1;
                    matrizTetris[2][7] = 1;
                    matrizTetris[2][8] = 1;
                }
                break;
            case 6:
                if (estanCuadritosVacios(0, 7, 1, 7, 2, 7, 2, 6) == true) {
                    matrizTetris[0][7] = 1;
                    matrizTetris[1][7] = 1;
                    matrizTetris[2][7] = 1;
                    matrizTetris[2][6] = 1;
                }
                break;
            case 7:
                if (estanCuadritosVacios(0, 7, 0, 6, 0, 8, 1, 7) == true) {
                    matrizTetris[0][7] = 1;
                    matrizTetris[0][6] = 1;
                    matrizTetris[0][8] = 1;
                    matrizTetris[1][7] = 1;
                }
                break;
        }
    }

    protected boolean perdioGame(){
        for(int i=0; i<10;i++){
            if(matrizTetris[0][i]==1){
                return true;
            }
        }
        return false;
    }


    protected boolean estanCuadritosVacios(int f1, int c1, int f2, int c2, int f3, int c3, int f4, int c4) {
        if(f1<14 && f2<14 && f3<14 || f4<14 && c1<10 && c2<10 && c3<10 && c4<10 ){
            if (matrizTetris[f1][c1] == 0 && matrizTetris[f2][c2] == 0 && matrizTetris[f3][c3] == 0 &&
                    matrizTetris[f4][c4] == 0) {
                return true;
            }
        }
        return false;
    }


    public void ocupaCuadritos(int f1, int c1, int f2, int c2, int f3, int c3, int f4, int c4) {
        matrizTetris[f1][c1] = 1;
        matrizTetris[f2][c2] = 1;
        matrizTetris[f3][c3] = 1;
        matrizTetris[f4][c4] = 1;
    }

    public void desocupaCuadritos(int f1, int c1, int f2, int c2, int f3, int c3, int f4, int c4) {
        matrizTetris[f1][c1] = 0;
        matrizTetris[f2][c2] = 0;
        matrizTetris[f3][c3] = 0;
        matrizTetris[f4][c4] = 0;
    }




    protected boolean puedeMoverFichaAbajo(Figura figura){
        switch (figura.getId()) {
            case 1:
                Palito palito = (Palito) figura; //downcast a figura
                int[][] ocupa_aux1 = palito.getCuadritosOcupa();
                //limpia cuadritos que estaban ocupados
                if (estanCuadritosVacios(ocupa_aux1[0][0] + 1, ocupa_aux1[0][1], ocupa_aux1[1][0] + 1, ocupa_aux1[1][1], ocupa_aux1[2][0] + 1, ocupa_aux1[2][1], ocupa_aux1[3][0] + 1, ocupa_aux1[3][1]) == true){
                    return true;
                }
                break;
            case 2:
                Ese_invertida ese_invertida = (Ese_invertida) figura; //downcast a figura
                int[][] ocupa_aux2 = ese_invertida.getCuadritosOcupa();
                //limpia cuadritos que estaban ocupados
                if (estanCuadritosVacios(ocupa_aux2[0][0] + 1, ocupa_aux2[0][1], ocupa_aux2[1][0] + 1, ocupa_aux2[1][1], ocupa_aux2[2][0] + 1, ocupa_aux2[2][1], ocupa_aux2[3][0] + 1, ocupa_aux2[3][1]) == true){
                    return true;
                }

                break;
            case 3:
                Ese ese = (Ese) figura; //downcast a figura
                int[][] ocupa_aux3 = ese.getCuadritosOcupa();
                //limpia cuadritos que estaban ocupados
                if (estanCuadritosVacios(ocupa_aux3[0][0] + 1, ocupa_aux3[0][1], ocupa_aux3[1][0] + 1, ocupa_aux3[1][1], ocupa_aux3[2][0] + 1, ocupa_aux3[2][1], ocupa_aux3[3][0] + 1, ocupa_aux3[3][1]) == true){
                    return true;
                }
                break;
            case 4:
                Cuadrado cuadrado = (Cuadrado) figura; //downcast a figura
                int[][] ocupa_aux4 = cuadrado.getCuadritosOcupa();
                //limpia cuadritos que estaban ocupados
                if (estanCuadritosVacios(ocupa_aux4[0][0] + 1, ocupa_aux4[0][1], ocupa_aux4[1][0] + 1, ocupa_aux4[1][1], ocupa_aux4[2][0] + 1, ocupa_aux4[2][1], ocupa_aux4[3][0] + 1, ocupa_aux4[3][1]) == true){
                    return true;
                }
                break;
            case 5:
                Ele ele = (Ele) figura; //downcast a figura
                int[][] ocupa_aux = ele.getCuadritosOcupa();
                //limpia cuadritos que estaban ocupados
                if (estanCuadritosVacios(ocupa_aux[0][0] + 1, ocupa_aux[0][1], ocupa_aux[1][0] + 1, ocupa_aux[1][1], ocupa_aux[2][0] + 1, ocupa_aux[2][1], ocupa_aux[3][0] + 1, ocupa_aux[3][1]) == true){
                    return true;
                }
            case 6:
                Ele_invertida ele_invertida = (Ele_invertida) figura; //downcast a figura
                int[][] ocupa_aux6 = ele_invertida.getCuadritosOcupa();
                //limpia cuadritos que estaban ocupados
                if (estanCuadritosVacios(ocupa_aux6[0][0] + 1, ocupa_aux6[0][1], ocupa_aux6[1][0] + 1, ocupa_aux6[1][1], ocupa_aux6[2][0] + 1, ocupa_aux6[2][1], ocupa_aux6[3][0] + 1, ocupa_aux6[3][1]) == true){
                    return true;
                }
                break;
            case 7:
                Te te = (Te) figura; //downcast a figura
                int[][] ocupa_aux7 = te.getCuadritosOcupa();
                //limpia cuadritos que estaban ocupados
                if (estanCuadritosVacios(ocupa_aux7[0][0] + 1, ocupa_aux7[0][1], ocupa_aux7[1][0] + 1, ocupa_aux7[1][1], ocupa_aux7[2][0] + 1, ocupa_aux7[2][1], ocupa_aux7[3][0] + 1, ocupa_aux7[3][1]) == true){
                    return true;
                }
                break;
        }
        return false;
    }


    protected void moverFicha_abajo(Figura figura) {
        switch (figura.getId()) {
            case 1:
                Palito palito = (Palito) figura; //downcast a figura
                int [][] ocupa_aux = palito.getCuadritosOcupa();
                //desocupa cuadritos del tetris
                desocupaCuadritos(ocupa_aux[0][0], ocupa_aux[0][1], ocupa_aux[1][0], ocupa_aux[1][1], ocupa_aux[2][0], ocupa_aux[2][1], ocupa_aux[3][0], ocupa_aux[3][1]);
                //setea los nuevos cuadritos de la ele
                palito.setCuadritosOcupaEle(ocupa_aux[0][0] + 1, ocupa_aux[0][1], ocupa_aux[1][0] + 1, ocupa_aux[1][1], ocupa_aux[2][0] + 1, ocupa_aux[2][1], ocupa_aux[3][0] + 1, ocupa_aux[3][1]);
                //ocupa nuevos cuadritos del tetris
                ocupaCuadritos(ocupa_aux[0][0] + 1, ocupa_aux[0][1], ocupa_aux[1][0] + 1, ocupa_aux[1][1], ocupa_aux[2][0] + 1, ocupa_aux[2][1], ocupa_aux[3][0] + 1, ocupa_aux[3][1]);
                break;
            case 2:
                Ese_invertida ese_invertida = (Ese_invertida) figura; //downcast a figura
                int [][] ocupa_aux2 = ese_invertida.getCuadritosOcupa();
                //desocupa cuadritos del tetris
                desocupaCuadritos(ocupa_aux2[0][0], ocupa_aux2[0][1], ocupa_aux2[1][0], ocupa_aux2[1][1], ocupa_aux2[2][0], ocupa_aux2[2][1], ocupa_aux2[3][0], ocupa_aux2[3][1]);
                //setea los nuevos cuadritos de la ele
                ese_invertida.setCuadritosOcupaEle(ocupa_aux2[0][0] + 1, ocupa_aux2[0][1], ocupa_aux2[1][0] + 1, ocupa_aux2[1][1], ocupa_aux2[2][0] + 1, ocupa_aux2[2][1], ocupa_aux2[3][0] + 1, ocupa_aux2[3][1]);
                //ocupa nuevos cuadritos del tetris
                ocupaCuadritos(ocupa_aux2[0][0] + 1, ocupa_aux2[0][1], ocupa_aux2[1][0] + 1, ocupa_aux2[1][1], ocupa_aux2[2][0] + 1, ocupa_aux2[2][1], ocupa_aux2[3][0] + 1, ocupa_aux2[3][1]);

                break;
            case 3:
                Ese ese = (Ese) figura; //downcast a figura
                int [][] ocupa_aux3 = ese.getCuadritosOcupa();
                //desocupa cuadritos del tetris
                desocupaCuadritos(ocupa_aux3[0][0], ocupa_aux3[0][1], ocupa_aux3[1][0], ocupa_aux3[1][1], ocupa_aux3[2][0], ocupa_aux3[2][1], ocupa_aux3[3][0], ocupa_aux3[3][1]);
                //setea los nuevos cuadritos de la ele
                ese.setCuadritosOcupaEle(ocupa_aux3[0][0] + 1, ocupa_aux3[0][1], ocupa_aux3[1][0] + 1, ocupa_aux3[1][1], ocupa_aux3[2][0] + 1, ocupa_aux3[2][1], ocupa_aux3[3][0] + 1, ocupa_aux3[3][1]);
                //ocupa nuevos cuadritos del tetris
                ocupaCuadritos(ocupa_aux3[0][0] + 1, ocupa_aux3[0][1], ocupa_aux3[1][0] + 1, ocupa_aux3[1][1], ocupa_aux3[2][0] + 1, ocupa_aux3[2][1], ocupa_aux3[3][0] + 1, ocupa_aux3[3][1]);

                break;
            case 4:
                Cuadrado cuadrado = (Cuadrado) figura; //downcast a figura
                int [][] ocupa_aux4 = cuadrado.getCuadritosOcupa();
                //desocupa cuadritos del tetris
                desocupaCuadritos(ocupa_aux4[0][0], ocupa_aux4[0][1], ocupa_aux4[1][0], ocupa_aux4[1][1], ocupa_aux4[2][0], ocupa_aux4[2][1], ocupa_aux4[3][0], ocupa_aux4[3][1]);
                //setea los nuevos cuadritos de la ele
                cuadrado.setCuadritosOcupaEle(ocupa_aux4[0][0] + 1, ocupa_aux4[0][1], ocupa_aux4[1][0] + 1, ocupa_aux4[1][1], ocupa_aux4[2][0] + 1, ocupa_aux4[2][1], ocupa_aux4[3][0] + 1, ocupa_aux4[3][1]);
                //ocupa nuevos cuadritos del tetris
                ocupaCuadritos(ocupa_aux4[0][0] + 1, ocupa_aux4[0][1], ocupa_aux4[1][0] + 1, ocupa_aux4[1][1], ocupa_aux4[2][0] + 1, ocupa_aux4[2][1], ocupa_aux4[3][0] + 1, ocupa_aux4[3][1]);

                break;
            case 5:
                Ele ele = (Ele) figura; //downcast a figura
                int [][] ocupa_aux5 = ele.getCuadritosOcupa();
                //desocupa cuadritos del tetris
                desocupaCuadritos(ocupa_aux5[0][0], ocupa_aux5[0][1], ocupa_aux5[1][0], ocupa_aux5[1][1], ocupa_aux5[2][0], ocupa_aux5[2][1], ocupa_aux5[3][0], ocupa_aux5[3][1]);
                //setea los nuevos cuadritos de la ele
                ele.setCuadritosOcupaEle(ocupa_aux5[0][0] + 1, ocupa_aux5[0][1], ocupa_aux5[1][0] + 1, ocupa_aux5[1][1], ocupa_aux5[2][0] + 1, ocupa_aux5[2][1], ocupa_aux5[3][0] + 1, ocupa_aux5[3][1]);
                //ocupa nuevos cuadritos del tetris
                ocupaCuadritos(ocupa_aux5[0][0] + 1, ocupa_aux5[0][1], ocupa_aux5[1][0] + 1, ocupa_aux5[1][1], ocupa_aux5[2][0] + 1, ocupa_aux5[2][1], ocupa_aux5[3][0] + 1, ocupa_aux5[3][1]);

                break;
            case 6:
                Ele_invertida ele_invertida = (Ele_invertida) figura; //downcast a figura
                int [][] ocupa_aux6 = ele_invertida.getCuadritosOcupa();
                //desocupa cuadritos del tetris
                desocupaCuadritos(ocupa_aux6[0][0], ocupa_aux6[0][1], ocupa_aux6[1][0], ocupa_aux6[1][1], ocupa_aux6[2][0], ocupa_aux6[2][1], ocupa_aux6[3][0], ocupa_aux6[3][1]);
                //setea los nuevos cuadritos de la ele
                ele_invertida.setCuadritosOcupaEle(ocupa_aux6[0][0] + 1, ocupa_aux6[0][1], ocupa_aux6[1][0] + 1, ocupa_aux6[1][1], ocupa_aux6[2][0] + 1, ocupa_aux6[2][1], ocupa_aux6[3][0] + 1, ocupa_aux6[3][1]);
                //ocupa nuevos cuadritos del tetris
                ocupaCuadritos(ocupa_aux6[0][0] + 1, ocupa_aux6[0][1], ocupa_aux6[1][0] + 1, ocupa_aux6[1][1], ocupa_aux6[2][0] + 1, ocupa_aux6[2][1], ocupa_aux6[3][0] + 1, ocupa_aux6[3][1]);

                break;
            case 7:
                Te te = (Te) figura; //downcast a figura
                int [][] ocupa_aux7 = te.getCuadritosOcupa();
                //desocupa cuadritos del tetris
                desocupaCuadritos(ocupa_aux7[0][0], ocupa_aux7[0][1], ocupa_aux7[1][0], ocupa_aux7[1][1], ocupa_aux7[2][0], ocupa_aux7[2][1], ocupa_aux7[3][0], ocupa_aux7[3][1]);
                //setea los nuevos cuadritos de la ele
                te.setCuadritosOcupaEle(ocupa_aux7[0][0] + 1, ocupa_aux7[0][1], ocupa_aux7[1][0] + 1, ocupa_aux7[1][1], ocupa_aux7[2][0] + 1, ocupa_aux7[2][1], ocupa_aux7[3][0] + 1, ocupa_aux7[3][1]);
                //ocupa nuevos cuadritos del tetris
                ocupaCuadritos(ocupa_aux7[0][0] + 1, ocupa_aux7[0][1], ocupa_aux7[1][0] + 1, ocupa_aux7[1][1], ocupa_aux7[2][0] + 1, ocupa_aux7[2][1], ocupa_aux7[3][0] + 1, ocupa_aux7[3][1]);

                break;
        }
    }
}


