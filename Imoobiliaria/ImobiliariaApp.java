import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.TreeMap;
import java.util.Set;
import java.util.HashSet;

public class ImobiliariaApp
{
    private static Imoobiliaria imo;
    private static Menu menu_principal,menu_registo,menu_vendedor,
                   menu_comprador,menu_comprador_registado,
                   menu_cria_imovel,menu_logado,menu_leilao_vendedor;
                   
    private ImobiliariaApp() {}
                   
    public static void main(String[] args) {
        String file_name = "imo_estado";
        carregarMenus();
        initApp(file_name);
        apresentarMenu();
        try {
            imo.gravaObj(file_name);
            imo.log("log.txt", true);
        }
        catch (IOException e) {
            System.out.println("Não consegui gravar os dados!");
        }
        System.out.println("Volte sempre!");
    }

    private static void apresentarMenu(){
        int running = 1;

        do {
            if(imo.getUtilizador() != null){
                menu_logado.executa();
                switch(menu_logado.getOpcao()){
                    case 1: menu();
                            break;
                    case 2: fecharSessao();
                            break;
                    case 0: running = 0;
                }

            }
            else{
                menu_principal.executa();
                switch (menu_principal.getOpcao()) {
                    case 1: registo();
                            break;
                    case 2: iniciarSessao();
                            break;
                    case 3: menu();
                            break;
                    case 0: running = 0;
                }
            }
        } while (running!=0);

    }

    private static void menu(){

        if(imo.getUtilizador() == null)
            running_menu_comprador();
        else{
            Utilizador util = imo.getUtilizador();
            if(util.getClass().getSimpleName().equals("Vendedor"))
                running_menu_vendedor();
            else running_menu_comprador_registado();
        }
    }

    private static void carregarMenus() {
        String[] menu0 = {"Menu",
                        "Fechar sessão"};
        String[] menu1 = {"Registar Utilizador",
                        "Iniciar sessão",
                        "Menu"};
        String [] menu2 = {"Vendedor",
                           "Comprador"};
        String [] menu3 = {"Colocar Imóvel à venda",
                           "Consultas aos Imóveis",
                           "Alterar estado de um Imóvel",
                           "Imóveis mais consultados",
                           "Lista de Imóveis de um dado tipo",
                           "Lista de Imóveis habitáveis",
                           "Todos os Imóveis e respectivos vendedores",
                           "Leilões"};
        String [] menu4 = {"Lista de Imóveis de um dado tipo",
                           "Lista de Imóveis habitáveis",
                           "Todos os Imóveis e respectivos vendedores"};
        String [] menu5 = {"Lista de Imóveis de um dado tipo",
                           "Lista de Imóveis habitáveis",
                           "Todos os Imóveis e respectivos vendedores",
                           "Marcar um Imóvel como favorito",
                           "Consultar favoritos"};
        String[] menu6 = {"Loja","Loja Habitável","Apartamento","Moradia",
                          "Terreno"};
        String[] menu7 = {"Iniciar leilão"};

        menu_logado = new Menu(menu0);
        menu_principal = new Menu(menu1);
        menu_registo = new Menu(menu2);
        menu_vendedor = new Menu(menu3);
        menu_comprador = new Menu(menu4);
        menu_comprador_registado = new Menu(menu5);
        menu_cria_imovel = new Menu(menu6);
        menu_leilao_vendedor = new Menu(menu7);
    }

    private static void initApp(String fich){
        try {
            imo = Imoobiliaria.leObj(fich);
        }
        catch (IOException e) {
            imo = new Imoobiliaria();
            System.out.println("Não consegui ler os dados!\nErro de leitura.");
        }
        catch (ClassNotFoundException e) {
            imo = new Imoobiliaria();
            System.out.println("Não consegui ler os dados!\nFicheiro com formato desconhecido.");
        }
        catch (ClassCastException e) {
            imo = new Imoobiliaria();
            System.out.println("Não consegui ler os dados!\nErro de formato.");
        }
    }

