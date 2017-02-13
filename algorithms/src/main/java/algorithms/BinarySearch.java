package algorithms;

public class BinarySearch {

	public static void main(String[] args) {
		
		int array[] = {0, 5, 12, 45, 78, 98, 105, 123, 167, 201, 201, 223};
		BinarySearch bs = new BinarySearch();
		int value = 201;
		int result = bs.binarySearch(array, 0, array.length - 1, value);
		
		if(result != -1){
			System.out.printf("The value %d is at pos %d\n", value, result);
		}
		else {
			System.out.println("The value not available in the list");
		}
		
		result = bs.binarySearchI(array, 0, array.length - 1, value);
		
		if(result != -1){
			System.out.printf("The value %d is at pos %d\n", value, result);
		}
		else {
			System.out.println("The value not available in the list");
		}
	}
	
	int binarySearch(int[] array, int l, int r, int value) {
		
		if(r>=1) {
			
			int mid = l + (r-l)/2;
			
			if(array[mid] == value) {
				return mid;
			}
			
			if(array[mid] > value) {
				return binarySearch(array, l, mid - 1 , value);
			}
			
			return binarySearch(array, mid + 1, r, value);
		}
		
		return -1;
	}
	
	int binarySearchI(int [] array, int l, int r, int value) {
		while(l<=r) {
			
			int mid = l + (r-l)/2;
			
			if(array[mid] == value) {
				return mid;
			}
			
			if(value < array[mid]) {
				r = mid - 1;
			}
			
			else {
				l = mid + 1;
			}
		}
		
		return -1;
	}

}
