package com.yrwan.hamming;
import java.util.Scanner;
public class Main {
    private static final double errPr=0.1;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("�����볤��Ϊ4�Ķ��������У�");
        int d[] = new int[4];
        for (int i = 0; i < 4; i++) {
            d[i] = Hamming.fromHex(sc.next());
        }
        sc.close();
        int[] encodeData=Hamming.encode(d);
        println("�����",encodeData);
        BSC bsc=new BSC(errPr);
        int[] transmitedData=bsc.send(encodeData);
        println("BSC�����",transmitedData);
        int[] decodeData=Hamming.decode(transmitedData);
        println("��������",decodeData);
    }
    private static void println(String message,int[] data){
        System.out.print(message);
        for (int i:data){
            System.out.printf(i+" ");
        }
        System.out.println();
    }
}