import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Factorize {
	

	static long n = 109546051211L;
	static final int million = 1000000;
	static final long mod = 1000000007;
	
	public static void main( String args[]) throws Exception{
		
	
		
	
		int[] primes = new int[ million ];
	
		int size =0;
		
		boolean[] isPrime = new boolean[million];
		
		for( int i = 0 ; i  < million ; ++i )
			isPrime[i] = true;
		
		int cur = 2 ; 
		
		while( cur < million ){
			
			if(isPrime[cur]){
			
				for( int i = 2*cur ; i < million ; i += cur){
					isPrime[i] = false;
				}
				
				primes[size++] = cur;
			}
			
			cur++;
		}
		

		n = Long.parseLong(args[0]);
		
		long res = n;
		int index = 0;
		
		while( index < size && res > 1 ){
			
			int prime = primes[index];
			int counter = 0;
			while( res%prime == 0 ){
				counter++;
				res /= prime;
			}
			
			if( counter > 0 ){
				System.out.println(prime + "   ..   " + counter);
			}
			index++;
		}
		
		if( res == 1 ){
			System.out.println("Factorization successfull :)");
		}
		
		else{
			
			System.out.println("Sorry!!! Couldn't factorize :(");
			System.out.println("    Residue = " + res);
		}
	}
	


	
}


/*
---SIZE---
78498
----------
186583  X  1
587117  X  1
res = 1

1
48 2
001001011110110001010000110011001010111111000110
*/
