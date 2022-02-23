package com.shama.datastructures.LeetCode.LinkedList;

public class AddTwoNum {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int data) {
            this.val = data;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy_head = new ListNode(0);
        ListNode l3 = dummy_head;

        int carry =0;
        while(l1!= null || l2 != null){
            int l1_val = (l1 != null)? l1.val :0;
            int l2_val = (l2 != null)? l2.val :0;

            int current_sum = l1_val + l2_val + carry;
            carry = current_sum /10;
            int last_digit = current_sum % 10;

            ListNode new_node = new ListNode(last_digit);
            l3.next = new_node;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            l3 = l3.next;
        }
        if(carry >0){
            ListNode new_node = new ListNode(carry);
            l3.next = new_node;
            l3 = l3.next;
        }
        return dummy_head.next;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int v1 =0, v2 = 0, sum = 0, carry = 0;
        ListNode sumHead = new ListNode(0);
        ListNode ptr = sumHead;
        while(l1 != null || l2 != null){
            if(l1 != null){
                v1 = l1.val;
                l1 = l1.next;
            }else{
                v1=0;
            }
            if(l2 != null){
                v2 = l2.val;
                l2 = l2.next;
            }else{
                v2=0;
            }
            sum = v1 + v2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode temp = new ListNode(sum);
            ptr.next = temp;
            ptr = ptr.next;
        }

        if(carry != 0){
            ListNode temp = new ListNode(carry);
            ptr.next = temp;

        }
        return sumHead.next;
    }
}
