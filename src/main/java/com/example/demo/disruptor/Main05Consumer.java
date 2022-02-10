package com.example.demo.disruptor;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import java.util.concurrent.*;

/**
 *
 * 指定多个事件处理对象，即多个消费者 会在不同线程上执行消费
 *
 */
public class Main05Consumer {
    public static void main(String[] args) throws InterruptedException {
        EventFactory factory = new LongEventFactory();
        int bufferSize = 1024;
        Disruptor disruptor = new Disruptor<>(factory, bufferSize, Executors.defaultThreadFactory(), ProducerType.MULTI, new YieldingWaitStrategy());
        LongEventHandler h1 = new LongEventHandler();
        LongEventHandler h2 = new LongEventHandler();
        disruptor.handleEventsWith(h1,h2);
        disruptor.start();
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        int threads = 10;
        ExecutorService service = Executors.newCachedThreadPool();
        CyclicBarrier barrier = new CyclicBarrier(threads);
        for (int i = 0; i < threads; i++) {
            int finalI = i;
            service.submit(()->{
                System.out.printf("thread %s is ready run ", finalI);
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                for (int j = 0; j < 10; j++) {
                    long finalJ = j;
                    ringBuffer.publishEvent((event, sequence) -> event.setEventId(finalJ));
                }
            });
        }
        service.shutdown();
        TimeUnit.SECONDS.sleep(3);
        System.out.println(LongEventHandler.count);
    }

}
