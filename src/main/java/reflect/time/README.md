- 这里的类是通过反射得到方法的运行效率；
- 如果使用spring的话，有两种方法：
    - 使用MethodInterceptor进行拦截；
    - 使用原始aop进行拦截

**使用MethodInterceptor**
http://blog.csdn.net/indieinside/article/details/39370493
http://blog.csdn.net/gameover8080/article/details/7714343
```
import javax.servlet.http.HttpServletRequest;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.qunar.wireless.ugc.controllor.web.LoginRequired;

/**
 * @author tao.zhang
 * @create-time 2012-2-31
 */
public class LoginRequiredInterceptor1 implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {

        Object[] ars = mi.getArguments();

        for(Object o :ars){
            if(o instanceof HttpServletRequest){
               System.out.println("------------this is a HttpServletRequest Parameter------------ ");
            }
        }
        // 判断该方法是否加了@LoginRequired 注解
        if(mi.getMethod().isAnnotationPresent(LoginRequired.class)){
             System.out.println("----------this method is added @LoginRequired-------------------------");
        }

       //执行被拦截的方法，切记，如果此方法不调用，则被拦截的方法不会被执行。
        return mi.proceed();
    }
}
```
```
<bean id="springMethodInterceptor" class="com.qunar.wireless.ugc.interceptor.LoginRequiredInterceptor1" ></bean>
<aop:config>
             <!--切入点-->
             <aop:pointcut id="loginPoint"
             expression="execution(public * com.qunar.wireless.ugc.controllor.web.*.*(..)) "/>
             <!--在该切入点使用自定义拦截器-->
             <aop:advisor pointcut-ref="loginPoint" advice-ref="springMethodInterceptor"/>
  </aop:config>
```

**传统AOP**
http://blog.csdn.net/andymu077/article/details/6780850
```
<bean id="testLog" class="chen.hui.log.MyLog"></bean> <!--将日志类注入到bean中。-->
<aop:config>
    <aop:aspect id="b" ref="testLog"><!--调用日志类-->
        <aop:pointcut id="log" expression="execution(* chen.hui.log.*.*(..))"/><!--配置在log包下所有的类在调用之前都会被拦截-->
        <aop:before pointcut-ref="log" method="before"/><!--在log包下面所有的类的所有方法被调用之前都调用MyLog中的before方法-->
        <aop:after pointcut-ref="log" method="after"/>><!--在log包下面所有的类的所有方法被调用之前都调用MyLog中的after方法-->
    </aop:aspect>
</aop:config>
```

## AOP
AOP概念

让我们从定义一些重要的AOP概念开始。

- 方面（Aspect）：一个关注点的模块化，这个关注点实现可能另外横切多个对象。事务管理是J2EE应用中一个很好的横切关注点例子。方面用Spring的Advisor或拦截器实现。
- 连接点（Joinpoint）：程序执行过程中明确的点，如方法的调用或特定的异常被抛出。
- 通知（Advice）：在特定的连接点，AOP框架执行的动作。各种类型的通知包括“around”、“before”和“throws”通知。通知类型将在下面讨论。许多AOP框架包括Spring都是以拦截器做通知模型，维护一个“围绕”连接点的拦截器链。
- 切入点（Pointcut）：指定一个通知将被引发的一系列连接点的集合。AOP框架必须允许开发者指定切入点，例如，使用正则表达式。
- 引入（Introduction）：添加方法或字段到被通知的类。Spring允许引入新的接口到任何被通知的对象。例如，你可以使用一个引入使任何对象实现IsModified接口，来简化缓存。
- 目标对象（Target Object）：包含连接点的对象，也被称作被通知或被代理对象。
- AOP代理（AOP Proxy）：AOP框架创建的对象，包含通知。在Spring中，AOP代理可以是JDK动态代理或CGLIB代理。
- 编织（Weaving）：组装方面来创建一个被通知对象。这可以在编译时完成（例如使用AspectJ编译器），也可以在运行时完成。Spring和其他纯Java AOP框架一样，在运行时完成织入。

各种通知类型包括：

- Around通知：包围一个连接点的通知，如方法调用。这是最强大的通知。Aroud通知在方法调用前后完成自定义的行为，它们负责选择继续执行连接点或通过返回它们自己的返回值或抛出异常来短路执行。
- Before通知：在一个连接点之前执行的通知，但这个通知不能阻止连接点前的执行（除非它抛出一个异常）。
- Throws通知：在方法抛出异常时执行的通知。Spring提供强制类型的Throws通知，因此你可以书写代码捕获感兴趣的异常（和它的子类），不需要从Throwable或Exception强制类型转换。
- After returning通知：在连接点正常完成后执行的通知，例如，一个方法正常返回，没有抛出异常。