package com.sistema.listener;

import com.sistema.bean.LoginDeclarations;
import com.sistema.janelas.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginActionListener implements ActionListener {

    private Login frame;

    public LoginActionListener(Login frame) {
        this.frame = frame;
    } 
    public static void escrever(String mensagem, String logFile) throws IOException {
                //O segundo parametro "true" indica append para o arquivo em questao.
                FileWriter fileWriter = new FileWriter(logFile, true);
        try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            String data = (new java.util.Date()).toString();
            String msg = data + " : " + mensagem + "\n";
            bufferedWriter.write(msg);
            bufferedWriter.flush();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
                escrever("Efetuou Login!", "log.txt");
            } catch (IOException ex) {
                ex.printStackTrace();            }
        
        if ("entrar".equals(e.getActionCommand())) {
            //salvar
            LoginDeclarations login = frame.getLogin();
            
        }else if ("Cancelar".equals(e.getActionCommand())) {
            frame.dispose();
            //como limpar os campos?
        }
    }
    
}
