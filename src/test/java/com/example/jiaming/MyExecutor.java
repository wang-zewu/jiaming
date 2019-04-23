package com.example.jiaming;

import java.util.concurrent.*;

public class MyExecutor {

    private  static ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws  Exception{
        Result r = new Result();
        r.setName("jiaming");

        Future<Result> f = executor.submit(new MyTask(r), r);
        Result tr =  f.get();
        System.out.println(tr.getName());


//       Future<String> fresult = (Future<String>) executor.submit(new Callable() {
//            @Override
//            public String call() {
//                System.out.println("runnable 执行完毕");
//                return  "ok";
//            }
//        });
//
//        try {
//            System.out.println(fresult.get());
//            System.out.println(fresult.isDone());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        FutureTask<Integer> futureTask = new FutureTask<>(()->1+2);
        executor.submit(futureTask);
        System.out.println(futureTask.get());;
    }

}


