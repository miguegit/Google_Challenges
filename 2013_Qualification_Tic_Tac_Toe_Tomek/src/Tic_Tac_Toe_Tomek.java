import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Tic_Tac_Toe_Tomek {

	public static void main(String[] args) {
		long time_start, time_end;
		time_start = System.currentTimeMillis();
		new Tic_Tac_Toe_Tomek().run();
		time_end = System.currentTimeMillis();
		System.out.println("the task has taken "+ ( (time_end - time_start)/1000.0 ) +" seconds");
	}
	
public void run(){
		
		BufferedReader br = null;
		try {
 
			br = new BufferedReader(new FileReader("small.in"));				
			
			int instrucciones = Integer.parseInt(br.readLine());
			for(int q = 1; q <= instrucciones; q++){
				Character[][] matriz = new Character[4][4];
				// leemos la matriz
				for (int w = 0; w<4; w++){
					String parts = br.readLine();
					for(int t=0; t<4; t++){
						matriz[w][t] = parts.charAt(t);
					}
				
				}
				
			br.readLine();
//			System.out.println("Case #"+q+": ");	

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
