package org.camunda.bpm.listprocessing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class ListMatching
{    
    public static void main(String[] args) throws IOException {    
        BufferedReader reader1 = new BufferedReader(new FileReader("C:\\Users\\Jaira\\git\\Senior-Design-Project\\list-processing\\src\\main\\java\\org\\camunda\\bpm\\listprocessing\\input.txt"));
         
        //BufferedReader reader2 = new BufferedReader(new FileReader("C:\\inputCorrect.txt"));
        
        BufferedWriter writer1 = new BufferedWriter(new FileWriter("C:\\Users\\Jaira\\git\\Senior-Design-Project\\list-processing\\src\\main\\java\\org\\camunda\\bpm\\listprocessing\\fix.txt"));
        
        String line1 = reader1.readLine();
        writer1.write(line1,0,line1.length());
		writer1.newLine();
         
        boolean areEqual = true;
         
        int lineNum = 1;      
        
        line1 = reader1.readLine();
        
        //System.out.println(line1.substring(16,17).toUpperCase());
        
        while (line1 != null)
        {
        	//System.out.println("yo" + line1.length());
        	 int i= 17; 
        	 System.out.print(line1.substring(16,17).toUpperCase());
        
        	//i starts at 0 and increments till it equals the size of the line
        	while(i < line1.length()) {      		
        		
        		//scan for space
        		if(line1.charAt(i) == 126 || line1.charAt(i) == 32){
        			//change next letter to uppercase
        			System.out.print(line1.substring(i, i+2).toUpperCase());
        		}
        		else {
        			//change all letters to lowercase
        			System.out.print(line1.substring(i, i+1).toLowerCase());
        		}
        		//System.out.println(line1);
        		//after making the changes write to a new file
        	
        		
        		i++;
        		//writer1.write((char)i);
        		
        		//System.out.println(line1.length());
        		//System.out.println(i);
        	}
        	
        	writer1.write(line1,0,line1.length());
    		writer1.newLine();
    		
        	
//            if(line1 == null || line2 == null)
//            {
//                areEqual = false;
//                 
//                break;
//            }
//            else {
//                    	}
//            }
             
        	//line1 = reader1.readLine();
    		line1 = null;
             
            //line2 = reader2.readLine();
             
            lineNum++; //counting the number of line
        
        }
        //System.out.println("yoyo" + line1.length());
        reader1.close();
        writer1.close();
//        readerFix.close();
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

