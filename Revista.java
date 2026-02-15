public class Revista extends ItemDoAcervo // class filho
{
    private int edicao;

    public Revista(String titulo, int ano, int edicao) {
        super(titulo, ano);
        this.edicao = edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getEdicao() {
        return edicao;
    }

    @Override
    public int getPrazo() {
        return 7;
    }

    @Override
    public double getMulta() {
        return 1.0d;
    }

    @Override
    public String toString() {
        return "A revista '" + getTitulo() +
                "', " + getEdicao() + "ª Edição " +
                "(" + getAno() +
                ") - Status: " + getStatus();
    }
}
