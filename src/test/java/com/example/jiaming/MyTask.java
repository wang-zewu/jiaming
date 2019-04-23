package com.example.jiaming;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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

    public static void main(String[] args) {
//        CompletableFuture.runAsync(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });

       CompletableFuture<Void> f =
               CompletableFuture.runAsync(()->{
            System.out.println("已经完成");
        });



        try {
//            if( f.isDone()){
                System.out.println(f.isDone());
                System.out.println( f.get()); ;
//            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ///////////////////////////////////
       CompletableFuture<String> fs =  CompletableFuture.supplyAsync(()->{
            return  "task1";
        }).thenApply(cc -> {
            return cc + "task2";
        });

        try {
            System.out.println(fs.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
////////////////////////////////////////////
        CompletableFuture.supplyAsync(()->"hello")
                .thenApply(a -> a+"world")
                .thenApply(String::toUpperCase)
                .thenCombine(CompletableFuture.completedFuture("java"), (s1, s2)->s1+s2)
                .thenAccept(System.out::println);




    }
}
