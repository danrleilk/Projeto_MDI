package com.sistema.listener;

import com.sistema.bd.ProfessorDAO;
import com.sistema.bean.Professor;
import com.sistema.janelas.ConsultaProfessor;
import excecoes.Excecoes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ProfessorAL2 implements ActionListener {

    private final ConsultaProfessor frame;
    private final ProfessorDAO dao = new ProfessorDAO();
    private Professor prof = new Professor();

    public ProfessorAL2(ConsultaProfessor frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String gac = e.getActionCommand();
        System.out.println(gac);
        if ("salvar".equals(gac)) {
            try {
                prof = frame.getProfessor();
                try {
                    dao.insert(prof);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    return;
                }
            } catch (Excecoes ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return;
            }
            JOptionPane.showMessageDialog(null, "Salvo com sucesso.");
        }

        if ("atualizar".equals(gac)) {
            try {
                prof = frame.getProfessor();
                try {
                    dao.update(prof);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    return;
                }
            } catch (Excecoes ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return;
            }
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso.");
        }

        if ("excluir".equals(gac)) {
            try {
                prof = frame.getProfessor();
                try {
                    dao.delete(prof);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    return;
                }
            } catch (Excecoes ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return;
            }
            JOptionPane.showMessageDialog(null, "Excluido com sucesso.");
        }
    }

}
