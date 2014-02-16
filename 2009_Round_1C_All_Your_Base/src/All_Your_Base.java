import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class All_Your_Base {
	
	public static void main(String[] args) {
		long time_start, time_end;
		time_start = System.currentTimeMillis();
		new All_Your_Base().run();
		time_end = System.currentTimeMillis();
		System.out.println("the task has taken "+ ( (time_end - time_start)/1000.0 ) +" seconds");
	}
	
	public void run(){
		
		BufferedReader br = null;
//		int foo = Integer.parseInt("11001001", 2);
//		System.out.println(foo);
//		
//		String s = Integer.toString(1023,3);
//		System.out.println(Integer.toString(Integer.parseInt("1023", 4), 10));
//		System.out.println(Integer.toString(Integer.parseInt("102", 3), 10));
		
		try {
			
			br = new BufferedReader(new FileReader("small.in"));
			int instrucciones = Integer.parseInt(br.readLine());
			for(int i = 1; i <= instrucciones; i++){
							
				String linea = br.readLine();
				BigInteger res = convert(linea);
				
				
				
				
				
			System.out.println("Case #"+i+": " +res);	
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



 public BigInteger convert(String str) {
	    BigInteger res = new BigInteger("0");
	    int base = 0;
	    int len = str.length();
	 
	    HashMap<String, Integer> hm = new HashMap<String, Integer>();
	    int index = 1;
	 
	    for(int i=0;i<len;i++) {
	      if(!hm.containsKey("" + str.charAt(i))) {
	        if(i != 0) {
	          if(index == 1) {
	            index--;
	          } else if (index == 0) {
	            index = 2;
	          } else {
	            index++;
	          }
	        }        
	 
	        hm.put("" + str.charAt(i), new Integer(index));
	        base++;
	      }
	    }
	 
	    if(hm.size() == 1) base = 2;
	    System.out.println("base : " + base + " Len : " + len);
	 
	    for(int i=0;i<len;i++) {
	      String s = str.charAt(i) + "";
	      res = res.add(new BigInteger("" + hm.get(s)).multiply(new BigInteger("" + base).pow(len-i-1)));
	    }
	 
	    return res;
	  }  
}