package DesignPattern.decorator;

/**
 * Created by czadmin on 2016/11/23.
 * 具体的项目经理A
 */
public class ManagerA extends Manager{

    public ManagerA(Project project) {
        super(project);
    }

    /**
     * 项目经理自己的事情：做早期工作
     */
    public void doEarlyWork() {
        System.out.println("项目经理A 在做需求分析");
        System.out.println("项目经理A 在做架构设计");
        System.out.println("项目经理A 在做详细设计");
    }
}
