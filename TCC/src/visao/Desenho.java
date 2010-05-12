/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import entrada.H;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Hemerson
 */
public class Desenho extends JPanel {

    Parametros param = new Parametros();
    XYSeriesCollection dataset = new XYSeriesCollection();
    int altura;
    int largura;

    public Desenho() {
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        dataset = new XYSeriesCollection();
        XYSeries xy = this.desenhaMetodoEstimacao(g);
        dataset.addSeries(xy != null ? xy : new XYSeries(""));
        xy = this.desenhaModeloMatematico(g);
        dataset.addSeries(xy != null ? xy : new XYSeries(""));

        this.desenhaGrafico(g);
    }

    /**
     * Plota todas as distancias H na tela, onde:
     * coordX = valor da distancia H (mapeada para coordenada de tela)
     * coordY = valor calculado do metodo de estimacao (Cressie, Pairwise ou Matheron)
     * @param g
     */
    private XYSeries desenhaMetodoEstimacao(Graphics g) {
        if (!param.getMetodoEstimacao().equals("Metodo")) {
            try {
                param.setYmax(param.getPontos().getYMaxMetodo(param.getMetodoEstimacao()));
                param.setListaValores(new ArrayList<Integer>());
                param.setHashMetodo(new HashMap<Integer, Integer>());

                List<Integer> listaX = new ArrayList<Integer>();
                List<Integer> listaY = new ArrayList<Integer>();
                for (int i = 0; i < param.getPontos().getDistancias().size(); i++) {
                    H h = new H(param.getPontos().getDistancias().get(i));
                    if (h.getDistancia() < param.getPontos().getCutoff()) {
                        int coordXtela = (int) this.transformaCoordenadaX(h.getDistancia());
                        int coordYtela = 0;
                        coordYtela = (int) this.transformaCoordenadaY(h.getValorMetodo(param.getMetodoEstimacao()));

                        /* armazena valores para calculo do mmq */
                        if (!param.getListaValores().contains(coordXtela)) {
                            param.getListaValores().add(coordXtela);
                        }
                        param.getHashMetodo().put(coordXtela, ((param.getVmax() - coordYtela) + param.getVmin()));
                        listaX.add(coordXtela);
                        listaY.add(coordYtela + param.getVmin());
                    }
                }
                return gerarGraficoPontos("titulo", "eixoX", "eixoY", listaX, listaY);
            } catch (Exception e) {
            }
        }
        return null;
    }

    private XYSeries desenhaModeloMatematico(Graphics g) {
        try {
            param.setY(new ArrayList(param.getModelo().calculaModeloMatematico(param.getUmax(), param.getModeloMatematico())));
            param.setYmax(((Double) param.getY().get(param.getY().size() - 1)) + 0.3); //atualiza proporcao da tela
            param.setHashModelo(new HashMap<Integer, Integer>());
            List<Integer> listaX = new ArrayList<Integer>();
            List<Integer> listaY = new ArrayList<Integer>();
            for (int i = 0; i < param.getUmax(); i++) {
                int y = (int) this.transformaCoordenadaY((Double) param.getY().get(i));
                /* armazena valores para calculo do mmq */
                param.getHashModelo().put(i, y);
                listaX.add(i);
                listaY.add(y);
            }
            param.getModelo().calculaMMQ(param);
            param.getAtualiza().setTexto("" + param.getModelo().getMmq());
            return gerarGraficoLinhaXY("titulo", "eixoX", "eixoY", listaX, listaY);
        } catch (Exception e) {
        }
        return null;
    }

    public void setaVariaveis(Parametros param, int altura, int largura) {
        this.param = param;
        this.altura = altura;
        this.largura = largura;
    }

    private double transformaCoordenadaX(double x) {
        return (param.getUmax() / param.getXmax()) * x;
    }

    private double transformaCoordenadaY(double y) {
        return (param.getVmax() / param.getYmax()) * y;
    }

    /**
     * Gera um Grafico de LinhasXY
     */
    public XYSeries gerarGraficoLinhaXY(String tituloGrafico, String tituloEixoX,
            String tituloEixoY, List<Integer> listaX, List<Integer> listaY) throws Exception {
        BufferedImage buf = null;
        try {
            XYSeries seriesLinha = new XYSeries(param.getModeloMatematico());
            for (int i = 0; i < listaX.size(); i++) {
                seriesLinha.add(listaX.get(i), listaY.get(i));
            }
            return seriesLinha;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * Gera um Grafico de LinhasXY
     */
    public XYSeries gerarGraficoPontos(String tituloGrafico, String tituloEixoX,
            String tituloEixoY, List<Integer> listaX, List<Integer> listaY) throws Exception {
        BufferedImage buf = null;
        try {
            XYSeries seriesPontos = new XYSeries(param.getMetodoEstimacao());
            for (int i = 0; i < listaX.size(); i++) {
                seriesPontos.add(listaX.get(i), listaY.get(i));
            }
            return seriesPontos;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void desenhaGrafico(Graphics g) {
        JFreeChart chart = ChartFactory.createXYLineChart(
                "", // chart title
                "h", // x axis label
                "γ(h)", // y axis label
                dataset, // data
                PlotOrientation.VERTICAL,
                true, // include legend
                true, // tooltips
                false // urls
                );

        /* customizacao do grafico */
        chart.setBackgroundPaint(Color.WHITE);
        XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.BLACK);
        plot.setRangeGridlinePaint(Color.BLACK);
        //plot.setNoDataMessage("Escolha o método de estimação e o modelo matemático");

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, false); //mostra apenas os pontos
        renderer.setSeriesShapesVisible(0, true);
        renderer.setSeriesLinesVisible(1, true);
        renderer.setSeriesShapesVisible(1, false);

        /* setar as cores das series */
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.BLUE);

        /* remove da legenda se estiver vazio */
        if (dataset.getSeries(0).isEmpty()) {
            renderer.setSeriesVisibleInLegend(0, false);
        }
        if (dataset.getSeries(1).isEmpty()) {
            renderer.setSeriesVisibleInLegend(1, false);
        }
        plot.setRenderer(renderer);

        // change the auto tick unit selection to integer units only...
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        g.drawImage(chart.createBufferedImage(largura, altura), 0, 0, largura, altura, this);
    }
}
