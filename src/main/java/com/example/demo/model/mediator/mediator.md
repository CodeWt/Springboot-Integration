中介者模式(调停者模式)
```aidl
中介者模式又称调停者模式 ，用一个中介对象来封装一系列的对象交互。中介者使得各对象不需要显示地相互引用，从而使其耦合松散，而且可以独立改变他们之间的交互。
```
优缺点
```aidl
1.中介者的出现降低了其它对象之间交互（多对多）的复杂性，同时也就增加了自身的复杂性。
2.尽管中介者模式很容易在系统中应用，但要防止误用，不要急于使用该模式，而要首先反思系统在设计上是不是有不合理之处。
3.中介者模式一般应用于一组对象以定义良好但是复杂的方式进行通信的场合以及想定制一个分布在多个类中的行为而又不想生成多个子类的场合。
```