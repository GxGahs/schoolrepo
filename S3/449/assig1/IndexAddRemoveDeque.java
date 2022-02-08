

public class IndexAddRemoveDeque<T> extends IndexDeque<T> implements IndexableAddRemove<T> {

	public IndexAddRemoveDeque(int initsize) {
		super(initsize);

	}


	public void addToFront(int i, T item) {
		if (i > size()) {
			throw new IndexOutOfBoundsException("Illegal index " + i);
		} else if (size() >= data.length) {
			resize();
		}
		if (i == 0) {
			addToFront(item);
			return;
		}


		if (front + i >= data.length) {
			for (int o = 0; o < data.length - front; o++) {
				data[front + o - 1] = data[front + o];
			}
			data[data.length - 1] = data[0];
			for (int o = 0; o < front + i - data.length - 1; o++) {
				data[o] = data[o+1];
			}
			try {
				data[front + i -1] = item;
			} catch (IndexOutOfBoundsException e) {
				data[front + i - data.length - 1] = item;
			}




		} else {
			for (int o = 0; o < i; o++) {
				if (front + o == 0) {
					data[data.length - 1] = data[0];
					continue;
				} else {
				data[front + o - 1] = data[front + o];
				}
			}
			data[front + i -1] = (T) item;
		}
		size++;
		if (--front < 0) {
			front = data.length - 1;
		}

	}


	public void addToBack(int i, T item) {
		if (i > size()) {
			throw new IndexOutOfBoundsException("Illegal index " + i);
		} else if (size() >= data.length) {
			resize();
		}
		if (i == 0) {
			addToBack(item);
			return;
		}

		if (back - i < 0) {
			for (int o = 0; o <= back; o++) {
				data[back - o + 1] = data[back - o];
			}
			data[0] = data[data.length - 1];

			for (int o = 0; o < Math.abs(back + 1 - i); o++) {
				data[data.length - o - 2] = data[data.length - o - 1];
			}
			try {
				data[back + 1 - i] = item;
			} catch (IndexOutOfBoundsException e) {
				data[back - i + data.length + 1] = item;
			}


		} else {
			for (int o = 0; o < i; o++) {
				if (back - o + 1 >= data.length) {
					data[0] = data[data.length - 1];
					continue;
				}
				data[back - o + 1] = data[back - o];
			}
			data[back - i + 1] = (T) item;
		}
		size++;
		if (++back >= data.length) {
			back = 0;
		}

	}


	public T removeFront(int i) {
		if (size < i+1) {
			throw new IndexOutOfBoundsException();

		}
		T temp = (T) new Object();
		if (i == 0) {
			temp = (T) removeFront();
			return temp;
		}
		try {
			temp = data[front + i];

			for (int o = 0; o < i; o++) {
				data[front + i - o] = data[front + i - o - 1];
			}

		} catch (IndexOutOfBoundsException e) {
			temp = data[front + i - data.length];
			for (int o = 0; o < front + i - data.length; o++) {
				data[front + i - data.length - o] = data[front + i - data.length - o - 1];
			}
			data[0] = data[data.length - 1];
			for (int o = 0; o < data.length - front - 1; o++) {
				data[data.length - 1 - o] = data[data.length - 2 - o];
			}
		}

		size--;
		if (++front >= data.length) {
			front = 0;
		}

		return temp;
	}


	public T removeBack(int i) {
		if (size < i+1) {
			throw new IndexOutOfBoundsException();
		}
		T temp = (T) new Object();
		if (i==0) {
			temp = (T) removeBack();
			return temp;
		}
		try {
			temp = data[back - i];
			for (int o = 0; o < i; o++) {
				data[back - i + o] = data[back - i + o + 1];
			}
		} catch (IndexOutOfBoundsException e) {
			temp = data[back - i + data.length];
			for (int o = 0; o < Math.abs(back - i + 1); o++) {
				data[back - i + data.length + o] = data[back - i + data.length + o + 1];
			}
			data[data.length - 1] = data[0];
			for (int o = 0; o < back - Math.abs(i - back) + 1; o++) {
				data[o] = data[o + 1];
			}
		}


		size--;
		if (--back < 0) {
			back = data.length - 1;
		}

		return temp;
	}

}
