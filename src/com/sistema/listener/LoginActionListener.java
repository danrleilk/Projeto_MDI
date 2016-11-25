package com.sistema.listener;

import com.sistema.bd.ProfessorDAO;
import com.sistema.bd.AlunoDAO;
import com.sistema.bean.Aluno;
import com.sistema.bean.Professor;
import com.sistema.janelas.Login;
import com.sistema.janelas.Menu;
import com.sistema.janelas.MenuAluno;
import com.sistema.janelas.MenuProfessor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginActionListener implements ActionListener {

    private final Login frame;
    private ProfessorDAO pd = new ProfessorDAO();
    private final AlunoDAO ad = new AlunoDAO();

    public LoginActionListener(Login frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("entrar".equals(e.getActionCommand())) {

            JComboBox Tipo = frame.getComboBox();
            JTextField usuario = frame.getUser();
            JPasswordField senha = frame.getSenha();
            String user = usuario.getText();
            String password = Arrays.toString(senha.getPassword());
            String Tipe = Tipo.getSelectedItem().toString();
            String pw = new String(password);

            if (Tipe.equals("Administrador")) {
                if ("Admin".equals(user) || pw.equals("admin")) {
                    Menu menu = new Menu();
                    menu.setVisible(true);
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Senha incorreta.");
                }
            } else
            // Still doesnt work...wtf
            if (Tipe.equals("Professor")) {
                Professor prof = pd.getProfessorbyname(user);
                if (prof.getNomeProf().equals(user)) {
                    if (prof.getSenhaProf().equals(pw)) {
                        MenuProfessor menu = new MenuProfessor();
                        menu.setVisible(true);
                        frame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Senha incorreta.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario não encontrado.");
                }
            }
            if (Tipe.equals("Aluno")) {
                Aluno aluno = ad.getAlunobyname(user);
                if (aluno.getNomeAluno().equals(user)) {
                    if (aluno.getSenhaAluno().equals(pw)) {
                        MenuAluno menu = new MenuAluno();
                        menu.setVisible(true);
                        frame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Senha incorreta.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario não encontrado.");
                }

            }

            File arquivo = new File("usuario.txt");
            try (FileWriter fw = new FileWriter(arquivo)) {
                fw.write(frame.getUser().getText());
                fw.flush();
                String mensagem = frame.getUser().getText();
                Log.escrever(frame.getUser().getText() + " logou no Sistema! ");

            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "não foi possivel salvar seus dados.");
            }
        } else if ("cancelar".equals(e.getActionCommand())) {
            frame.dispose();
        }
    }

}
