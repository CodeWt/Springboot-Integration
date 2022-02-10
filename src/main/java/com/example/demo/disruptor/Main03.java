package com.example.demo.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.Executors;

public class Main03 {
    public static void main(String[] args) {
        Disruptor<LongEvent> disruptor = new Disruptor<>(LongEvent::new, 1024, Executors.defaultThreadFactory());
        disruptor.handleEventsWith((event, sequence, endOfBatch) -> System.out.println(Thread.currentThread().getName()
                + " consume ==> \n" + event + " sequence: " + sequence + " endOfBatch: " + endOfBatch));
        disruptor.start();
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        ringBuffer.publishEvent((event, sequence) -> event.setEventId(1000l));
        ringBuffer.publishEvent((event, sequence, arg0) -> event.setEventId(arg0),1000l);
        ringBuffer.publishEvent((event, sequence, arg0, arg1) -> event.setEventId(arg0 + arg1),10000l,10000l);
        ringBuffer.publishEvent((event, sequence, arg0, arg1, arg2) -> event.setEventId(arg0 + arg1 + arg2),10000l,10000l,10000l);
        ringBuffer.publishEvent((event, sequence, args1) -> {
            int res = 0;
            for (Object arg : args1){
                res += (int) arg;
            }
            event.setEventId((long)res);
        },100,100,100,100,100,100,100,100,100);
    }
}
