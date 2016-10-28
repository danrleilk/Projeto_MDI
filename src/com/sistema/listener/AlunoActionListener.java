package com.sistema.listener;

import com.sistema.bean.Aluno;
import com.sistema.janelas.CadAluno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AlunoActionListener implements ActionListener {

    private final CadAluno frame;

    public AlunoActionListener(CadAluno frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("cadastrar".equals(e.getActionCommand())) {
            try {
                //salvar
                write();
            } catch (IOException ex) {
                Logger.getLogger(AlunoActionListener.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(null, "Dados Cadastrados para: " + frame.getNome().getText());

        } else if ("cancelar".equals(e.getActionCommand())) {
            frame.dispose();
        }
    }

    public void read() throws FileNotFoundException, IOException, ClassNotFoundException {

        try (FileInputStream fis = new FileInputStream("data.ser")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object aluno = ois.readObject();
        }
    }

    public void write() throws FileNotFoundException, IOException {

        Aluno aluno = new Aluno();
        aluno.setCodAluno(frame.getCodigo().toString());
        aluno.setNomeAluno(frame.getNome().toString());
        aluno.setSenhaAluno(frame.getSenha().toString());
        aluno.setSexo(frame.getSexo().getSelectedItem().toString());
        aluno.setDataNasc(frame.getDataNasc().toString());
        aluno.setEmail(frame.getEmail().toString());
        aluno.setEndereco(frame.getEnder().toString());
        aluno.setResponsavel(frame.getResp().toString());
        aluno.setTelefone(frame.getTelefone().toString());

        FileOutputStream fos = new FileOutputStream("data.ser");
        ObjectOutputStream oos = null;
        oos = new ObjectOutputStream(fos);
        oos.writeObject(aluno);
        oos.flush();
        oos.close();
    }

}
