package com.example.demo.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.Executors;

public class Main01 {
    public static void main(String[] args) {
        //event工厂
        LongEventFactory factory = new LongEventFactory();
        //定义ringbuffer must be power of 2
        int bufferSize = 1024;
        //construct the buffer Executors.defaultThreadFactory()==> 创建消费者线程调用onEvent方法处理消费
        Disruptor disruptor = new Disruptor<>(factory, bufferSize, Executors.defaultThreadFactory());
        //connect to the handler
        disruptor.handleEventsWith(new LongEventHandler());
        //start the disruptor and start all threads running
        disruptor.start();
        //get the ringbuffer from the disruptor to be used for publishing
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        long sequence = ringBuffer.next();//grab the next sequence
        //get the entry in the disruptor
        LongEvent event = ringBuffer.get(sequence);
        //fill with data 修改预填充对象的属性值
        event.setEventId(666L);
        ringBuffer.publish(sequence);
    }
}
