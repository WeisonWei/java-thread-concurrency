package com.thread.schedule;

import lombok.extern.slf4j.Slf4j;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

@Slf4j
public class FooTimerTask extends TimerTask {

    private volatile int flag = 0;

    @Override
    public void run() {

        Thread.currentThread().setName("task-" + flag + " " + System.currentTimeMillis());
        if (flag > 10) {
            this.cancel();
            //this.scheduledExecutionTime();
            return;
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info(">>>>>" + Thread.currentThread().getName() + ">>>>>>" + System.currentTimeMillis());
        flag++;
    }
}
