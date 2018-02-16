
package jade.agenci;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

 //@author Konrad

public class DataBase {
    
   String DBpath;
    
   DataBase(String path)
   {
       this.DBpath = path;
   } 
   
   public ArrayList<String> DBsearch(String tag)
   {
        ArrayList<String> ret = new ArrayList<String>();
        ArrayList<String> lines = new ArrayList<String>();
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(this.DBpath);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =  new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }   
            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                this.DBpath + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + this.DBpath + "'");                  
        }
        
        ArrayList<String[]> userTags = new ArrayList<String[]>();
        String[] linesTab = new String[lines.size()];
        linesTab = lines.toArray(linesTab);
        //String[] testy = linesTab[0].split(Pattern.quote(","));
        //userTags.set(0, linesTab[0].split(Pattern.quote(",")));
       
      
        for(int i = 0;i<lines.size();i++){
            //userTags.set(i, linesTab[i].split(Pattern.quote(",")));
            String[] testy = linesTab[i].split(Pattern.quote(","));
            List<String> temp = Arrays.asList(testy);
             if(temp.contains(tag))
            {
                ret = new ArrayList<String>(temp);
                return ret;
            }
            
        }
//        for (String[] sesja : userTags){
//            List<String> temp = Arrays.asList(sesja);
//            if(temp.contains(tag))
//            {
//                ret = new ArrayList<String>(temp);
//                return ret;
//            }        
//        }
        return ret;
   }
   
   public void DBwrite(String tag)
   {
       // The name of the file to open.
        try {
            // Assume default encoding.
            FileWriter fileWriter = new FileWriter(this.DBpath,true);
            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            // Note that write() does not automatically
            // append a newline character.
            if(tag != "")    
                bufferedWriter.write(tag + ",");
            else
                bufferedWriter.newLine();
            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println("Error writing to file '" + this.DBpath + "'");
        }
   }
}
