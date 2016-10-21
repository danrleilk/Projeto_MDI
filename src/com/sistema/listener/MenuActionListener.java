package com.sistema.listener;

import com.sistema.janelas.CadAluno;
import com.sistema.janelas.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class MenuActionListener extends Menu implements ActionListener {

    private Menu frame;

    public MenuActionListener(Menu frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Novo Aluno".equals(e.getActionCommand())) {
            CadAluno ca = new CadAluno();
      
            ca.setVisible(true);
        } else if ("cancelar".equals(e.getActionCommand())) {
            JOptionPane.showMessageDialog(null, "Clicou no Cancelar");
        }
    }

}
