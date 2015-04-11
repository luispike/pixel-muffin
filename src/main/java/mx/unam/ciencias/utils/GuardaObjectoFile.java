/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guillermorojas
 */
public class GuardaObjectoFile {
    
    
    public static void guardarEnArchivo(Object object,String filename){
          try{ 
            OutputStream file = new FileOutputStream(filename);
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);

            try{
                output.writeObject(object);
             }
             finally{
                  output.close();
            }
          }
        catch(IOException ex){
            System.out.println( "IOException");
        }
    }
    
    public static Object recuperaObjecto(String filename) {
     Object object=null;
        try{
            InputStream file = new FileInputStream(filename) ;
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream (buffer);
            
            object=input.readObject();
            input.close();
            
            return object;
         }
        catch(ClassNotFoundException ex){
            System.out.println( "ClassNotFoundException");
          return null;
        }
        catch(IOException ex){
          System.out.println( "IOException");
          return null;
        }
        
    }
    
    
}
