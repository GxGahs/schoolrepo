package assignment3;



//import assignment2.MyStringBuilder.CNode;

//CS 0445 Fall 2020
//Read this class and its comments very carefully to make sure you implement
//the class properly.  The data and public methods in this class are identical
//to those in MyStringBuilder, with the exception of the two additional methods
//shown at the end.  You cannot change the data or add any instance
//variables.  However, you may (and will need to) add some private methods.
//No iteration (i.e. no loops) is allowed in this implementation. 

//For more details on the general functionality of most of these methods, 
//see the specifications of the similar method in the StringBuilder class.  
public class MyStringBuilder2
{
	// These are the only three instance variables you are allowed to have.
	// See details of CNode class below.  In other words, you MAY NOT add
	// any additional instance variables to this class.  However, you may
	// use any method variables that you need within individual methods.
	// But remember that you may NOT use any variables of any other
	// linked list class or of the predefined StringBuilder or 
	// or StringBuffer class in any place in your code.  You may only use the
	// String class where it is an argument or return type in a method.
	private CNode firstC;	// reference to front of list.  This reference is necessary
							// to keep track of the list
	private CNode lastC; 	// reference to last node of list.  This reference is
							// necessary to improve the efficiency of the append()
							// method
	private int length;  	// number of characters in the list

	// You may also add any additional private methods that you need to
	// help with your implementation of the public methods.

	// Create a new MyStringBuilder2 initialized with the chars in String s
	public MyStringBuilder2(String s)
	{
		if (s == null || s.length() == 0) // Special case for empty String
		{					 			  // or null reference
			firstC = null;
			lastC = null;
			length = 0;
		}
		else
		{
			// Create front node to get started
			firstC = new CNode(s.charAt(0));
			length = 1;
			lastC = firstC;
			
			linkNodes(s, s.length()-1);
			
		}
		
	}

	// Create a new MyStringBuilder2 initialized with the chars in array s
	public MyStringBuilder2(char [] s)
	{
		if (s == null || s.length == 0) // Special case for empty String
		{					 			  // or null reference
			firstC = null;
			lastC = null;
			length = 0;
		}
		else
		{
			// Create front node to get started
			firstC = new CNode(s[0]);
			length = 1;
			lastC = firstC;
			
			linkNodes(s,s.length-1);
		}
	}

	// Copy constructor -- make a new MyStringBuilder2 from an old one.  Be sure
	// that you make new nodes for the copy.
	public MyStringBuilder2(MyStringBuilder2 old)
	{
		if (old.firstC == null) {
			firstC = null;
			lastC = null;
			length = 0;
					
		}
		else {
			firstC = new CNode(old.firstC.data);
			length = 1;
			lastC = firstC;
		}
		linkNodes(old.firstC.next);
	}
	
	// Create a new empty MyStringBuilder2
	public MyStringBuilder2()
	{
		firstC = null;
		lastC = null;
		length = 0;
	}
	
	private void linkNodes(String s, int length) {
		if (length <= 0) {
			return;
		}
		
		CNode curr = new CNode(s.charAt(s.length() - length));
		lastC.next = curr;
		lastC = curr;
		this.length++;
		linkNodes(s,length-1);
		return;
	}
	
	private void linkNodes(char[] s, int length) {
		if (length <= 0) {
			return;
		}
		
		CNode curr = new CNode(s[s.length - length]);
		lastC.next = curr;
		lastC = curr;
		this.length++;
		linkNodes(s,length-1);
		return;
	}
	
