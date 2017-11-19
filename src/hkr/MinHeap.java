package hkr;

import java.util.NoSuchElementException;

public class MinHeap {
	
	int arr[] = null;
	int size = 0;

	public MinHeap(int n) {
		arr = new int[n];
	}
	
	public void insert(int num) {
		size++;
		arr[size] = num;
		swim(size);
		// median();
	}

	public double delete() {
		double min = arr[1];
		arr[1] = arr[size];
		size--;
		sink(1);
		arr[size + 1] = 0;
		return min;
	}

	public double peek() {
		return arr[1];
	}

	public int size() {
		return size;
	}

	private void sink(int index) {
		while (index * 2 < size) {
			int j = index * 2;
			if (j < size && arr[j] > arr[j + 1]) {
				j++;
			}
			if (arr[index] > arr[j]) {
				int temp = arr[j];
				arr[j] = arr[index];
				arr[index] = temp;
			} else {
				break;
			}
			index = j;
		}
	}

	private void swim(int index) {
		while (index > 1 && arr[index / 2] > arr[index]) {
			// swap the numbers
			int temp = arr[index];
			arr[index] = arr[index / 2];
			arr[index / 2] = temp;
			index = index / 2;
		}
	}

	public double median() {
		if (size == 0) {
			throw new NoSuchElementException("Empty array");
		}
		if (size == 1) {
			System.out.println(String.format("%.1f", arr[size]));
			return arr[size];
		}
		double median;
		int mid = size / 2;
		if (size % 2 == 0) {
			median = (arr[mid] + arr[mid + 1]) / 2;
			System.out.println(String.format("%.1f", median));
			return median;
		} else {
			median = arr[mid + 1];
			System.out.println(String.format("%.1f", median));
			return median;
		}
		// return median;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i] + ",");
		}
		sb.append("]");
		return sb.toString();
	}

	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap(7);
		minHeap.insert(12);
		minHeap.insert(4);
		minHeap.insert(5);
		minHeap.insert(3);
		minHeap.insert(8);
		minHeap.insert(7);
		System.out.println(minHeap + " size " + minHeap.size);
		minHeap.delete();
		System.out.println("\n" + minHeap + " size " + minHeap.size);
	}
}
