package com.example.demo.disruptor;

import com.lmax.disruptor.EventHandler;

public class LongEventHandler implements EventHandler<LongEvent> {

    public static int count;

    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        count++;
        System.out.println(Thread.currentThread().getName() + " consume ==> \n" + event + " sequence: " + sequence + " endOfBatch: " + endOfBatch + " count: " + count);
    }
}
