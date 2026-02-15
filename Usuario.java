public class Usuario
{
    private String nome;
    private int id;

    public Usuario(int id, String nome)
    {
        setNome(nome);
        setId(id);
    }

    public void setId(int id)
    {
        if (id <= 0)
        {
            System.out.println("Id inválido");
        }
        else
        {
            this.id = id;
        }
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome()
    {
        return nome;
    }

    @Override
    public String toString() {
        return nome +
                " (id=" + id +
                ')';
    }
}
