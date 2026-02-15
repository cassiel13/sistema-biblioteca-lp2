package src;

public class Livro extends ItemDoAcervo implements Reservavel, Validavel{
    private String autor;
    private boolean reservado;
    private String ISBN;

    public Livro(String titulo, String autor, int ano, String ISBN) {
        super(titulo, ano);
        setAutor(autor);
        this.reservado = false;
        this.ISBN = ISBN;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor == "") {
            System.out.println("Erro: título inválido.");
        } else {
            this.autor = autor;
        }
    }

    @Override
    public int getPrazo() {
        return 14;
    }

    @Override
    public double getValorMultaPorDia() {
        return 0.75;
    }

    public boolean getReservado() {return reservado;}

    public void setReservado(boolean newValue) {this.reservado = newValue;};

    @Override
    public String toString() {
        return "Livro '" + getTitulo() + "', de " + autor + " (" + getAno() + ") - Status: " + getStatus();
    }

    @Override
    public double calcularMulta(long diasAtraso) {
        return diasAtraso * getValorMultaPorDia();
    }

    @Override
    public String getDadosParaBusca() {
        return getTitulo() + " " + autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public String formatarParaEtiqueta() {
        return "ETIQUETA DO ITEM - Livro: " + getTitulo() + " ("+ getAno() + ") | Autor: " + getAutor();
    }
    public void reservar() {
        reservado = true;
    }

    public void cancelarReserva() {
        reservado = false;
    }

    public boolean validar() {
        if (!(getTitulo().equals("")) && getISBN().length() == 13) {return true;}
        return false;
    }
}
