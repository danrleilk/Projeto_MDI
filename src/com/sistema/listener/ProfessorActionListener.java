package com.sistema.listener;

import com.sistema.janelas.CadProfessor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;

public class ProfessorActionListener implements ActionListener {

    private final CadProfessor frame;

    public ProfessorActionListener(CadProfessor frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("cadastrar".equals(e.getActionCommand())) {
            try {
                Log.escrever("Cadastrou Professor ");
                Gravar.escrever("Professor.txt", frame.getProf().getCodProf() + " : ");
                Gravar.escrever("Professor.txt", frame.getProf().getNomeProf() + " : ");
                Gravar.escrever("Professor.txt", frame.getProf().getSenhaProf() + " : ");
                Gravar.escrever("Professor.txt", frame.getProf().getSexo() + " : ");
                Gravar.escrever("Professor.txt", frame.getProf().getDatanasc() + " : ");
                Gravar.escrever("Professor.txt", frame.getProf().getEmail() + " : ");
                Gravar.escrever("Professor.txt", frame.getProf().getTelefone() + " : ");
                Gravar.escrever("Professor.txt", frame.getProf().getEndereco() + " : ");
                Gravar.escrever("Professor.txt", frame.getProf().getEspecializacao() + " ;\n");

                frame.dispose();
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "não foi possivel salvar seus dados.");
            }
        } else if ("cancelar".equals(e.getActionCommand())) {
            frame.dispose();
        }
    }
}
