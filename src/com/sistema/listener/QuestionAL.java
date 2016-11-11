/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.listener;

import com.sistema.bd.QuestionDAO;
import com.sistema.bean.Question;
import com.sistema.janelas.CadQuestion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * @author Danrlei
 */
public class QuestionAL implements ActionListener {

    private final CadQuestion frame;
    private QuestionDAO dao = new QuestionDAO();

    public QuestionAL(CadQuestion frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("cadastrar".equals(e.getActionCommand())) {
            Question q = new Question();
            q = frame.getQuestion();
            dao.insert(q);
            frame.dispose();
        } else if ("cancelar".equals(e.getActionCommand())) {
            frame.dispose();
        }
    }

}
