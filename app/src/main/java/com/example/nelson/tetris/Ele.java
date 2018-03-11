package com.example.nelson.tetris;

import android.util.Log;

/**
 * Created by Nelson on 9/3/2018.
 */

public class Ele extends Figura {
    int posicionActual;
    private int cuadritosOcupa[][] = new int[4][2];


    public Ele(int pid, String pcolor, int pPosicionActual,int f1, int c1, int f2, int c2, int f3, int c3, int f4, int c4) {
        super(pid, pcolor);
        posicionActual = pPosicionActual;
        setCuadritosOcupaEle(f1, c1, f2, c2, f3, c3, f4, c4);

    }

    protected void setCuadritosOcupaEle(int f1,int cl1, int f2, int cl2, int f3, int cl3, int f4, int cl4){
        cuadritosOcupa[0][0] = f1;
        cuadritosOcupa[0][1] = cl1;
        cuadritosOcupa[1][0] = f2;
        cuadritosOcupa[1][1] = cl2;
        cuadritosOcupa[2][0] = f3;
        cuadritosOcupa[2][1] = cl3;
        cuadritosOcupa[3][0] = f4;
        cuadritosOcupa[3][1] = cl4;
    }


    protected void setPosicionActual(int pPosicionActual){
        posicionActual=pPosicionActual;
    }
    protected int getPosicionActual(){
        return posicionActual;
    }


    protected int[][] getCuadritosOcupa(){
        int cuadritosOcupa_aux[][] = new int[4][2];
        for (int i=0; i<4; i++){
            for(int j=0;j<2;j++){
                cuadritosOcupa_aux[i][j] = cuadritosOcupa[i][j];
                Log.d("ESTE CUADRITO OCUPA", String.valueOf(cuadritosOcupa[i][j]));
            }
            Log.d("-----CORTE", "-----");
        }
        return cuadritosOcupa_aux;
    }

    @Override
    protected void rotarFigura() {
        if (posicionActual>4){
            posicionActual=0;
        }
        posicionActual = posicionActual+1;

        int cuadritosOcupa_aux[][] = getCuadritosOcupa();
        int f1 = cuadritosOcupa_aux[0][0];
        int c1 = cuadritosOcupa_aux[0][1];
        int f2 = cuadritosOcupa_aux[1][0];
        int c2 = cuadritosOcupa_aux[1][1];
        int f3 = cuadritosOcupa_aux[2][0];
        int c3 = cuadritosOcupa_aux[2][1];
        int f4 = cuadritosOcupa_aux[3][0];
        int c4 = cuadritosOcupa_aux[4][1];

        switch(posicionActual){
            case 1:
                setCuadritosOcupaEle(f1-1,c1-1,f2,c2,f3+1,c3+1,f4,c4+2);
                setPosicionActual(1);

                break;
            case 2:
                setCuadritosOcupaEle(f1+2,c1-2,f2+1,c2-1,f3,c3,f4-1, c4-1);
                setPosicionActual(2);
                break;
            case 3:
                setCuadritosOcupaEle(f1,c1+2,f2-1,c2+1,f3-2,c3,f4-1,c4-1);
                setPosicionActual(3);
                break;
            case 4:
                setCuadritosOcupaEle(f1+1,c1-1,f2,c2,f3+1,c3-1,f4-2,c4);
                setPosicionActual(4);
                break;
        }
    }

    public void mueveIzquierda(){
        int cuadritos_ocupa_aux[][] = cuadritosOcupa;
        if( cuadritos_ocupa_aux[0][1]>0 && cuadritos_ocupa_aux[1][1]>0 && cuadritos_ocupa_aux[2][1]>0 && cuadritos_ocupa_aux[3][1]>0){
            setCuadritosOcupaEle(cuadritos_ocupa_aux[0][0],cuadritos_ocupa_aux[0][1]-1,
                                 cuadritos_ocupa_aux[1][0], cuadritos_ocupa_aux[1][1]-1,
                                 cuadritos_ocupa_aux[2][0], cuadritos_ocupa_aux[2][1]-1,
                                 cuadritos_ocupa_aux[3][0], cuadritos_ocupa_aux[3][1]-1);
        }
    }

    public void mueveDerecha(){
        int cuadritos_ocupa_aux[][] = cuadritosOcupa;
        if( cuadritos_ocupa_aux[0][1]<9 && cuadritos_ocupa_aux[1][1]<9 && cuadritos_ocupa_aux[2][1]<9 && cuadritos_ocupa_aux[3][1]<9){
            setCuadritosOcupaEle(cuadritos_ocupa_aux[0][0],cuadritos_ocupa_aux[0][1]+1,
                    cuadritos_ocupa_aux[1][0], cuadritos_ocupa_aux[1][1]+1,
                    cuadritos_ocupa_aux[2][0], cuadritos_ocupa_aux[2][1]+1,
                    cuadritos_ocupa_aux[3][0], cuadritos_ocupa_aux[3][1]+1);
        }
    }

    public void mueveAbajo(){
        int cuadritos_ocupa_aux[][] = cuadritosOcupa;
        if( cuadritos_ocupa_aux[0][0]<14 && cuadritos_ocupa_aux[1][0]<14 && cuadritos_ocupa_aux[2][0]<14 && cuadritos_ocupa_aux[3][0]<14){
            setCuadritosOcupaEle(cuadritos_ocupa_aux[0][0]+1,cuadritos_ocupa_aux[0][1],
                    cuadritos_ocupa_aux[1][0]+1, cuadritos_ocupa_aux[1][1],
                    cuadritos_ocupa_aux[2][0]+1, cuadritos_ocupa_aux[2][1],
                    cuadritos_ocupa_aux[3][0]+1, cuadritos_ocupa_aux[3][1]);
        }
    }
}
