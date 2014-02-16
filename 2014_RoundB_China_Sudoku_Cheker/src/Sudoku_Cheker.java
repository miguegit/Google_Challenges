import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Sudoku_Cheker {

	public static void main(String[] args) {
		long time_start, time_end;
		time_start = System.currentTimeMillis();
		new Sudoku_Cheker().run();
		time_end = System.currentTimeMillis();
		System.out.println("the task has taken "+ ( (time_end - time_start)/1000.0 ) +" seconds");
	}
	
	
	public void run(){
		
		BufferedReader br = null;
		try {
 
			br = new BufferedReader(new FileReader("A-large-practice.in"));				
			
			int instrucciones = Integer.parseInt(br.readLine());
			for(int i = 1; i <= instrucciones; i++){
				Map<Integer,List<Integer>> mapa = new HashMap();
				int sol_final = 0;
				int	dimension = Integer.parseInt(br.readLine());
				// leemos cada fila de la matriz
				for(int t=1; t<= dimension*dimension; t++){
					List<Integer> lista = new ArrayList();
					String[] partes = br.readLine().split("\\s");
					if( partes.length != (dimension*dimension) ){
						sol_final++;
						break;
					}
					//rellenamos la lista con los valores del array
					for(int u=0; u<partes.length; u++){
						lista.add(Integer.parseInt(partes[u]));
					}					
					for(int y=1; y<=dimension*dimension; y++){
						if(!lista.contains(y)){
							sol_final++;
							break;
						}
					}
					
					mapa.put(t, lista);
				}
				
				//vamos a comprobar tantas veces como cuadrados tenga la matriz
				int fila =0;
				int columna =0;
				int contador = 1;
				while(contador<=dimension*dimension){
										
				List<Integer> list_matriz = new ArrayList();
				for(int t=1; t<= dimension; t++){
					List<Integer> l = mapa.get(t+fila);
					for(int j=0; j<dimension; j++){
						list_matriz.add(l.get(j+columna));
//						System.out.println("Lista : "+l+" y quiere acceder a "+(j+columna));
					}
				}
				
				if((fila + dimension)>=(dimension*dimension)){
//					System.out.println("Ha entrado aqui");
					fila = 0;
					columna = columna+dimension;
				}else{
					fila=fila+dimension;
//					System.out.println("Se incrementa");

				}
				
//				System.out.println(list_matriz);	
				
				for(int c = 1; c<= dimension*dimension; c++){
					if(!list_matriz.contains(c)){
						sol_final++;
						break;
					}
				}
				
				contador++;
				
				
				
				}
				
			if(sol_final == 0){
				System.out.println("Case #"+i+": Yes");
			}else{
				System.out.println("Case #"+i+": No");	
			}
			
//			System.out.println(mapa);	

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
