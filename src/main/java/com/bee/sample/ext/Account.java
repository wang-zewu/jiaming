package com.bee.sample.ext;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Account {

    //锁：保护账户资源
    private final Object balLock = new Object();
    private Integer balance;
    private final Object pwLock = new Object();
    private String pawwword;

    void withdraw(Integer amt){
        synchronized (balLock){
            if(this.balance > amt){
                this.balance -= amt;
            }
        }
    }


    public static void main(String[] args) {
        CurrentThread ct = new CurrentThread();
        Thread t = new Thread(ct);
        t.start();
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.getId()+"   "+t.getName());
        t.interrupt();
    }



}

class CurrentThread implements  Runnable{
    @Override
    public void run() {
        Thread td = Thread.currentThread();
        System.out.println(td.getId()+"   "+td.getName());
        while (true){
            if(td.isInterrupted()){
                System.out.println(22222222);
                break;
            }
            System.out.println(1111111111);
//            try {
//                Thread.sleep(100);
//            }catch (Exception e){
//
//            }finally {
//
//            }

        }
    }
}