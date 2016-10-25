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
import javax.swing.JOptionPane;

public class LoginActionListener implements ActionListener {

    private Login frame;

    public LoginActionListener(Login frame) {
        this.frame = frame;

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
         if ("entrar".equals(e.getActionCommand())) {
            //salvar
            JOptionPane.showMessageDialog(null, "Clicou no OK: " + frame.getTextoTextField().getText());

        } else if ("cancelar".equals(e.getActionCommand())) {
            frame.dispose();
            //como limpar os campos?
        }
    }

}
