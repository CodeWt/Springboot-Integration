一、单一职责原则
```aidl
单一职责原则，就一个类而言，应该仅有一个引起它变化的原因。

1.如果一个类承担的职责过多，就等于把这些职责耦合在了一起，一个职责的变化可能会削弱或者抑制这个类完成其他职责的能力。这种耦合会导致脆弱的设计，
当变化发生时，设计会遭受到意想不到的破坏。
2.软件设计要做的许多内容，就是发现职责并把那些职责相互分离。其实如果能够想到多于一个动机去改变一个类，那么这个类就具有多于一个的职责，就应该考虑职责分离。
3.单一职责思想的体现，如垂直搜索，分类信息。
4.多思考类的职责分离，尽量做到单一职责，使得代码具有易维护性、易扩展、易复用、灵活多样。

```
二、开放封闭原则
```aidl
开放-封闭原则，是说软件实体(类、模块、函数等等)应该可以扩展，但不可以修改。即对于扩展开放，对于更改是封闭的。

1.无论一个模块是多么的封闭，都会存在一些无法对之封闭的变化。既然不可能完全封闭，就应该在软件的设计阶段猜出变化的种类，然后构造抽象来隔离那些变化。
2.面对需求，对程序的改动是通过增加新代码进行的，而不是更改现有的代码。
3.尽可能在开发初期就知道该系统或软件发生变化的地方，因为查明可能发生变化所等待的时间越长，要创建正确的抽象就越困难。
4.开放-封闭原则是面向对象设计的核心所在。遵循这个原则可以带来面向对象所声称的巨大好处，即 可维护，可扩展，可复用，灵活性好。
5.coder 应该仅对program 呈现出频繁变化的那些部分作出抽象，然而，对于application 的每个部分都刻意地进行抽象同样不是好主意。拒绝不成熟的抽象和抽象本身一样重要。

```
三、依赖倒转原则
```aidl
依赖倒转原则(依赖倒置原则)，抽象不应该依赖细节，细节应该依赖于抽象。即 针对接口编程，不要对实现编程。
高层模块不应该依赖底层模块。两个都应该依赖于抽象。

1.依赖倒转可以说是面向对象设计的标志。如果编写程序考虑的是如何针对抽象而不是针对细节编程，即程序中所有的依赖关系都是终止于抽象类或者接口，那就是面向对象设计，反之那就是过程化的设计了。
```
四、里氏代换原则
```aidl
里氏代换原则，子类型必须能够替换掉他们的父类型。

1.一个软件实体如果使用的是一个父类的话，那么一定适用于其子类，而且察觉不出父类和子类对象的区别。也就是说，在软件里面，把父类换成它的子类，程序的行为没有发生变化。
2.由于子类型的可替换性使得使用父类型的模块在无需修改的情况下就可以扩展。

```
五、迪米特法则
```aidl
迪米特法则，如果两个类不必彼此直接通信，那么这两个类就不应当直接相互作用。如果其中一个类需要调用另一个类的某一个方法的话，可以通过第三者转发这个调用。
迪米特法则其根本的思想是强调了类之间的耦合，类之间的耦合越弱，越有利于复用，一个处在弱耦合的类被修改，不会对有关系的类造成波及。也就是说，信息的隐藏促进了软件的复用。

```
六、合成/聚合 复用原则
```aidl
合成/聚合复用原则，尽量使用合成/聚合，尽量不要使用类继承。

1.聚合表示一种弱的 拥有 关系，体现的是 A 对象可以包含 B 对象，但B对象不是A对象的一部分；合成则是一种强的 拥有 关系，体现了严格的部分整体的关系，部分和整体的生命周期一样。
2.合成/聚合复用的原则好处是，优先使用对象的合成/聚合将有助于保持每个类被封装，并被集中在单个任务上。这样类和类的继承层次会保持较小的规模，并且不太可能增长为不可控制的庞然大物。

```

