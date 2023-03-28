package week3;

public class SelectSort {

	public static int[] dataList(int size) { // 초기 데이터
		int[] initData = new int[size];
		for (int i = 0; i < size; i++) {
			initData[i] = (int) (Math.random() * size * 10);
		}
		return initData;
	}

	public static int[] selectionSort(int[] initData) {
		int dataSize = initData.length;
		int data[] = initData;
		for (int i = 0; i < dataSize - 1; i++) { // 0부터 length-1만큼 돌아
			for (int j = i + 1; j < dataSize; j++) {
				if (initData[i] > initData[j]) {
					data = swap(initData, i, j);
				}
			}
		}
		return data;
	}

	private static int[] swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
		return data;
	}

	public static void main(String[] args) {
		int dataSize = 35;
		int[] initData = new int[dataSize];

		System.out.println("\n  ---- Init Data  ----");
		initData = dataList(dataSize);
		showData(initData);

		System.out.println("\n  ---- Select Sorted Data  ----");
		int[] sortedData = selectionSort(initData);
		showData(sortedData);
	}

	private static void showData(int[] data) { // 데이터 리스트를 보여줌
		int length = data.length;
		int nRow = 1 + (int) length / 10; // row 앞에 있는 번호
		for (int i = 0; i < nRow; i++) {
			for (int j = i * 10; j < Math.min(length, (i + 1) * 10); j++) {
				System.out.print(" " + data[j]);
			}
			System.out.println();
		}
	}
}
