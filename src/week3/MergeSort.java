package week3;

public class MergeSort {
	public static int[] dataList(int size) { // 초기 데이터
		int[] initData = new int[size];

		for (int i = 0; i < size; i++) {
			initData[i] = (int) (Math.random() * size);
		}
		return initData;

	}

	public static int[] mergeSort(int[] data) {
		return mergeSort(data, 0, data.length - 1);
	}

	private static int[] mergeSort(int[] data, int s, int e) {
		if (s < e) {
			int middle = (s + e) / 2;
			mergeSort(data, s, middle);
			mergeSort(data, middle + 1, e);
			merge(data, s, middle, e);
		}
		return data;
	}

	private static int[] merge(int[] data, int s, int middle, int e) {
		int[] sorted = new int[data.length];

		int i = s;
		int j = middle + 1;
		int k = s;

		while (i <= middle && j <= e) {
			if (data[i] < data[j]) {
				sorted[k++] = data[i++];
			} else {
				sorted[k++] = data[j++];
			}
		}

		while (i <= middle) {
			sorted[k++] = data[i++];
		}
		while (j <= e) {
			sorted[k++] = data[j++];
		}
		for (int l = s; l <= e; l++) {
			data[l] = sorted[l];
		}

		return data;
	}

	public static void main(String[] args) {
		int dataSize = 35;
		int[] initData = new int[dataSize];

		System.out.println("\n  ---- Init Data  ----");
		initData = dataList(dataSize);
		showData(initData);

		System.out.println("\n  ---- Merge Sorted Data  ----");
		int[] sortedData = mergeSort(initData);
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
