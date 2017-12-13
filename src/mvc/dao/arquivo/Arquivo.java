/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.dao.arquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Jardel Carvalho
 */
public class Arquivo {
    
    private static final Arquivo uniqueinstance = new Arquivo();
    
    private Arquivo(){
        
    }
    
    public static Arquivo getInstance(){
        return uniqueinstance;
    }
    
    public ArrayList<String> ler(String diretorio){
        FileReader reader = null;
        BufferedReader buffReader = null;
        ArrayList<String> lido = new ArrayList<>();
        try{
            reader = new FileReader(diretorio);
            buffReader = new BufferedReader(reader);
            String ultimo = buffReader.readLine();
            do{
                lido.add(ultimo);
                ultimo = buffReader.readLine();
            }while(ultimo != null);
            reader.close();
            buffReader.close();
        }catch(IOException e){
            e.printStackTrace();
            lido.clear();
            return null;
        }
        return lido;
    }
    
    public boolean escrever(String dado, String diretorio){
        FileWriter writer = null;
        try{
            writer = new FileWriter(diretorio, true);
            writer.write(dado + "\n");
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public void flush(String diretorio){ //método adicionado fora do UML
        try{
            FileWriter file = new FileWriter(diretorio);
            file.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
