package entrada;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import visao.Parametros;

/**
 *
 * @author Hemerson
 */
public class ModeloMatematico {

    private int alcance;
    private double efeitoPepita;
    private double contribuicao;
    private double mmq;
    private List<Integer> valoresTela; //valores de Y para tela - pontos lidos

    public ModeloMatematico() {
        this.alcance = 0;
        this.efeitoPepita = 0.0;
        this.contribuicao = 0.0;
        this.mmq = 0.0;
        this.valoresTela = new ArrayList<Integer>();
    }

    public ModeloMatematico(int alcance, double efeitoPepita, double contribuicao) {
        this.alcance = alcance;
        this.efeitoPepita = efeitoPepita;
        this.contribuicao = contribuicao;
        this.mmq = 0.0;
    }

    public ModeloMatematico(ModeloMatematico modeloMatematico) {
        this.alcance = modeloMatematico.getAlcance();
        this.efeitoPepita = modeloMatematico.getEfeitoPepita();
        this.contribuicao = modeloMatematico.getContribuicao();
        this.mmq = modeloMatematico.getMmq();
        this.valoresTela = new ArrayList<Integer>(modeloMatematico.getValoresTela());
    }

    /**
     * Para cada ponto x da tela (de 0 ate umax), calcula um y correspondente de acordo com o modelo matematico
     * @param umax
     * @param modeloMatematico
     * @return
     */
    public List calculaModeloMatematico(int umax, String modeloMatematico) {
        List Y = new ArrayList<Double>();
        try {
            for (int i = 0; i < umax; i++) {
                double h = (double) i;
                double ha = h / this.alcance; /*(h/a) utilizado nas formulas*/
                double aux = 0.0;

                if (modeloMatematico.equals("Circular")) { // 0 < h < a
                    if (h > this.alcance) {
                        Y.add(Y.size() > 0 ? Y.get(Y.size() - 1) : 0);
                    } else {
                        double div = (2 * (this.efeitoPepita + this.contribuicao)) / Math.PI;
                        double raiz = ha * Math.sqrt(1.0 - Math.pow(ha, 2));
                        double circular = div * (raiz + Math.asin(ha));
                        Y.add(circular);
                    }
                } else {
                    if (modeloMatematico.equals("Esferico")) {
                        if (h >= this.alcance) {
                            Y.add(Y.size() > 0 ? Y.get(Y.size() - 1) : 0);
                        } else {
                            aux = 1.5 * ha;
                            aux -= 0.5 * Math.pow(ha, 3);
                            Y.add((this.efeitoPepita + (this.contribuicao * aux)));
                        }
                    } else {
                        if (modeloMatematico.equals("Exponencial")) {
                            if (h >= this.alcance) {
                                Y.add(Y.size() > 0 ? Y.get(Y.size() - 1) : 0);
                            } else {
                                aux = this.efeitoPepita + this.contribuicao * (1.0 - Math.exp(-3.0 * ha));
                                Y.add(aux);
                            }
                        } else {
                            if (modeloMatematico.equals("Gaussiano")) {
                                if (h >= this.alcance) {
                                    Y.add(Y.size() > 0 ? Y.get(Y.size() - 1) : 0);
                                } else {
                                    aux = -3.0 * Math.pow(ha, 2);
                                    Y.add((this.efeitoPepita + this.contribuicao * (1.0 - Math.exp(aux))));
                                }
                            } else {
                                if (modeloMatematico.equals("Linear")) {
                                    if (h >= this.alcance) {
                                        Y.add(Y.size() > 0 ? Y.get(Y.size() - 1) : 0);
                                    } else {
                                        Y.add((this.efeitoPepita + (this.contribuicao * (ha))));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("erro calculaModeloMatematico: " + e);
            return null;
        }
        return Y;
    }

    public double getMmq() {
        return mmq;
    }

    public List<Integer> getValoresTela() {
        return valoresTela;
    }

    public void setValoresTela(List<Integer> valoresTela) {
        this.valoresTela = new ArrayList<Integer>(valoresTela);
    }

    /**
     * Calcula o valor do mmq. Para cada H calculado nos pontos de entrada, faz o calculo:
     * H.getValorModelo() - Y.get(H.getDistancia())
     * @param metodoEstimacao
     * @param modeloMatematico
     * @param pontos
     * @param Y
     */
    public void calculaMMQ(Parametros param) {
        this.mmq = 0;
        if ((!param.getMetodoEstimacao().equals("Metodo")) && (!param.getModeloMatematico().equals("Modelo"))) {
            DecimalFormat aproximador = new DecimalFormat("000,000.00");
            for (int i = 0; i < param.getListaValores().size(); i++) {
                Integer coordX = param.getListaValores().get(i);
                Integer yMetodo = (param.getHashMetodo().get(coordX));
                if (param.getHashModelo().containsKey(coordX)) {
                    Integer yModelo = (param.getHashModelo().get(coordX));
                    mmq += Math.pow(yMetodo - yModelo, 2);
                }
            }
            //mmq = Double.parseDouble(aproximador.format(mmq).replace(',', '.'));
        }
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
}
