/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.listener;

import com.sistema.janelas.CadQuestion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 *
 * @author Danrlei
 */
public class QuestionAL implements ActionListener {

    private final CadQuestion frame;

    public QuestionAL(CadQuestion frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("cadastrar".equals(e.getActionCommand())) {
            try {
                Log.escrever("Cadastrou Professor ");
                Gravar.escrever("Questions.txt", frame.getQuestion().getEnunciado() + " \n ");
                Gravar.escrever("Questions.txt", frame.getQuestion().getA() + " : ");
                Gravar.escrever("Questions.txt", frame.getQuestion().getB() + " : ");
                Gravar.escrever("Questions.txt", frame.getQuestion().getC() + " : ");
                Gravar.escrever("Questions.txt", frame.getQuestion().getD() + " \n ");
                Gravar.escrever("Questions.txt", frame.getQuestion().getResp() + " ; ");

                frame.dispose();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if ("cancelar".equals(e.getActionCommand())) {
            frame.dispose();
        }
    }

}
