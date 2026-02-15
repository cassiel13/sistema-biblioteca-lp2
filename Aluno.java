package src;

public class Aluno extends Usuario {
    public Aluno (String nome, String id) {
        super(nome, id);
    }

    public int getLimiteDeitens() { return 3; }

    public String formatarParaEtiqueta() {
        return "CARTÃO DE ACESSO - Aluno: " + getNome() + " | ID: " + getId();
    }
}
