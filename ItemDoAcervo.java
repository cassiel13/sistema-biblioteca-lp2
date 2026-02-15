// A classe pai foi criada porque todos os filhos tem uma relação de É UM com essa classe pai.

public class ItemDoAcervo  // Classe pai
{
    // Atributos em comum entre os filhos e a classe pai
    private int ano;
    private StatusItem status;
    private String titulo;

    public ItemDoAcervo(String titulo, int ano) {
        this.ano = ano;
        this.status = StatusItem.DISPONIVEL;
        this.titulo = titulo;
    }

    // Métodos em comum entre o pai e as classes filhos.
    public void setStatus(StatusItem status) {
        this.status = status;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public StatusItem getStatus() {
        return status;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPrazo()
    {
        return 7;
    }

    public double getMulta()
    {
        return 0.5d;
    }
}
