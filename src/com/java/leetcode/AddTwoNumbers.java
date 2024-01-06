package com.java.leetcode;

public class AddTwoNumbers
{
	
	public static void main(String[] args)
	{
		
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
		ListNode node =new ListNode();
		Integer number_l1 = node.fetchNumber(l1);
		Integer number_l2 = node.fetchNumber(l2);

		return null;
	}



	public class ListNode 
	{
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }

		/**
		 * 
		 * @param node
		 * @return
		 */
		Integer getListLength(ListNode node)
		{
			Integer len=0;
			if(node!=null)
			{
				while(node !=null)
				{
					len++;
					node=node.next;
				}
			}
			return len;
		}

		/**
		 * 
		 * 
		 * @param node
		 * @param length
		 * @return
		 */
		Integer fetchNumber(ListNode node)
		{
			Integer number=0;
			Integer multiplier = 1;
			
			while(node != null)
			{
				number = number + (node.val*multiplier);
				multiplier = multiplier*10;
			}
			return number;
		}
		
		/**
		 * 
		 * 
		 * @param number
		 * @return
		 */
		ListNode generateList(Integer number)
		{
			
			return null;
		}
	}
}
