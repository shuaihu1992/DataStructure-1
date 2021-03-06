package com.localhost.part08.Sort;

public class Sort {

	/**
	 * 冒泡排序(Bubble Sort)
	 * 是一种最简单的排序算法。
	 * 基本思想：迭代地对输入序列中的第一个元素到最后一个元素进行两两比较，当需要时交换两个元素位置。
	 */
	public static void bubbleSort(int[] array) {
		// 获取数组元素个数
		int n = array.length;
		// 这种for循环是为了避免比较已经排好序的数据
		for (int pass = n - 1; pass >= 0; pass--) {
			// 只比较未排序部分
			for (int i = 0; i < pass; i++) {
				// 最大值向后移动
				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
			}
		}
	}
	
	/**
	 * 冒泡排序(Bubble Sort)加强版
	 */
	public static void bubbleSortImproved(int[] array) {
		// 获取数组元素个数
		int n = array.length;
		// 标记每一趟排序是否出现数据交换
		boolean swapped = true;
		// 这种for循环是为了避免比较已经排好序的数据
		for (int pass = n - 1; pass >= 0 && swapped; pass--) {
			swapped = false;
			// 只比较未排序部分
			for (int i = 0; i < pass; i++) {
				// 最大值向后移动
				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					// 出现数据交换
					swapped = true;
				}
			}
		}
	}
	
	/**
	 * 选择排序(Selection Sort)
	 * 是一种原地排序(即不需要额外的存储空间)算法，适用于小文件。
	 * 思路：
	 * 寻找序列中最小值
	 * 用当前位置的交换最小值
	 * 对所有元素重复上述过程，直到序列排序完成
	 */
	public static void selectionSort(int[] array) {
		// 获取数组元素个数
		int n = array.length;
		// 最小值的下标
		int min ;
		// 临时变量
		int temp;
		// 寻找最小值位置并与当前位置交换
		for (int i = 0; i < n; i++) {
			min = i;
			// 寻找最小值位置
			for (int j = i + 1; j < n; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			// 交换元素
			temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
	}
	
	/**
	 * 插入排序(Insertion Sort)
	 * 是一种简单且高效的比较排序算法。典型的原地排序
	 * 思路：每次从输入数据中移除一个元素并将其插入已排序序列的正确位置，直到所有输入输入元素都插入有序序列中。
	 * @param array
	 */
	public static void insertionSort(int[] array) {
		// 获取数组元素个数
		int n = array.length;
		// 临时变量
		int temp;
		// 有序序列的循环变量
		int j;
		for (int i = 1; i < n; i++) {
			// 获取输入数据
			temp = array[i];
			j = i;
			// 排序
			while (j >= 1 && (array[j - 1] > temp)) {
				array[j] = array[j - 1];
				j--;
			}
			// 将数据放入有序序列
			array[j] = temp; 
		}
	}
	
	/**
	 * 希尔排序(Shell Sort)
	 * 又称为缩小增量排序(diminishing increment sort)
	 * 该算法是一种泛化的插入排序。
	 * 希尔排序也称为n间距(n-gap)插入排序。希尔排序分多路并使用不同的间距来比较元素，通过逐步减少间距，最终以1为间距进行排序。
	 * @param array
	 */
	public static void shellSort(int[] array) {
		// 先获取数组元素的个数
		int length = array.length;
		// 数组元素
		int temp;
		// 内循环的循环变量，在外部声明，避免重复创建
		int i, j;
		
		// 控制增量序列
		for (int gap = length / 2; gap > 0; gap /= 2) {
			// 在固定的增量序列下分组比较数组元素
			for (i = gap; i < length; i++) {
				temp = array[i];
				j = i;
				// 数据交换，此处的while循环是为了处理gap=1的情况
				while ((j >= gap) && (array[j - gap] > temp)) {
					array[j] = array[j - gap];
					j -= gap;
				}
				array[j] = temp;
			}
		}
	}
	
	/**
	 * 归并排序(Merge Sort)
	 * 参考：http://blog.csdn.net/yinjiabin/article/details/8265827/
	 * @param array
	 * @param left
	 * @param right
	 */
	public static void mergeSort(int[] array, int left, int right) {
		if (right > left) {
			int mid = (left + right) / 2;
			mergeSort(array, left, mid);
			mergeSort(array, mid + 1, right);
			merge(array, left, mid + 1, right);
		}
	}
	
	/**
	 * 合并数据块
	 * @param array 原始数组
	 * @param left 数据块的起始位置
	 * @param mid 数据块的中间位置
	 * @param right 数据块的最后位置
	 */
	public static void merge(int[] array, int left, int mid, int right) {
		// 左侧数据块的结束位置
		int left_end = mid - 1;
		// 左右两侧数据块元素的个数
		int size = right - left + 1;
		// 临时数组用来存储排好序的数据
		int[] temp = new int[array.length];
		// 临时数组的下标
		int temp_pos = left;
		
		// 确保数据在合法的数据块范围内
		while ((left <= left_end) && (mid <= right)) {
			if (array[left] <= array[mid]) {
				temp[temp_pos] = array[left];
				temp_pos++;
				left++;
			} else {
				temp[temp_pos] = array[mid];
				temp_pos++;
				mid++;
			}
		}
		
		// 处理左侧的数据块
		while (left <= left_end) {
			temp[temp_pos] = array[left];
			temp_pos++;
			left++;
		}
		
		// 处理右侧的数据块
		while (mid <= right) {
			temp[temp_pos] = array[mid];
			temp_pos++;
			mid++;
		}
		
		// 将临时数组中的元素赋值给原数组
		for (int i = 0; i < size; i++) {
			array[right] = temp[right];
			right--;
		}
	}
	
	/**
	 * 快速排序(Quick Sort)也称为分区交换排序
	 * 思路：
	 * 1.如果数组中只有一个元素或者没有数据需要排序则直接返回
	 * 2.选择数组中的一个元素作为中心点(pivot)，通常选择数组最右侧的元素
	 * 3.把数组分为两部分，一部分是元素大于中心点，一部分是元素小于中心点
	 * 4.递归处理两部分数组
	 * @param array 原始数组
	 * @param low 数组的起始位置
	 * @param high 数组的结束位置
	 */
	public static void quickSort(int[] array, int low, int high) {
		if (high > low) {
			int pivot = partition(array, low, high);
			quickSort(array, low, pivot - 1);
			quickSort(array, pivot + 1, high);
		}
	}
	
	/**
	 * 查找中心点位置，并根据中心点分组
	 * @param array 原始数组
	 * @param low 数组的起始位置
	 * @param high 数组的结束位置
	 * @return 中心点位置
	 */
	public static int partition(int[] array, int low, int high) {
		// 默认选取数组最左边元素为中心点
		int pivot_item = array[low];
		// 数组的起始位置
		int left = low;
		// 数组的结束为止
		int right = high;
		
		while (left < right) {
			// 从数组左侧开始找大于中心点的位置
			while (left <= high && (array[left] <= pivot_item)) {
				left++;
			}
			// 从数组右侧开始找小于中心点的位置
			while (right >= low && (array[right] > pivot_item)) {
				right--;
			}
			// 交换左侧找到的大于中心点值和右侧找到的小于中心点值
			if (left < right) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
			}
		}
		// rught就是中心点的最终位置
		array[low] = array[right];
		array[right] = pivot_item;
		return right;
	}
}

















