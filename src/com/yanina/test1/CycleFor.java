package com.yanina.test1;

public class CycleFor {

    private int x;

    public void cycle(int x){

        this.x =x;
        for(int i=0; i<5; i++)
        { x=x+3;}
        System.out.println(x);}
}
