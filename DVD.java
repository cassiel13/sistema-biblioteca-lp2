public class DVD extends ItemDoAcervo // Classe filho
{
    private int duracaoMinutos;

    public DVD(String titulo, int ano, int duracaoMinutos) {
        super(titulo, ano);
        this.duracaoMinutos = duracaoMinutos;
    }

    // Sobrescrita do método getMulta()
    @Override
    public double getMulta() {
        return 2.0d;
    }

    // Sobrescrita do método getPrazo()
    @Override
    public int getPrazo() {
        return 3;
    }

    // Sobrescrita do método toString()
    @Override
    public String toString() {
        return "O DVD '" + getTitulo() + "', de (" + getAno() + ") - "
                + duracaoMinutos + " min - Status: " + getStatus();
    }
}
