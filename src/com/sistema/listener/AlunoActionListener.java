package com.sistema.listener;

import com.sistema.bean.Aluno;

import com.sistema.janelas.CadAluno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlunoActionListener implements ActionListener {

    private final CadAluno frame;

    public AlunoActionListener(CadAluno frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("cadastrar".equals(e.getActionCommand())) {
            try {
                Log.escrever("Cadastrou Aluno ");
                Gravar.escrever("Alunos.txt", frame.getAluno().getCodAluno() + " : ");
                Gravar.escrever("Alunos.txt", frame.getAluno().getNomeAluno()+ " : ");
                Gravar.escrever("Alunos.txt", frame.getAluno().getSenhaAluno()+ " : ");
                Gravar.escrever("Alunos.txt", frame.getAluno().getSexo()+ " : ");
                Gravar.escrever("Alunos.txt", frame.getAluno().getDataNasc()+ " : ");
                Gravar.escrever("Alunos.txt", frame.getAluno().getEmail()+ " : ");
                Gravar.escrever("Alunos.txt", frame.getAluno().getTelefone()+ " : ");
                Gravar.escrever("Alunos.txt", frame.getAluno().getEndereco()+ " : ");
                Gravar.escrever("Alunos.txt", frame.getAluno().getResponsavel()+ " ;\n");

                frame.dispose();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if ("cancelar".equals(e.getActionCommand())) {
            frame.dispose();
        }
    }

}
