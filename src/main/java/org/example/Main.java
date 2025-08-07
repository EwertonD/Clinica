package org.example;

import java.text.*;
import java.time.*;
import java.util.*;
import java.time.ZoneId;

public class Main {
    private static Sistema sistema = new Sistema();
    private static Estoque estoque = new Estoque();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Sistema de Adoção e Resgate de Animais ---");
            System.out.println("1. Cadastrar Animal");
            System.out.println("2. Cadastrar Voluntário");
            System.out.println("3. Cadastrar Pretendente");
            System.out.println("4. Registrar Resgate");
            System.out.println("5. Registrar Tratamento");
            System.out.println("6. Registrar Doação");
            System.out.println("7. Registrar Adoção");
            System.out.println("8. Listar Animais");
            System.out.println("9. Listar Voluntários");
            System.out.println("10. Listar Pretendentes");
            System.out.println("11. Listar Resgates");
            System.out.println("12. Listar Tratamentos");
            System.out.println("13. Listar Doações");
            System.out.println("14. Listar Adoções");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    cadastrarAnimal();
                    break;
                case 2:
                    cadastrarVoluntario();
                    break;
                case 3:
                    cadastrarPretendente();
                    break;
                case 4:
                    registrarResgate();
                    break;
                case 5:
                    registrarTratamento();
                    break;
                case 6:
                    registrarDoacao();
                    break;
                case 7:
                    registrarAdocao();
                    break;
                case 8:
                    listarAnimais();
                    break;
                case 9:
                    listarVoluntarios();
                    break;
                case 10:
                    listarPretendentes();
                    break;
                case 11:
                    listarResgates();
                    break;
                case 12:
                    listarTratamentos();
                    break;
                case 13:
                    listarDoacoes();
                    break;
                case 14:
                    listarAdocoes();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static Animal cadastrarAnimal() {
        System.out.println("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Raça: ");
        String raca = scanner.nextLine();
        System.out.print("Espécie: ");
        String especie = scanner.nextLine();
        System.out.print("Cor: ");
        String cor = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Animal animal = new Animal(id, raca, especie, cor, idade);
        animal.cadastrarAnimal(sistema);
        System.out.println("Animal cadastrado com sucesso!");

        return animal;
    }

    private static void cadastrarVoluntario() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Contato: ");
        String contato = scanner.nextLine();

