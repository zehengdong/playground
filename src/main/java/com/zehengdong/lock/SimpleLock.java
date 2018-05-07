package com.zehengdong.lock;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SimpleLock {
    private int count = 0;

    private int currentEventValue = 0;
    private static Lock reentrantLock = new ReentrantLock();

    public static synchronized void inc(String name){
        for(int i=0;i<10;i++) {
            System.out.println(name + " :: "+i);
            try{
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SimpleLock simpleLock = new SimpleLock();
        new TestThread("Thread1", simpleLock);
        new TestThread("thread2", simpleLock);
        new TestThread("thread3", simpleLock);

        try {
            reentrantLock.tryLock(123L, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();


    }





}
