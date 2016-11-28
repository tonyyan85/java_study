##spring mvc

http://blog.csdn.net/thinkscape/article/details/45244251

- Joinpoint：拦截点
- pointcut joinpoint的表达式
    - Pointcut接口：含有两个属性ClassFilter（过滤类）、MethodMatcher（过滤方法）
- advice 切入逻辑
    - AdvisorAdapter接口：将上述Advise转化为MethodInterceptor

## 实现形式
- 动态代理
- cglib
- javassist 是一个运行时编译库，他能动态的生成或修改类的字节码