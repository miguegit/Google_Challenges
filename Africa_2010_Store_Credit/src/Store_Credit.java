import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Store_Credit {
	
	
	
	
	public static void main(String[] args) {
		long time_start, time_end;
		time_start = System.currentTimeMillis();
		new Store_Credit().run();
		time_end = System.currentTimeMillis();
		System.out.println("the task has taken "+ ( (time_end - time_start)/1000.0 ) +" seconds");
	}
	
	public void run(){
		
		
		String s = "abc";
		System.out.println("valor:"+(s.charAt(2) - 'a'));
//		(s.charAt(0) - 'a');
		
		BufferedReader br = null;
		int posicion1 = 0;
		int posicion2 = 0;
		
		try {
 
			String sCurrentLine; 
			br = new BufferedReader(new FileReader("A-large-practice.in"));				
			
			int instrucciones = Integer.parseInt(br.readLine());
			for(int i = 1; i <= instrucciones; i++){
				int cantidad = Integer.parseInt(br.readLine());
				int longitud = Integer.parseInt(br.readLine());
				String[] parts = br.readLine().split("\\s");
				
				List<Integer> lista = new ArrayList<>();
				for(int j=0; j<= (longitud-1); j++){
					int value = Integer.parseInt(parts[j]);
					if(lista.isEmpty()) lista.add(value);
					else{
						for(int z=0; z < lista.size(); z++){
							int value2 = lista.get(z);
							if((value2+value)==cantidad){
								posicion2 = z;
								posicion1 = j;
								break;
							}
						}
						
						lista.add(value);
					} 
				}
				
				System.out.println("Case #"+i+": "+(posicion2 +1)+" "+(posicion1 + 1));

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
