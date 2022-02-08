
public class MyStringBuilder
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

	// Create a new MyStringBuilder initialized with the chars in String s
	// Note: This method is implemented for you.  See A2Help.java
	public MyStringBuilder(String s) {
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
			CNode currNode = firstC;
			// Create remaining nodes, copying from String.  Note
			// how each new node is simply added to the end of the
			// previous one.  Trace this to see what is going on.
			for (int i = 1; i < s.length(); i++)
			{
				CNode newNode = new CNode(s.charAt(i));
				currNode.next = newNode;
				currNode = newNode;
				length++;
			}
			lastC = currNode;
		}
	}

	// Create a new MyStringBuilder initialized with the chars in array s
	public MyStringBuilder(char [] s)
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
			CNode currNode = firstC;
			// Create remaining nodes, copying from char array.  Note
			// how each new node is simply added to the end of the
			// previous one.  Trace this to see what is going on.
			for (int i = 1; i < s.length; i++)
			{
				CNode newNode = new CNode(s[i]);
				currNode.next = newNode;
				currNode = newNode;
				length++;
			}
			lastC = currNode;
		}
	}

	// Copy constructor -- make a new MyStringBuilder from an old one.  Be sure
	// that you make new nodes for the copy.
	public MyStringBuilder(MyStringBuilder old)
	{
		if (old.firstC == null) {
			firstC = null;
			lastC = null;
			length = 0;
		} else {
			firstC = new CNode(old.firstC.data);
			length = 1;
			CNode currNode = firstC;

			for (int i = 1; i < old.length; i++) {
				CNode newNode = new CNode(old.charAt(i));
				currNode.next = newNode;
				currNode = newNode;
				length++;
			}
			lastC = currNode;

		}
	}

	// Create a new empty MyStringBuilder
	public MyStringBuilder()
	{
		firstC = null;
		lastC = null;
		length = 0;
	}

	// Return the entire contents of the current MyStringBuilder as a String
	// For this method you should do the following:
	// 1) Create a character array of the appropriate length
	// 2) Fill the array with the proper characters from your MyStringBuilder
	// 3) Return a new String using the array as an argument, or
	//    return new String(charArray);
	// Note: This method is implemented for you.  See A2Help.java
	public String toString() {
		char [] c = new char[length];  // Make array of correct size
		int i = 0;
		CNode currNode = firstC;
		while (currNode != null)   	// Iterate through the MyStringBuilder
		{							// putting the characters into the
			c[i] = currNode.data;	// correct positions in the array
			i++;
			currNode = currNode.next;
		}
		return new String(c);	// return a new String from the array
	}

	// Append MyStringBuilder b to the end of the current MyStringBuilder, and
	// return the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(MyStringBuilder b)
	{
		if (b.length == 0 || b.firstC == null) {return this;}
		else {
			CNode currNode = lastC;
			CNode newNode = b.firstC;
			while (newNode != null) {
				currNode.next = new CNode(newNode.data);
				currNode = currNode.next;
				newNode = newNode.next;
				length++;
			}
			lastC = currNode;
			return this;
		}


	}

	// Append String s to the end of the current MyStringBuilder, and return
	// the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(String s)
	{
		if (s.length() == 0) {return this;}

		int i = 0;
		//special case of empty stringbuilder
		if (firstC == null) {
			firstC = new CNode(s.charAt(i++));
			lastC = firstC;
			length++;
		}

		for (; i < s.length(); i++) {
			append(s.charAt(i)); //corrects for length increase and changes lastC
		}
		return this;
	}

	// Append char array c to the end of the current MyStringBuilder, and
	// return the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(char [] c)
	{
		if (c.length == 0) {return this;}

		int i = 0;
		//special case of empty stringbuilder
		if (firstC == null) {
			firstC = new CNode(c[i++]);
			lastC = firstC;
			length++;
		}
		for (; i < c.length; i++) {
			append(c[i]); //corrects for length increase and changes lastC
		}
		return this;
	}

	// Append char c to the end of the current MyStringBuilder, and
	// return the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(char c)
	{
		if (firstC == null) {
			firstC = new CNode(c);
			lastC = firstC;
			length++;
			return this;
		}
		lastC.next = new CNode(c);
		length++;
		lastC = lastC.next;
		return this;
	}

	// Return the character at location "index" in the current MyStringBuilder.
	// If index is invalid, throw an IndexOutOfBoundsException.
	public char charAt(int index)
	{
		if (length == 0 || index > length - 1) {throw new IndexOutOfBoundsException();}
		CNode currNode = firstC;
		for (int i = 0; i < index; i++) {
			currNode = currNode.next;
		}
		return currNode.data;
	}

	// Delete the characters from index "start" to index "end" - 1 in the
	// current MyStringBuilder, and return the current MyStringBuilder.
	// If "start" is invalid or "end" <= "start" do nothing (just return the
	// MyStringBuilder as is).  If "end" is past the end of the MyStringBuilder,
	// only remove up until the end of the MyStringBuilder. Be careful for
	// special cases!
	public MyStringBuilder delete(int start, int end)
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

		//if the start is index 0, we make firstC = firstC.next repeatedly
		if (start == 0) {
			for (int i = 0; i < end; i++) {
				firstC = firstC.next;
				length--;
			}
			return this;
		}

		CNode segEndNode = firstC, segStartNode;

		for (int i = 0; i < start -1; i++) {
			segEndNode = segEndNode.next;
		}
		segStartNode = segEndNode.next;
		for (int i = start; i < end; i++) {
			segStartNode = segStartNode.next;
			length--;
		}
		segEndNode.next = segStartNode;
		return this;
	}

	// Delete the character at location "index" from the current
	// MyStringBuilder and return the current MyStringBuilder.  If "index" is
	// invalid, do nothing (just return the MyStringBuilder as is).
	// Be careful for special cases!
	public MyStringBuilder deleteCharAt(int index)
	{
		if (index < 0 || index >= length) {return this;}
		if (index == 0) {
			firstC = firstC.next;
			length--;
			return this;
		}


		CNode priorNode = firstC;
		for (int i = 0; i < index - 1; i++) {
			priorNode = priorNode.next;
		}
		try {
			priorNode.next = priorNode.next.next;
		} catch (Exception e) {
			priorNode.next = null;
			lastC = priorNode;
		}
		length--;

		return this;
	}

	// Find and return the index within the current MyStringBuilder where
	// String str first matches a sequence of characters within the current
	// MyStringBuilder.  If str does not match any sequence of characters
	// within the current MyStringBuilder, return -1.  Think carefully about
	// what you need to do for this method before implementing it.
	public int indexOf(String str)
	{

		if (str.length() == 0) {return -1;}
		//check if each char is the char at start of string and go from there idk LOL
		CNode currNode = firstC;
		for (int i = 0; i <= length - str.length(); i++) {
			if (currNode.data == str.charAt(0)) {

				CNode innerNode = currNode.next;
				boolean isStr = true;

				//iterate over length of the string and see if the SB matches
				for (int j = 1; j < str.length() && isStr; j++) {
					if (innerNode.data == str.charAt(j)) {
						innerNode = innerNode.next;
					} else {
						isStr = false;
					}
				} // for 2
				if (isStr) {return i;}

			} //check against first char
			currNode = currNode.next;
		} //for 1
		return -1;
	}

	// Insert String str into the current MyStringBuilder starting at index
	// "offset" and return the current MyStringBuilder.  if "offset" ==
	// length, this is the same as append.  If "offset" is invalid
	// do nothing.
	public MyStringBuilder insert(int offset, String str)
	{
		if (offset < 0 || offset > length) {return this;}
		if (offset == length) {
			return append(str);
		}

		CNode strFNode = new CNode(str.charAt(0)), lastNode = strFNode;
		for (int i = 1; i < str.length(); i++) {
			lastNode.next = new CNode(str.charAt(i));
			lastNode = lastNode.next;
		}

		if (offset == 0) {
			lastNode.next = firstC;
			firstC = strFNode;
			length += str.length();
			return this;
		}

		CNode currNode = firstC, tempNode;
		for (int i = 0; i < offset - 1; i++) {
			currNode = currNode.next;
		}

		tempNode = currNode.next;
		currNode.next = strFNode;
		lastNode.next = tempNode;
		length += str.length();
		return this;
	}

	// Insert character c into the current MyStringBuilder at index
	// "offset" and return the current MyStringBuilder.  If "offset" ==
	// length, this is the same as append.  If "offset" is invalid,
	// do nothing.
	public MyStringBuilder insert(int offset, char c)
	{
		if (offset < 0 || offset > length) {return this;}
		if (offset == length) {
			return append(c);
		}

		if (offset == 0) {
			CNode newNode = new CNode(c,firstC);
			firstC = newNode;
			length++;
			return this;
		}

		CNode currNode = firstC;
		for (int i = 0; i < offset - 1; i++) {
			currNode = currNode.next;
		}
		CNode tempNode = currNode.next;
		currNode.next = new CNode(c,tempNode);
		length++;
		return this;



	}

	// Insert char array c into the current MyStringBuilder starting at index
	// index "offset" and return the current MyStringBuilder.  If "offset" is
	// invalid, do nothing.
	public MyStringBuilder insert(int offset, char [] c)
	{
		if (offset < 0 || offset > length) {return this;}
		if (offset == length) {
			return append(c);
		}

		CNode cFNode = new CNode(c[0]), lastNode = cFNode;
		for (int i = 1; i < c.length; i++) {
			lastNode.next = new CNode(c[i]);
			lastNode = lastNode.next;
		}

		if (offset == 0) {
			lastNode.next = firstC;
			firstC = cFNode;
			length += c.length;
			return this;
		}

		CNode currNode = firstC, tempNode;
		for (int i = 0; i < offset - 1; i++) {
			currNode = currNode.next;
		}

		tempNode = currNode.next;
		currNode.next = cFNode;
		lastNode = tempNode;
		length += c.length;
		return this;
	}

	// Return the length of the current MyStringBuilder
	public int length()
	{
		return length;
	}

	// Delete the substring from "start" to "end" - 1 in the current
	// MyStringBuilder, then insert String "str" into the current
	// MyStringBuilder starting at index "start", then return the current
	// MyStringBuilder.  If "start" is invalid or "end" <= "start", do nothing.
	// If "end" is past the end of the MyStringBuilder, only delete until the
	// end of the MyStringBuilder, then insert.  This method should be done
	// as efficiently as possible.  In particular, you may NOT simply call
	// the delete() method followed by the insert() method, since that will
	// require an extra traversal of the linked list.
	public MyStringBuilder replace(int start, int end, String str)
	{
		if (start < 0 || start >= length || end <= start) {return this;}

		if (end > length) {
			end = length;
		}

		//create sublist made of string elements
		CNode strFNode = new CNode(str.charAt(0)), lastNode = strFNode;
		for (int i = 1; i < str.length(); i++) {
			lastNode.next = new CNode(str.charAt(i));
			lastNode = lastNode.next;
		}

		if (end > length) {
			end = length;
		}

		if (end - start >= length) {
			firstC = strFNode;
			lastC = lastNode;
			length = str.length();
		}

		else if (start == 0) {
			for (int i = 0; i < end; i++) {
				firstC = firstC.next;
				length--;
			}
			//insert
			lastNode.next = firstC;
			firstC = strFNode;
			length += str.length();

		} else {
			CNode segEndNode = firstC, segStartNode;

			for (int i = 0; i < start -1; i++) {
				segEndNode = segEndNode.next;
			}
			segStartNode = segEndNode.next;
			for (int i = start; i < end; i++) {
				segStartNode = segStartNode.next;
				length--;
			}
			segEndNode.next = strFNode;
			lastNode.next = segStartNode;
			length += str.length();
		}
		return this;






	}

	// Reverse the characters in the current MyStringBuilder and then
	// return the current MyStringBuilder.
	public MyStringBuilder reverse()
	{
		CNode currNode = new CNode(firstC.data), iteratorNode = firstC.next, lastC = currNode;
		for (int i = 1; i < length; i++) {
			CNode tempNode = new CNode(iteratorNode.data, currNode);
			currNode = tempNode;
			iteratorNode = iteratorNode.next;
		}
		firstC = currNode;
		return this;
	}

	// Return as a String the substring of characters from index "start" to
	// index "end" - 1 within the current MyStringBuilder.  For this method
	// you should do the following:
	// 1) Create a character array of the appropriate length
	// 2) Fill the array with the proper characters from your MyStringBuilder
	// 3) Return a new String using the array as an argument, or
	//    return new String(charArray);
	public String substring(int start, int end)
	{
		char[] chararr = new char[end - start];

		CNode currNode = firstC;
		for (int i = 0; i < start; i++) {
			currNode = currNode.next;
		}
		for (int i = 0; i < end - start; i++) {
			chararr[i] = currNode.data;
			currNode = currNode.next;
		}
		return new String(chararr);
	}

	// You must use this inner class exactly as specified below.  Note that
	// since it is an inner class, the MyStringBuilder class MAY access the
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
