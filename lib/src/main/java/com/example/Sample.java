package com.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Sample {
    static private Integer intg = new Integer(30);

    static class ClassA {
        private int m = 1;
        private int n = 2;

        public int getM() {
            return m;
        }

        public void setM(int m) {
            this.m = m;
        }

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }
    }

    public static void main(String[] arg) {
        Sample s= new Sample();
        Integer intg = new Integer(10);
        Integer intg1 = new Integer(10);
        int i = 5;
        ClassA a = new ClassA();
        //10 10 5 1 2
        System.out.println(intg+" "+intg1+" "+i+" "+a.getM()+" "+a.getN());
        s.test(intg,intg1,i,a);

        //10 10 5 6 2
        System.out.println(intg+" "+intg1+" "+i+" "+a.getM()+" "+a.getN());


    }
    private void test(Integer intg,Integer intg1,int i ,ClassA a){
        intg = new Integer(intg.intValue()+10);
        intg1 = Sample.intg;
        i+=10;
        a.setM(6);
        a = new ClassA();
        a.setM(15);
        a.setN(16);
    }
}
