package org.ajeet.algorithms.searching;

public class AmazonQuestion {
	
	private static int numDigits(String seq){
		int digits = 1;
		for(int i=0; i < seq.length(); i++){			
			int diff = 0;
			int failures = 0; //If failures are three move to next iteration
			int success = 0; //We need at least two success 			
			for(int j=0; j<=seq.length(); j = j+digits){				
				int num1  = Integer.parseInt(seq.substring(j, j+digits));
				int num2  = Integer.parseInt(seq.substring(j+digits, j+digits+digits));
				int tmpDiff = num1 - num2;
				if(diff ==0){
					diff = tmpDiff;	
					continue;
				}
				if(tmpDiff == diff){
					++success;
					if(success == 2){
						System.out.println("This sequence has " + digits + " digit numbers.");
						return digits;
					}					
				}   else {
					//success = 0;			
					++failures;
					if(failures == 2){
						System.out.println("This sequence does not contains " +  digits + " digit numbers so trying " + (digits + 1) + " digit numbers");
						++digits;
						break;
					}
				}
				
			}
			
		}
		return 0;
	}
	
	private static int getMissingNumber(String seq, int digits){
		int diff = 0;
		for(int j=0; j<=seq.length(); j = j+digits){				
			int num1  = Integer.parseInt(seq.substring(j, j+digits));
			int num2  = Integer.parseInt(seq.substring(j+digits, j+digits+digits));
			int tmpDiff = num1 - num2;
			if(diff == 0){
				diff = tmpDiff;	
			} else if (tmpDiff != diff){
				return (num2 + num1)/2;
			}
		}
		return 0;
		
	}
	
	public static void main(String[] args) {
		//Note: It has limitaion  - sequence should have at least 5 numbers.
		String seq = "4142434546";
		int digits = numDigits(seq);
		//System.out.println(digits);
		System.out.println(getMissingNumber(seq, digits));
	}

}
