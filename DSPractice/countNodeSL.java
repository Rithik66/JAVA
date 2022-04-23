public class countNodeSL{
    static Node head; // 
    static class Node{
        Node next;
        int data;
        Node(int data){
            this.data=data;
            next=null;
        }
    }
    public static void display(){
        Node n=head;
        while(n!=null){
            System.out.print(n.data+" -> ");
            n=n.next;
        }
        System.out.println("null");
    }
    static void count(){
        int count=0;
        Node n=head;
        while(n!=null){
            count++;
            n=n.next;
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        Node f1 = new Node(10);
        Node s2 = new Node(20);
        Node t3 = new Node(30);

        head=f1;
        f1.next=s2;
        s2.next=t3;
        display();
        count();
    }
}
