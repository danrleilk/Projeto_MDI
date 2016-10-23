package com.sistema.listener;

import com.sistema.bean.Aluno;
import com.sistema.janelas.CadAluno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlunoActionListener implements ActionListener {

    private CadAluno frame;

    public AlunoActionListener(CadAluno frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Cadastrar".equals(e.getActionCommand())) {
            //salvar
            Aluno aluno = frame.getAluno();

        } else if ("Cancelar".equals(e.getActionCommand())) {
            //como limpar os campos?
        }

    }

}
