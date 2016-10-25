package com.sistema.listener;

import com.sistema.janelas.CadAluno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class AlunoActionListener implements ActionListener {

    private CadAluno frame;

    public AlunoActionListener(CadAluno frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("cadastrar".equals(e.getActionCommand())) {
            //salvar

            JOptionPane.showMessageDialog(null, "Dados Cadastrados." + frame.getNome().getText());

        } else if ("cancelar".equals(e.getActionCommand())) {
            frame.dispose();
        }
    }

    /*
    public static void main (String args[]){
        System.out.println("nome"+ Aluno.class.getName());
    }*/
 /*
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
     */
}