    private static void registo(){
        Utilizador user;
        Scanner is = new Scanner(System.in);

        menu_registo.executa();
        if(menu_registo.getOpcao() !=0){
            String nome,email,password,morada,data,info;
            System.out.print("Nome: ");
            nome = is.nextLine();
            System.out.print("Email: ");
            email = is.nextLine();
            System.out.print("Password: ");
            password = is.nextLine();
            System.out.print("Morada: ");
            morada = is.nextLine();
            System.out.print("Data de nascimento: ");
            data = is.nextLine();

            switch(menu_registo.getOpcao()){
                case 1: user = new Vendedor(email,nome,password,morada,data,null,null);
                        break;
                case 2: user = new Comprador(email,nome,password,morada,data,null);
                        break;
                default: user = new Comprador();
            }
            try{
                imo.registarUtilizador(user);
            }
            catch(UtilizadorExistenteException e){
                System.out.println("Este utizador já existe!");
            }
        }
        else System.out.println("Registo cancelado!");
        is.close();
    }

    private static void iniciarSessao(){
        Scanner is = new Scanner(System.in);
        String email,password;
        System.out.print("E-mail: ");
        email = is.nextLine();
        System.out.print("Password: ");
        password = is.nextLine();

        try{
            imo.iniciaSessao(email,password);
        }
        catch(SemAutorizacaoException e){
            System.out.println(e.getMessage());
        }

        is.close();
    }

    private static void fecharSessao(){
        imo.fechaSessao();
    }

     private static void running_menu_comprador(){
        do{
            menu_comprador.executa();
            switch(menu_comprador.getOpcao()){
                case 1: consultarImoveisTipo();
                        break;
                case 2: habitaveisPreco();
                        break;
                case 3: imoveisVendedores();
                        break;
            }
        }while(menu_comprador.getOpcao()!=0);
    }


    private static void running_menu_vendedor(){
        do{
            menu_vendedor.executa();
            switch(menu_vendedor.getOpcao()){
                case 1: adicionaImovel();
                        break;
                case 2: consultarImoveis();
                        break;
                case 3: alterarEstado();
                        break;
                case 4: topConsultados();
                        break;
                case 5: consultarImoveisTipo();
                        break;
                case 6: habitaveisPreco();
                        break;
                case 7: imoveisVendedores();
                        break;   
                case 8: running_menu_leilao_vendedor();
                        break;
            }
        }while(menu_vendedor.getOpcao()!=0);
    }
    
    private static void running_menu_comprador_registado(){
        do{
            menu_comprador_registado.executa();
            switch(menu_comprador_registado.getOpcao()){
                case 1: consultarImoveisTipo();
                        break;
                case 2: habitaveisPreco();
                        break;
                case 3: imoveisVendedores();
                        break;
                case 4: favoritoImovel();
                        break;
                case 5: consultarFavoritos();
                        break;
            }
        }while(menu_comprador_registado.getOpcao()!=0);
    }
    
    private static void running_menu_leilao_vendedor(){
        do{
            menu_leilao_vendedor.executa();
            switch(menu_leilao_vendedor.getOpcao()){
                case 1: iniciar_leilao();
                        break;
            }
        
        }while(menu_leilao_vendedor.getOpcao()!=0);
    }
    
    private static void iniciar_leilao(){
        Scanner is = new Scanner(System.in);
        int tempo;
        Imovel imovel = inputID();
        System.out.print("Tempo (segundos): ");
        tempo = is.nextInt();
        
        try{
            imo.iniciaLeilao(imovel,tempo);
        }
        catch(SemAutorizacaoException e){
            System.out.println(e.getMessage());
        }
    }
    
    // Esta função devia estar no Imobiliaria
    private static void consultarFavoritos(){

        Map<String,Imovel> favoritos = new HashMap<String,Imovel>();
        Comprador utilizador = (Comprador) imo.getUtilizador();
        favoritos = utilizador.getFavoritos();
        for(Imovel i : favoritos.values())
            System.out.println(i);

    }

    private static void favoritoImovel(){
        Scanner is = new Scanner(System.in);
        String idImovel;
        System.out.print("ID Imóvel: ");
        idImovel = is.nextLine();
        try{
            imo.setFavorito(idImovel);
        }
        catch(SemAutorizacaoException | ImovelInexistenteException e){
            System.out.println(e.getMessage());
        }
        is.close();
    }

