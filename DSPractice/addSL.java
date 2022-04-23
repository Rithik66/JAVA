public class addSL {
    static Node head;
    static Node tail; 
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
    public static void add(int data){
        Node f4 =new Node(data);
        if(head==null){
            head=f4;
            tail=f4;
        }
        else{
            tail.next=f4;
            tail=f4;
        }
    }
    public static void main(String[] args) {
        Node f1 = new Node(10);
        Node s2 = new Node(20);
        Node t3 = new Node(30);

        head=f1;
        tail=t3;
        f1.next=s2;
        s2.next=t3;
        add(40);
        add(50);
        add(60);
        display();
    }
}
