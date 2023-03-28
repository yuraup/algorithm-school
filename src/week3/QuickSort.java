package week3;

public class QuickSort {
	public static int[] dataList(int size) { // 초기 데이터
		int[] initData = new int[size];

		for (int i = 0; i < size; i++) {
			initData[i] = (int) (Math.random() * size);
		}
		return initData;

	}

	public static int[] quickSort(int[] data) {
		return quickSort(data, 0, data.length - 1);
	}

	private static int[] quickSort(int[] data, int s, int e) {
		if (s < e) {
			int middle = partition(data, s, e);
			quickSort(data, s, middle - 1);
			quickSort(data, middle + 1, e);
		}
		return data;
	}

	private static int partition(int[] data, int s, int e) {
		int pivot = e; // pivot == last num

		int left = s;
		int right = e;

		while (left < right) {
			while (data[left] < data[pivot] && left < right) {
				left++;
			}
			while (data[right] >= data[pivot] && left < right) {
				right--;
			}
			if (left < right) {
				swap(data, left, right);
			}
		}
		swap(data, pivot, right);
		return right;
	}

	private static int[] swap(int[] data, int j, int k) { // 1 3
		int temp = data[j]; // temp = 1
		data[j] = data[k]; // j = 3
		data[k] = temp; // k = 1 , 바뀜
		return data;
	}

	public static void main(String[] args) {
		int dataSize = 35;
		int[] initData = new int[dataSize];

		System.out.println("\n  ---- Init Data  ----");
		initData = dataList(dataSize);
		showData(initData);

		System.out.println("\n  ---- quick Sorted Data  ----");
		int[] sortedData = quickSort(initData);
		showData(sortedData);
	}

	private static void showData(int[] data) {
		int length = data.length;
		int nRow = 1 + (int) length / 10;
		for (int i = 0; i < nRow; i++) {
			for (int j = i * 10; j < Math.min(length, (i + 1) * 10); j++) {
				System.out.print(" " + data[j]);
			}
			System.out.println();
		}
	}
}
