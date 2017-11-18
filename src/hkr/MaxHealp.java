package general.ds;

import java.util.NoSuchElementException;

public class MaxHealp {

	double arr[] = new double[10];
	int size = 0;

	public void insert(int num) {
		size++;
		arr[size] = num;
		swim(size);
	}

	public double delete() {
		double min = arr[1];
		arr[1] = arr[size];
		size--;
		sink(1);
		arr[size+1] = 0;
		return min;
	}

	private void sink(int index) {
		while (index * 2 < size) {
			int j = index * 2;
			if (j < size && arr[j] < arr[j + 1]) {
				j++;
			}
			if (arr[index] < arr[j]) {
				double temp = arr[j];
				arr[j] = arr[index];
				arr[index] = temp;
			} else {
				break;
			}
			index = j;
		}
	}

	private void swim(int index) {
		while (index > 1 && arr[index / 2] < arr[index]) {
			// swap the numbers
			double temp = arr[index];
			arr[index] = arr[index / 2];
			arr[index / 2] = temp;
			index = index / 2;
		}
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
		MaxHealp minHeap = new MaxHealp();
		minHeap.insert(12);
		minHeap.insert(4);
		minHeap.insert(5);
		minHeap.insert(3);
		minHeap.insert(8);
		minHeap.insert(7);
		System.out.println(minHeap + " size " + minHeap.size);
		minHeap.delete();
		System.out.println("\n"+minHeap + " size " + minHeap.size);
	}
}
