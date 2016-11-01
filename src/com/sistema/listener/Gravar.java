package com.sistema.listener;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Gravar {

    public static void escrever(String LogFile, String mensagem) throws IOException {
        FileWriter fileWriter = new FileWriter(LogFile, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String msg = mensagem;
        bufferedWriter.write(msg);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

}
