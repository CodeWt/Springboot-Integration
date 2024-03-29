状态模式定义
```aidl
当一个对象的内在状态改变时允许改变其行为，这个对象看起来像是改变了其类。
```
状态模式的好处和用处
```aidl
1.将与特定状态相关的行为局部化，并且将不同的状态的行为分割开来。
2.将特定的状态相关的行为都放入一个对象中，由于所有与状态相关的代码都存于某个ConcreteState中，所以通过定义新的子类可以很容易地增加新的状态和转换。
3.这样做的 目的 是消除庞大的条件分支语句，状态模式通过把各种各样的状态转移逻辑分布到State的子类之间，来减少相互间的依赖。

```
什么时候应该考虑使用该模式呢？
```aidl
1.当一个对象的行为取决于它的状态，并且他必须在运行时刻根据状态改变它的行为时，就可以考虑。
2.如果业务需求对某项业务有多个装填，通常都是一些枚举常量，状态的变化都是依靠大量的分支判断实现，此时可考虑将每一种业务状态定义为一个State子类，这样个状态对象之间相互独立变化而不互相影响。
3.状态的operation必须是不变化的(新增或减少operation),而状态是有可能会新增。否则不用。
4.如果只有一种状态也不用，直接用switch-case
```

