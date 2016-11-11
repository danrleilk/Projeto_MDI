package com.sistema.listener;

import com.sistema.bd.ProfessorDAO;
import com.sistema.bean.Professor;
import com.sistema.janelas.CadProfessor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;

public class ProfessorActionListener implements ActionListener {

    private final CadProfessor frame;
    private ProfessorDAO dao = new ProfessorDAO();
            

    public ProfessorActionListener(CadProfessor frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("cadastrar".equals(e.getActionCommand())) {
            Professor al = new Professor();
            al = frame.getProf();
            dao.insert(al);
            frame.dispose();
        } else if ("cancelar".equals(e.getActionCommand())) {
            frame.dispose();
        }
    }
}
