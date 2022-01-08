package utils;

public class ListNode{
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public static void print(ListNode head){  while(head!=null) {System.out.print(head.val+"->"); head=head.next;} }   
}
