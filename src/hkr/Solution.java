package hkr;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        MinHeap maxHeap = new MinHeap(n);
		MaxHeap minHeap = new MaxHeap(n);
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            int num = a[a_i];
            if (minHeap.size() == 0) {
				minHeap.insert(num);
				double median = minHeap.peek();
				System.out.println(String.format("%.1f", median));
				continue;
			}
			if (maxHeap.size() == 0) {
				if (num < minHeap.peek()) {
					maxHeap.insert(minHeap.delete());
					minHeap.insert(num);
					double median = (minHeap.peek() + maxHeap.peek()) / 2;
					System.out.println(String.format("%.1f", median));
					continue;
				}
			}

			if (minHeap.size() == maxHeap.size()) {
				if (num < minHeap.peek()) {
					minHeap.insert(num);
					double median = minHeap.peek();
					System.out.println(String.format("%.1f", median));
					continue;
				} else {
					maxHeap.insert(num);
					double median = maxHeap.peek();
					System.out.println(String.format("%.1f", median));
					continue;
				}
			} else if (minHeap.size() < maxHeap.size()) {
				if(num < minHeap.peek()) {
					minHeap.insert(num);
					double median = (minHeap.peek() + maxHeap.peek()) / 2;
					System.out.println(String.format("%.1f", median));
				}else {
					minHeap.insert(maxHeap.delete());
					maxHeap.insert(num);
					double median = (minHeap.peek() + maxHeap.peek()) / 2;
					System.out.println(String.format("%.1f", median));
				}
			} else {
				if(num > maxHeap.peek()) {
					maxHeap.insert(num);
					double median = (minHeap.peek() + maxHeap.peek()) / 2;
					System.out.println(String.format("%.1f", median));
				}else {
					maxHeap.insert(minHeap.delete());
					minHeap.insert(num);
					double median = (minHeap.peek() + maxHeap.peek()) / 2;
					System.out.println(String.format("%.1f", median));
				}

			}
        }
    }
}

class MaxHeap {

	private int arr[] = null;
	private int size = 0;

	public MaxHeap(int n) {
		arr = new int[n];
	}

	public void insert(int num) {
		size++;
		arr[size] = num;
		swim(size);
	}

	public int delete() {
		int min = arr[1];
		arr[1] = arr[size];
		size--;
		sink(1);
		arr[size + 1] = 0;
		return min;
	}

	public int peek() {
		return arr[1];
	}

	public int size() {
		return size;
	}

	private void sink(int index) {
		while (index * 2 <= size) {
			int j = index * 2;
			if (j < size && arr[j] < arr[j + 1]) {
				j++;
			}
			if (arr[index] < arr[j]) {
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
		while (index > 1 && arr[index / 2] < arr[index]) {
			// swap the numbers
			int temp = arr[index];
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
}


 class MinHeap {
	
	private int arr[] = null;
	private int size = 0;

	public MinHeap(int n) {
		arr = new int[n];
	}
	
	public void insert(int num) {
		size++;
		arr[size] = num;
		swim(size);
		// median();
	}

	public int delete() {
		int min = arr[1];
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
		while (index * 2 <= size) {
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
			return -1;
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

}
