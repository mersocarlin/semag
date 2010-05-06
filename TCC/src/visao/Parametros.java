/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package visao;

import threads.AtualizaMMQ;
import entrada.ModeloMatematico;
import entrada.Entrada;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JTextField;

/**
 *
 * @author Hemerson
 */
public class Parametros {
    private ModeloMatematico modelo;
    private String modeloMatematico;
    private String metodoEstimacao;
    private Entrada pontos;
    private List<Double> Y;
    private AtualizaMMQ atualiza;
    
    /* coordenadas de tela */
    private int umin;
    private int vmin;
    private int umax;
    private int vmax;

    /* coordenadas de mundo */
    private double xmax;
    private double ymax;

    /* variaveis para calculo do mmq */
    HashMap<Integer, Integer> hashMetodo;
    HashMap<Integer, Integer> hashModelo;
    List<Integer> listaValores;

    public Parametros() {
        this.modelo = new ModeloMatematico();
        this.modeloMatematico = "Modelo";
        this.metodoEstimacao = "Metodo";
        this.pontos = new Entrada();
        this.Y = new ArrayList<Double>();

        this.umin = 15;
        this.vmin = 20;
        this.umax = 0;
        this.vmax = 0;

        this.xmax = 0.0;
        this.ymax = 0.0;

        this.atualiza = new AtualizaMMQ();

        this.hashMetodo = new HashMap<Integer, Integer>();
        this.hashModelo = new HashMap<Integer, Integer>();
        this.listaValores = new ArrayList<Integer>();
    }

    public HashMap<Integer, Integer> getHashMetodo() {
        return hashMetodo;
    }

    public void setHashMetodo(HashMap<Integer, Integer> hashMetodo) {
        this.hashMetodo = hashMetodo;
    }

    public HashMap<Integer, Integer> getHashModelo() {
        return hashModelo;
    }

    public void setHashModelo(HashMap<Integer, Integer> hashModelo) {
        this.hashModelo = hashModelo;
    }

    public List<Integer> getListaValores() {
        return listaValores;
    }

    public void setListaValores(List<Integer> listaValores) {
        this.listaValores = new ArrayList<Integer>(listaValores);
    }

    public AtualizaMMQ getAtualiza() {
        return atualiza;
    }

    public void setAtualiza(JTextField mmq, String texto) {
        this.atualiza = new AtualizaMMQ();
        this.atualiza.setMmq(mmq);
        this.atualiza.setTexto(texto);
        this.atualiza.start();
    }    

    public List<Double> getY() {
        return Y;
    }

    public void setY(List<Double> Y) {
        this.Y = new ArrayList<Double>(Y);
    }

    public String getMetodoEstimacao() {
        return metodoEstimacao;
    }

    public void setMetodoEstimacao(String metodoEstimacao) {
        this.metodoEstimacao = metodoEstimacao;
    }

    public ModeloMatematico getModelo() {
        return modelo;
    }

    public void setModelo(ModeloMatematico modelo) {
        this.modelo = modelo;
    }

    public String getModeloMatematico() {
        return modeloMatematico;
    }

    public void setModeloMatematico(String modeloMatematico) {
        this.modeloMatematico = modeloMatematico;
    }

    public Entrada getPontos() {
        return pontos;
    }

    public void setPontos(Entrada pontos) {
        this.pontos = pontos;
    }

    public int getUmax() {
        return umax;
    }

    public void setUmax(int umax) {
        this.umax = umax;
    }

    public int getUmin() {
        return umin;
    }

    public void setUmin(int umin) {
        this.umin = umin;
    }

    public int getVmax() {
        return vmax;
    }

    public void setVmax(int vmax) {
        this.vmax = vmax;
    }

    public int getVmin() {
        return vmin;
    }

    public void setVmin(int vmin) {
        this.vmin = vmin;
    }

    public double getXmax() {
        return xmax;
    }

    public void setXmax(double xmax) {
        this.xmax = xmax;
    }

    public double getYmax() {
        return ymax;
    }

    public void setYmax(double ymax) {
        this.ymax = ymax;
    }
}
