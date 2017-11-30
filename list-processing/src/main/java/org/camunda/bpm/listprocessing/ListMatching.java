package org.camunda.bpm.listprocessing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 
public class ListMatching
{    
    public static void main(String[] args) throws IOException  {    
        BufferedReader reader1 = new BufferedReader(new FileReader("src/main/java/org.camunda.bpm.listprocessing/input.txt"));
         
        //BufferedReader reader2 = new BufferedReader(new FileReader("C:\\inputCorrect.txt"));
        
        //writes the updated input othe new file
        BufferedWriter writer1 = new BufferedWriter(new FileWriter("src/main/java/org.camunda.bpm.listprocessing/fixed.txt"));
         
        String line1 = reader1.readLine();
         
        //String line2 = reader2.readLine();
         
       // boolean areEqual = true;
         
        //int lineNum = 1;
        
        int i= 0; 
        while (line1 != null)
        {
        	i = 16;
        	//i starts at 0 and increments till it equals the size of the line
        	while(i < line1.length()) {
        		
        		//change the first letter to uppercase
        		line1.substring(16,17).toUpperCase();
        		
        		//scan for space
        		if(line1.charAt(i) == 32){
        			//change next letter to uppercase
        			line1.substring(i+1, i+2).toUpperCase();
        		}
        		else {
        			//change all letters to lowercase
        			line1.substring(i, i+1).toLowerCase();
        		}
        		System.out.println(line1);
        		//after making the changes write to a new file
        		writer1.write(line1);
        		writer1.newLine();
        		
        		i++;
        	}
        	
        	
//            if(line1 == null || line2 == null)
//            {
//                areEqual = false;
//                 
//                break;
//            }
//            else {
//                    	}
//            }
             
        	line1 = reader1.readLine();
             
            //line2 = reader2.readLine();
             
            //lineNum++; //counting the number of line
        
        }
        reader1.close();
        writer1.close();
    }
}

     
//        if(areEqual)
//        {
//            System.out.println("Two files have same content.");
//        }
//        else
//        {
//            System.out.println("Two files have different content. They differ at line "+lineNum);
//             
//            //System.out.println("File1 has "+line1+" and File2 has "+line2+" at line "+lineNum);
//        }
//         
//        reader1.close();
//         
//        //reader2.close();
//    }

