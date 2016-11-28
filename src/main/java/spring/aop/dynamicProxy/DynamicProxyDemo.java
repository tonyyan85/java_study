package spring.aop.dynamicProxy;

import spring.aop.model.Business;
import spring.aop.model.IBusiness;
import spring.aop.model.IBusiness2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ʹ�ö�̬����ʵ��AOP��Demo��ʾ
 * 
 * @author tengfei.fangtf
 */
public class DynamicProxyDemo {

public static void main(String[] args) {
    aop();
}

public static void aop() {
    //��Ҫ����Ľӿڣ���������ʵ�ֵĶ���ӿڶ����������ﶨ��
    Class[] proxyInterface = new Class[] { IBusiness.class, IBusiness2.class };
    //����AOP��Advice
    LogInvocationHandler handler = new LogInvocationHandler(new Business());
    //���ɴ�������������
    ClassLoader classLoader = DynamicProxyDemo.class.getClassLoader();
    //���ɴ�����
    IBusiness2 proxyBusiness = (IBusiness2) Proxy.newProxyInstance(classLoader, proxyInterface, handler);
    //ʹ�ô������ʵ�������÷�����
    proxyBusiness.doSomeThing2();
    ((IBusiness) proxyBusiness).doSomeThing();
}



/**
 * ��ӡ��־������
 */
public static class LogInvocationHandler implements InvocationHandler {

    public Object target; //Ŀ�����

    LogInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //ִ��ԭ���߼�
        Object rev = method.invoke(target, args);
        //ִ��֯�����־
        if (method.getName().equals("doSomeThing")) {
            System.out.println("��̬�����¼��־");
        }
        return rev;
    }
}

}
