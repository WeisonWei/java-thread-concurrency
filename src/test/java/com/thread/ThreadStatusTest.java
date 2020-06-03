package com.thread;

import com.thread.state.StateRunnable;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import java.util.concurrent.CountDownLatch;

@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ThreadStatusTest {

    private CountDownLatch countDownLatch = new CountDownLatch(2);

    @Test
    @Order(1)
    @DisplayName("Thread线程状态")
    public synchronized void createThread() throws InterruptedException {
        StateRunnable stateRunnable = new StateRunnable(countDownLatch, "1");
        Thread thread = new Thread(stateRunnable);
        Thread thread1 = new Thread(stateRunnable);
        log.debug("Thread -new- status:{}", thread.getState());
        thread.start();
        thread1.start();
        log.debug("Thread -star- status:{}", thread.getState());
        //IllegalMonitorStateException
        //thread.wait();
        //log.debug("Thread -wait- status:{}",thread.getState());
        log.debug("Thread -wait- notify:{}", thread.getState());
        thread.join();
        log.debug("Thread -join- status:{}", thread.getState());
        countDownLatch.await();
    }
}