    private static void imoveisVendedores(){
        Map<Imovel,Vendedor> imoveisVendedores = new TreeMap<Imovel,Vendedor>();
        imoveisVendedores = imo.getMapeamentoImoveis();
        for(Map.Entry<Imovel,Vendedor> entry : imoveisVendedores.entrySet()){
            Imovel i = entry.getKey();
            Vendedor v = entry.getValue();
            System.out.println("\n******************* Vendedor *******************");
            System.out.println(v);
            System.out.println(i);
            System.out.println("************************************************");
        }
    }

    private static void habitaveisPreco(){
        Scanner is = new Scanner(System.in);
        List<Habitavel> lista = new ArrayList<Habitavel>();
        int preco;
        preco = (int) inputPreco();


        lista = imo.getHabitaveis(preco);
        for(Habitavel i: lista)
            System.out.println(i);

        is.close();
    }

    private static void consultarImoveisTipo(){
        Scanner is = new Scanner(System.in);
        List<Imovel> lista = new ArrayList<Imovel>();
        String tipo; int preco;
        tipo = inputTipo();
        preco = (int) inputPreco();

        lista = imo.getImovel(tipo,preco);
        for(Imovel i: lista)
            System.out.println(i);

        is.close();
    }

    private static void consultarImoveis(){
       List<Consulta> lista = new ArrayList<Consulta>();
       try{
            lista = imo.getConsultas();
        }
        catch(SemAutorizacaoException e){
            System.out.println(e.getMessage());
       }

       for(Consulta c: lista){
            String x = c.toString();
            System.out.println(x);
       }

    }

    private static void topConsultados(){
        Scanner is = new Scanner(System.in);
        int numero;
        Set<String> lista = new HashSet<String>();
        numero = inputConsultas();
        lista = imo.getTopImoveis(numero);
        for(String i:lista){
            System.out.println(i);
        }
    }

    private static void alterarEstado(){
        String id,estado;
        Scanner is = new Scanner(System.in);
        System.out.print("ID do Imóvel: ");
        id = is.nextLine();
        System.out.print("Estado: ");
        estado = is.nextLine();
        try{
            imo.setEstado(id,estado);
        }
        catch(ImovelInexistenteException | SemAutorizacaoException |
        EstadoInvalidoException e){
            System.out.println(e.getMessage());
        }
        is.close();
    }

