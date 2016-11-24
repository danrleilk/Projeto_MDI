package com.sistema.listener;

import com.sistema.bd.ProfessorDAO;
import com.sistema.bd.AlunoDAO;
import com.sistema.bean.Aluno;
import com.sistema.bean.Professor;
import com.sistema.janelas.Login;
import com.sistema.janelas.Menu;
import com.sistema.janelas.MenuProfessor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginActionListener implements ActionListener {

    private final Login frame;
    private final ProfessorDAO pd = new ProfessorDAO();
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

            if (Tipe.equals("Administrador")) {
                if ("Admin".equals(user) && password.equals("admin")) {
                    Menu menu = new Menu();
                    menu.setVisible(true);
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Senha incorreta.");
                }
            } else if (Tipe.equals("Professor")) {
                Professor prof = pd.getProfessorbyname(user);
                System.out.println("prof: " + prof.getNomeProf() + "\tsenha: " + prof.getSenhaProf());
                System.out.println("prof: " + usuario + "\tsenha: " + senha);

                if (prof.getNomeProf().equals(user)) {
                    if (prof.getSenhaProf().equals(password)) {
                        MenuProfessor menu = new MenuProfessor();
                        menu.setVisible(true);
                        frame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Senha incorreta.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario não encontrado.");
                }
                // segundo else não funciona ... pq?
                if (Tipe.equals("Aluno")) {
                    Aluno aluno = ad.getAlunobyname(user);
                    if (aluno.getNomeAluno().equals(user)) {
                        if (aluno.getSenhaAluno().equals(password)) {

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

                /*File arquivo = new File("usuario.txt");
            try (FileWriter fw = new FileWriter(arquivo)) {
                fw.write(frame.getTextoTextField().getText());
                fw.flush();
                String mensagem = frame.getTextoTextField().getText();
                Log.escrever(frame.getTextoTextField().getText() + " logou no Sistema! ");

            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "não foi possivel salvar seus dados.");
            }*/
            } else if ("cancelar".equals(e.getActionCommand())) {

                frame.dispose();
            }
        }

    }
}
