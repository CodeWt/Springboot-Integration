package com.example.demo.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.*;

/**
 *
 * 默认生产者为多线程模式（即加锁）  ProducerType.MULTI
 * 多线程模式下会覆盖sequence     ProducerType.SINGLE
 *
 */
public class Main04ProducerType {
    public static void main(String[] args) throws InterruptedException {
        EventFactory factory = new LongEventFactory();
        int bufferSize = 1024;
        Disruptor disruptor = new Disruptor(factory,bufferSize, Executors.defaultThreadFactory(), ProducerType.MULTI,new BlockingWaitStrategy());
        disruptor.handleEventsWith(new LongEventHandler());
        disruptor.start();
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        int threads = 10;
        ExecutorService service = Executors.newCachedThreadPool();
        CyclicBarrier barrier = new CyclicBarrier(threads);
        for (int i = 0; i < threads; i++) {
            final long finalI = i;
            service.submit(()->{
                try {
                    barrier.await();
                    System.out.printf("thread [%s] is ready run !" , finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                for (int j = 0; j < 1000; j++) {
                    ringBuffer.publishEvent(((event, sequence) -> {
                        event.setEventId(finalI);
                    }));
                }
            });
        }
        service.shutdown();
        TimeUnit.SECONDS.sleep(3);
        System.out.println(LongEventHandler.count);
    }
}
