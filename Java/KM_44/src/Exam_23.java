import java.util.Random;

public class Exam_23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		Exam_23 ex = new Exam_23();
		int[] arr = new int[10];
		for(int i=0; i<10; i++) {
			arr[i] = r.nextInt(100);
		}
		System.out.print("[ ");
		for(int el : arr) {
			System.out.printf("%d ", el);
		}
		System.out.print("]\n");
		System.out.printf("합계: %d\n", ex.getSum(arr));
		
		System.out.printf("평균: %.1f\n", ex.getAvg(arr));
		System.out.printf("최대값: %d\n", ex.getMax(arr));
		System.out.printf("최소값: %d\n", ex.getMin(arr));
	}
	
	public int getSum(int[] a) {
		int sum = 0;
		for(int el: a) {
			sum += el;
		}
		return sum;
	}
	
	public double getAvg(int[] a) {
		double avg = 0;
		int sum = 0;
		for(int el: a) {
			sum += el;
		}
		avg = sum / 10.0;
		return avg;
	}
	
	public int getMax(int[] a) {
		int maxNum = 0;
		for(int el: a) {
			if(el > maxNum) maxNum = el;
		}
		return maxNum;
	}
	
	public int getMin(int[] a) {
		int minNum = 100;
		for(int el: a) {
			if(el < minNum) minNum = el;
		}
		return minNum;
	}

}
