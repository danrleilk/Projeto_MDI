package com.sistema.listener;

import com.sistema.bd.AlunoDAO;
import com.sistema.bean.Aluno;

import com.sistema.janelas.CadAluno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;

public class AlunoActionListener implements ActionListener {

    private final CadAluno frame;
    private AlunoDAO dao = new AlunoDAO();

    public AlunoActionListener(CadAluno frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("cadastrar".equals(e.getActionCommand())) {
            Aluno al = new Aluno();
            al = frame.getAluno();
            dao.insert(al);
            frame.dispose();
        } else if ("cancelar".equals(e.getActionCommand())) {
            frame.dispose();
        }
    }

}
