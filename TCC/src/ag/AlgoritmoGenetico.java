/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ag;

import entrada.ModeloMatematico;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import threads.BarraProgresso;
import visao.Parametros;

/**
 *
 * @author Hemerson
 */
public class AlgoritmoGenetico {

    private int tamanhoPopulacao;
    private double taxaMutacao;
    private double taxaCruzamento;
    private double elitismo;
    private int tamanhoGeracao;
    private List<Cromossomo> populacao;
    private List<List> geracoes;
    private String cruzamento;
    private String selecao;
    private String mutacao;

    public AlgoritmoGenetico() {
        this.tamanhoPopulacao = 0;
        this.taxaMutacao = 0.0;
        this.taxaCruzamento = 0.0;
        this.elitismo = 0;
        this.tamanhoGeracao = 0;
        this.populacao = new ArrayList<Cromossomo>();
        this.geracoes = new ArrayList<List>();
        this.cruzamento = "Media Simples";
        this.selecao = "Roleta";
        this.mutacao = "Randomica";
    }

    public double getElitismo() {
        return elitismo;
    }

    public void setElitismo(double elitismo) {
        this.elitismo = elitismo;
    }

    public List<List> getGeracoes() {
        return geracoes;
    }

    public void setGeracoes(List<List> geracoes) {
        this.geracoes = new ArrayList<List>(geracoes);
    }

    public int getTamanhoGeracao() {
        return tamanhoGeracao;
    }

    public void setTamanhoGeracao(int tamanhoGeracao) {
        this.tamanhoGeracao = tamanhoGeracao;
    }

    public int getTamanhoPopulacao() {
        return tamanhoPopulacao;
    }

    public void setTamanhoPopulacao(int tamanhoPopulacao) {
        this.tamanhoPopulacao = tamanhoPopulacao;
    }

    public double getTaxaCruzamento() {
        return taxaCruzamento;
    }

    public void setTaxaCruzamento(double taxaCruzamento) {
        this.taxaCruzamento = taxaCruzamento;
    }

    public double getTaxaMutacao() {
        return taxaMutacao;
    }

    public void setTaxaMutacao(double taxaMutacao) {
        this.taxaMutacao = taxaMutacao;
    }

    public List<Cromossomo> getPopulacao() {
        return populacao;
    }

    public void setPopulacao(List<Cromossomo> populacao) {
        this.populacao = new ArrayList<Cromossomo>(populacao);
    }

    public String getCruzamento() {
        return cruzamento;
    }

    public void setCruzamento(String cruzamento) {
        this.cruzamento = cruzamento;
    }

    public String getSelecao() {
        return selecao;
    }

    public void setSelecao(String selecao) {
        this.selecao = selecao;
    }

    public String getMutacao() {
        return mutacao;
    }

    public void setMutacao(String mutacao) {
        this.mutacao = mutacao;
    }

    /**
     * Cria a populacao inicial a partir de valores aleatorios de acordo com
     * os valores de maximo alcance, efeito pepita e contribuicao.
     * PS: Nao cria cromossomos repetidos.
     * @param maxAlcance
     * @param maxEP
     * @param param
     */
    public void geraPopulacaoInicial(int maxAlcance, double maxEP, Parametros param) {
        Random rand = new Random();
        while (this.populacao.size() < this.tamanhoPopulacao) {
            Cromossomo cromossomo = new Cromossomo();
            cromossomo.setAlcance(Math.max(1, rand.nextInt(maxAlcance)));
            cromossomo.setEfeitoPepita(Math.min(rand.nextDouble(), maxEP));
            cromossomo.setContribuicao(Math.min(rand.nextDouble(), maxEP));
            Double fitness = this.calculaFitness(cromossomo, param);
            cromossomo.setFitness(fitness);
            if (!cromossomo.getFitness().isInfinite()) {
                if (!this.isRepetido(cromossomo, this.populacao)) {
                    DecimalFormat df = new DecimalFormat("0.0000");
                    cromossomo.setEfeitoPepita(Double.parseDouble(df.format(cromossomo.getEfeitoPepita()).replace(",", ".")));
                    cromossomo.setContribuicao(Double.parseDouble(df.format(cromossomo.getContribuicao()).replace(",", ".")));
                    this.populacao.add(cromossomo);
                }
            } else {
                System.out.println("valor infinito na populacao inicial");
            }
        }
        /*Ordena por Fitness.*/
        Collections.sort(this.populacao);
    }

