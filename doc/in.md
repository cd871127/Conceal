# JAVA基础

## JVM

### GC

#### GCRoots
虚拟机栈引用的对象，方法区常量或静态引用的对象，本地方法栈引用的对象。

#### 安全点
方法调用，异常跳转，循环跳转

抢先式：直接暂定线程，如果线程不在安全点，则继续执行到安全点。
主动式：线程直接跑到安全点，停止。

#### GC算法
1. 复制
2. 标记清除
3. 标记整理

参数server:优先选择串行GC client:优先选择并行GC

parNew parOld 标记整理



##### CMS
1. 初始标记，标记GCRoots直接可达的对象，STW；
2. 并发标记：标记步骤1中对象可达的；
3. 重新标记：标记步骤2中引用修改的对象；
4. 并发清除，STW
优点：短停顿
缺点：有内存碎片，无法处理浮动垃圾

##### G1：

#### GC条件

##### Minor GC

Minor GC之前，会检查老年代连续空间是否大于新生代所有对象大小总和，如果不成立，那么会检查是否允许担保失败，如果允许，就会检查老年代连续空间是否大于历次晋升对象的平均大小，如果小于就会fullgc，大于就会minorGC，担保失败后，会Full GC

##### FullGC
System.GC；老年代空间不足，方法区空间不足，Minor GC进入老年代对象平均大小大于老年代空间；Eden和From区复制到To区，大于To区空间，对象会进入老年代；

#### STW停顿
撤销轻量锁，GC，热部署，DEBUG

### 类加载

1. 加载： 读取class文件到内存
2. 验证： 判断合法性
3. 准备：分配内存，初始值
4. 解析：符号引用转换为直接引用
5. 初始化：静态代码块

### 双亲委派

## 多线程

### 线程池
`ThreadPoolExecutor`
参数：
	核心线程数：
	最大线程数：
	存活时间：
	线程工厂：
	阻塞队列：

拒绝策略：`RejectedExecutionHandler`
ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。 
ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。 
ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务 

### volatile
原理：内存屏障，防止重排序，
`long`和`double`不是原子写入

### 并发包
`ConcurrentHashMap`：JAVA1.7分段锁，`ReentrantLock` ，JAVA1.8用CAS和`Synchronized`实现

`ArrayBlockingQueue`：两个Condition

`LinkedBlockingQueue`：两个锁

add remove 抛异常
put take 阻塞
offer poll 马上返回

### Happens-before

volatile：
start：
join：
lock：
串行语义：


### 锁
#### 显示锁
原理：AQS，用CAS获取整型的state，使用a，和release，默认非公平，如果需要公平，那么加锁操作会入队。


#### 内部锁
原理：对象头
偏向锁：
轻量锁：自旋
重量锁：阻塞

#### 规避死锁
锁排序
锁粗化
超时

## 集合类

### HashMap

### TreeSet



# MySQL

## 索引
### Hash

### B树
回表查询

# Redis

# Zookeeper

# Kafka

# Consul
