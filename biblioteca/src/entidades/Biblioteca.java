package entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<ItemBiblioteca> acervo;
    private List<Usuario> usuarios;
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        this.acervo = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.emprestimos = new ArrayList<>();

        InitializeLibrary();
    }

    public void InitializeLibrary() {
        // LIVROS
        Livro livro1 = new Livro("L001", "O Senhor dos Anéis", "J.R.R. Tolkien", 1954, 184, 38, "Klebinho", "Fantasia", "978-0544003415", 1);
        Livro livro2 = new Livro("L002", "1984", "George Orwell", 1949, 328, 20, "Klebinho", "Distopia", "978-0451524935", 1);
        Livro livro3 = new Livro("L003", "Dom Casmurro", "Machado de Assis", 1899, 256, 15, "Klebinho", "Romance", "978-8520927610", 1);
        Livro livro4 = new Livro("L004", "O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943, 96, 25, "Klebinho", "Fábula", "978-0156012195", 1);
        Livro livro5 = new Livro("L005", "A Revolução dos Bichos", "George Orwell", 1945, 112, 30, "Klebinho", "Satira", "978-0451526342", 1);
        // REVISTAS
        Revista revista1 = new Revista("R001", "Revista Ciência Hoje", "Sociedade Brasileira para o Progresso da Ciência", 2023, 50, 10, "1234-5679", "Ciência", 1);
        Revista revista2 = new Revista("R002", "Revista Superinteressante", "Editora Abril", 2023, 60, 15, "9876-5432", "Curiosidades", 1);
        Revista revista3 = new Revista("R003", "Revista National Geographic", "National Geographic Society", 2023, 80, 20, "5678-1234", "Natureza", 1);
        Revista revista4 = new Revista("R004", "Revista Veja", "Editora Abril", 2023, 40, 12, "4321-8765", "Notícias", 1);
        Revista revista5 = new Revista("R005", "Revista Galileu", "Editora Globo", 2023, 70, 18, "8765-4321", "Tecnologia", 1);
        // TESES
        Tese tese1 = new Tese("T001", "A Influência da Literatura na Formação do Pensamento Crítico", "Universidade de São Paulo", 2020, 200, 3, "Jozimar Alvez", "Jairo Dallas", "Machime Learning");
        Tese tese2 = new Tese("T002", "O Impacto das Redes Sociais na Saúde Mental dos Jovens", "Universidade Estadual de Campinas", 2021, 150, 2, "Maria Fernanda", "Carlos Eduardo", "Psicologia");
        Tese tese3 = new Tese("T003", "A Evolução da Inteligência Artificial e suas Implicações Éticas", "Universidade Federal do Rio de Janeiro", 2022, 180, 4, "Lucas Pereira", "Fernanda Costa", "Ética em Tecnologia");
        Tese tese4 = new Tese("T004", "O Papel da Educação na Redução da Desigualdade Social", "Universidade de Brasília", 2023, 220, 5, "Ana Clara", "Ricardo Alves", "Educação e Sociedade");
        Tese tese5 = new Tese("T005", "A Sustentabilidade na Indústria da Moda: Desafios e Oportunidades", "Universidade Federal de Minas Gerais", 2024, 160, 3, "Bruno Costa", "Mariana Silva", "Sustentabilidade e Moda");
        // ALUNOS
        Aluno aluno1 = new Aluno("Alice Silva", "U001", "CCOMP");
        Aluno aluno2 = new Aluno("Bruno Costa", "U002", "CCONT");
        Aluno aluno3 = new Aluno("Carla Mendes", "U003", "MEDICINA");
        Aluno aluno4 = new Aluno("Diego Santos", "U004", "ADMIN");
        Aluno aluno5 = new Aluno("Elisa Ferreira", "U005", "DIREITO");
        // PROFESSORES
        Professor professor1 = new Professor("Dr. Fernando Oliveira", "P001", "CCOMP", "Doutorado em Ciência da Computação");
        Professor professor2 = new Professor("Dra. Gabriela Lima", "P002", "CCONT", "Mestrado em Contabilidade");
        Professor professor3 = new Professor("Dr. Henrique Souza", "P003", "MEDICINA", "Doutorado em Medicina");
        Professor professor4 = new Professor("Dra. Isabela Rocha", "P004", "ADMIN", "Mestrado em Administração");
        Professor professor5 = new Professor("Dr. João Pereira", "P005", "DIREITO", "Doutorado em Direito");
        // SERVIDORES ADMINISTRATIVOS
        ServidorAdministrativo servidor1 = new ServidorAdministrativo("Carlos Eduardo", "S001", "Bibliotecário", "Responsável pelo acervo");
        ServidorAdministrativo servidor2 = new ServidorAdministrativo("Mariana Silva", "S002", "Atendimento", "Responsável pelo atendimento ao público");
        ServidorAdministrativo servidor3 = new ServidorAdministrativo("Ricardo Alves", "S003", "Tecnologia", "Responsável pela manutenção dos sistemas");
        ServidorAdministrativo servidor4 = new ServidorAdministrativo("Fernanda Costa", "S004", "Administração", "Responsável pela gestão administrativa");
        ServidorAdministrativo servidor5 = new ServidorAdministrativo("Lucas Pereira", "S005", "Segurança", "Responsável pela segurança da biblioteca");

        // Adiciona itens à biblioteca
        adicionarItem(livro1);
        adicionarItem(livro2);
        adicionarItem(livro3);
        adicionarItem(livro4);
        adicionarItem(livro5);
        adicionarItem(revista1);
        adicionarItem(revista2);
        adicionarItem(revista3);
        adicionarItem(revista4);
        adicionarItem(revista5);
        adicionarItem(tese1);
        adicionarItem(tese2);
        adicionarItem(tese3);
        adicionarItem(tese4);
        adicionarItem(tese5);

        // Adiciona usuários à biblioteca
        adicionarUsuario(aluno1);
        adicionarUsuario(aluno2);
        adicionarUsuario(aluno3);
        adicionarUsuario(aluno4);
        adicionarUsuario(aluno5);
        adicionarUsuario(professor1);
        adicionarUsuario(professor2);
        adicionarUsuario(professor3);
        adicionarUsuario(professor4);
        adicionarUsuario(professor5);
        adicionarUsuario(servidor1);
        adicionarUsuario(servidor2);
        adicionarUsuario(servidor3);
        adicionarUsuario(servidor4);
        adicionarUsuario(servidor5);
    }

    // LIVROS
    public List<ItemBiblioteca> getItens() {
        return acervo;
    }
    public void  adicionarItem(ItemBiblioteca NovoItem) {
        if (acervo.stream().anyMatch(itemAtual -> itemAtual.getCodigo().equalsIgnoreCase(NovoItem.getCodigo())))
            throw new IllegalArgumentException("O item já possui cadastro!");
        
        acervo.add(NovoItem);
    }
    public void removerItem(String Codigo) {
        // Não precisa de verificação pois ele Dependo do buscarItem, que lança um erro caso não encontre o item
        ItemBiblioteca itemRemovido = buscarItem(Codigo);
        acervo.remove(itemRemovido);
    }
    public ItemBiblioteca buscarItem(String Codigo) {
        if(Codigo == null || Codigo.trim().isEmpty())
            throw new IllegalArgumentException("Código inválido!");

        return getItens().stream()
            .filter(livro -> livro.getCodigo().equals(Codigo.trim()))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Item não encontrado!"));
    }

    // USUARIOS
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    public void adicionarUsuario(Usuario NovoUsuario) {
        if (usuarios.stream().anyMatch(usuarioAtual -> usuarioAtual.getCodigoUsuario().equalsIgnoreCase(NovoUsuario.getCodigoUsuario())))
            throw new IllegalArgumentException("O usuário já possui cadastro!");

        usuarios.add(NovoUsuario);
    }
    public void removerUsuario(String CodigoUsuario) {
        Usuario usuarioRemovido = buscarUsuario(CodigoUsuario);
        usuarios.remove(usuarioRemovido);
    }
    public Usuario buscarUsuario(String CodigoUsuario) {
        if(CodigoUsuario == null || CodigoUsuario.trim().isEmpty())
            throw new IllegalArgumentException("Código de usuário inválido!");

        return getUsuarios().stream()
            .filter(usuario -> usuario.getCodigoUsuario().equals(CodigoUsuario.trim()))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado!"));
    }

    // EMPRÉSTIMOS
    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
    public Emprestimo buscarEmprestimo(String CodigoEmprestimo) {
        if (CodigoEmprestimo == null || CodigoEmprestimo.trim().isEmpty())
            throw new IllegalArgumentException("Código de empréstimo inválido!");

        return getEmprestimos().stream()
            .filter(emprestimo -> emprestimo.getCodigoEmprestimo().equals(CodigoEmprestimo.trim()))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Empréstimo não encontrado!"));
    }
    // Cria um emprestimo novo e adiciona na lista de emprestimos da biblioteca
    public void realizarEmprestimo(String codigoEmprestimo, String codigoUsuario, String codigoLivro) {
        if(codigoEmprestimo == null || codigoEmprestimo.isEmpty())
            throw new IllegalArgumentException("Código de empréstimo inválido!");

        if(codigoUsuario == null || codigoUsuario.isEmpty())
            throw new IllegalArgumentException("Código de usuário inválido");

        if(codigoLivro == null || codigoLivro.isEmpty())
            throw new IllegalArgumentException("Código do livro inválido");

        codigoEmprestimo = codigoEmprestimo.trim();
        codigoUsuario = codigoUsuario.trim();
        codigoLivro = codigoLivro.trim();

        Usuario usuarioEmprestimo = buscarUsuario(codigoUsuario);
        if(usuarioEmprestimo == null)
            throw new IllegalArgumentException("Usuário não encontrado!");

        // Busca o livro
        ItemBiblioteca livroEmprestado = buscarItem(codigoLivro);

        if(livroEmprestado == null)
            throw new IllegalArgumentException("Livro não encontrado!");
        
        if (livroEmprestado.getQuantidadeDisponivel() < 0) 
            throw new IllegalArgumentException("Livro indisponível para empréstimo!");
        
        // Classe dos emprestimos
        LocalDate dataAtual = LocalDate.now();
        // Adiciona 30 dias à data atual para definir a data de devolução
        LocalDate dataDevolucao = dataAtual.plusDays(30); // Adiciona 30 dias à data atual

        Emprestimo emprestimo = new Emprestimo(String.valueOf(emprestimos.size() + 1), codigoUsuario, codigoLivro, dataAtual, dataDevolucao, true);
        // Adiciona o emprestimo à List de emprestimos da biblioteca
        emprestimos.add(emprestimo);
        livroEmprestado.realizarEmprestimo();

    }
    public void realizarDevolucao(String codigoEmprestimo) {
        Emprestimo emprestimoDevolucao = buscarEmprestimo(codigoEmprestimo);
        if(emprestimoDevolucao == null)
            throw new IllegalArgumentException("Emprestimo não encontrado!");

        if (emprestimoDevolucao.getEmprestado()) {
            for(Emprestimo emprestimo : this.emprestimos)
                if(emprestimo.getCodigoEmprestimo().equals(emprestimoDevolucao.getCodigoEmprestimo())) {
                    emprestimo.setEmprestado(false);
                    emprestimo.setDataDevolucao(LocalDate.now());
                    emprestimo.calculaMulta(emprestimo.getDataDevolucao());
                }    
            // Incrementa a quantidade disponível do livro devolvido        
            ItemBiblioteca livroDevolvido = buscarItem(emprestimoDevolucao.getIdLivro());
            if (livroDevolvido == null)
                throw new IllegalArgumentException("Livro não encontrado!");

            livroDevolvido.realizarDevolucao();
        }
    }
}