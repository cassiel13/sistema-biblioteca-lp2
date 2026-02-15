import java.time.LocalDate;

public class Emprestimo
{
    private Usuario user;
    private ItemDoAcervo item;
    private StatusItem status;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevista;

    public Emprestimo(Usuario user, ItemDoAcervo item, LocalDate data, LocalDate dataPrevista) {
        setItem(item);
        setStatus(status);
        setUser(user);
        setDataPrevista(dataPrevista);

        this.dataEmprestimo = data;
    }

    public LocalDate getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(LocalDate dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public ItemDoAcervo getItem() {
        return item;
    }

    public Usuario getUser() {
        return user;
    }

    public StatusItem getStatus()
    {
        return status;
    }

    public LocalDate getDataDoEmprestimo()
    {
        return dataEmprestimo;
    }

    public void setItem(ItemDoAcervo item) {
        this.item = item;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public void setStatus(StatusItem status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "O item '" + item.getTitulo() + "', de (" + item.getAno() + ") foi emprestado para "
                + user.getNome() + " no dia " + dataEmprestimo
                + " e a data prevista para a devolução é dia " + dataPrevista;
    }
}
