package com.sistema.listener;

import com.sistema.bd.ProfessorDAO;
import com.sistema.bean.Professor;
import com.sistema.janelas.CadProfessor;
import excecoes.Excecoes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;

public class ProfessorAL implements ActionListener {

    private final CadProfessor frame;
    private ProfessorDAO dao = new ProfessorDAO();
    private Professor prof = new Professor();

    public ProfessorAL(CadProfessor frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String gac = e.getActionCommand();
        if ("cadastrar".equals(gac)) {
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
