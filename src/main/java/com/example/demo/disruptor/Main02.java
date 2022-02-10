package com.example.demo.disruptor;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.Executors;

public class Main02 {
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

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        //------------------迎合java8
        EventTranslator<LongEvent> translator = new EventTranslator<LongEvent>() {
            @Override
            public void translateTo(LongEvent event, long sequence) {
                event.setEventId(777L);
            }
        };
        ringBuffer.publishEvent(translator);
        //------------------
        EventTranslatorOneArg<LongEvent, Long> oneArg = new EventTranslatorOneArg<LongEvent, Long>() {
            @Override
            public void translateTo(LongEvent event, long sequence, Long arg0) {
                event.setEventId(arg0);
            }
        };
        ringBuffer.publishEvent(oneArg,888L);
        //------------------
        EventTranslatorTwoArg<LongEvent, Long, Long> twoArg = new EventTranslatorTwoArg<LongEvent, Long, Long>() {
            @Override
            public void translateTo(LongEvent event, long sequence, Long arg0, Long arg1) {
                event.setEventId(arg0 + arg1);
            }
        };
        ringBuffer.publishEvent(twoArg,1000L,1000L);
        //--------------------
        EventTranslatorThreeArg<LongEvent, Long, Long, Long> threeArg = new EventTranslatorThreeArg<LongEvent, Long, Long, Long>() {
            @Override
            public void translateTo(LongEvent event, long sequence, Long arg0, Long arg1, Long arg2) {
                event.setEventId(arg0 + arg1 + arg2);
            }
        };
        ringBuffer.publishEvent(threeArg,1000L,1000L,1000L);
        //--------------------------
        EventTranslatorVararg<LongEvent> vararg = new EventTranslatorVararg<LongEvent>() {
            @Override
            public void translateTo(LongEvent event, long sequence, Object... args) {
                long res = 0;
                for(Object o : args){
                    res += (int) o;
                }
                event.setEventId(res);
            }
        };
        ringBuffer.publishEvent(vararg,1000,1000,1000,1000,1000,1000);
    }
}
