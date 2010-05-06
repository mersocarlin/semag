
package entrada;

/**
 *
 * @author Hemerson
 */
public class H implements Comparable {

    private double distancia;
    private int ocorrencia;
    private double matheron;
    private double cressie;
    private double pairwise;

    public H() {
        this.distancia = 0.0;
        this.ocorrencia = 0;
        this.matheron = 0.0;
        this.cressie = 0.0;
        this.pairwise = 0.0;
    }

    public H(H h) {
        this.distancia = h.getDistancia();
        this.ocorrencia = h.getOcorrencia();
        this.matheron = h.getMatheron();
        this.cressie = h.getCressie();
        this.pairwise = h.getPairwise();
    }

    public int getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(int ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getCressie() {
        return cressie;
    }

    public void setCressie(double cressie) {
        this.cressie = cressie;
    }

    public double getMatheron() {
        return matheron;
    }

    public void setMatheron(double matheron) {
        this.matheron = matheron;
    }

    public double getPairwise() {
        return pairwise;
    }

    public void setPairwise(double pairwise) {
        this.pairwise = pairwise;
    }

    /**
     * Calcula o valor das semivariancias de H
     * @param Zs variavel Z(s)
     * @param Zsh variavel Z(s + h)
     */
    public void calculaMetodoEstimacao(double Zs, double Zsh) {
        this.matheron += Math.pow((Zs - Zsh), 2);
        double aux = Zs - Zsh;
        if ((aux) < 0) {
            aux = -aux;
        }
        this.cressie += Math.sqrt(aux);
        this.pairwise += Math.pow((Zs - Zsh) / (Zs + Zsh), 2);
    }

    /**
     * atualiza o valor dos metodos de atualizacao de acordo
     * com as respectivas formulas
     */
    public void atualizaMetodoEstimacao() {
        this.matheron = (1.0 / (2.0 * this.ocorrencia)) * this.matheron;

        double aux = (1.0 / this.ocorrencia);
        aux = aux * this.cressie;
        this.cressie = Math.pow(aux, 4) / (0.914 + (0.988 / this.ocorrencia));

        this.pairwise = (2.0 / this.ocorrencia) * this.pairwise;
    }

    /**
     * retorna o valor correspondente ao metodo de estimcao
     * @param metodoEstimacao Cressie, Matheron ou Pairwise
     * @return
     */
    public double getValorMetodo(String metodoEstimacao) {
        if (metodoEstimacao.equals("Cressie")) {
            return this.cressie;
        } else {
            if (metodoEstimacao.equals("Matheron")) {
                return this.matheron;
            } else {
                if (metodoEstimacao.equals("Pairwise")) {
                    return this.pairwise;
                }
            }
        }
        return 0.0;
    }

    public int compareTo(Object o) {
        H h1 = (H) o;
        if (this.distancia == h1.getDistancia()) {
            return 0;
        }
        return 1;
    }

    @Override
    public String toString() {
        return "Distancia: " + this.distancia + " - Ocorrencia: " + this.ocorrencia
                + " - Matheron: " + this.matheron + " - Cressie: " + this.cressie
                + " - Pairwise: " + this.pairwise;
    }
}
