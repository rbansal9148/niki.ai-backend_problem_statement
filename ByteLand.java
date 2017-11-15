import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ByteLand{

	public static long calcValidString(int n, boolean isPrevZero){
		// Exponential Solution
		if(n==0){
			return 1;
		}
		int sum = 0;
		if(isPrevZero == false){
			sum += calcValidString(n-1, true);
		}
		sum += calcValidString(n-1, false);

		return sum;
	}

	public static void main(String args[]){
		int test = 0;
		int[] n;
		FileReader freader = null;
		BufferedReader reader = null;
		try{
			freader = new FileReader("./input");
			reader = new BufferedReader(freader);
			try{
				test = Integer.parseInt(reader.readLine());
			} catch( NumberFormatException e){
				e.printStackTrace();
			}

			int temp = 0;
			n = new int[test];
			while(temp < test){
				n[temp] = Integer.parseInt(reader.readLine());
				temp++;
			}
		} catch(IOException e){
			n = new int[1];
			e.printStackTrace();
			// reader.close();
		} finally {
			try{
				reader.close();
			} catch(IOException e){
				e.printStackTrace();
			}
		}

		for(int i=0; i<test; i++){
			System.out.println(calcValidString(n[i], false));
		}
	}
}
