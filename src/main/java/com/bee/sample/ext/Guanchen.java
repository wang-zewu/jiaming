package com.bee.sample.ext;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Guanchen<T> {
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();
    Queue<String> queue = new LinkedList<String>();

    void enq(T x){
        lock.lock();
        try {
            while (queue.size()==10){
//                notFull.wait();

            }

        }finally {

            lock.unlock();
        }
    }

}

class Allocator{
    private List<Object> als = new ArrayList<Object>();
    synchronized boolean apply(Object from, Object to){
        if(als.contains(from) || als.contains(to)){
            return  false;
        }else{
            als.add(from
            );
            als.add(to);
        }
        return true;

    }
    synchronized void free(Object from, Object to){
        als.remove(from);
        als.remove(to);
    }
}

class Account1{
    private Allocator actr;
    private int balance;
    void transfer(Account1 target, int amt){
        while (!actr.apply(this, target));
        try {
            synchronized (this){
                synchronized (target){
                    if(this.balance > amt){
                        this.balance -= amt;
                        target.balance +=amt;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            actr.free(this,target);
        }
    }
}
