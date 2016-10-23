package com.sistema.listener;

import com.sistema.bean.Aluno;
import com.sistema.janelas.CadAluno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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

    public void read() throws FileNotFoundException {
        
        Aluno aluno = frame.getAluno();
        FileOutputStream fos = new FileOutputStream("arquivo");
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException ex) {
            Logger.getLogger(AlunoActionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        oos.writeObject(aluno);
        oos.flush();
        oos.close();
    }

}
