package com.example.nelson.tetris;

/**
 * Created by Nelson on 9/3/2018.
 */

public abstract class Figura {
    private int id;
    private String color;
    private int cantidadCuadritos=4;

    public Figura(int pid, String pcolor){
        id=pid;
        color=pcolor;
    }

    private void setId(int pId){
        id=pId;
    }

    private void setColor(String pColor){
        color=pColor;
    }

    protected int getId(){
        return id;
    }

    private String getColor(){
        return color;
    }

    private int getCantidadCuadritos(){
        return cantidadCuadritos;
    }

    abstract protected void rotarFigura();
}
