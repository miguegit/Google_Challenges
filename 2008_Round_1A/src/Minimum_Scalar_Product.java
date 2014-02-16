import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Minimum_Scalar_Product {

	public static void main(String[] args) {
		long time_start, time_end;
		time_start = System.currentTimeMillis();
		new Minimum_Scalar_Product().run();
		time_end = System.currentTimeMillis();
		System.out.println("the task has taken "+ ( (time_end - time_start)/1000.0 ) +" seconds");
	}
	
	public void run(){
		
		BufferedReader br = null;
		int posicion1 = 0;
		int posicion2 = 0;
		
		try {
 
			String sCurrentLine; 
			br = new BufferedReader(new FileReader("A-small-practice.in"));				
			
			int instrucciones = Integer.parseInt(br.readLine());
			for(int i = 1; i <= instrucciones; i++){
				int cantidad = 0;
				int longitud = Integer.parseInt(br.readLine());
				String[] vector1 = br.readLine().split("\\s");
				String[] vector2 = br.readLine().split("\\s");
				Arrays.sort(vector1);
				Arrays.sort(vector2);
				for(int j=0; j<vector1.length; j++){
					cantidad += Integer.parseInt(vector1[j]) * Integer.parseInt(vector2[(longitud-j)-1]);
				}
			System.out.println("Case #"+i+": "+cantidad);	
			}
					
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
 
	
		
	}
}
