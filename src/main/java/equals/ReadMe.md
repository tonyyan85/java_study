# equals和hashcode的作用

## equals
- **EqualsTest1**：当没有重写equals时，两个对象比较是否为同一个对象；
- **EqualsTest2**：重写equals方法后，两个Person对象的 name 和 age 都相等；

## equals与==
- **==** 是判断两个对象的地址是否相同
- **equals** 判断两个对象是否相同，但分两种情况：
    - **类没有覆盖equals()方法** 则通过equals()比较该类的两个对象时，等价于通过“==”比较这两个对象；
    - **类覆盖了equals()方法** 一般，我们都覆盖equals()方法来两个对象的内容相等；若它们的内容相等，则返回true(即，认为这两个对象相等)。

## hashCode() 的作用
hashCode() 的作用是获取哈希码，也称为散列码；它实际上是返回一个int整数。这个哈希码的作用是确定该对象在哈希表中的索引位置。hashCode() 在散列表中才有用，在其它情况下没用。


## equals和hashcode的关系
- **第一种 不会创建“类对应的散列表”** NormalHashCodeTest，p1和p2相等的情况下，hashCode()也不一定相等；
- **第二种 会创建“类对应的散列表”** 将对象存放到HashSet, Hashtable, HashMap时，就需要重写equals和hashcode了。ConflictHashCodeTest1类就是没有重写hashcode导致可以set同一个值得对象。




在对象放入HashSet, Hashtable, HashMap时， 在这种情况下，该类的“hashCode() 和 equals() ”是有关系的：
1. 如果两个对象相等，那么它们的hashCode()值一定相同。这里的相等是指，通过equals()比较两个对象时返回true。
2. 如果两个对象hashCode()相等，它们并不一定相等。 因为在散列表中，hashCode()相等，即两个键值对的哈希值相等。然而哈希值相等，并不一定能得出键值对相等。补充说一句：“两个不同的键值对，哈希值相等”，这就是哈希冲突。

参考：http://www.cnblogs.com/skywang12345/p/3324958.html



