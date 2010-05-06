/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag;

/**
 *
 * @author Hemerson
 */
public class Cromossomo implements Comparable{
    private int alcance;
    private double efeitoPepita;
    private double contribuicao;
    private Double fitness;

    public Cromossomo() {
        this.alcance = 0;
        this.efeitoPepita = 0.0;
        this.contribuicao = 0.0;
        this.fitness = 0.0;
    }

    public Cromossomo(int alcance, double efeitoPepita, double contribuicao, Double fitness) {
        this.alcance = alcance;
        this.efeitoPepita = efeitoPepita;
        this.contribuicao = contribuicao;
        this.fitness = fitness;
    }

    public Cromossomo(Cromossomo cromossomo) {
        this.alcance = cromossomo.getAlcance();
        this.efeitoPepita = cromossomo.getEfeitoPepita();
        this.contribuicao = cromossomo.getContribuicao();
        this.fitness = cromossomo.getFitness();
    }

    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    public double getContribuicao() {
        return contribuicao;
    }

    public void setContribuicao(double contribuicao) {
        this.contribuicao = contribuicao;
    }

    public double getEfeitoPepita() {
        return efeitoPepita;
    }

    public void setEfeitoPepita(double efeitoPepita) {
        this.efeitoPepita = efeitoPepita;
    }

    public Double getFitness() {
        return fitness;
    }

    public void setFitness(Double fitness) {
        this.fitness = fitness;
    }

    public int compareTo(Object o) {
        Cromossomo crom = (Cromossomo)o;
        return this.fitness.compareTo(crom.getFitness());
    }

//    public void validaCromossomo(){
//        if(this.alcance == 0){
//            this.alcance = 244;
//        }
//        if(this.efeitoPepita == 0.0){
//            this.efeitoPepita = 0.1;
//        }
//        if(this.contribuicao == 0.0){
//            this.contribuicao = 0.1;
//        }
//    }

    @Override
    public String toString() {
        String retorno = "A: " + this.alcance + " ";
        retorno += "C0: " + this.efeitoPepita + " ";
        retorno += "C1: " + this.contribuicao + " ";
        retorno += "MMQ: " + this.fitness + " ";
        return retorno;
    }
}
