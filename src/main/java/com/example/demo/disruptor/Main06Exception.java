package com.example.demo.disruptor;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.Executors;

/**
 *
 * 处理异常
 *
 */
public class Main06Exception {
    public static void main(String[] args) {
        EventFactory factory = new LongEventFactory();
        int bufferSize = 1024;
        Disruptor disruptor = new Disruptor<>(factory, bufferSize, Executors.defaultThreadFactory(), ProducerType.MULTI, new SleepingWaitStrategy());
        EventHandler h1 = (event, sequence, endOfBatch) -> {
            System.out.println(event);
            //不处理此异常会影响到其它消费者执行
            throw new Exception("消费者异常");
        };
        disruptor.handleEventsWith(h1);
        disruptor.handleExceptionsFor(h1).with(new ExceptionHandler() {
            @Override
            public void handleEventException(Throwable ex, long sequence, Object event) {
                ex.printStackTrace();
            }

            @Override
            public void handleOnStartException(Throwable ex) {
                System.out.println("exception start to run .");
            }

            @Override
            public void handleOnShutdownException(Throwable ex) {
                System.out.println("exception stop ...");
            }
        });
        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        ringBuffer.publishEvent((event, sequence) -> event.setEventId(666L));
    }
}
