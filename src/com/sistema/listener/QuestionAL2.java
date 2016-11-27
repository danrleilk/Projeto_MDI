/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.listener;

import com.sistema.bd.QuestionDAO;
import com.sistema.bean.Question;
import com.sistema.janelas.ConsultaQuestion;
import excecoes.Excecoes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;

/**
 * @author Danrlei
 */
public class QuestionAL2 implements ActionListener {

    private final ConsultaQuestion frame;
    private final QuestionDAO dao = new QuestionDAO();
    private Question q = new Question();

    public QuestionAL2(ConsultaQuestion frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String gac = e.getActionCommand();

        if ("salvar".equals(gac)) {
            try {
                q = frame.getQuestion();
                try {
                    dao.insert(q);
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
                q = frame.getQuestion();
                try {
                    dao.update(q);
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
                q = frame.getQuestion();
                try {
                    dao.delete(q);
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
