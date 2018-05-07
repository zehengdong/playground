package com.zehengdong.lock;

public class TestThread extends Thread {
    String name;
    SimpleLock simpleLock;

    public TestThread(String name, SimpleLock simpleLock) {
        this.name = name;
        this.simpleLock = simpleLock;
        start();
    }
    @Override
    public void run() {
        SimpleLock.inc(name);
    }

}
