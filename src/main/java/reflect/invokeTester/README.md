### **反射是什么**

**反射机制**简单理解就是指程序在运行的时候能够获取或修改自身信息。如果知道一个类的名称/或者它的一个实例对象， 就能把这个类的所有方法和变量的信息(方法名，变量名，方法，修饰符，类型，方法参数等等所有信息)找出来。如果明确知道这个类里的某个方法名+参数个数 类型，还能通过传递参数来运行那个类里的那个方法，这就是反射。

### **原理概述**
先介绍运行时类型识别。**运行时类型识别(Run-time Type Identification, RTTI)**主要有两种方式，一种是我们在编译时和运行时已经知道了所有的类型，另外一种是功能强大的“反射”机制。

要理解RTTI在Java中的工作原理，首先必须知道类型信息在运行时是如何表示的，这项工作是由“Class对象”完成的，它包含了与类有关的信息。类是程序的重要组成部分，每个类都有一个Class对象，每当编写并编译了一个新类就会产生一个Class对象，它被保存在一个同名的.class文件中。在运行时，当我们想生成这个类的对象时，运行这个程序的Java虚拟机(JVM)会确认这个类的Class对象是否已经加载，如果尚未加载，JVM就会根据类名查找.class文件，并将其载入，一旦这个类的Class对象被载入内存，它就被用来创建这个类的所有对象。一般的RTTI形式包括三种：

 1. 传统的类型转换。如“(Apple)Fruit”，由RTTI确保类型转换的正确性，如果执行了一个错误的类型转换，就会抛出一个ClassCastException异常。
 2. **通过Class对象来获取对象的类型**。如 Class c = Class.forName(“Apple”); Object o = c.newInstance();
 3. 通过关键字instanceof或Class.isInstance()方法来确定对象是否属于某个特定类型的实例，准确的说，应该是instanceof
    / Class.isInstance()可以用来确定对象是否属于某个特定类及其所有基类的实例，这和equals() /
    ==不一样，它们用来比较两个对象是否属于同一个类的实例，没有考虑继承关系。

Class支持反射，java.lang.reflect中包含了Field/Method/Constructor类，每个类都实现了Member接口。这些类型的对象都是由JVM在运行时创建的，用来表示未知类里对应的成员。

 - 可以用Constructor类创建新的对象，用get()和set()方法读取和修改与Field对象关联的字段；
 - 用invoke()方法调用与Method对象关联的方法；
 - 可以调用getFields()、getMethods()、getConstructors()等方法来返回表示字段、方法以及构造器的对象数组。

这样，未知的对象的类信息在运行时就能被完全确定下来，而在编译时不需要知道任何信息。

###**优缺点**
**优点**就是可以实现动态创建对象和编译
**缺点**是对性能有影响。使用反射基本上是一种**解释操作**，我们可以告诉JVM，我们希望做什么并且它满足我们的要求。这类操作总是慢于只**直接执行相同的操作**。

###**Class.forName详解**
>主要功能
Class.forName(xxx.xx.xx)返回的是一个类
Class.forName(xxx.xx.xx)的作用是要求JVM查找并加载指定的类，
也就是说JVM会执行该类的静态代码段

Class.forName(classname)方法,实际上是调用了Class类中的 Class.forName(classname, true, currentLoader)方法。
参数：

 - name - 所需类的完全限定名；
 -  initialize - 是否必须初始化类；
 -  loader - 用于加载类的类加载器。

currentLoader则是通过调用ClassLoader.getCallerClassLoader()获取当前类加载器的。类要想使用，必须用类加载器加载，所以需要加载器。反射机制，不是每次都去重新反射，而是提供了cache，每次都会需要类加载器去自己的cache中查找，如果可以查到，则直接返回该类。

####**new() 和 Class.forName() 区别**
其实上面已经说到一些了，这里来做个总结：
首先，newInstance( )是一个方法，而new是一个关键字；
其次，Class下的newInstance()的使用有局限，因为它生成对象只能调用无参的构造函数，而使用 new关键字生成对象没有这个限制。
简言之：
newInstance(): 弱类型,低效率,只能调用无参构造。
new: 强类型,相对高效,能调用任何public构造。
Class.forName(“”)返回的是类。
Class.forName(“”).newInstance()返回的是object 。