    public boolean isRepetido(Cromossomo cromossomo, List<Cromossomo> populacaoAtual) {
        for (int j = 0; j < populacaoAtual.size(); j++) {
            if (Double.compare(populacaoAtual.get(j).getFitness(), cromossomo.getFitness()) == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo cruzamento pela media simples segundo a formula: C = (P1 + P2)/2
     * @param P1 Cromossomo Pai 1
     * @param P2 Cromossomo Pai 2
     * @param param
     * @return novo Cromossomo filho se o valor randomizado for menor que a taxa de cruzamento
     * ou o filho fica igual ao pai com melhor aptidao
     */
    public Cromossomo cruzamentoMediaSimples(Cromossomo P1, Cromossomo P2, Parametros param) {
        Cromossomo filho = null;
        Random rand = new Random();
        double var = Math.min(rand.nextDouble(), 1.0);
        if (var < this.taxaCruzamento) {
            filho = new Cromossomo();
            filho.setAlcance((P1.getAlcance() + P2.getAlcance()) / 2);
            filho.setEfeitoPepita((P1.getEfeitoPepita() + P2.getEfeitoPepita()) / 2);
            filho.setContribuicao((P2.getContribuicao() + P2.getContribuicao()) / 2);
            Double fitness = this.calculaFitness(filho, param);
            filho.setFitness(fitness);
            return filho;
        } else {
            filho = P1.getFitness() < P2.getFitness() ? new Cromossomo(P1) : new Cromossomo(P2);
        }
        return filho;
    }

    /**
     * Metodo cruzamento pela media geometrica segundo a formula: C = raiz(P1^2 + P2^2)
     * @param P1 Cromossomo Pai 1
     * @param P2 Cromossomo Pai 2
     * @param param
     * @return novo Cromossomo filho se o valor randomizado for menor que a taxa de cruzamento
     * ou o filho fica igual ao pai com melhor aptidao
     */
    public Cromossomo cruzamentoMediaGeometrica(Cromossomo P1, Cromossomo P2, Parametros param) {
        Cromossomo filho = new Cromossomo();
        Random rand = new Random();
        double var = Math.min(rand.nextDouble(), 1.0);
        if (var < this.taxaCruzamento) {
            filho.setAlcance((int) Math.sqrt(Math.pow(P1.getAlcance(), 2.0) + Math.pow(P2.getAlcance(), 2.0)));
            filho.setEfeitoPepita(Math.sqrt(Math.pow(P1.getEfeitoPepita(), 2.0) + Math.pow(P2.getEfeitoPepita(), 2.0)));
            filho.setContribuicao(Math.sqrt(Math.pow(P1.getContribuicao(), 2.0) + Math.pow(P2.getContribuicao(), 2.0)));
            Double fitness = this.calculaFitness(filho, param);
            filho.setFitness(fitness);
        } else {
            filho = P1.getFitness() < P2.getFitness() ? new Cromossomo(P1) : new Cromossomo(P2);
        }
        return filho;
    }

    /**
     * Metodo de cruzamento heutistico segundo a formula: C = P1 + r (P1 - P2), onde f(P1) > f(P2) e .
     * r um valor de 0 a 1. Este metodo favorece o pai com fitness maior
     * @param P1 Cromossomo Pai 1
     * @param P2 Cromossomo Pai 2
     * @param param
     * @return novo Cromossomo filho se o valor randomizado for menor que a taxa de cruzamento
     * ou o filho fica igual ao pai com melhor aptidao
     */
    public Cromossomo cruzamentoHeuristico(Cromossomo P1, Cromossomo P2, Parametros param) {
        Cromossomo filho = null;
        Random rand = new Random();

        double var = Math.min(rand.nextDouble(), 1.0);
        if (var < this.taxaCruzamento) {
            filho = new Cromossomo();

            double maior = Math.max(P1.getAlcance(), P2.getAlcance());
            double menor = Math.min(P1.getAlcance(), P2.getAlcance());
            double r = Math.min(rand.nextDouble(), 1.0);
            filho.setAlcance(Math.max(0, (int) (maior + r * (maior - menor))));

            maior = Math.max(P1.getEfeitoPepita(), P2.getEfeitoPepita());
            menor = Math.min(P1.getEfeitoPepita(), P2.getEfeitoPepita());
            r = Math.min(rand.nextDouble(), 1.0);
            filho.setEfeitoPepita(Math.min(1.0, (maior + r * (maior - menor))));

            maior = Math.max(P1.getContribuicao(), P2.getContribuicao());
            menor = Math.min(P1.getContribuicao(), P2.getContribuicao());
            r = Math.min(rand.nextDouble(), 1.0);
            filho.setContribuicao(Math.min(1.0, (maior + r * (maior - menor))));
            //filho.validaCromossomo();
            Double fitness = this.calculaFitness(filho, param);
            filho.setFitness(fitness);
        } else {
            filho = P1.getFitness() < P2.getFitness() ? new Cromossomo(P1) : new Cromossomo(P2);
        }
        return filho;
    }

    /**
     * Metodo cruzamento aritmetico, retorna dois filhos gerados pelas respectivas equacoes:
     * C1 = B * P1 + (1 - B) * P2 e C2 = (1 - B) P1 + B * P2, onde O < B < 1
     * @param P1 Cromossomo Pai 1
     * @param P2 Cromossomo Pai 1
     * @param param
     * @return novo Cromossomo filho se o valor randomizado for menor que a taxa de cruzamento
     * ou os filhos ficam iguais aos pais
     */
    public List<Cromossomo> cruzamentoAritmetico(Cromossomo P1, Cromossomo P2, Parametros param) {
        List lista = new ArrayList<Cromossomo>();
        Cromossomo filho1 = null;
        Cromossomo filho2 = null;
        Random rand = new Random();
        double beta = 0.0;

        double var = Math.min(rand.nextDouble(), 1.0);
        if (var < this.taxaCruzamento) {
            filho1 = new Cromossomo();
            filho2 = new Cromossomo();
            beta = Math.min(rand.nextDouble(), 1.0);
            filho1.setAlcance((int) (beta * P1.getAlcance() + (1 - beta) * P2.getAlcance()));
            filho2.setAlcance((int) (beta * P2.getAlcance() + (1 - beta) * P1.getAlcance()));

            beta = Math.min(rand.nextDouble(), 1.0);
            filho1.setEfeitoPepita(beta * P1.getEfeitoPepita() + (1 - beta) * P2.getEfeitoPepita());
            filho2.setEfeitoPepita(beta * P2.getEfeitoPepita() + (1 - beta) * P1.getEfeitoPepita());

            beta = Math.min(rand.nextDouble(), 1.0);
            filho1.setContribuicao(beta * P1.getContribuicao() + (1 - beta) * P2.getContribuicao());
            filho2.setContribuicao(beta * P2.getContribuicao() + (1 - beta) * P1.getContribuicao());

            Double fitness = this.calculaFitness(filho1, param);
            filho1.setFitness(fitness);
            fitness = this.calculaFitness(filho2, param);
            filho2.setFitness(fitness);
        } else {
            filho1 = new Cromossomo(P1);
            filho2 = new Cromossomo(P2);
        }
        lista.add(filho1);
        lista.add(filho2);
        return lista;
    }

    /**
     * Metodo cruzamento BLX-alfa, retorna dois filhos gerados pelas respectivas equacoes:
     * C1 = P1 + B * (P2 - P1), onde -alfa < B < 1 + alfa e alfa é um pequeno valor que
     * estende os limites para a definição de C. alfa pode ser = 0.5
     * @param P1 Cromossomo Pai 1
     * @param P2 Cromossomo Pai 1
     * @param param
     * @return novo Cromossomo filho se o valor randomizado for menor que a taxa de cruzamento
     * ou o filho fica igual ao pai com melhor aptidao
     */
    public Cromossomo cruzamentoBLX(Cromossomo P1, Cromossomo P2, int maxAlcance, double maxEP, Parametros param) {
        Cromossomo filho = null;
        Random rand = new Random();
        double alfa = 0.5;

        double var = Math.min(rand.nextDouble(), 1.0);
        if (var < this.taxaCruzamento) {
            double beta = 5.0;
            while (!((beta > (-alfa)) && (beta < (1 + alfa)))) {
                beta = rand.nextDouble();
            }
            filho = new Cromossomo();
            filho.setAlcance(Math.min((int) (P1.getAlcance() + beta * (P2.getAlcance() - P1.getAlcance())), maxAlcance));
            beta = 5.0;
            while (!((beta > (-alfa)) && (beta < (1 + alfa)))) {
                beta = rand.nextDouble();
            }
            filho.setEfeitoPepita(P1.getEfeitoPepita() + beta * (P2.getEfeitoPepita() - P1.getEfeitoPepita()));
            beta = 5.0;
            while (!((beta > (-alfa)) && (beta < (1 + alfa)))) {
                beta = rand.nextDouble();
            }
            filho.setContribuicao(P1.getContribuicao() + beta * (P2.getContribuicao() - P1.getContribuicao()));
        } else {
            filho = P1.getFitness() > P2.getFitness() ? new Cromossomo(P1) : new Cromossomo(P2);
        }
        Double fitness = this.calculaFitness(filho, param);
        filho.setFitness(fitness);
        return filho;
    }

    /**
     * Soma ou subtrai uma pequena parcela ao valor contido no cromossomo
     * @param cromossomo
     * @param maxAlcance
     * @param maxEP
     * @param param
     * @return
     */
    public Cromossomo mutacaoCreep(Cromossomo cromossomo, int maxAlcance, double maxEP, Parametros param) {
        Random rand = new Random();
        double valor = 0.0;

        if (rand.nextBoolean()) { /* faz a soma */
            cromossomo.setAlcance(Math.min(cromossomo.getAlcance() + rand.nextInt(maxAlcance), maxAlcance));
            valor = Math.min(rand.nextDouble(), 1.0);
            cromossomo.setEfeitoPepita(Math.min(cromossomo.getEfeitoPepita() + valor, 1.0));
            valor = Math.min(rand.nextDouble(), 1.0);
            cromossomo.setContribuicao(Math.min(cromossomo.getContribuicao() + valor, 1.0));
        } else { /* faz a subtracao */
            int alcance = cromossomo.getAlcance() - rand.nextInt(maxAlcance);
            cromossomo.setAlcance(alcance > 0 ? alcance : cromossomo.getAlcance());
            valor = Math.min(rand.nextDouble(), 1.0);
            valor = cromossomo.getEfeitoPepita() - valor;
            cromossomo.setEfeitoPepita(valor > 0.0 ? valor : cromossomo.getEfeitoPepita());
            valor = Math.min(rand.nextDouble(), 1.0);
            valor = cromossomo.getContribuicao() - valor;
            cromossomo.setContribuicao(valor > 0.0 ? valor : cromossomo.getContribuicao());
        }
        Double fitness = this.calculaFitness(cromossomo, param);
        cromossomo.setFitness(fitness);
        return cromossomo;
    }

    public Cromossomo mutacaoGaussiana(Cromossomo cromossomo, int maxAlcance, double maxEP, Parametros param) {
        Random rand = new Random();
        cromossomo.setAlcance(rand.nextInt(maxAlcance));
        cromossomo.setEfeitoPepita(Math.min(rand.nextDouble(), maxEP));
        cromossomo.setContribuicao(Math.min(rand.nextDouble(), maxEP));
        Double fitness = this.calculaFitness(cromossomo, param);
        cromossomo.setFitness(fitness);
        return cromossomo;
    }

    public Cromossomo mutacaoNaoUniforme(Cromossomo cromossomo, int maxAlcance, double maxEP, Parametros param) {
        Random rand = new Random();
        cromossomo.setAlcance(rand.nextInt(maxAlcance));
        cromossomo.setEfeitoPepita(Math.min(rand.nextDouble(), maxEP));
        cromossomo.setContribuicao(Math.min(rand.nextDouble(), maxEP));
        Double fitness = this.calculaFitness(cromossomo, param);
        cromossomo.setFitness(fitness);
        return cromossomo;
    }

    public Cromossomo mutacaoNaoUniformeMultipla(Cromossomo cromossomo, int maxAlcance, double maxEP, Parametros param) {
        Random rand = new Random();
        cromossomo.setAlcance(rand.nextInt(maxAlcance));
        cromossomo.setEfeitoPepita(Math.min(rand.nextDouble(), maxEP));
        cromossomo.setContribuicao(Math.min(rand.nextDouble(), maxEP));
        Double fitness = this.calculaFitness(cromossomo, param);
        cromossomo.setFitness(fitness);
        return cromossomo;
    }

    /**
     * Multiplica o valor atual do cromossomo por outro randomizado entre 0 e 1
     * @param cromossomo
     * @param maxAlcance
     * @param maxEP
     * @param param
     * @return
     */
    public Cromossomo mutacaoUniforme(Cromossomo cromossomo, int maxAlcance, double maxEP, Parametros param) {
        Random rand = new Random();
        cromossomo.setAlcance(Math.max(Math.min((int) (cromossomo.getAlcance() * rand.nextDouble()), maxAlcance), 1));
        cromossomo.setEfeitoPepita(Math.min(rand.nextDouble() * cromossomo.getEfeitoPepita(), maxEP));
        cromossomo.setContribuicao(Math.min(rand.nextDouble() * cromossomo.getContribuicao(), maxEP));
        Double fitness = this.calculaFitness(cromossomo, param);
        cromossomo.setFitness(fitness);
        return cromossomo;
    }

    public Double calculaFitness(Cromossomo cromossomo, Parametros param) {
        param.setModelo(new ModeloMatematico(cromossomo.getAlcance(), cromossomo.getEfeitoPepita(), cromossomo.getContribuicao()));

        param.setY(new ArrayList(param.getModelo().calculaModeloMatematico(param.getUmax(), param.getModeloMatematico())));
        param.setYmax(((Double) param.getY().get(param.getY().size() - 1)) + 0.3); //atualiza proporcao da tela

        param.setHashModelo(new HashMap<Integer, Integer>());
        for (int i = 0; i < param.getUmax(); i++) {
            int y = (int) this.transformaCoordenadaY((Double) param.getY().get(i), param);
            /* armazena valores para calculo do mmq */
            param.getHashModelo().put((i + param.getUmin()), ((param.getVmax() - y) + param.getVmin()));
        }
        param.getModelo().calculaMMQ(param);
        Double fitness = (100 / param.getModelo().getMmq());
        return fitness;
    }

    private double transformaCoordenadaY(double y, Parametros param) {
        return (param.getVmax() / param.getYmax()) * y;
    }

    public double getSomaFitness() {
        double somaFitness = 0.0;
        for (int i = 0; i < this.populacao.size(); i++) {
            somaFitness += this.populacao.get(i).getFitness();
        }
        return somaFitness;
    }

    /**
     * Metodo de selecao por roleta: randomiza um numero de 0 ate a soma total dos fitness.
     * Somando-se os fitness, retorna o cromossomo que possui a soma maior
     * do que o valor randomizado
     * @return 
     */
    public Cromossomo selecaoRouletteWheel() {
        Random rand = new Random();
        double somaFitness = this.getSomaFitness();
        double roda = Math.min(somaFitness * rand.nextDouble(), somaFitness);
        double cont = 0.0;
        for (int i = 0; i < this.populacao.size(); i++) {
            cont += this.populacao.get(i).getFitness();
            if (roda <= cont) {
                return this.populacao.get(i);
            }
        }
        return null;
    }

    /**
     * 2 ou mais indivíduos são sorteados aleatoriamente e o indivíduo com o
     * melhor valor de aptidão é selecionado.
     * @return
     */
    public Cromossomo selecaoTorneio() {
        Random rand = new Random();
        Cromossomo f1 = new Cromossomo();
        f1.setFitness(-0.999);
        int numSorteios = Math.max(2, rand.nextInt(this.populacao.size()) / 2);
        for (int i = 0; i < numSorteios; i++) {
            int pos = rand.nextInt(populacao.size());
            if (this.populacao.get(pos).getFitness() > f1.getFitness()) {
                f1 = new Cromossomo(this.populacao.get(pos));
            }
        }
        return f1;
    }

    /**
     * Retorna o cromossomo selecionado de acordo com o
     * metodo de selecao do AG: Rank, Roleta ou Torneio
     * @return
     */
    public Cromossomo selecionaCromossomo() {
        return this.selecao.equals("Rank") ? null
                : (this.selecao.equals("Roleta") ? new Cromossomo(this.selecaoRouletteWheel())
                : (this.selecao.equals("Torneio") ? new Cromossomo(this.selecaoTorneio())
                : new Cromossomo(this.selecaoRouletteWheel())));
    }

    public Cromossomo cruzaCromossomo(Cromossomo P1, Cromossomo P2, int maxAlcance, double maxEP, Parametros Param) {
        return this.cruzamento.equals("BLX") ? new Cromossomo(this.cruzamentoBLX(P1, P2, maxAlcance, maxEP, Param))
                : (this.cruzamento.equals("Heuristico") ? new Cromossomo(this.cruzamentoHeuristico(P1, P2, Param))
                : (this.cruzamento.equals("Media Geometrica") ? new Cromossomo(this.cruzamentoMediaGeometrica(P1, P2, Param))
                : (this.cruzamento.equals("Media Simples") ? new Cromossomo(this.cruzamentoMediaSimples(P1, P2, Param))
                : new Cromossomo(this.cruzamentoMediaSimples(P1, P2, Param)))));
    }

    public Cromossomo mutaCromossomo(Cromossomo cromossomo, int maxAlcance, double maxEP, Parametros Param) {
        return this.mutacao.equals("Creep") ? new Cromossomo(this.mutacaoCreep(cromossomo, maxAlcance, maxEP, Param))
                : (this.mutacao.equals("Gaussiana") ? new Cromossomo(this.mutacaoGaussiana(cromossomo, maxAlcance, maxEP, Param))
                : (this.mutacao.equals("Nao-Uniforme") ? new Cromossomo(this.mutacaoNaoUniforme(cromossomo, maxAlcance, maxEP, Param))
                : (this.mutacao.equals("Nao-Uniforme Multipla") ? new Cromossomo(this.mutacaoNaoUniformeMultipla(cromossomo, maxAlcance, maxEP, Param))
                : (this.mutacao.equals("Uniforme") ? this.mutacaoUniforme(cromossomo, maxAlcance, maxEP, Param)
                : this.mutacaoUniforme(cromossomo, maxAlcance, maxEP, Param)))));
    }

    public List<Cromossomo> elitismo() {
        List<Cromossomo> lista = new ArrayList<Cromossomo>();
        List<Cromossomo> populacaoAtual = new ArrayList<Cromossomo>(this.geracoes.get(this.geracoes.size() - 1));

        for (int i = populacaoAtual.size() - 1; i >= 0; i--) {
            lista.add(populacaoAtual.get(i));
            if (lista.size() == (this.elitismo * this.populacao.size())) {
                break;
            }
        }
        return lista;
    }

    public void inicia(int maxAlcance, double maxEP, Parametros param, BarraProgresso t,
            JTextArea jTextAreaResultado, DefaultTableModel modeloResultado) {
        jTextAreaResultado.setText("");
        jTextAreaResultado.append("Modelo Matemático: " + param.getModeloMatematico() + "\n");
        jTextAreaResultado.append("Método de Estimação: " + param.getMetodoEstimacao() + "\n");
        jTextAreaResultado.append("\n");
        jTextAreaResultado.append("***** AG ***** \n");
        jTextAreaResultado.append(this.toString());
        Object linha[] = new Object[]{};
        try {
            t.start();
            Random rand = new Random();
            this.geraPopulacaoInicial(maxAlcance, maxEP, param);

            linha = new Object[]{"", "", "", ""};
            modeloResultado.addRow(linha);
            linha = new Object[]{"GERAÇÃO 1", "", "", ""};
            modeloResultado.addRow(linha);
            for (int i = 0; i < populacao.size(); i++) {
                Cromossomo cromossomo = new Cromossomo(populacao.get(i));
                linha = new Object[]{cromossomo.getAlcance(), cromossomo.getEfeitoPepita(), cromossomo.getContribuicao(), cromossomo.getFitness()};
                modeloResultado.addRow(linha);
            }

            this.getGeracoes().add(this.getPopulacao());
            for (int i = 0; i < this.getTamanhoGeracao() - 1; i++) {
                t.POSICAO = ((i + 1) * 100) / this.tamanhoGeracao;

                /* ELITISMO */
                List<Cromossomo> proxPopulacao = new ArrayList<Cromossomo>(this.elitismo());

                while (proxPopulacao.size() < this.populacao.size()) {
                    /* SELECAO */
                    Cromossomo P1 = new Cromossomo(this.selecionaCromossomo());
                    Cromossomo P2 = new Cromossomo(this.selecionaCromossomo());
                    while (P2.compareTo(P1) == 0) {
                        P2 = new Cromossomo(this.selecionaCromossomo());
                    }

                    List<Cromossomo> cromossomos = new ArrayList<Cromossomo>();

                    /* CRUZAMENTO */
                    if (this.getCruzamento().equals("Aritmetico")) {
                        cromossomos = new ArrayList<Cromossomo>(this.cruzamentoAritmetico(P1, P2, param));
                    } else {
                        Cromossomo filho = new Cromossomo(this.cruzaCromossomo(P1, P2, maxAlcance, maxEP, param));
                        if (!filho.getFitness().isInfinite()) {
                            cromossomos.add(filho);
                        } else {
                            System.out.println("fitness infinito");
                        }
                    }

                    /* MUTACAO */
                    List<Cromossomo> cromossomosMutados = new ArrayList<Cromossomo>();
                    for (int j = 0; j < cromossomos.size(); j++) {
                        Cromossomo cromossomo = cromossomos.get(j);
                        if (Math.min(rand.nextDouble(), 1.0) < this.getTaxaMutacao()) {
                            cromossomo = new Cromossomo(this.mutaCromossomo(cromossomo, maxAlcance, maxEP, param));
                            if (cromossomo.getFitness().isInfinite()) {
                                System.out.println("valor inf");
                            }
                        }
                        cromossomosMutados.add(cromossomo);
                    }

                    DecimalFormat df = new DecimalFormat("0.0000");
                    for (int j = 0; j < cromossomosMutados.size(); j++) {
                        Cromossomo cromossomo = new Cromossomo(cromossomosMutados.get(j));
                        cromossomo.setEfeitoPepita(Double.parseDouble(df.format(cromossomo.getEfeitoPepita()).replace(",", ".")));
                        cromossomo.setContribuicao(Double.parseDouble(df.format(cromossomo.getContribuicao()).replace(",", ".")));
                        proxPopulacao.add(cromossomo);
//                        if(!ag.isRepetido(cromossomos.get(j),proxPopulacao)){
//                            proxPopulacao.add(cromossomos.get(j));
//                        }
                    }
                }

                /* Ordena por Fitness */
                Collections.sort(proxPopulacao);

                linha = new Object[]{"", "", "", ""};
                modeloResultado.addRow(linha);
                linha = new Object[]{"GERAÇÃO " + (i + 2), "", "", ""};
                modeloResultado.addRow(linha);
                for (int j = 0; j < proxPopulacao.size(); j++) {
                    Cromossomo cromossomo = new Cromossomo(proxPopulacao.get(j));
                    linha = new Object[]{cromossomo.getAlcance(), cromossomo.getEfeitoPepita(), cromossomo.getContribuicao(), cromossomo.getFitness()};
                    modeloResultado.addRow(linha);
                }
                this.getGeracoes().add(proxPopulacao);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }

    @Override
    public String toString() {
        return "Tamanho da População: " + this.tamanhoPopulacao + "\n"
                + "Gerações: " + this.tamanhoGeracao + "\n"
                + "Tx Cruzamento: " + this.taxaCruzamento * 100 + "%\n"
                + "Tx Mutação: " + this.taxaMutacao * 100 + "%\n"
                + "Elitismo: " + this.elitismo * 100 + "%\n"
                + "Mutação: " + this.mutacao + "\n"
                + "Seleção: " + this.selecao + "\n"
                + "Cruzamento: " + this.cruzamento + "\n";
    }
}


