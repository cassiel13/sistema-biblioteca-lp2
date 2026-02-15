package src;

public class Professor extends Usuario {
    public Professor(String nome, String id) {
        super(nome, id);
    }

    public int getLimiteDeitens() { return 10; }

    public String formatarParaEtiqueta() {
        return "CARTÃO DE ACESSO - Professor: " + getNome() + " | ID: " + getId();
    }
}
