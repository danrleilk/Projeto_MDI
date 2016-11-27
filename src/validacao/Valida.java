package validacao;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Valida {

    public boolean validaVazio(JTextField Campo) {

        if (!Campo.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean validaArea(JTextArea Campo) {

        if (!Campo.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validaData(JTextField Campo) {

        if (Campo.getText().trim().replace("/", "").length() < 8) {
            return false;
        } else {
            return true;
        }
    }

}
