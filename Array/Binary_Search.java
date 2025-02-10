public class Binary_Search{
	public static int BinarySearch(int arr[], int target) {
		int i = 0;
		int j = arr.length-1;
		while (i<=j) {
			int mid = (i+j)/2;
			if (arr[mid] > target) {
				j = mid -1;
			}
			else if (arr[mid] < target) {
				i = mid + 1;
			}
			else {
				return mid;
			}
		}
		return -1;
		
	}
	public static void main (String[] args) {
		int arr[] = {2, 4, 6, 8, 9};
		System.out.println(BinarySearch(arr, 2));
	}
}
