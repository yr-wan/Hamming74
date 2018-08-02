package com.yrwan.hamming;
public class BSC {
    double errPr;//BSC信道的错误概率
    public BSC(double Pr){
        errPr = Pr;
    }
//经BSC传输信号，返回传输后的值
    public int[] send(int[] data){
    	int[] x=new int[data.length];
    	x = data;
        for(int i = 0; i<data.length;i++)
            if(Math.random()<errPr){
                x[i] = 1 - x[i];
            }
        return x;
    }
}