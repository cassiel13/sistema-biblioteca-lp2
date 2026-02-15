public class Livro extends ItemDoAcervo // Classe filho
{
    private String autor;

    public Livro(String titulo, String autor, int ano)
    {
        super(titulo, ano);
        setAutor(autor);
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutor() {return autor;}

    @Override
    public int getPrazo() {
        return 14;
    }

    @Override
    public double getMulta() {
        return 0.75;
    }

    @Override
    public String toString() {
        return "O livro '" + getTitulo() +
                "', de " + autor +
                " (" + getAno() +
                ") - Status: " + getStatus();
    }
}
