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

    public void read() throws FileNotFoundException, IOException, ClassNotFoundException {

        try (FileInputStream fis = new FileInputStream("data.ser")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object aluno = ois.readObject();
        }
    }

    public void write() throws FileNotFoundException, IOException {

        Aluno aluno = frame.getAluno();

        FileOutputStream fos = new FileOutputStream("data.ser");
        ObjectOutputStream oos = null;
        oos = new ObjectOutputStream(fos);
        oos.writeObject(aluno);
        oos.flush();
        oos.close();
    }

}
