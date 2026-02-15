package src;

public abstract class ItemDoAcervo implements Imprimivel, Validavel{
    private String titulo;
    private int ano;
    private StatusLivro status;

    public ItemDoAcervo(String titulo, int ano) {
        setTitulo(titulo);
        setAno(ano);
        setStatus(StatusLivro.DISPONIVEL);
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        int ano_atual = 2025;
        if (ano > ano_atual) {
            System.out.println("Erro: ano inválido.");
        } else {
            this.ano = ano;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == "") {
            System.out.println("Erro: título inválido.");
        } else {
            this.titulo = titulo;
        }
    }

    public StatusLivro getStatus() {
        return status;
    }

    public final void imprimirFichaCatalografica() {
        System.out.println("=== Sistema DE BIBLIOTECA - FICHA DO ITEM ===");
        System.out.println("ID Interno: " + this.hashCode());
        System.out.println("Detalhes: " + this.toString());
        System.out.println("=============================================");
    }

    public abstract int getPrazo();

    public abstract double getValorMultaPorDia();

    public abstract String getDadosParaBusca();

    public abstract double calcularMulta(long diasAtraso);

    public void setStatus(StatusLivro status) {
        this.status = status;
    }
}
