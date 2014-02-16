import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Rope_Intranet {

	public static void main(String[] args) {
		long time_start, time_end;
		time_start = System.currentTimeMillis();
		new Rope_Intranet().run();
		time_end = System.currentTimeMillis();
		System.out.println("the task has taken "+ ( (time_end - time_start)/1000.0 ) +" seconds");
	}
	
	
	public void run(){
		
	
		BufferedReader br = null;
			
		try {
 
			 
			br = new BufferedReader(new FileReader("A-large-practice.in"));				
			int iteraciones = Integer.parseInt(br.readLine());
			for(int i=1; i<= iteraciones; i++){
				int aristas = Integer.parseInt(br.readLine());
				List<Integer> l1 = new ArrayList();
				List<Integer> l2 = new ArrayList();
				int contador = 0;
				for(int j=0; j<aristas; j++){
					String[] separa  = br.readLine().split("\\s");
					if(j==0){  // primera iteracion que entra
						l1.add(Integer.parseInt(separa[0]));
						l2.add(Integer.parseInt(separa[1]));						
					}else{ // demas iteraciones	
						for(int z=0; z< l1.size(); z++){
							if(((Integer.parseInt(separa[0]) > l1.get(z)) && ((Integer.parseInt(separa[1]) < l2.get(z))))  || ((Integer.parseInt(separa[0]) < l1.get(z)) && ((Integer.parseInt(separa[1]) > l2.get(z)))) ){
								contador ++;
							}
						}
					}
					
					
				}				
				
			System.out.println("Case #"+i+": "+contador);		
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
