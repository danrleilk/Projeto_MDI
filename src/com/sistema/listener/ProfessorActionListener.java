package com.sistema.listener;

import com.sistema.bean.Professor;
import com.sistema.janelas.CadProfessor;
import com.sistema.janelas.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ProfessorActionListener extends Login implements ActionListener {

    private CadProfessor frame;

    public ProfessorActionListener(CadProfessor frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Cadastrar".equals(e.getActionCommand())) {
            //salvar
            Professor prof = frame.getProf();
        } else if ("Cancelar".equals(e.getActionCommand())) {
            //como limpar os campos?
        }
    }

    //Fazer o trem de salvar em txt nesse arquivo tbm
}
