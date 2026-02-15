package src;

public class Revista extends ItemDoAcervo {
    private int edicao;

    public Revista(String titulo, int ano, int edicao) {
        super(titulo, ano);
        setEdicao(edicao);
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    @Override
    public int getPrazo() {
        return 10;
    }

    @Override
    public double getValorMultaPorDia() {
        return 1.0;
    }

    @Override
    public String getDadosParaBusca() {
        return getTitulo() + " " + edicao;
    }

    @Override
    public double calcularMulta(long diasAtraso) {
        if (diasAtraso > 7) {return diasAtraso * getValorMultaPorDia() * 2;}
        return diasAtraso * getValorMultaPorDia();
    }

    @Override
    public String toString() {
        return "Revista '" + getTitulo() + "' " + edicao + ". Edição (" + getAno() + ") - Status: " + getStatus();
    }

    public String formatarParaEtiqueta() {
        return "ETIQUETA DO ITEM - Revista: " + getTitulo() + " ("+ getAno() + ") | Edição: " + getEdicao();
    }

    public boolean validar() {return true;}
}
