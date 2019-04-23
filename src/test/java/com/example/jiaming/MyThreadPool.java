package com.example.jiaming;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class MyThreadPool {

    private BlockingQueue<Runnable> workQueue;
    private List<WorkerThread> threads = new ArrayList<>();
    MyThreadPool(int poolSize, BlockingQueue<Runnable> workQueue){
        this.workQueue = workQueue ;
        for(int idx=0; idx<poolSize; idx++){
            WorkerThread work = new WorkerThread();
            work.start();
            threads.add(work);
        }

    }


    public void execute(Runnable command){
        try {
            workQueue.put(command);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    class WorkerThread extends  Thread{
        public void run(){
            while (true){
                Runnable task = null;
                try {
                    task = workQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                task.run();
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>(2);
        MyThreadPool pool = new MyThreadPool(10, workQueue);

        pool.execute(()->{
            System.out.println("hello");
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("wang");
            }
        });
    }

}
