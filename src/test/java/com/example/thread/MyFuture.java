package com.example.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class MyFuture {

    public static void main(String[] args) throws Exception{
       CompletableFuture<Integer> cf =  CompletableFuture.supplyAsync(()->{
            System.out.println("task doing ...");
            try {
                TimeUnit.SECONDS.sleep(2L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }
            return 100;
        });

//       CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(()->{
//           System.out.println("task doing2......");
//           try {
//               TimeUnit.SECONDS.sleep(3L);
//           } catch (InterruptedException e) {
//               e.printStackTrace();
//           } finally {
//           }
//           return "result2";
//       });
//       CompletableFuture<Void> allcf = CompletableFuture.allOf(cf, cf2);
//       allcf.join();
//        System.out.println("计算结果:"+cf.get());
//        System.out.println("计算结果:"+cf2.get());

//       CompletableFuture<String> cf3 =  cf.thenCompose(res ->CompletableFuture.supplyAsync(()->{
       CompletableFuture<Integer> cf3 =  cf.thenCombine(
           CompletableFuture.supplyAsync(()->{
            System.out.println("task doing3......");
            try {
                TimeUnit.SECONDS.sleep(3L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }
            return 300;
        }),
               (re1, re2) -> re1*re2);

        System.out.println(cf3.get());
    }
}