但是使用newInstance时候，就必须保证：1、这个类已经加载；2、这个类已经连接了。而完成上面两个步骤的正是class的静态方法forName（）方法，这个静态方法调用了启动类加载器（就是加载javaAPI的那个加载器）

###**常用方法使用**
Java类反射中所必须的类：
Java的类反射所需要的类并不多，它们分别是：**Field、Constructor、Method、Class、Object**，下面我将对这些类做一个简单的说明。

 - **Field类**：提供有关类或接口的属性的信息，以及对它的动态访问权限。反射的字段可能是一个类（静态）属性或实例属性，简单的理解可以把它看成一个封装反射类的属性的类。
 - **Constructor类**：提供关于类的单个构造方法的信息以及对它的访问权限。这个类和Field类不同，Field类封装了反射类的属性，而Constructor类则封装了反射类的构造方法。
 - **Method类**：提供关于类或接口上单独某个方法的信息。所反映的方法可能是类方法或实例方法（包括抽象方法）。
   这个类不难理解，它是用来封装反射类方法的一个类。
 - **Class类**：类的实例表示正在运行的 Java 应用程序中的类和接口。枚举是一种类，注释是一种接口。每个数组属于被映射为 Class
   对象的一个类，所有具有相同元素类型和维数的数组都共享该 Class 对象。
 - **Object类**：每个类都使用 Object 作为超类。所有对象（包括数组）都实现这个类的方法。

**实例代码**：
```java
import java.lang.reflect.Method;

public class InvokeTester {
    public InvokeTester() {
    }

    String str;

    public InvokeTester(String str) {
        this.str = str;
    }

    public int add(int param1, int param2) {
        return param1 + param2;
    }

    public String echo(String msg) {
        return "echo: " + msg;
    }

    public String getStr() {
        return "one param ctor" + str;
    }

    public static void main(String[] args) throws Exception {
        //直接获取类
        //Class<?> classType = InvokeTester.class;
        //通过完整的类型路径获取类
        Class<?> classType = Class.forName("reflect.invokeTester.InvokeTester");
        //使用newInstance创建对象
        // Object invokeTester = classType.newInstance();
        //使用默认构造函数获取对象
        Object invokeTester = classType.getConstructor(new Class[]{}).newInstance(new Object[]{});
        //获取InvokeTester类的add()方法
        Method addMethod = classType.getMethod("add", new Class[]{int.class, int.class});
        //调用invokeTester对象上的add()方法
        Object result = addMethod.invoke(invokeTester, new Object[]{new Integer(100), new Integer(200)});
        System.out.println((Integer) result);
        //获取InvokeTester类的echo()方法
        Method echoMethod = classType.getMethod("echo", new Class[]{String.class});
        //调用invokeTester对象的echo()方法
        result = echoMethod.invoke(invokeTester, new Object[]{"Hello"});
        System.out.println((String) result);
        //创建有参构造函数的类对象
        Object invokeTester1 = classType.getConstructor(new Class[]{String.class}).newInstance(new Object[]{new String("测试一个带参数的构造调用")});
        //获取方法方式相同
        Method getStrMethod = classType.getMethod("getStr");
        Object str = getStrMethod.invoke(invokeTester1);
        System.out.println(str);
    }
}
```
简单介绍一下Methed方法

 - Method addMethod = classType.**getMethod**("add", new Class[]{int.class,
   int.class}); ：通过methodName和参数的argsClass（方法中的参数类型集合）数组得到要执行的Method。
 - Object result = addMethod.**invoke**(invokeTester, new Object[]{new Integer(100), new Integer(200)});执行该Method.invoke方法的参数是执行这个方法的对象owner，和参数数组args，可以这么理解：owner对象中带有参数args的method方法。返回值是Object，也既是该方法的返回值。


**参考信息**：

 1. [Java反射机制的原理与简单使用](http://www.tuicool.com/articles/zuIN7r)
 2. [Class.forName()用法详解](http://my.oschina.net/u/2331760/blog/599292?p=1)
 3. [学习：java原理—反射机制](http://www.cnblogs.com/forlina/archive/2011/06/21/2085849.html)