package com.yrwan.hamming;
public class BSC {
    double errPr;//BSC�ŵ��Ĵ������
    public BSC(double Pr){
        errPr = Pr;
    }
//��BSC�����źţ����ش�����ֵ
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