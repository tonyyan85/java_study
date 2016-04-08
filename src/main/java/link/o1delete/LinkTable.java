package link.o1delete;

// 删除链表结点要求O(1)时间复杂度

/**
 * 在链表中删除一个结点，最常规的做法是从链表的头结点开始，顺序查找要删除的结点，找到之后再删除。由于需要顺序查找，时间复杂度自然就是O(n)了。

 我们之所以需要从头结点开始查找要删除的结点，是因为我们需要得到要删除的结点的前面一个结点。

 “狸猫换太子法”：可以从给定要删除的结点得到它的下一个结点。这个时候我们实际删除的是它的下一个结点，在删除之前，我们需要需要把给定的结点的下一个结点的数据拷贝到给定的结点中，然后删除该节点的下一个节点。此时，时间复杂度为O(1)。
 */


/**
 * 链表节点类
 */
class Node{
    public String value;
    public Node next;
    public Node(String value){
        this.value=value;
        this.next=null;
    }
}
/**
 * 链表类
 */
public class LinkTable {
    public Node head;
    public LinkTable(Node node){
        this.head=node;
    }
    /**
     * 增加节点
     */
    public void addNode(Node node){
        Node end=head;
        while(end.next!=null){
            end=end.next;
        }
        end.next=node;
    }
    /**
     * 删除节点
     * 时间复杂度为O(1)无需遍历链表元素
     */
    public void delNode(Node node){
        node.value=node.next.value;
        node.next=node.next.next;
    }
    /**
     * 打印链表元素
     */
    public void print(){
        Node index=this.head;
        while(index!=null){
            System.out.print(index.value+"-->");
            index=index.next;
        }
        System.out.println("NULL");
    }

    public static void main(String [] args){
        LinkTable lt=new LinkTable(new Node("中国"));
        lt.addNode(new Node("美国"));
        Node japanNode=new Node("日本");
        lt.addNode(japanNode);
        lt.addNode(new Node("意大利"));
        lt.addNode(new Node("德国"));
        lt.addNode(new Node("荷兰"));
        lt.print();

        lt.delNode(japanNode);
        lt.print();
    }
}

/**
 运行结果：
 中国-->美国-->日本-->意大利-->德国-->荷兰-->NULL
 中国-->美国-->意大利-->德国-->荷兰-->NULL
 */