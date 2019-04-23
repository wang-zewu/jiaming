package com.example.jiaming;

public class MyTask implements Runnable {
    private Result r;
    public MyTask(Result r){
        this.r = r;
    }
    @Override
    public void run() {
        System.out.println("MyTask run");
        r.setName("我的ja");
    }
}
