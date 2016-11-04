package com.sistema.listener;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Log {

    public static void escrever(String mensagem) throws IOException {
        //O segundo parametro "true" indica append para o arquivo em questao.
        FileWriter fileWriter = new FileWriter("log_cadastro.log", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String data = (new java.util.Date()).toString();
        String msg = data + " : " + mensagem + "\n";
        bufferedWriter.write(msg);
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
