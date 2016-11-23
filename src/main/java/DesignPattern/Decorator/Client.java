package DesignPattern.Decorator;

/**
 * 下面通过一个软件项目例子来说明装饰模式的使用
 * 过程是这样的：
 * 项目经理接到一个项目，项目最终要完成编码。
 * 项目经理接到项目后，先做些前期的工作（比如需求分析、设计），然后将编码工作委派给代码工人，代码工人干完后，项目经理做项目的收尾工作。
 * 客户端测试
 */
public class Client {
    public static void main(String args[]) {
        Project employe = new Employe();        //代码工人
        Project managerA = new ManagerA(employe); //项目经理
        Project managerB = new ManagerB(employe); //项目经理
        //以经理的名义将编码完成，功劳都是经理的，实际编码的是工人
        managerA.doCoding();
        managerB.doCoding();
    }
}
