package com.sistema.listener;

import com.sistema.bean.LoginDeclarations;
import com.sistema.janelas.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginActionListener implements ActionListener{
        
    private Login frame;       
            

    public LoginActionListener(Login frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Entrar".equals(e.getActionCommand())) {
            //salvar
            LoginDeclarations login = frame.getLogin();
            
            
        } else if ("Cancelar".equals(e.getActionCommand())) {
            frame.dispose();
            //como limpar os campos?
        }
    }
    
}
