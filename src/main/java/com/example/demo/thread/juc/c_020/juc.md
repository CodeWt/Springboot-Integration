synchronize vs ReentrantLock
```
synchronize自动加锁解锁，4种锁升级状态
ReentrantLock 手动加锁，解锁，底层CAS实现，出现各种condition（不同等待队列）
```

notify不会释放锁，会通知叫醒另个wait的线程去抢锁
wait释放锁并等待被另个线程notify