import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Reverse_Words {
	public static void main(String[] args) {
			 
			BufferedReader br = null;
			int instrucciones = 0;
			
			try {
	 
				String sCurrentLine;
	 
				br = new BufferedReader(new FileReader("B-large-practice.in"));				
				
				instrucciones = Integer.parseInt(br.readLine());
				int contador = 0;
				
				while ((sCurrentLine = br.readLine()) != null) {
					if(contador > instrucciones) break;
					contador++;
					String[] parts = sCurrentLine.split("\\s");
					List<String> lista = new ArrayList<String>();
					for( int i = (parts.length)-1; i>=0;i--){
						lista.add(" "+parts[i]);
//						System.out.print(parts[i]);
					}
					System.out.print("Case #"+contador+":");
					for(String lis : lista){
						System.out.print(lis);
					}
					System.out.println();
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
