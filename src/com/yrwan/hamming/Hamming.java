package com.yrwan.hamming;
public class Hamming {
    //根据传入的4位二进制序列算出7位汉明码,其中前三位为信息码 后三位为监督码
    public static int[] encode(int[] d){
        if (d.length!=4){
            return new int[4];
        }
        // 根据四位信息码算出三位监督码
        int p1 = d[0] ^ d[1] ^ d[3];
        int p2 = d[0] ^ d[2] ^ d[3];
        int p3 = d[1] ^ d[2] ^ d[3];
        int[] results=new int[7];
        results[0]=d[0];
        results[1]=d[1];
        results[2]=d[2];
        results[3]=d[3];
        results[4]=p1;
        results[5]=p2;
        results[6]=p3;
        return results;
    }
    //根据传入的7位汉明码算出2进制序列,其中后三位为监督码
    public static int[] decode(int[] d){
        if (d.length!=7){
            return new int[4];
        }
        int c1 = d[4] ^ d[0] ^ d[1] ^ d[3];
        int c2 = d[5] ^ d[0] ^ d[2] ^ d[3];
        int c3 = d[6] ^ d[1] ^ d[2] ^ d[3];
        if (c1 + c2 + c3 == 3) d[3] = 1 ^ d[3];
        else if (c1 + c2 == 2) d[0] = 1 ^ d[0];
        else if (c1 + c3 == 2) d[1] = 1 ^ d[1];
        else if (c2 + c3 == 2) d[2] = 1 ^ d[2];
        int[] results=new int[4];
        results[0]=d[0];
        results[1]=d[1];
        results[2]=d[2];
        results[3]=d[3];
        return results;
    }
    //返回四位的16进制编码
    public static int fromHex(String s) {
        return Integer.parseInt(s, 16) & 0xFFFF;
    }
}