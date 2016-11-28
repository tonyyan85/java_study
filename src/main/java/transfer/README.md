## 事务

###分布式事务 JTA
http://www.ibm.com/developerworks/cn/java/j-lo-jta/

分布式事务处理 : **Java 事务编程接口（JTA：Java Transaction API**和 **Java 事务服务 (JTS；Java Transaction Service)** 为 J2EE 平台提供了分布式事务服务。分布式事务（Distributed Transaction）包括事务管理器（Transaction Manager）和一个或多个支持 XA 协议的资源管理器 ( Resource Manager )。我们可以将资源管理器看做任意类型的持久化数据存储；事务管理器承担着所有事务参与单元的协调与控制。JTA 事务有效的屏蔽了底层事务资源，使应用可以以透明的方式参入到事务处理中；但是与本地事务相比，XA 协议的系统开销大，在系统开发过程中应慎重考虑是否确实需要分布式事务。若确实需要分布式事务以协调多个事务资源，则应实现和配置所支持 XA 协议的事务资源，如 JMS、JDBC 数据库连接池等。使用 JTA 处理事务的示例如下（注意：connA 和 connB 是来自不同数据库的连接）