    private static void adicionaImovel(){
        Imovel imovel = criaImovel();
        if(imovel!=null){
            try{
                imo.registaImovel(imovel);
            }
            catch(ImovelExisteException | SemAutorizacaoException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static Imovel criaImovel(){
        Imovel imovel = null;
        Scanner is = new Scanner(System.in);

        menu_cria_imovel.executa();
        if(menu_cria_imovel.getOpcao() !=0){
            String rua,estado;
            Double preco, preco_Minimo; String id;
            System.out.print("Rua: ");
            rua = is.nextLine();
            preco = inputPreco();
            preco_Minimo = inputPrecoMinimo();
            estado = "em venda";
            id = "ID_" + imo.getId();

            switch(menu_cria_imovel.getOpcao()){
                case 1: double area_loja; boolean wc_loja; String tipo_Negocio,wc_string;
                        int numero_loja;
                        area_loja = inputArea();
                        wc_loja = inputWC();
                        tipo_Negocio = inputTipoNegocio();
                        numero_loja = inputNumero();
                        imovel = new Loja(id,rua,preco,preco_Minimo,estado,null,
                        area_loja,wc_loja,tipo_Negocio,numero_loja);
                        break;

                case 2: double area_loja_hab; boolean wc_loja_hab,garagem_loja_hab;
                        String tipo_negocio_loja_hab, tipo_loja_hab;
                        int numero_loja_hab, quartos_loja_hab, casa_banho_loja_hab,
                        andar_loja_hab;
                        area_loja_hab = inputArea();
                        wc_loja_hab = inputWC();
                        tipo_negocio_loja_hab = inputTipoNegocio();
                        numero_loja_hab = inputNumero();
                        tipo_loja_hab = inputTipo();
                        quartos_loja_hab = inputQuartos();
                        casa_banho_loja_hab = inputCasasBanho();
                        andar_loja_hab = inputAndar();
                        garagem_loja_hab = inputGaragem();
                        imovel = new LojaHabitavel(id,rua,preco,preco_Minimo,estado,
                        null,area_loja_hab,wc_loja_hab,tipo_negocio_loja_hab,numero_loja_hab,
                        tipo_loja_hab,quartos_loja_hab,casa_banho_loja_hab,andar_loja_hab,
                        garagem_loja_hab);
                        break;

                case 3: String tipo_apart; double area_apart; int quartos_apart,
                        casa_banho_apart,andar_apart, numero_apart; boolean garagem_apart;
                        tipo_apart = inputTipo();
                        area_apart = inputArea();
                        quartos_apart = inputQuartos();
                        casa_banho_apart = inputCasasBanho();
                        numero_apart = inputNumero();
                        andar_apart = inputAndar();
                        garagem_apart = inputGaragem();
                        imovel = new Apartamento(id,rua,preco,preco_Minimo,estado,null,
                        tipo_apart,area_apart,quartos_apart,casa_banho_apart,numero_apart,andar_apart,
                        garagem_apart);
                        break;

                case 4: String tipo_moradia; double area_moradia,area_coberta_moradia,
                        area_terreno_moradia; int quartos_moradia,casas_banho_moradia,
                        numero_moradia;
                        tipo_moradia = inputTipo();
                        area_moradia = inputArea();
                        area_coberta_moradia = inputAreaCoberta();
                        area_terreno_moradia = inputAreaTerreno();
                        quartos_moradia = inputQuartos();
                        casas_banho_moradia = inputCasasBanho();
                        numero_moradia = inputNumero();
                        imovel = new Moradia(id,rua,preco,preco_Minimo,estado,null,
                        tipo_moradia,area_moradia,area_coberta_moradia,area_terreno_moradia,
                        quartos_moradia,casas_banho_moradia,numero_moradia);
                        break;

                case 5: String tipo_terreno; int area_terreno;
                        float diametro_canalizacoes,carga_eletrica,saneamento;
                        tipo_terreno = inputTipo();
                        area_terreno = (int) inputArea();
                        diametro_canalizacoes = inputCanalizacoes();
                        carga_eletrica = inputCargaEletrica();
                        saneamento = inputSaneamento();
            }

        is.close();
       }
       return imovel;
    }

    private static boolean inputWC(){
        String wc_string; boolean wc;
        System.out.print("Wc (S/N): ");
        Scanner is = new Scanner(System.in);
        wc_string = is.nextLine();
        if(wc_string.equals("S")|| wc_string.equals("s")) wc = true;
        else wc = false;
        is.close();
        return wc;
    }

    private static boolean inputGaragem(){
        String garagem_string; boolean garagem;
        System.out.print("Garagem (S/N): ");
        Scanner is = new Scanner(System.in);
        garagem_string = is.nextLine();
        if(garagem_string.equals("S")|| garagem_string.equals("s")) garagem = true;
        else garagem = false;
        is.close();
        return garagem;
    }

    private static double inputPreco(){
        double preco;
        System.out.print("Preço: ");
        Scanner is = new Scanner(System.in);
        try{
            preco = is.nextDouble();
        }
        catch(InputMismatchException e){
            System.out.println("Preço inválido!");
            preco = inputPreco();
        }
        is.close();
        return preco;
    }

     private static double inputPrecoMinimo(){
        double preco;
        System.out.print("Preço Mínimo: ");
        Scanner is = new Scanner(System.in);
        try{
            preco = is.nextDouble();
        }
        catch(InputMismatchException e){
            System.out.println("Preço inválido!");
            preco = inputPrecoMinimo();
        } ;
        is.close();
        return preco;
    }

    private static double inputArea(){
        double area;
        System.out.print("Área: ");
        Scanner is = new Scanner(System.in);
        try{
            area = is.nextDouble();
        }
        catch(InputMismatchException e){
            System.out.println("Área inválida!");
            area = inputArea();
        }
        is.close();
        return area;
    }

    private static double inputAreaCoberta(){
        double area;
        System.out.print("Área Coberta: ");
        Scanner is = new Scanner(System.in);
        try{
            area = is.nextDouble();
        }
        catch(InputMismatchException e){
            System.out.println("Área coberta inválida");
            area = inputAreaCoberta();
        }
        is.close();
        return area;
    }

    private static double inputAreaTerreno(){
        double area;
        System.out.print("Área Terreno: ");
        Scanner is = new Scanner(System.in);
        try{
            area = is.nextDouble();
        }
        catch(InputMismatchException e){
            System.out.println("Área do terreno inválida!");
            area = inputAreaTerreno();
        } ;
        is.close();
        return area;
    }

    private static int inputNumero(){
        int numero;
        System.out.print("Número: ");
        Scanner is = new Scanner(System.in);
        try{
            numero = is.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("Número inválido!");
            numero = inputNumero();
        }
        is.close();
        return numero;
    }

    private static int inputQuartos(){
        int quartos;
        System.out.print("Quartos: ");
        Scanner is = new Scanner(System.in);
        try{
            quartos = is.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("Número de quartos inválido!");
            quartos = inputQuartos();
        }
        is.close();
        return quartos;
    }

    private static int inputAndar(){
        int andar;
        System.out.print("Andar: ");
        Scanner is = new Scanner(System.in);
        try{
            andar = is.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("Andar inválido!");
            andar = inputAndar();
        }
        is.close();
        return andar;
    }
    
    private static int inputConsultas(){
        int consultas;
        System.out.print("Número de consultas: ");
        Scanner is = new Scanner(System.in);
        try{
            consultas = is.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("Número de consultas inválido!");
            consultas = inputConsultas();
        }
        is.close();
        return consultas;
    }

    private static int inputCasasBanho(){
        int casas_banho;
        System.out.print("Casas de banho: ");
        Scanner is = new Scanner(System.in);
        try{
            casas_banho = is.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("Número de casas de banho inválido!");
            casas_banho = inputCasasBanho();
        }
        is.close();
        return casas_banho;
    }

    private static String inputTipoNegocio(){
        String tipo_negocio;
        System.out.print("Tipo de negócio: ");
        Scanner is = new Scanner(System.in);
        tipo_negocio = is.nextLine();
        is.close();
        return tipo_negocio;
    }

    private static String inputTipo(){
        String tipo;
        System.out.print("Tipo: ");
        Scanner is = new Scanner(System.in);
        tipo = is.nextLine();
        is.close();
        return tipo;
    }

    private static float inputCanalizacoes(){
        float total;
        System.out.print("Canalizações: ");
        Scanner is = new Scanner(System.in);
        try{
            total = is.nextFloat();
        }
        catch(InputMismatchException e){
            System.out.println("Valor inválido!");
            total = inputCanalizacoes();
        }
        is.close();
        return total;
    }

    private static float inputCargaEletrica(){
        float total;
        System.out.print("Carga Elétrica: ");
        Scanner is = new Scanner(System.in);
        try{
            total = is.nextFloat();
        }
        catch(InputMismatchException e){
            System.out.println("Valor inválido!");
            total = inputCargaEletrica();
        }
        is.close();
        return total;
    }

    private static float inputSaneamento(){
        float total;
        System.out.print("Saneamento: ");
        Scanner is = new Scanner(System.in);
        try{
            total = is.nextFloat();
        }
        catch(InputMismatchException e){
            System.out.println("Valor inválido!");
            total = inputSaneamento();
        }
        is.close();
        return total;
    }
    
    private static Imovel inputID(){
        Scanner is = new Scanner(System.in);
        String id; 
        System.out.print("ID_Imóvel: ");
        id = is.nextLine();
        Imovel imovel;
        try{
            imovel = imo.getImovelLeilao(id);
        }
        catch(ImovelInexistenteException e){
            System.out.println(e.getMessage());
            imovel = inputID();
        }
        return imovel;
    }    
}
