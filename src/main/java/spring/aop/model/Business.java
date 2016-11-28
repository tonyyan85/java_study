package spring.aop.model;

/**
 * ҵ���߼���
 */
public class Business implements IBusiness, IBusiness2 {

    @Override
    public boolean doSomeThing() {
        System.out.println("ִ��ҵ���߼�");
        return true;
    }

    @Override
    public void doSomeThing2() {
        String s = "ִ��ҵ���߼�2";
        System.out.println(s);
    }

    public static void main(String[] args) {
        Business h = new Business();
        h.doSomeThing2();
        h.doSomeThing();
    }

}
