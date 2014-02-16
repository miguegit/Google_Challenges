import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.FileWriter;  
import java.io.IOException;  
import java.util.HashSet;  

public class File_Fix_It {  
    public static void main(String[] args) throws IOException {  
        BufferedReader in = new BufferedReader(new FileReader(  
                "small.in"));  
        FileWriter out = new FileWriter(  
                "output.out"); 
  
        int T = new Integer(in.readLine());  
  
        for (int cases = 1; cases <= T; cases++) {  
            String[] st = new String(in.readLine()).split("\\s");  
            int N = new Integer(st[0]);  
            int M = new Integer(st[1]);  
  
            int result = 0;  
  
            HashSet<String> hs1 = new HashSet<String>();  
  
            for (int i = 0; i < N; i++) {  
                String[] st1 = new String(in.readLine()).split("/");  
                String stTmp = "";  
                for (int j = 1; j < st1.length; j++) {  
                    stTmp = stTmp + "/" + st1[j];  
                    hs1.add(stTmp);  
                }  
            }  
            
            for (int i = 0; i < M; i++) {  
                String[] st2 = new String(in.readLine()).split("/");  
                String stTmp = "";  
                for (int j = 1; j < st2.length; j++) {  
                    stTmp = stTmp + "/" + st2[j];  
                    if (!hs1.contains(stTmp)) {  
                        result++;  
                        hs1.add(stTmp);  
                    }  
                }  
            }  
  
            out.write("Case #" + cases + ": " + result + "\n");  
  
        }  
        in.close();  
        out.flush();  
        out.close();  
    }  
}  