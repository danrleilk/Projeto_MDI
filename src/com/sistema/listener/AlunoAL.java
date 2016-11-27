package com.sistema.listener;

import com.sistema.bd.AlunoDAO;
import com.sistema.bean.Aluno;

import com.sistema.janelas.CadAluno;
import excecoes.Excecoes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;

public class AlunoAL implements ActionListener {

    private final CadAluno frame;
    private AlunoDAO dao = new AlunoDAO();
    private Aluno al = new Aluno();

    public AlunoAL(CadAluno frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String gac = e.getActionCommand();
        if ("cadastrar".equals(gac)) {
            try {
                al = frame.getAluno();
                try {
                    dao.insert(al);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    return;
                }
            } catch (Excecoes ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return;
            }
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
            frame.dispose();
        }
        if ("cancelar".equals(gac)) {
            int resposta = JOptionPane.showConfirmDialog(null, "Você deseja cancelar esta operação?", null, YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                frame.dispose();
            }
        }
    }

}
