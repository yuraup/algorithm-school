package week3;

public class BubbleSort {

	public static int[] dataList(int size) { // 초기 데이터
		int[] initData = new int[size];

		for (int i = 0; i < size; i++) {
			initData[i] = (int) (Math.random() * size);
		}
		return initData;

	}

	public static int[] bubbleSort(int[] initData) {
		int dataSize = initData.length;
		for (int i = dataSize - 1; i >= 0; i--) { // 큰 -> 작은
			for (int j = 0; j < i; j++) {
				if (initData[j] > initData[j + 1]) {
					int[] data = initData; // 초기 데이터를 데이터에 넣어서 변수 바꿈
					data = swap(data, j, j + 1);
				}
			}
		}

		return initData;

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

		System.out.println("\n  ---- Bubble Sorted Data  ----");
		int[] sortedData = bubbleSort(initData);
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
