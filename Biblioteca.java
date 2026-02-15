/*
Resposta: não, porque não faz sentido ir a biblioteca e pedir um Item, o tipo itemDoAcervo é um tipo usado somente
para generalizar todos os elementos do acervo em um só tipo.
 */


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Biblioteca
{
    private List<ItemDoAcervo> acervo;
    private List<Usuario> listaUsuario;
    private List<Emprestimo> registroDeEmprestimo;

    private LocalDate dataPrevista;
    private LocalDate dataEmprestimo;

    public Biblioteca ()
    {
        acervo = new ArrayList<>();
        listaUsuario = new ArrayList<>();
        registroDeEmprestimo = new ArrayList<>();
    }

    public Usuario pesquisarUsuario(Usuario IdUser)
    {
        for (var usuario : listaUsuario)
        {
            if (IdUser.getId() == usuario.getId()) {
                return IdUser;
            }
        }

        return null;
    }

    public ItemDoAcervo pesquisarItem(ItemDoAcervo itemProcurado)
    {
        for (var item : acervo)
        {
            if (item.getTitulo().equalsIgnoreCase(itemProcurado.getTitulo()))
            {
                return item;
            }
        }
        return null;
    }

    public void listarAcervo()
    {
        System.out.println(" ");
        System.out.println("________________________________________________________________________________________");
        System.out.println("                                     Itens no Acervo");
        System.out.println("$======================================================================================$");

        int quantosExemplares = 0;
        List<ItemDoAcervo> itensJaImpressos = new ArrayList<>();
        itensJaImpressos.clear();

        boolean jaImprimiu = false;

        for (ItemDoAcervo itemDoAcervo : acervo)
        {
            for (ItemDoAcervo compararItem : itensJaImpressos)
            {
                if (itemDoAcervo.getTitulo().equals(compararItem.getTitulo()))
                {
                    jaImprimiu = true;
                }
            }

            if (jaImprimiu == false)
            {
                System.out.println("   ->   " + itemDoAcervo);
                itensJaImpressos.add(itemDoAcervo);
                quantosExemplares = pesquisarItemPorTermo(itemDoAcervo.getTitulo()).toArray().length;
                System.out.println("                                                                                         [" + quantosExemplares + "] Exemplar(es)");

            }

            jaImprimiu = false;
        }
        System.out.println("________________________________________________________________________________________");

    }

    public List<ItemDoAcervo> pesquisarItemPorTermo(String termo)
    {
        List<ItemDoAcervo> itens = new ArrayList<>();
        for (var item : acervo)
        {
            if (item.getTitulo().toLowerCase().contains(termo.toLowerCase()))
            {
                itens.add(item);
            }
        }

        return itens;
    }

    public void imprimirPesquisaPorTermo(List<ItemDoAcervo> itens)
    {
        System.out.println("Itens relacionados:");
        for (var item : itens)
        {
            System.out.println("'" + item.getTitulo() + "', " + item.getAno() + " - Status: " + item.getStatus());
        }

        if (itens == null)
        {
            System.out.println("(Nenhum item foi encontrado)");
        }
    }

    public void cadastrarUsuario(Usuario user)
    {
        listaUsuario.add(user);
        //System.out.println("O usuário " + user.getNome() + " foi cadastrado com sucesso");
    }

    public void cadastrarItem(ItemDoAcervo item)
    {
        acervo.add(item);

        //System.out.println("O livro " + livro.getTitulo() + " foi cadastrado com sucesso");
    }

    public void registrarEmprestimo(Usuario user, ItemDoAcervo item)
    {
        Usuario usuarioDoEmprestimo = pesquisarUsuario(user);
        if (usuarioDoEmprestimo == null)
        {
            System.out.println("Erro: O usuário não está cadastrado.");
            return;
        }

        ItemDoAcervo itemDoEmprestimo = pesquisarItem(item);

        if (itemDoEmprestimo == null)
        {
            System.out.println("Erro: O item não está cadastrado.");
            return;
        }

        if (itemDoEmprestimo.getStatus() != StatusItem.DISPONIVEL)
        {
            System.out.println("Erro: O item ja foi emprestado.");
            return;
        }

        itemDoEmprestimo.setStatus(StatusItem.INDISPONIVEL);
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.dataEmprestimo = LocalDate.now();
        biblioteca.dataPrevista = LocalDate.now().plusDays(itemDoEmprestimo.getPrazo());
        Emprestimo emprestimo = new Emprestimo(user, itemDoEmprestimo, biblioteca.dataEmprestimo, biblioteca.dataPrevista);
        registroDeEmprestimo.add(emprestimo);
        System.out.println(emprestimo);
    }

    public Emprestimo pesquisarEmprestimoPorItem(ItemDoAcervo item)
    {
        for (Emprestimo emprestimo : registroDeEmprestimo)
        {
            if (emprestimo.getItem().getTitulo().equalsIgnoreCase(item.getTitulo()))
            {
                return emprestimo;
            }
        }
        return null;
    }

    public void registrarDevolucao (ItemDoAcervo item)
    {
        boolean estaItem = false;
        for (Emprestimo emprestimo : registroDeEmprestimo)
        {
            if (emprestimo.getItem().getTitulo().equalsIgnoreCase(item.getTitulo()))
            {
                estaItem = true;
                item.setStatus(StatusItem.DISPONIVEL);

                long diasDiferenca = ChronoUnit.DAYS.between(emprestimo.getDataPrevista(), emprestimo.getDataPrevista().plusDays(5));

                if (diasDiferenca > 0)
                {
                    System.out.println("O item '" + emprestimo.getItem().getTitulo()
                            + "' foi devolvido por "+ emprestimo.getUser().getNome()
                            + " fora do prazo. A multa a ser paga é de R$ " //
                            + diasDiferenca * emprestimo.getItem().getMulta() + "0");
                }
                else
                {
                    System.out.println("O item '" + emprestimo.getItem().getTitulo()
                            + "' foi devolvido por "+ emprestimo.getUser().getNome()
                            + " com sucesso!");

                }
            }
        }

        if (!estaItem)
        {
            System.out.println("O item não está no registro de emprestimo");
        }
    }

    public List<ItemDoAcervo> buscar(String termo)
    {
        List<ItemDoAcervo> lista = new ArrayList<>();
        for (var item : acervo)
        {
            if (item.getTitulo().toLowerCase().contains(termo.toLowerCase()))
            {
                lista.add(item);
            }

            if (item instanceof Livro)
            {
                if (item.getTitulo().toLowerCase().contains(termo.toLowerCase()))
                {
                    lista.add(item);
                }
            }
        }

        return lista;
    }

    public static void main(String[] args)
    {
        Biblioteca biblioteca = new Biblioteca();
//
//        Livro livro1 = new Livro("Java Como Programar", "Deitel", 2014);
//        Livro livro2 = new Livro("Metamorfose", "Frank Kafka", 1890);
//        Livro livro3 = new Livro("A vida intelectual", "A.-D Sertillanges", 1876);


        Usuario user1 = new Usuario(1234, "Cassiel P.");
        Usuario user2 = new Usuario(0001, "Cassiel Pereira Ribeiro");
//
//        biblioteca.cadastrarItem(livro1);
//        biblioteca.cadastrarItem(livro2);
//        biblioteca.cadastrarItem(livro3);
//
        biblioteca.cadastrarUsuario(user1);
        biblioteca.cadastrarUsuario(user2);
//
//        biblioteca.listarAcervo();
//        System.out.println("");
//
//        biblioteca.registrarEmprestimo(user1, livro1);
//        biblioteca.listarAcervo();
//
//        System.out.println("");
//
//        biblioteca.registrarDevolucao(livro1);
//        biblioteca.listarAcervo();
//
//        Revista revista1 = new Revista("Veja", 2025,13);
//
//        biblioteca.cadastrarItem(revista1);
//
//        biblioteca.listarAcervo();
//
//        biblioteca.registrarEmprestimo(user2, revista1);
//
//        biblioteca.listarAcervo();
//
//        biblioteca.registrarDevolucao(revista1);
//
//        biblioteca.listarAcervo();

        ItemDoAcervo dvd1 = new DVD("O Rei Leão", 1984,84);
        biblioteca.cadastrarItem(dvd1);

        biblioteca.listarAcervo();

        biblioteca.registrarEmprestimo(user1, dvd1);
        biblioteca.registrarDevolucao(dvd1);

        biblioteca.listarAcervo();

        List<ItemDoAcervo> lista = biblioteca.buscar("leão");

        for (var item : lista)
        {
            System.out.println(item);
        }
    }

}
