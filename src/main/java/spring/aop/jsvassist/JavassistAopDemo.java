/**
 * Create on 2011-10-13 ����04:29:04 by tengfei.fangtf
 * 
 * Copyright 1999-2100 Alibaba.com Corporation Limited.
 * 
 * All rights reserved.
 */
package spring.aop.jsvassist;

import javassist.*;
import spring.aop.model.Business;

/**
 * ʹ��Javassist��ʾAop��Demo.
 * 
 * @author tengfei.fangtf
 */
public class JavassistAopDemo {

    public static void main(String[] args) throws Exception {
        aop();
    }

    public static void aop() throws NotFoundException, CannotCompileException, InstantiationException, IllegalAccessException {
        //��ȡ���CtClass������ClassPool
        ClassPool cp = ClassPool.getDefault();
//        //����һ���������
//        Loader cl = new Loader();
//        //����һ��ת������������ص�ʱ��
//        cl.addTranslator(cp, new MyTranslator());
//        //����װ�ص�JVM
//        try {
//            cl.run("jsvassist.JavassistAopDemo$MyTranslator", null);
//        } catch (Throwable e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        CtClass cc = cp.get("model.Business");
        //���ָ���������ķ���
        CtMethod m = cc.getDeclaredMethod("doSomeThing");
        //�ڷ���ִ��ǰ�������
        m.insertBefore("{ System.out.println(\"��¼��־\"); }");
        ((Business)cc.toClass().newInstance()).doSomeThing();
        
    }

    public static class MyTranslator implements Translator {

        public void start(ClassPool pool) throws NotFoundException, CannotCompileException {
        }

        /* *
         * ��װ�ص�JVMǰ���д���֯��
         */
        public void onLoad(ClassPool pool, String classname) {
            if (!"model.Business".equals(classname)) {
                return;
            }
            //ͨ��������ȡ���ļ�
            try {
                CtClass cc = pool.get(classname);
                //���ָ���������ķ���
                CtMethod m = cc.getDeclaredMethod("doSomeThing");
                //�ڷ���ִ��ǰ�������
                m.insertBefore("{ System.out.println(\"��¼��־\"); }");
            } catch (NotFoundException e) {
            } catch (CannotCompileException e) {
            }
        }

        public static void main(String[] args) {
            Business b = new Business();
            b.doSomeThing2();
            b.doSomeThing();
        }
    }

}
