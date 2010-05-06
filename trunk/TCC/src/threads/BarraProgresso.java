/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.util.concurrent.TimeUnit;
import javax.swing.JProgressBar;

/**
 *
 * @author Hemerson
 */
public class BarraProgresso extends Thread {

    public JProgressBar BARRA = null;
    public int POSICAO = 0;

    public BarraProgresso(JProgressBar BARRA, int POSICAO) {
        this.BARRA = BARRA;
        this.POSICAO = POSICAO;
    }

    @Override
    public void run() {
        try { /* execucao da thread */
            while (!Thread.currentThread().isInterrupted()) {
                BARRA.setValue(POSICAO);
                BARRA.getUI().update(BARRA.getGraphics(), BARRA);
                TimeUnit.MILLISECONDS.sleep(10);
            }
        } catch (InterruptedException e) {
        } finally { /* finalizacao da thread */
        }
    }
}
