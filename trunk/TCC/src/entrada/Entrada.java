
package entrada;

import java.util.ArrayList;
import java.util.List;
import threads.BarraProgresso;

/**
 *
 * @author Hemerson
 */
public class Entrada {

    private List<H> distancias;
    private List<Ponto> listaPontos;
    private Metodo cressie;
    private Metodo matheron;
    private Metodo pairwise;
    private double cutoff;
    private double maiorH;

    public Entrada() {
        this.distancias = new ArrayList<H>();
        this.listaPontos = new ArrayList<Ponto>();
        this.cressie = new Metodo();
        this.matheron = new Metodo();
        this.pairwise = new Metodo();
        this.cutoff = 0.0;
        this.maiorH = 0.0;
    }

    public double getMaiorH() {
        return maiorH;
    }

    public void setMaiorH(double maiorH) {
        this.maiorH = maiorH;
    }

    public double getCutoff() {
        return cutoff;
    }

    public void setCutoff(double cutoff) {
        this.cutoff = cutoff;
    }

    public Metodo getCressie() {
        return cressie;
    }

    public void setCressie(Metodo cressie) {
        this.cressie = new Metodo(cressie);
    }

    public Metodo getMatheron() {
        return matheron;
    }

    public void setMatheron(Metodo matheron) {
        this.matheron = new Metodo(matheron);
    }

    public Metodo getPairwise() {
        return pairwise;
    }

    public void setPairwise(Metodo pairwise) {
        this.pairwise = new Metodo(pairwise);
    }

    public List<H> getDistancias() {
        return distancias;
    }

    public void setDistancias(List<H> distancias) {
        this.distancias = new ArrayList<H>(distancias);
    }

    public List<Ponto> getListaPontos() {
        return listaPontos;
    }

    public void setListaPontos(List<Ponto> listaPontos) {
        this.listaPontos = new ArrayList<Ponto>(listaPontos);
    }

    /**
     * retorna o valor de Ymax dos metodos de estimacao
     * @param metodoEstimacao Cressie, Matheron ou Pairwise
     * @return
     */
    public double getYMaxMetodo(String metodoEstimacao){
        if (metodoEstimacao.equals("Cressie")) {
            return this.cressie.getYmax();
        } else {
            if (metodoEstimacao.equals("Matheron")) {
                return this.matheron.getYmax();
            } else {
                if (metodoEstimacao.equals("Pairwise")) {
                    return this.pairwise.getYmax();
                }
            }
        }
        return 0.0;
    }

    /**
     * Verifica se a distancia H ja existe no conjunto de distancias
     * se ja existe, atualiza a ocorencia e calcula o valor da semivariacia para os metodos
     * se nao existe, adiciona na lista de distancias, atualiza a ocorrencia e calcula o
     * valor da semivariancia
     * @param h
     * @param Zs
     * @param Zsh
     */
    public void existeDistancia(H h, Ponto Zs, Ponto Zsh) {
        boolean existe = false;
        if (this.distancias.size() > 0) {
            for (int i = 0; i < this.distancias.size(); i++) {
                if (this.distancias.get(i).compareTo(h) == 0) {
                    this.distancias.get(i).setOcorrencia(this.distancias.get(i).getOcorrencia() + 1);
                    this.distancias.get(i).calculaMetodoEstimacao(Zs.getZ(), Zsh.getZ());
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                h.setOcorrencia(h.getOcorrencia() + 1);
                h.calculaMetodoEstimacao(Zs.getZ(), Zsh.getZ());
                this.distancias.add(h);
            }
        } else {
            h.setOcorrencia(h.getOcorrencia() + 1);
            h.calculaMetodoEstimacao(Zs.getZ(), Zsh.getZ());
            this.distancias.add(h);
        }

    }

    public void calculaDistancias(BarraProgresso t) {
        t.start();
        
        for (int i = 0; i < listaPontos.size(); i++) {
            t.POSICAO = (int)(((double)i/(double)listaPontos.size())*100);
            for (int j = i; j < listaPontos.size(); j++) {
                if (i != j) {
                    H h = new H();
                    h.setDistancia(listaPontos.get(i).distancia(listaPontos.get(j)));
                    Ponto Zs = new Ponto(listaPontos.get(i));
                    Ponto Zsh = new Ponto(listaPontos.get(j));
                    this.existeDistancia(h, Zs, Zsh);
                    
                    if(h.getDistancia() > this.maiorH){
                        this.maiorH = h.getDistancia();
                    }
                }
            }
        }
        t.POSICAO = 100;
        
        System.out.println("Distancias: " + this.distancias.size());
        /* atualiza o valor das variancias e seta os xmax e ymax pra plotagem na tela */
        for(int i = 0; i < this.distancias.size(); i++){
            distancias.get(i).atualizaMetodoEstimacao();
            if(this.distancias.get(i).getPairwise()> this.pairwise.getYmax()){
                this.pairwise.setYmax(this.distancias.get(i).getPairwise());
            }
            if(this.distancias.get(i).getCressie()> this.cressie.getYmax()){
                this.cressie.setYmax(this.distancias.get(i).getCressie());
            }
            if(this.distancias.get(i).getMatheron()> this.matheron.getYmax()){
                this.matheron.setYmax(this.distancias.get(i).getMatheron());
            }
            if(this.distancias.get(i).getDistancia()> this.pairwise.getXmax()){
                this.pairwise.setXmax(this.distancias.get(i).getDistancia());
                this.matheron.setXmax(this.distancias.get(i).getDistancia());
                this.cressie.setXmax(this.distancias.get(i).getDistancia());
            }
        }
    }
}
