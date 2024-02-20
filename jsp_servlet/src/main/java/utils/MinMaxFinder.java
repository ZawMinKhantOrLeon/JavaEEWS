package utils;

public final class MinMaxFinder {
	
	private MinMaxFinder() {
		
	}
	public static <T extends Comparable<T>> T max(T one,T two,T three,T four){
		T max=one;
		
		if(two.compareTo(max) > 0)
			max=two;
		
		if(three.compareTo(max) > 0)
			max=three;
		
		if(four.compareTo(max) > 0)
			max=four;
		
		 return max;
     }
    
	public static <T extends Comparable<T>> T min(T one,T two,T three,T four){
		T min=one;
		
		if(two.compareTo(min) < 0)
			min=two;
		
		if(three.compareTo(min) < 0)
			min=three;
		
		if(four.compareTo(min) < 0)
			min=four;
		
		 return min;
     }
}