	private void linkNodes(CNode currNode) {
		if (currNode == null) {
			return;
		}
		else {
			lastC.next = new CNode(currNode.data);
			lastC = lastC.next;
			this.length++;
			linkNodes(currNode.next);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	

	// Append MyStringBuilder2 b to the end of the current MyStringBuilder2, and
	// return the current MyStringBuilder2.  Be careful for special cases!
	public MyStringBuilder2 append(MyStringBuilder2 b)
	{
		if (b.length == 0 || b.firstC == null) {return this;}
		else {
			appendNodesMSB2(b.firstC);
			return this;
		}
	}


	// Append String s to the end of the current MyStringBuilder2, and return
	// the current MyStringBuilder2.  Be careful for special cases!
	public MyStringBuilder2 append(String s)
	{
		if (s.length() == 0) {return this;}
		else {
			appendNodesS(s);
			return this;
		}
	}

	// Append char array c to the end of the current MyStringBuilder2, and
	// return the current MyStringBuilder2.  Be careful for special cases!
	public MyStringBuilder2 append(char [] c)
	{
		if (c.length == 0) {return this;}
		else {
			String s = new String(c);
			appendNodesS(s);
			return this;
		}
	}

	// Append char c to the end of the current MyStringBuilder2, and
	// return the current MyStringBuilder2.  Be careful for special cases!
	public MyStringBuilder2 append(char c)
	{
		if (firstC == null) {
			firstC = new CNode(c);
			lastC = firstC;
			length++;
			return this;
		}
		else {
			lastC.next = new CNode(c);
			this.length++;
			lastC = lastC.next;
			return this;
		}
	}
	
	private void appendNodesMSB2(CNode currNode) {
		if (currNode == null) {
			return;
		}
		else {
			lastC.next = currNode;
			length++;
			lastC = lastC.next;
			appendNodesMSB2(currNode.next);
		}
	}
	
	private void appendNodesS(String s) {
		if (s.length() == 0) {
			return;
		}
		else {
			if (lastC == null) {
				firstC = new CNode(s.charAt(0));
				lastC = firstC;
				this.length++;
			}
			else {
				lastC.next = new CNode(s.charAt(0));
				lastC = lastC.next;
				this.length++;
			}
			appendNodesS(s.substring(1));
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	// Return the character at location "index" in the current MyStringBuilder2.
	// If index is invalid, throw an IndexOutOfBoundsException.
	public char charAt(int index)
	{
		if (index >= length || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		else {
			return locateChar(index, firstC);
		}
	}
	
	private char locateChar(int i, CNode currNode) {
		if (i == 0) {
			return currNode.data;
		}
		else {
			return locateChar(i-1, currNode.next);
		}
	}

	// Delete the characters from index "start" to index "end" - 1 in the
	// current MyStringBuilder2, and return the current MyStringBuilder2.
	// If "start" is invalid or "end" <= "start" do nothing (just return the
	// MyStringBuilder2 as is).  If "end" is past the end of the MyStringBuilder2, 
	// only remove up until the end of the MyStringBuilder2. Be careful for 
	// special cases!
	public MyStringBuilder2 delete(int start, int end)
	{
		if (start < 0 || start >= length || end <= start) {
			return this;
		}
		if (end > length) {
			end = length;
		}
		if (end - start >= length) {
			firstC = null;
			lastC = null;
			length = 0;
			return this;
		}
		if (start == 0) {
			deleteNodesFromStart(end,0);
		}
		else {
			CNode tailNode = firstC;
			deleteNodes(start, end, 1, tailNode);
		}
		return this;
		
		
	}
	
	private void deleteNodesFromStart(int end, int counter) {
		if (counter < end) {
			firstC = firstC.next;
			length--;
			deleteNodesFromStart(end,++counter);
		}
		else {
			return;
		}
	}
	private void deleteNodes(int start, int end, int counter, CNode tail) {
		if (counter >= start && counter < end) {
			try {
				tail.next = tail.next.next;
			} catch (Exception e) {
				tail.next = null;
			}
			length--;
			deleteNodes(start, end, ++counter, tail);
		}
		else if (counter == end) {
			if (tail.next == null) {
				lastC = tail;
			}
			return;
		}
		else {
			deleteNodes(start, end, ++counter, tail.next);
		}
	}

	// Delete the character at location "index" from the current
	// MyStringBuilder2 and return the current MyStringBuilder2.  If "index" is
	// invalid, do nothing (just return the MyStringBuilder2 as is).
	// Be careful for special cases!
	public MyStringBuilder2 deleteCharAt(int index)
	{
		if (index < 0 || index >= length) {return this;}
		if (index == 0) {
			firstC = firstC.next;
			length--;
			return this;
		}
		deleteChar(firstC, index, 1);
		return this;
	}
	
	private void deleteChar(CNode curr, int index, int counter) {
		if (counter == index) {
			try {
				curr.next = curr.next.next;
			} catch (Exception e) {
				curr.next = null;
				lastC = curr;
			}
			length--;
		}
		else {
			deleteChar(curr.next, index, ++counter);
		}
	}

	// Find and return the index within the current MyStringBuilder2 where
	// String str first matches a sequence of characters within the current
	// MyStringBuilder2.  If str does not match any sequence of characters
	// within the current MyStringBuilder2, return -1.  Think carefully about
	// what you need to do for this method before implementing it.
	public int indexOf(String str)
	{
		if (str.length() == 0) {return -1;}
		
		return doesStringExist(firstC, str, 0);
	}
	
	private int doesStringExist(CNode curr, String str, int index) {
		
		if (index + str.length() > this.length) {
			return -1;
		}
		
		if (curr.data == str.charAt(0)) {
			if (substring(index, index + str.length()).equals(str)) {
				return index;
			}
			else {
				return doesStringExist(curr.next, str, ++index);
			}
		}
		else {
			return doesStringExist(curr.next, str, ++index);
		}
		
	}

	// Insert String str into the current MyStringBuilder2 starting at index
	// "offset" and return the current MyStringBuilder2.  if "offset" == 
	// length, this is the same as append.  If "offset" is invalid
	// do nothing.
	public MyStringBuilder2 insert(int offset, String str)
	{
		if (offset == this.length) {
			append(str);
			return this;
		}
		else if (offset == 0) {
			CNode newFirstNode = new CNode(str.charAt(0));
			this.length++;
			addNodes(newFirstNode, str.substring(1)).next = firstC;
			firstC = newFirstNode;
			return this;
			
		}
		else {
			CNode offsetNode = findOffsetNode(offset, firstC);
			System.out.println(offsetNode.data);
			CNode headNode = offsetNode.next;
			addNodes(offsetNode, str).next = headNode;
			return this;
		}
		
	}

	// Insert character c into the current MyStringBuilder2 at index
	// "offset" and return the current MyStringBuilder2.  If "offset" ==
	// length, this is the same as append.  If "offset" is invalid, 
	// do nothing.
	public MyStringBuilder2 insert(int offset, char c)
	{
		if (offset == this.length) {
			append(c);
			return this;
		}
		else if (offset == 0) {
			CNode newFirstNode = new CNode(c, firstC);
			this.length++;
			firstC = newFirstNode;
			return this;
		}
		else {
			CNode offsetNode = findOffsetNode(offset, firstC);
			CNode headNode = offsetNode.next;
			this.length++;
			offsetNode.next = new CNode(c,headNode);
			return this;
		}
		
	}

	// Insert char array c into the current MyStringBuilder2 starting at index
	// index "offset" and return the current MyStringBuilder2.  If "offset" is
	// invalid, do nothing.
	public MyStringBuilder2 insert(int offset, char [] c)
	{
		String str = new String(c);
		if (offset == this.length) {
			append(c);
			return this;
		}
		
		else if (offset == 0) {
			CNode newFirstNode = new CNode(str.charAt(0));
			this.length++;
			addNodes(newFirstNode, str.substring(1)).next = firstC;
			firstC = newFirstNode;
			return this;
			
		}
		else {
			CNode offsetNode = findOffsetNode(offset, firstC);
			System.out.println(offsetNode.data);
			CNode headNode = offsetNode.next;
			addNodes(offsetNode, str).next = headNode;
			return this;
		}
	}
	
	private CNode findOffsetNode(int offset, CNode curr) {
		if ( offset == 1) {
			return curr;
		}
		else {
			
			return findOffsetNode(--offset, curr.next);
		}
	}
	
	private CNode addNodes(CNode curr, String str) {
		if (str.length() == 0) {
			return curr;
		}
		else {
			curr.next = new CNode(str.charAt(0));
			this.length++;
			return addNodes(curr.next, str.substring(1));
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	// Return the length of the current MyStringBuilder2
	public int length()
	{
		return this.length;
	}

	// Delete the substring from "start" to "end" - 1 in the current
	// MyStringBuilder2, then insert String "str" into the current
	// MyStringBuilder2 starting at index "start", then return the current
	// MyStringBuilder2.  If "start" is invalid or "end" <= "start", do nothing.
	// If "end" is past the end of the MyStringBuilder2, only delete until the
	// end of the MyStringBuilder2, then insert.  This method should be done
	// as efficiently as possible.  In particular, you may NOT simply call
	// the delete() method followed by the insert() method, since that will
	// require an extra traversal of the linked list.
	public MyStringBuilder2 replace(int start, int end, String str)
	{
		if (start < 0 || start >= length || end <= start) {return this;}
	
		if (end > length) {
			end = length;
		}
		
		if (start == 0) {
			deleteNodesFromStart(end, 0);
			CNode newFirstNode = new CNode(str.charAt(0));
			this.length++;
			addNodes(newFirstNode, str.substring(0)).next = firstC;
			firstC = newFirstNode;
			return this;
		}
		
		else {
			CNode tailNode = findOffsetNode(start, firstC);
			System.out.println(tailNode.data);
			
			deleteNodes(start, end, start, tailNode);
			CNode headNode = tailNode.next;
			
			
			addNodes(tailNode, str).next = headNode;
		
			return this;
		}
		
	}

	// Reverse the characters in the current MyStringBuilder2 and then
	// return the current MyStringBuilder2.
	public MyStringBuilder2 reverse()
	{
		if (this.length == 0) {
			return this;
		}
		MyStringBuilder2 newMSB2 = new MyStringBuilder2();
		reverseNodes(firstC, 0);
		return this;
		
	}
	
	private void reverseNodes(CNode curr, int counter) {
		if (curr.next != null) {
			reverseNodes(curr.next, ++counter);
		}
		else {
			firstC = new CNode(curr.data);
			lastC = firstC;
			return;
		}
		
		lastC.next = new CNode(curr.data);
		lastC = lastC.next;
		
		if (counter == 0) {
			lastC = firstC;
		}
		
	}
	
	// Return as a String the substring of characters from index "start" to
	// index "end" - 1 within the current MyStringBuilder2
	public String substring(int start, int end)
	{
		char [] chararr = new char[end - start];
		
		CNode startNode = firstC;
		fillArray(chararr, 0, start, end, startNode);
		return new String(chararr);
	}
	
	private void fillArray(char[] chararr, int counter, int start, int end, CNode curr) {
		if (counter >= start) {
			if (counter == end) {
				return;
			}
			chararr[counter - start] = curr.data;
			fillArray(chararr, ++counter, start, end, curr.next);
		}
		else {
			fillArray(chararr, ++counter, start, end, curr.next);
		}
	}

	// Return the entire contents of the current MyStringBuilder2 as a String
	public String toString()
	{
		char [] c = new char[length];
		int i = 0;
		CNode currNode = firstC;
		c = nodesToCharArray(c, i , currNode);
		return new String(c);
	}
	
	private char[] nodesToCharArray(char[] c, int i, CNode currNode) {
		if (currNode == null) {
			return c;
		}
		else {
			c[i] = currNode.data;
			i++;
			nodesToCharArray(c, i, currNode.next);
		}
		return c;
	}

	// Find and return the index within the current MyStringBuilder2 where
	// String str LAST matches a sequence of characters within the current
	// MyStringBuilder2.  If str does not match any sequence of characters
	// within the current MyStringBuilder2, return -1.  Think carefully about
	// what you need to do for this method before implementing it.  For some
	// help with this see the Assignment 3 specifications.
	public int lastIndexOf(String str)
	{
		//something should probably go here...
		return -1;
	}
	
	// Find and return an array of MyStringBuilder2, where each MyStringBuilder2
	// in the return array corresponds to a part of the match of the array of
	// patterns in the argument.  If the overall match does not succeed, return
	// null.  For much more detail on the requirements of this method, see the
	// Assignment 3 specifications.
	public MyStringBuilder2 [] regMatch(String [] pats)
	{
		/*iterate over the node array, for each character check if it is in 
		if match pattern*/
		
		MyStringBuilder2 MSB2array[] = new MyStringBuilder2[pats.length];
		
		CNode currNode = firstC;
		MyStringBuilder2[] arr = new MyStringBuilder2[1];
		return arr;
		/*
		
		match(int index, CNode currN) {
			if (MSB2array[0].length == 0) {
				
				if (currN == null) {
					return false;
				}
				else if (currN.regularMatches(pats[index])) {
					MSB2array[index].append(currN.data);
					match(index, currN.next);
				}
				else {
					match(index, currN.next);
				}
				
				
				
				
				if (currN.regularMatches(pats[index])) {
					MSB2array[index].append(currN.data);
					
					match(index, currN.next);
				}
				else {
					match(index + 1);
				}
				
			}
			
			else {
				if (currNode.regularMatches(pats[index])) {
					MSB2array[index].append(currNode.data);
					currNode = currNode.next;
					match(index);
				}
			}
		
		
		}*/
		
		
		
		
		
	}
	
	// You must use this inner class exactly as specified below.  Note that
	// since it is an inner class, the MyStringBuilder2 class MAY access the
	// data and next fields directly.
	private class CNode
	{
		private char data;
		private CNode next;

		public CNode(char c)
		{
			data = c;
			next = null;
		}

		public CNode(char c, CNode n)
		{
			data = c;
			next = n;
		}
	}
	
	
}

