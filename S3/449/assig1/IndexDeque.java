

public class IndexDeque<T> extends MyDeque<T> implements Indexable<T> {


	public IndexDeque(int initsize) {
		super(initsize);

	}


	public T getFront(int i) {
		if (i+1 > size()) {
			throw new IndexOutOfBoundsException("Illegal index " + i);
		} else if (front + i < data.length) {
			return data[front + i];
		} else {
			return data[front + i - data.length];
		}
	}


	public T getBack(int i) {
		if (i+1 > size()) {
			throw new IndexOutOfBoundsException("Illegal index " + i);
		} else if (back - i >= 0) {
			return data[back - i];
		} else {
			return data[back - i + data.length];
		}
	}


	public void setFront(int i, Object item) {
		if (i+1 > size()) {
			throw new IndexOutOfBoundsException();
		} else if (front + i < data.length) {
			data[front + i] = (T) item;
		} else {
			data[front + i - data.length] = (T) item;
		}

	}


	public void setBack(int i, Object item) {
		if (i+1 > size()) {
			throw new IndexOutOfBoundsException();
		} else if (back - i >= 0) {
			data[back - i] = (T) item;
		} else {
			data[back - i + data.length] = (T) item;
		}

	}

	public int size() {
		return size;
	}


}
