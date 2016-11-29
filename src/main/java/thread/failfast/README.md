http://www.cnblogs.com/skywang12345/p/3498483.html

通过“expectedModCount”和“modCount”是否相同来判断Iterator时 数据是否被修改

CopyOnWriteArrayList 解决fail-fastd的原理是
- CopyOnWriteArrayList没有继承于AbstractList，它仅仅只是实现了List接口；
- ArrayList的iterator()函数返回的Iterator是在AbstractList中实现的；而CopyOnWriteArrayList是自己实现Iterator；
- ArrayList的Iterator实现类中调用next()时，会“调用checkForComodification()比较‘expectedModCount’和‘modCount’的大小”；但是，CopyOnWriteArrayList的Iterator实现类中，没有所谓的checkForComodification()，更不会抛出ConcurrentModificationException异常！
- **新建COWIterator时，将集合中的元素保存到一个新的拷贝数组中。**
- **这样，当原始集合的数据改变，拷贝数据中的值也不会变化。**