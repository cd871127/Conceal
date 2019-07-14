# Redis

### 底层数据结构

##### SDS(Simple dynamic string)

```c
struct sdshdr{
    //长度
    int len;
    //剩余空间
    int free;
    char buf[]
}
```

优点：
  O(1)时间复杂度获取长度。
  杜绝缓冲区溢出，API会检查free是否满足长度需求。
  减少修改字符串时内存分配次数。 扩容：如果分配后空间小于1MB，就分配2倍修改后的空间，如果大于1MB，就多分配1MB空间，缩短字符串时：记录free不立即回收
  二进制安全：可以保存所有类型的数据，因为sds不用‘\0’判断末尾
  兼容C字符串：不用‘\0’判断末尾，但是实际还是会存‘\0’在末尾


##### 链表

```c
typedef struct listNode{
    //前置节点
    struct listNode *prev;
    //后置节点
    struct listNode *next;
    //值
    void *value;
} listNode;

typedef struct list{
    //头结点
    listNode *head;
    //尾节点
    listNode *tail;
    //长度
    unsigned long len;
    //节点复制函数
    void *(*dup)(void *ptr);
    //节点释放函数
    void (*free)(void *ptr);
    //节点对比函数
    int (*match)(void *ptr,void *key);
} list;
```
特点：
    双端
    无环
    头尾指针
    长度计数器
    多态，void*提供
    
##### 字典

###### 哈希表

```c
typedef struct dictht{
    //哈希表数组
    dictEntry **table;
    //长度
    unsigned long size;
    //大小掩码，总等于size-1
    unsigned long sizemask;
    //已有节点数量
    unsigned long used;
} dictht;

typedef struct dictEntry{
    //键
    void *key;
    //值
    union{
        void *val;
        uint64_t u64;
        int64_t s64;
    }
    struct dictEntry *next;
} dictEntry;

typedef struct dict{
    //类型特定函数
    dictType *type;
    //私有数据
    void *privdata;
    //哈希表
    dictht ht[2];
    //当前没有进行rehash的时候为-1
    int trehashidex;
    
} dict;
```

链地址解决冲突，头插法。
只使用ht[0]

rehash：
1
    扩展：ht[1]分配大小为第一个大于ht[0].used*2的2的n次方
    收缩：ht[1]分配大小为第一个大于ht[0].used的2的n次方
2 ht[0]rehash到ht[1]上
3 释放ht[0]，把ht[1]设置为ht[0]

渐进式：
1 分配空间给ht[1]，设置rehashidx为0
2 rehash进行时，查找、删除、更新会同时操作ht[0],ht[0]，新增只会操作ht[1]

##### 跳跃表


```c
typedef struct zskiplistNode {
    // 后退指针
    struct zskiplistNode *backward;
    // 分值
    double score;
    // 成员对象
    robj *obj;
    // 层
    struct zskiplistLevel{
        // 前进指针
        struct zskiplistNode* forward;
        // 跨度
        unsigned int span;
    } level[];
    
} zskiplistNode;
```

层：新建节点随机1到32层
前进指针：移动到该层对应的下一个节点
跨度：用来计算排位
后退指针：只能退回到上一个节点
对象：必须唯一
分值：可以一样