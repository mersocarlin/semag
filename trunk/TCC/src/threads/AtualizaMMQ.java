/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import javax.swing.JTextField;

/**
 *
 * @author Hemerson
 */
public class AtualizaMMQ extends Thread {

    private JTextField mmq;
    private String texto;

    public AtualizaMMQ() {
        mmq = new JTextField();
        texto = "";
    }

    public AtualizaMMQ(JTextField mmq, String texto) {
        this.mmq = mmq;
        this.texto = texto;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            mmq.setText(texto);
        }
    }

    public JTextField getMmq() {
        return mmq;
    }

    public void setMmq(JTextField mmq) {
        this.mmq = mmq;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
