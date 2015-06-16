import java.io.*;
import java.math.BigInteger;
import java.util.*;

// 16: calculate the sum of digits of pow(2,1000)


public class IsPrime {
	

	static int iterations = 10;
	static final int million = 10000000;
	
	public static void main( String args[]) throws Exception{
		
	
		
			long n = Long.parseLong(args[0]);
			
			if( isPrime(n))
				System.out.println( "YES");

			else
				System.out.println("NO");
			
	
		
		 
		
		
	}
	

	static boolean isPrime( long n ){
		
		
		if( n == 2 || n == 3 ) return true;
		if( n == 1 || n%2 == 0 ) return false;
		
		int k = 0 ;
		long q = n -1  ; 
		
		while( q%2 == 0) {
			++k;
			q = q/2 ;
		}
		
		boolean ans = true;
		
		
		for( int i = 0 ; i < iterations ; ++i ){
		
	
			long a = (long)(Math.random()*(n-1)) + 1 ;
			a = 42;
			ans = ans && mayBe(n,k,q,a);
			
		}
		
		return ans ;
	}
	
	static long multiply( long a , long b , long mod){
		
		if( b == 1 ) return a%mod;
		long temp = multiply(a,b/2,mod);
		temp = (temp+temp)%mod;
		
		if( b%2 == 0 ) return temp;
		else return (temp+a)%mod;
		
	}
	
	static boolean mayBe( long p , int k , long q , long a ){
		
		long temp = pow(a,q,p); 
		
		if(  temp == 1 || temp == p-1) return true;
		
		
		
		for( int i = 1 ; i < k ; ++i ){
			temp = multiply(temp,temp,p);
			
			if( temp == p-1 )
				return true;
		}
		return false;
	}
	
	static long pow( long base , long exp , long mod){
		
		if( exp == 0 ) return 1;
		
		long temp = pow( base,exp/2,mod);
		temp = multiply(temp,temp,mod);
		
		if( exp%2 == 0 ) 
			return temp;
		else
			return multiply(temp,base,mod);
	}
	
	static class IO{
		
		
		BufferedReader reader;
		StringTokenizer tokenizer;
		PrintWriter writer;

		public void init() {
			try {
				reader = new BufferedReader(new InputStreamReader(System.in),8*1024);
				writer = new PrintWriter(System.out);
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(261);
			}
		}

		void destroy() {
			writer.close();
			System.exit(0);
		}

		void print(Object... objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0)
					writer.print(' ');
				writer.print(objects[i]);
			}
		}

		void println(Object... objects) {
			print(objects);
			writer.println();
		}

		String nextLine() throws IOException {
			return reader.readLine();
		}

		String nextToken() throws IOException {
			while (tokenizer == null || !tokenizer.hasMoreTokens())
				tokenizer = new StringTokenizer(nextLine());
			return tokenizer.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(nextToken());
		}

		long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(nextToken());
		}

		double nextDouble() throws NumberFormatException, IOException {
			return Double.parseDouble(nextToken());
		}
	}
	
}


/*

32416187567
9229360046-false
32416190071

*/
