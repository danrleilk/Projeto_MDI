package com.sistema.listener;

import com.sistema.bean.Professor;
import com.sistema.janelas.CadProfessor;
import com.sistema.janelas.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;

public class ProfessorActionListener implements ActionListener {

    private CadProfessor frame;

    public ProfessorActionListener(CadProfessor frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("cadastrar".equals(e.getActionCommand())) {
            try{
            Log.escrever("Cadastrou Professor ");
            frame.dispose();
            } catch(IOException ex){
                ex.printStackTrace();
            }
        } else if ("cancelar".equals(e.getActionCommand())) {
            //como limpar os campos?
            frame.dispose();
        }
    }

    //Fazer o trem de salvar em txt nesse arquivo tbm
}
