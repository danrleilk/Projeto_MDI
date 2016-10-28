
package com.sistema.listener;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Gravar {
    
     public static void escrever(String LogFile, String mensagem) throws IOException {
        //O segundo parametro "true" indica append para o arquivo em questao.
        FileWriter fileWriter = new FileWriter(LogFile, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        //String data = (new java.util.Date()).toString();
        String msg = " : " + mensagem + "\n";
        bufferedWriter.write(msg);
        bufferedWriter.flush();
        bufferedWriter.close();
    } 
    
}