        Voluntario voluntario = new Voluntario(nome, cpf, endereco, contato);
        sistema.adicionarVoluntario(voluntario);
        System.out.println("Voluntário cadastrado com sucesso!");
    }

    private static void cadastrarPretendente() {
        System.out.println("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();
        System.out.print("Espécies preferidas (separadas por vírgula): ");
        String[] especiesPreferidas = scanner.nextLine().split(",");
        System.out.print("Raças preferidas (separadas por vírgula): ");
        String[] racasPreferidas = scanner.nextLine().split(",");

        Pretendente pretendente = new Pretendente(id, nome, bairro, especiesPreferidas, racasPreferidas);
        sistema.adicionarPretendente(pretendente);
        System.out.println("Pretendente cadastrado com sucesso!");
    }

    private static void registrarResgate() {
        // Data do resgate
        System.out.print("Data do resgate (dd/MM/yyyy): ");
        String dataStr = scanner.nextLine();

        Date dataResgate = converterStringParaDate(dataStr);
        if (dataResgate == null) {
            return;
        }

        // Set para armazenar os animais resgatados
        Set<Animal> animaisResgatados = new HashSet<>();

        // Loop para cadastrar os animais resgatados
        while (true) {
            animaisResgatados.add(cadastrarAnimal());

            // Perguntar se deseja cadastrar mais animais
            System.out.print("Deseja cadastrar outro animal? (s/n): ");
            String resposta = scanner.nextLine();
            if (!resposta.equalsIgnoreCase("s")) {
                break; // Sai do loop se a resposta não for "s"
            }
        }

        Resgate resgate = new Resgate(dataResgate);
        resgate.setAnimaisResgatados(animaisResgatados);

        resgate.registrarResgate(sistema);
        System.out.println("Resgate registrado com sucesso!");
    }

    private static void registrarTratamento() {
        System.out.print("Nome do procedimento: ");
        String nomeProcedimento = scanner.nextLine();
        System.out.print("ID do animal tratado: ");
        int idAnimal = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Data do procedimento (dd/MM/yyyy): ");
        String dataStr = scanner.nextLine();

        Date dataProcedimento = converterStringParaDate(dataStr);
        if (dataProcedimento == null) {
            return;
        }

        System.out.print("Descrição do procedimento: ");
        String descricaoProcedimento = scanner.nextLine();

        Animal animalTratado = buscarAnimalPorID(idAnimal);
        if (animalTratado == null) {
            System.out.println("Animal não encontrado com o ID fornecido.");
            return;
        }

        Set<Medicamento> medicamentosUsados = cadastrarMedicamentosUtilizados();

        Tratamento tratamento = new Tratamento(nomeProcedimento, animalTratado, dataProcedimento, descricaoProcedimento);
        tratamento.setMedicamentosUsados(medicamentosUsados); // Adicionar os medicamentos ao tratamento
        animalTratado.registrarTratamento(tratamento);

        tratamento.registrarTratamento(sistema);
        tratamento.informarConsumo(estoque);

        System.out.println("Tratamento registrado com sucesso!");
    }

    private static void registrarDoacao() {
        System.out.print("Nome do doador: ");
        String nomeDoador = scanner.nextLine();
        System.out.print("Data da doação (dd/MM/yyyy): ");
        String dataStr = scanner.nextLine();

        Date dataDoacao = converterStringParaDate(dataStr);
        if (dataDoacao == null) {
            return;
        }

        Set<Racao> racoesDoacao = new HashSet<>();
        Set<Medicamento> medicamentosDoacao = new HashSet<>();
        Set<Avulso> avulsosDoacao = new HashSet<>();

        // Loop para permitir múltiplos tipos de doação
        while (true) {
            System.out.println("\n--- Registrar Itens da Doação ---");
            System.out.println("1. Ração");
            System.out.println("2. Medicamento");
            System.out.println("3. Item Avulso");
            System.out.println("0. Finalizar doação");
            System.out.print("Escolha o tipo de item: ");
            int tipoItem = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (tipoItem) {
                case 1:
                    // Loop para adicionar múltiplas rações
                    while (true) {
                        Racao racao = receberRacao();
                        if (racao != null) {
                            racoesDoacao.add(racao);
                        }
                        System.out.print("Deseja adicionar outra ração? (s/n): ");
                        String resposta = scanner.nextLine();
                        if (!resposta.equalsIgnoreCase("s")) {
                            break;
                        }
                    }
                    break;
                case 2:
                    // Loop para adicionar múltiplos medicamentos
                    while (true) {
                        Medicamento medicamento = receberMedicamento();
                        if (medicamento != null) {
                            medicamentosDoacao.add(medicamento);
                        }
                        System.out.print("Deseja adicionar outro medicamento? (s/n): ");
                        String resposta = scanner.nextLine();
                        if (!resposta.equalsIgnoreCase("s")) {
                            break;
                        }
                    }
                    break;
                case 3:
                    // Loop para adicionar múltiplos itens avulsos
                    while (true) {
                        Avulso avulso = receberAvulso();
                        if (avulso != null) {
                            avulsosDoacao.add(avulso);
                        }
                        System.out.print("Deseja adicionar outro item avulso? (s/n): ");
                        String resposta = scanner.nextLine();
                        if (!resposta.equalsIgnoreCase("s")) {
                            break;
                        }
                    }
                    break;
                case 0:
                    // Finalizar a doação
                    Doacao doacao = new Doacao(dataDoacao, nomeDoador, racoesDoacao, medicamentosDoacao, avulsosDoacao);
                    sistema.adicionarDoacao(doacao);
                    System.out.println("Doação registrada com sucesso!");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static Racao receberRacao() {
        System.out.print("ID da ração: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Racao racaoExistente = estoque.buscarRacaoPorID(id);

        if (racaoExistente != null) {
            System.out.print("Quantidade recebida: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            racaoExistente.setQuantidade(racaoExistente.getQuantidade() + quantidade);
            System.out.println("Quantidade de ração atualizada com sucesso!");
        } else {
            System.out.print("Marca da ração: ");
            String marca = scanner.nextLine();
            System.out.print("Espécie destinada: ");
            String especie = scanner.nextLine();
            System.out.print("Quantidade recebida: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            System.out.print("Tipo da ração: ");
            String tipo = scanner.nextLine();

            Racao novaRacao = new Racao(id, marca, especie, quantidade, tipo);
            estoque.getRacoes().add(novaRacao);
            System.out.println("Ração cadastrada com sucesso!");

            return novaRacao;
        }

        return racaoExistente;
    }

    private static Medicamento receberMedicamento() {
        System.out.print("ID do medicamento: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Medicamento medicamentoExistente = estoque.buscarMedicamentoPorID(id);

        if (medicamentoExistente != null) {
            System.out.print("Quantidade recebida: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            medicamentoExistente.setQuantidade(medicamentoExistente.getQuantidade() + quantidade);
            System.out.println("Quantidade de medicamento atualizada com sucesso!");
        } else {
            System.out.print("Nome do medicamento: ");
            String nome = scanner.nextLine();
            System.out.print("Quantidade recebida: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            System.out.print("Tipo do medicamento: ");
            String tipo = scanner.nextLine();

            Medicamento novoMedicamento = new Medicamento(id, nome, quantidade, tipo);
            estoque.getMedicamentos().add(novoMedicamento);
            System.out.println("Medicamento cadastrado com sucesso!");

            return novoMedicamento;
        }

        return medicamentoExistente;
    }

    private static Avulso receberAvulso()   {
        System.out.print("ID do item avulso: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Avulso avulsoExistente = estoque.buscarAvulsoPorID(id);

        if (avulsoExistente != null) {
            System.out.print("Quantidade recebida: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            avulsoExistente.setQuantidade(avulsoExistente.getQuantidade() + quantidade);
            System.out.println("Quantidade de item avulso atualizada com sucesso!");
        } else {
            System.out.print("Descrição do item avulso: ");
            String descricao = scanner.nextLine();
            System.out.print("Quantidade recebida: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            System.out.print("É uma doação financeira? (true/false): ");
            boolean financeira = scanner.nextBoolean();
            scanner.nextLine(); // Limpar o buffer

            Avulso novoAvulso = new Avulso(id, quantidade, descricao, financeira);
            estoque.getAvulsos().add(novoAvulso);
            System.out.println("Item avulso cadastrado com sucesso!");

            return novoAvulso;
        }

        return avulsoExistente;
    }

    private static void registrarAdocao() {
        System.out.print("ID do animal a ser adotado: ");
        int idAnimal = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("ID do pretendente: ");
        int idPretendente = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Animal animalAdotado = buscarAnimalPorID(idAnimal);
        Pretendente pretendente = buscarPretendentePorID(idPretendente);

        if (animalAdotado == null || pretendente == null) {
            System.out.println("Animal ou pretendente não encontrado. Verifique os IDs e tente novamente.");
            return;
        }

        System.out.println("\n--- Confirmação de Adoção ---");
        System.out.println("Animal: " + animalAdotado.getEspecie() + " (" + animalAdotado.getRaca() + ")");
        System.out.println("Pretendente: " + pretendente.getNome());
        System.out.print("Confirmar adoção? (s/n): ");
        String confirmacao = scanner.nextLine();

        if (!confirmacao.equalsIgnoreCase("s")) {
            System.out.println("Adoção cancelada.");
            return;
        }

        System.out.print("O pretendente confirma assinar o termo de responsabilidade? (s/n): ");
        String assinarTermo = scanner.nextLine();

        if (!assinarTermo.equalsIgnoreCase("s")) {
            System.out.println("Adoção cancelada. O termo de responsabilidade não foi assinado.");
            return;
        }

        Date dataAdocao = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()); // Data atual
        Adocao adocao = new Adocao(dataAdocao, animalAdotado, pretendente);

        adocao.assinarTermo();
        adocao.cadastrarAdocao(sistema);

        System.out.println("Adoção registrada com sucesso!");
    }

    private static void listarAnimais() {
        System.out.println("\n--- Animais Cadastrados ---");
        for (Animal animal : sistema.getAnimais()) {
            System.out.println(animal);
        }
    }

    private static void listarVoluntarios() {
        System.out.println("\n--- Voluntários Cadastrados ---");
        for (Voluntario voluntario : sistema.getVoluntarios()) {
            System.out.println(voluntario);
        }
    }

    private static void listarPretendentes() {
        System.out.println("\n--- Pretendentes Cadastrados ---");
        for (Pretendente pretendente : sistema.getPretendentes()) {
            System.out.println(pretendente);
        }
    }

    private static void listarResgates() {
        System.out.println("\n--- Resgates Registrados ---");
        for (Resgate resgate : sistema.getResgates()) {
            System.out.println(resgate);
        }
    }

    private static void listarTratamentos() {
        System.out.println("\n--- Tratamentos Registrados ---");
        for (Tratamento tratamento : sistema.getTratamentos()) {
            System.out.println(tratamento);
        }
    }

    private static void listarDoacoes() {
        System.out.println("\n--- Doações Registradas ---");
        for (Doacao doacao : sistema.getDoacoes()) {
            System.out.println(doacao);
        }
    }

    private static void listarAdocoes() {
        System.out.println("\n--- Adoções Registradas ---");
        for (Adocao adocao : sistema.getAdocoes()) {
            System.out.println(adocao);
        }
    }

    private static Date converterStringParaDate(String dataStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false); // Evita datas inválidas, como 30/02/2023
            return sdf.parse(dataStr);
        } catch (ParseException e) {
            System.out.println("Data inválida! Use o formato dd/MM/yyyy.");
            return null; // Retorna null se a data for inválida
        }
    }

    private static Animal buscarAnimalPorID(int id) {
        for (Animal animal : sistema.getAnimais()) {
            if (animal.getID() == id) {
                return animal;
            }
        }
        return null;
    }

    private static Pretendente buscarPretendentePorID(int id) {
        for (Pretendente pretendente : sistema.getPretendentes()) {
            if (pretendente.getID() == id) {
                return pretendente;
            }
        }
        return null;
    }

    private static Set<Medicamento> cadastrarMedicamentosUtilizados() {
        Set<Medicamento> medicamentosUsados = new HashSet<>();

        while (true) {
            System.out.print("\nID do medicamento utilizado: ");
            int idMedicamento = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            Medicamento medicamento = estoque.buscarMedicamentoPorID(idMedicamento);
            if (medicamento == null) {
                System.out.println("Medicamento não encontrado com o ID fornecido.");
                continue;
            }

            medicamentosUsados.add(medicamento);

            System.out.print("Deseja cadastrar outro medicamento? (s/n): ");
            String resposta = scanner.nextLine();
            if (!resposta.equalsIgnoreCase("s")) {
                break;
            }
        }

        return medicamentosUsados;
    }

}