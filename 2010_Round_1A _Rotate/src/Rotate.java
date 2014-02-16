import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Rotate {

	public static void main(String[] args) {
			long time_start, time_end;
			time_start = System.currentTimeMillis();
			new Rotate().run();
			time_end = System.currentTimeMillis();
			System.out.println("the task has taken "+ ( (time_end - time_start)/1000.0 ) +" seconds");
		}

	

public void run(){
		
		BufferedReader br = null;
			
		try {
 
			String sCurrentLine; 
			br = new BufferedReader(new FileReader("small.in"));			
			int instrucciones = Integer.parseInt(br.readLine());
			
			for(int i = 1; i <= instrucciones; i++){
				String[] variables = br.readLine().split("\\s");
				int dimension = Integer.parseInt(variables[0]);
				int longitud = Integer.parseInt(variables[1]);
				
				Character [][] matriz = new Character[dimension][dimension];
				
				// Ponemos la matriz en su sitio
				for( int j=0; j<dimension;j++){
					String partes = br.readLine();
					int delimitador = partes.length()-1;
					
					for(int var = partes.length()-1; var >=0; var--){
						char c = partes.charAt(var);
						if(c == 'R' || c=='B'){
							matriz[j][delimitador] = c;
							delimitador--;
						}
					}
				}
				
//				for (int u = 0; u < dimension; u++) { 
//		            for (int x = 0; x < dimension; x++) {
//		                System.out.print(matriz[u][x] + " ");
//		            }
//		            System.out.println();
//		        }
//				
				
				Set<Character> setfinal = new HashSet();
				
				
				int difference = dimension - longitud;
////				horizontal
				for(int z=0; z<dimension;z++){
					for(int x=0; x<=difference;x++){
						Set<Character> setito = new HashSet();
						for(int q=0;q<longitud;q++){						
							setito.add(matriz[z][q+x]);
//							System.out.println("Parametro1: "+z+" segundo "+(x)+ " la q es: "+q);
//							System.out.println(matriz[z][q+x]);

						}
						if(setito.size()==1 && !setito.contains("null")){
							setfinal.add(matriz[z][x]);
//							System.out.println("ha capturado uno");
						}
					}
				}
//				
//				vertical
				for(int z=0; z<=difference;z++){
					for(int x=0; x<dimension;x++){
						Set<Character> setito = new HashSet();
						for(int q=0;q<longitud;q++){						
							setito.add(matriz[q+z][x]);
//							System.out.println(matriz[q+z][x]);

						}
						if(setito.size()==1 && !setito.contains("null")){
							setfinal.add(matriz[z][x]);
//							System.out.println("ha capturado uno");
						}
					}
				}
//				
//				//diagonal caida hacia la derecha
				for(int z=0; z<=difference;z++){
					for(int x=0; x<=difference;x++){
						Set<Character> setito = new HashSet();
						for(int q=0;q<longitud;q++){						
							setito.add(matriz[z+q][x+q]);
//							System.out.println(matriz[z+q][x+q]);

						}
						if(setito.size()==1 && !setito.contains("null")){
							setfinal.add(matriz[z][x]);
//							System.out.println("ha capturado uno");
						}
					}
				}
				
				for(int z=0; z<=difference;z++){
					for(int x=dimension-1; x>=(dimension-1)-difference;x--){
						Set<Character> setito = new HashSet();
						for(int q=0;q<longitud;q++){						
							setito.add(matriz[z+q][x-q]);
//							System.out.println("Parametro1: "+z+" segundo "+(x)+ " la q es: "+q);
//							System.out.println(matriz[z+q][x-q]);

						}
						if(setito.size()==1 && !setito.contains("null")){
							setfinal.add(matriz[z][x]);
//							System.out.println("ha capturado uno");
						}
					}
				}

			if(setfinal.contains('B') && setfinal.contains('R')){
				System.out.println("Case #"+i+": Both");	

			}else{
				if(setfinal.contains('B')){
					System.out.println("Case #"+i+": Blue");
				}else{
					if(setfinal.contains('R')){
						System.out.println("Case #"+i+": Red");
				}else{
					System.out.println("Case #"+i+": Neither");
					}
				}
			}	

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
