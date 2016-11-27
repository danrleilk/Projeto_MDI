package com.sistema.listener;

import com.sistema.bd.AlunoDAO;
import com.sistema.bean.Aluno;

import com.sistema.janelas.ConsultaAluno;
import excecoes.Excecoes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

// Versão criada para funcionar como listener de Consulta aluno ja que não consegui fazer ALunoAL ler dos 2.
public class AlunoAL2 implements ActionListener {

    private final ConsultaAluno frame;
    private final AlunoDAO dao = new AlunoDAO();
    private Aluno al = new Aluno();

    public AlunoAL2(ConsultaAluno frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String gac = e.getActionCommand();

        if ("salvar".equals(gac)) {
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
        }

        if ("atualizar".equals(gac)) {
            try {
                al = frame.getAluno();
                try {
                    dao.update(al);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    return;
                }
            } catch (Excecoes ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return;
            }
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        }

        if ("excluir".equals(gac)) {
            try {
                al = frame.getAluno();
                try {
                    dao.delete(al);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    return;
                }
            } catch (Excecoes ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return;
            }
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
        }
    }

}
