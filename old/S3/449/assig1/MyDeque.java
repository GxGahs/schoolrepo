

public class MyDeque<T> implements DequeInterface<T> {

	protected T [] data;
	protected int back;
	protected int size;
	protected int front;

	public MyDeque(int initsize) {

		size = 0;
		back = -1;
		front = 0;
		data = (T []) new Object[initsize];
	}

	public MyDeque (MyDeque original) {
		size = original.size;
		data = (T[]) new Object[original.capacity()];
		front = original.front;

		int currentsize = 0;
		while (currentsize < original.size) {
			data[currentsize] = (T) original.data[front];
			if (++front >= data.length) {
				front = 0;
			}
			currentsize++;
		}
		front = 0;
		back = size -1;
	}

	public void resize() {
		Object[] temp = (T []) new Object[data.length * 2];

		int currentsize = 0;
		while (currentsize < size) {
			temp[currentsize] = data[front];
			if (++front >= data.length) {
				front = 0;
			}
			currentsize++;

		}
		front = 0;
		back = size - 1;

		data = (T[]) temp;
	}

	public void addToFront(Object newEntry) {

		if (size >= data.length) {
			resize();
		}

		if (--front < 0) {
			front = data.length - 1;
		}
		if (back < 0) {
			back = data.length -1;
		}
		data[front] = (T) newEntry;
		size++;

	}


	public void addToBack(Object newEntry) {
		if (size >= data.length) {
			resize();
		}
		if (++back >= data.length) {
			back = 0;
		}
		data[back] = (T) newEntry;
		size++;

	}


	public T removeFront() {
		if (!isEmpty()) {
			Object temp = data[front];

			if (++front >= data.length) {
				front = 0;
			}
			size--;
			return (T) temp;
		}
		return null;
	}


	public T removeBack() {
		if (!isEmpty()) {
			Object temp = data[back];
			data[back] = (T) new Object();
			if (--back < 0) {
				back = data.length - 1;
			}
			size--;
			return (T) temp;
		}
		return null;
	}


	public T getFront() {
		return data[front];
	}


	public T getBack() {
		return data[back];
	}


	public boolean isEmpty() {
		return size == 0;
	}


	public void clear() {
		int i = front - 1;
		do {
			i++;
			if (i < data.length) {
				data[i] = (T) new Object();
			} else {
				i = 0;
			}

		} while (i != back);
	}


	public int size() {
		return size;
	}


	public int capacity() {
		return data.length;
	}

	public String toString() {
		String newstring = "";

		if (isEmpty()) {
			newstring = "Deque is Empty";
			return newstring;
		} else {
			if (front <= back) {
				for (int i = front; i <= back; i++) {
					newstring += data[i].toString() + " ";
				}
			} else {

				int counter = 0;
				int tempFront = front;
				while (counter < size) {
					if (tempFront >= data.length) {
						tempFront = 0;
					}
					newstring += data[tempFront] + " ";
					tempFront++;
					counter++;
				}
			}
		}
		return newstring;
	}

	public boolean equals(MyDeque comp) {

		if (size != comp.size) {
			return false;
		} else {

			int counter = 0, offset1 = front, offset2 = comp.front;
			while (counter < size) {
				if (!data[offset1].equals(comp.data[offset2])) {return false;}

				if (++offset1 >= data.length) {offset1 = 0;}
				if (++offset2 >= comp.data.length) {offset2 = 0;}
				counter++;
			}
		}
		return true;

	}

	public int backIndex() {
		return back;
	}

	public int frontIndex() {
		return front;
	}

}
