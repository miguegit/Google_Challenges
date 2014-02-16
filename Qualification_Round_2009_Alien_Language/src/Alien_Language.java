import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Alien_Language {

	public static void main(String[] args) {
		long time_start, time_end;
		time_start = System.currentTimeMillis();
		new Alien_Language().run();
		time_end = System.currentTimeMillis();
		System.out.println("the task has taken "+ ( (time_end - time_start)/1000.0 ) +" seconds");
	}
	
	
	public void run(){
		
	
		BufferedReader br = null;
			
		try {
 
			String sCurrentLine; 
			br = new BufferedReader(new FileReader("A-large-practice.in"));				
			
			String[] instrucciones = br.readLine().split("\\s");
			int longitud = Integer.parseInt(instrucciones[0]);
			int elementos = Integer.parseInt(instrucciones[1]);
			int test_cases = Integer.parseInt(instrucciones[2]);
			List<String> lista = new ArrayList();
			for(int i = 1; i <= elementos; i++){
				lista.add(br.readLine());
			}
			for(int j = 1; j <= test_cases; j++){
				int contador_final=0;
				String parte = br.readLine();
				List lista2 = new ArrayList();
				for(int z=0; z < parte.length(); z++){	
//					Set set = new HashSet();
					List set = new ArrayList();
					if(parte.charAt(z)=='('){
						z++;
						while(parte.charAt(z)!=')'){
							set.add(parte.charAt(z));
							z++;
						}
						lista2.add(set);
						
					}else{
						set.add(parte.charAt(z));
						lista2.add(set);
					}					
					
				}
				
				for(String lis:lista){
					int contador = 0;
					for(int p=0; p<longitud;p++){
						List setito = (List) lista2.get(p);
						if(setito.contains(lis.charAt(p))){
							contador++;
						}
					}
				if(contador == longitud){
					contador_final++;
				}
				

				}
				
			System.out.println("Case #"+j+": "+contador_final);	
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
