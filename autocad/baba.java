package prog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Sistema
{
    static String[] Nome = new String[500];
    static String[] Endereco = new String[500];
    static String[] Tipo = new String[500];
    static String[] Sindicato = new String[500];
    static String[] IdSindicato = new String[500];
    static String[] AgendaPagamento = new String[500];
    static String[] MetodoPagamento = new String[500];
    static String[] Data = new String[500];
    static String[][] DataRV = new String[500][500];
    static String[] Entrada = new String[500];
    static String[] Saida = new String[500];
    static String[] Pagamento = new String[500];
    static String[] bi = new String[500];

    static Integer[] ID = new Integer[500];
    static Integer[] DiasTrabalho = new Integer[500];
    static Integer[] TAMANHO = new Integer[500];

    static Double[] TaxaSindicato = new Double[500];
    static Double[] Salario = new Double[500];
    static Double[] SalarioAtual = new Double[500];
    static Double[] ResultadoVendas = new Double[500];
    static Double[] TaxaServicos = new Double[500];

    static String[][] NomeUR = new String[100][500];
    static String[][] EnderecoUR = new String[100][500];
    static String[][] TipoUR = new String[100][500];
    static String[][] SindicatoUR = new String[100][500];
    static String[][] IdSindicatoUR = new String[100][500];
    static String[][] AgendaPagamentoUR = new String[100][500];
    static String[][] MetodoPagamentoUR = new String[100][500];
    static String[][] DataUR = new String[100][500];
  //  static String[][][] DataRVUR = new String[1000][1000][1000];
    static String[][] EntradaUR = new String[100][500];
    static String[][] SaidaUR = new String[100][500];
    static String[][] PagamentoUR = new String[100][500];
    static String[][] biUR = new String[100][500];

    static Integer[][] IDUR = new Integer[100][500];
    static Integer[][] TAMANHOUR = new Integer[100][500];
    static Integer[][] DiasTrabalhoUR = new Integer[100][500];

    static Double[][] TaxaSindicatoUR = new Double[100][500];
    static Double[][] SalarioUR = new Double[100][500];
    static Double[][] SalarioAtualUR = new Double[100][500];
    static Double[][] ResultadoVendasUR = new Double[100][500];
    static Double[][] TaxaServicosUR = new Double[100][500];


    static int tam = 0, MAX=0, day = 5, month = 6, year = 2019, indice = 4;
    static int ultimoDiaUtil = day, DiasUteis;
    static String DiaDaSemana = "quarta-feira", nomemes = "junho";
    static String dataEmString = day + "/" + month + "/" + year;
    static String diaUltimo = dataEmString, diaPrimeiro, dia7 = "7/5/2019";
    static int maxima = 30, estado = 0, undo = 0,w=1,z=1,q=0;

    public static void add()
    {
        Scanner input = new Scanner(System.in);
        String nome, acesso, endereco,id_sindicato;
        double salario, taxa_sindicato;
        int p=0, t=-1, sind=-1, metodoPagamento = -1, i=0;
        System.out.println("ADICIONANDO NOVO EMPREGADO\n");
        System.out.println("Digite o nome completo:");
        //input.nextLine();
        nome = input.nextLine();

        while (i < MAX)
        {
            acesso = Nome[i];
            if(nome.equals(acesso))
            {
                System.out.println("\nNOME JA PRESENTE NA LISTA\n");
                p = 1;
                break;
            }
            i++;
        }

        if(p == 0)
        {
            Nome[i] = nome;
            System.out.println("Digite o endereco:");
            endereco = input.nextLine();
            Endereco[i] = endereco;
            System.out.println("|------------------------------------------------|");
            System.out.println("| Digite o numero da respectiva escolha do tipo: |");
            System.out.println("| 1 - horista;                                   |");
            System.out.println("| 2 - assalariado;                               |");
            System.out.println("| 3 - assalariado commissionado;                 |");
            System.out.println("|------------------------------------------------|");

            double x=0.0;

            SalarioAtual[i] = x;

            if(t == -1)
            {
                while(t != 1 && t != 2 && t != 3)
                {
                    t = input.nextInt();
                    if(t == 1)
                    {
                        Tipo[i] = "horista";
                        AgendaPagamento[i] ="Semanalmente";
                        Pagamento[i] = "sexta-feira";
                        System.out.println("Insira o salario por hora:");
                        salario = input.nextDouble();
                        Salario[i] = salario;
                    }
                    if(t == 2){
                        Tipo[i] ="assalariado";
                        AgendaPagamento[i] ="Mensalmente";
                        Pagamento[i] = diaUltimo;//ultimo dia util do mes
                        System.out.println("Insira o salario por mes:");
                        salario = input.nextDouble();
                        Salario[i] = salario;
                    }
                    if(t == 3)
                    {
                        Tipo[i] ="comissionado";
                        AgendaPagamento[i] ="Bi-semanalmente";
                        Pagamento[i] = "sexta-feira";
                        bi[i] = "0";
                        System.out.println("Insira o salario:");
                        salario = input.nextDouble();
                        Salario[i] = salario;
                    }
                    if(t != 1 && t != 2 && t != 3)
                    {
                        System.out.println("Insira um numero valido");
                    }
                }
                t = -1;
            }

            System.out.println("Faz parte do Sindicato?");
            System.out.println("|-------------------|");
            System.out.println("| Digite:           |");
            System.out.println("| 0 , se NAO        |");
            System.out.println("| 1 , se SIM        |");
            System.out.println("|-------------------|");
            if(sind == -1)
            {
                while(sind != 0 && sind != 1)
                {
                    sind = input.nextInt();
                    if(sind == 1)
                    {
                        Sindicato[i] ="Faz parte do Sindicato.";
                        System.out.println("Identificacao no sindicato");
                        input.nextLine();
                        id_sindicato = input.nextLine();
                        IdSindicato[i] =(id_sindicato);
                        System.out.println("Taxa Sindical");
                        taxa_sindicato = input.nextDouble();
                        TaxaSindicato[i] = taxa_sindicato;
                        SalarioAtual[i] = SalarioAtual[i] - TaxaSindicato[i];
                        System.out.println(SalarioAtual[i]);
                    }
                    if(sind == 0)
                    {
                        Sindicato[i] =("Nao faz parte do Sindicato.");
                        IdSindicato[i] =("-");
                        taxa_sindicato = 0;
                        TaxaSindicato[i] =(taxa_sindicato);
                    }
                    else if(sind != 0 && sind != 1)
                    {
                        System.out.println("Insira um numero valido");
                    }
                }
                sind = -1;
            }

            System.out.println("Metodo de pagamento preterido:");
            System.out.println("|--------------------------------------------------|");
            System.out.println("| Insira o numero da respectiva escolha do metodo: |");
            System.out.println("| 1 - Cheque pelos Correios;                       |");
            System.out.println("| 2 - Cheque em maos;                              |");
            System.out.println("| 3 - Deposito em conta bancaria;                  |");
            System.out.println("|--------------------------------------------------|");

            if(metodoPagamento == -1)
            {
                while(metodoPagamento != 1 && metodoPagamento != 2 && metodoPagamento != 3)
                {
                    metodoPagamento = input.nextInt();
                    if(metodoPagamento == 1) MetodoPagamento[i] =("Cheque pelos Correios");

                    if(metodoPagamento == 2) MetodoPagamento[i] = ("Cheque em maos");

                    if(metodoPagamento == 3) MetodoPagamento[i] =("Deposito em conta bancaria");

                    if(metodoPagamento != 1 && metodoPagamento != 2 && metodoPagamento != 3) System.out.println("Insira um numero valido");
                }
                metodoPagamento = -1;
            }

            Data[i] =(dataEmString);
            String s = year + "" + i;
            ID[i] = Integer.parseInt(s);
            ResultadoVendas[i] = x;
            TaxaServicos[i] = x;

            int j;
            for(j=0;j<DiasUteis;j++)
            {
                DataRV[i][j] = "-";
                j++;
            }

            DiasTrabalho[i] = 0;
            Entrada[i] = "-";
            Saida[i] = "-";
            Sistema.ficha();
            System.out.println("\nNOME ADICIONADO COM SUCESSO!\n");
            tam = tam + 1;
            MAX = MAX + 1;

            TAMANHO[q] = MAX;
            q++;
        }
    }

    public static void remove()
    {
        Scanner input = new Scanner(System.in);
        int i=0, np,p=0;

        if(tam == 0){
            System.out.println("NAO HA EMPREGADOS PARA REMOVER\n");
        }
        if(tam>0)
        {
            System.out.println("|-----------------------------------------------------------------------------|");
            System.out.println("                              LISTA DE EMPREGADOS                              ");
            while(i < MAX)
            {
                if(ID[i] != -1)
                {
                    System.out.printf(" %d - %s \n",ID[i], Nome[i]);
                }
                i++;
            }
            System.out.println("|-----------------------------------------------------------------------------|\n");
            System.out.println("REMOVENDO EMPREGADO\n");
            System.out.println("Digite o numero do empregado que deseja remover\n");
            np = input.nextInt();
            i=0;

            while(i<MAX)
            {
                if(ID[i] == np)
                {
                    p=1;
                    break;
                }
                i++;
            }

            if(p==0)
            {
                System.out.println("\nNOME NAO ESTA PRESENTE NA LISTA!\n");
            }
            else if(p==1)
            {
                np = Sistema.posicao(np);
                ID[np] = -1;
                Nome[np] = null; Endereco[np] = null; Salario[np] = null; Tipo[np] = null;
                Sindicato[np] = null; IdSindicato[np] = null; TaxaSindicato[np] = null; AgendaPagamento[np] = null;
                MetodoPagamento[np] = null; Data[np] = null; SalarioAtual[np] = null; ResultadoVendas[np] = null;
                TaxaServicos[np] = null; DataRV[np] = null; DiasTrabalho[np] = null; Pagamento[np] = null;
                tam = tam-1;

                System.out.println("\nNOME REMOVIDO COM SUCESSO!\n");
            }
        }
    }

    public static void cartaoPonto()
    {
        Scanner input = new Scanner(System.in);
        int valor=-1;
        int i=0, np,p=0;

        if(tam == 0){
            System.out.println("NAO HA EMPREGADOS\n");
        }
        if(tam>0)
        {
            System.out.println("|-----------------------------------------------------------------------------|");
            System.out.println("                              LISTA DE EMPREGADOS                              ");
            while(i < MAX)
            {
                if(ID[i] != -1)
                {
                    System.out.printf(" %d - %s \n",ID[i], Nome[i]);
                }
                i++;
            }
            System.out.println("|-----------------------------------------------------------------------------|\n");
            System.out.println("Digite o numero do empregado");

            np = input.nextInt();
            i=0;
            while(i<MAX)
            {
                if(ID[i] == np)
                {
                    Sistema.cpempre(np);
                    p=1;
                    break;
                }
             }
            if(p==0) System.out.println("\nNOME NAO ESTA PRESENTE NA LISTA!");
        }
    }

    public static void resultadoVendas()
    {
        Scanner input = new Scanner(System.in);
        double valor;
        int i=0, np,p=0;

        if(tam == 0){
            System.out.println("NAO HA EMPREGADOS\n");
        }
        if(tam>0)
        {
            System.out.println("|-----------------------------------------------------------------------------|");
            System.out.println("                              LISTA DE EMPREGADOS                              ");
            while(i < MAX)
            {
                if(ID[i] != -1)
                {
                    System.out.printf(" %d - %s \n",ID[i], Nome[i]);
                    i++;
                }
            }
            System.out.println("|-----------------------------------------------------------------------------|\n");
            System.out.println("Digite o numero do empregado\n");
            np = input.nextInt();

            i=0;
            while(i<MAX)
            {
                if(ID[i] == np)
                {
                    Sistema.rvempre(np);
                    p=1;
                    break;
                }
            }
            if(p==0) System.out.println("\nNOME NAO ESTA PRESENTE NA LISTA!");
        }
    }

    public static void taxaServicos()
    {
        Scanner input = new Scanner(System.in);
        double valor;
        int i=0, np, p=0;

        if(tam == 0){
            System.out.println("NAO HA EMPREGADOS\n");
        }
        if(tam>0)
        {
            System.out.println("|-----------------------------------------------------------------------------|");
            System.out.println("                              LISTA DE EMPREGADOS                              ");
            while(i < MAX)
            {
                if(ID[i] != -1)
                {
                    System.out.printf(" %d - %s - \n",ID[i], Nome[i]);
                    i++;
                }
            }
            System.out.println("|-----------------------------------------------------------------------------|\n");
            System.out.println("Digite o numero do empregado\n");
            np = input.nextInt();

            i=0;
            while(i<MAX)
            {
                if(ID[i] == np)
                {
                    Sistema.tsempre(np);
                    p=1;
                    break;
                }
            }
            if(p==0) System.out.println("\nNOME NAO ESTA PRESENTE NA LISTA!");
        }
    }

    public static void alterar()
    {
        Scanner input = new Scanner(System.in);
        String nome,endereco,id_sindicato;
        double salario, taxa_sindicato;
        int i=0, np, n=-1, sind=-1,t = -1 , metodoPagamento=-1,p=0;
        if(tam == 0)
        {
            System.out.println("NAO HA EMPREGADOS\n");
        }
        if(tam > 0)
        {
            System.out.println("|-----------------------------------------------------------------------------|");
            System.out.println("                              LISTA DE EMPREGADOS\n");
            while(i < MAX)
            {
                if(ID[i] != -1)
                {
                    System.out.printf(" %d - %s\n",ID[i],Nome[i]);
                    i++;
                }
            }
            System.out.println("|-----------------------------------------------------------------------------|\n");
            System.out.println("Digite o numero do empregado que voce deseja alterar os dados\n");
            np = input.nextInt();
            System.out.println(np + "  " + ID[MAX-1]);

            i=0;
            while(i<MAX)
            {
                if(np == ID[i])
                {
                    Sistema.cpempre(np);
                    p=1;
                    break;
                }
            }
            if(p==0) System.out.println("\nNOME NAO ESTA PRESENTE NA LISTA!");

            if(p==1)
            {
                np = Sistema.posicao(np);
                while(n != 0)
                {
                    Sistema.Alteracao();
                    n = input.nextInt();

                    if(n == 1)
                    {
                        System.out.println("Digite o novo nome do empregado:");
                        input.nextLine();
                        nome = input.nextLine();
                        Nome[np] = nome;
                    }

                    if(n == 2)
                    {
                        System.out.println("Digite o novo endereco do empregado:");
                        input.nextLine();
                        endereco = input.nextLine();
                        Endereco[np] = endereco;
                    }

                    if(n == 3)
                    {
                        System.out.println("|-----------------------------------------------------|");
                        System.out.println("| Digite o numero da respectiva escolha do novo tipo: |");
                        System.out.println("| 1 - hourly;                                         |");
                        System.out.println("| 2 - salaried;                                       |");
                        System.out.println("| 3 - commissioned;                                   |");
                        System.out.println("|-----------------------------------------------------|");

                        if(t == -1)
                        {
                            while(t != 1 && t != 2 && t != 3)
                            {
                                t = input.nextInt();
                                if(t == 1)
                                {
                                    Tipo[np] = "horista";
                                    System.out.println("Insira o salario por hora:");
                                    salario = input.nextDouble();
                                    Salario[np] = salario;
                                    AgendaPagamento[np] ="Semanalmente";
                                    Pagamento[i] = "sexta-feira";
                                }
                                if(t == 2){
                                    Tipo[np]= "assalariado";
                                    System.out.println("Insira o salario por mes:");
                                    salario = input.nextDouble();
                                    Salario[np] =salario;
                                    AgendaPagamento[np] ="Mensalmente";
                                    Pagamento[i] = diaUltimo;
                                }
                                if(t == 3)
                                {
                                    Tipo[np] ="comissionado";
                                    System.out.println("Insira o salario:");
                                    salario = input.nextDouble();
                                    Salario[np] =salario;
                                    Pagamento[i] = "sexta-feira";
                                    bi[i] = "0";
                                    AgendaPagamento[np] = "Bi- semanalmente";
                                }
                                if(t != 1 && t != 2 && t != 3)
                                {
                                    System.out.println("Insira um numero valido");
                                }
                            }
                            t = -1;
                        }
                    }

                    if(n == 4)
                    {
                        System.out.println("|-------------------------------------------------------|");
                        System.out.println("| Insira o numero da respectiva escolha do novo metodo: |");
                        System.out.println("| 1 - Cheque pelos Correios;                            |");
                        System.out.println("| 2 - Cheque em maos;                                   |");
                        System.out.println("| 3 - Deposito em conta bancaria;                       |");
                        System.out.println("|-------------------------------------------------------|");

                        if(metodoPagamento == -1)
                        {
                            while(metodoPagamento != 1 && metodoPagamento != 2 && metodoPagamento != 3)
                            {
                                metodoPagamento = input.nextInt();
                                if(metodoPagamento == 1)
                                {
                                    MetodoPagamento[np] ="Cheque pelos Correios";
                                }
                                if(metodoPagamento == 2)
                                {
                                    MetodoPagamento[np] ="Cheque em maos";
                                }
                                if(metodoPagamento == 3)
                                {
                                    MetodoPagamento[np] ="Deposito em conta bancaria";
                                }
                                if(metodoPagamento != 1 && metodoPagamento != 2 && metodoPagamento != 3)
                                {
                                    System.out.println("Insira um numero valido");
                                }
                            }
                            metodoPagamento = -1;
                        }

                    }

                    if(n == 5)
                    {
                        if(sind == -1)
                        {
                            if(Sindicato[np].equals("Faz parte do Sindicato."))
                            {
                                System.out.println("Nao faz mais parte do Sindicato?");
                                System.out.println("|-----------------------------------------------|");
                                System.out.println("| Digite:                                       |");
                                System.out.println("| 0 - NAO, nao faço mais parte do Sindicato     |");
                                System.out.println("| 1 - SIM, ainda faço parte do Sindicato        |");
                                System.out.println("|-----------------------------------------------|");

                                while(sind != 0 && sind != 1)
                                {
                                    sind = input.nextInt();
                                    if(sind == 0)
                                    {
                                        Sindicato[np] ="Nao faz parte do Sindicato.";
                                        IdSindicato[np] ="-";
                                        taxa_sindicato = 0;
                                        TaxaSindicato[np] =taxa_sindicato;
                                    }
                                    else if(sind != 0 && sind != 1)
                                    {
                                        System.out.println("Insira um numero valido");
                                    }
                                }
                                sind = -1;
                            }

                            if(Sindicato[np].equals("Nao faz parte do Sindicato."))
                            {
                                System.out.println("Agora faz parte do Sindicato?");
                                System.out.println("|--------------------------------------------------|");
                                System.out.println("| Digite:                                          |");
                                System.out.println("| 0 - NAO, continuo sem fazer parte do Sindicato   |");
                                System.out.println("| 1 - SIM, agora faço parte do Sindicato           |");
                                System.out.println("|--------------------------------------------------|");
                                while(sind != 0 && sind != 1)
                                {
                                    sind = input.nextInt();
                                    if(sind == 1)
                                    {
                                        Sindicato[np] ="Faz parte do Sindicato.";
                                        System.out.println("Identificacao no sindicato");
                                        input.nextLine();
                                        id_sindicato = input.nextLine();
                                        IdSindicato[np] =id_sindicato;
                                        System.out.println("Taxa Sindical");
                                        taxa_sindicato = input.nextDouble();
                                        TaxaSindicato[np] =taxa_sindicato;
                                    }
                                    else if(sind != 0 && sind != 1)
                                    {
                                        System.out.println("Insira um numero valido");
                                    }
                                }
                                sind = -1;
                            }
                        }
                    }
                    System.out.println("ALTERACAO FEITA COM SUCESSO!\n");
                }
                n=0;
            }
        }
    }

    public static void MenuEmp()
    {
        System.out.println("|----------------------------------------|");
        System.out.println("|                  MENU                  |");
        System.out.println("|                                        |");
        System.out.println("| O que deseja fazer?                    |");
        System.out.println("| 1- Cartao de ponto                     |");
        System.out.println("| 2- Resultado da venda                  |");
        System.out.println("| 3- Taxa de servico                     |");
        System.out.println("| 4- Nova Agenda de Pagamento            |");
        System.out.println("| 5- Informacoes do Funcionario          |");
        System.out.println("| 0- Sair                                |");
        System.out.println("|                                        |");
        System.out.println("| 37- undo                       73-redo |");
        System.out.println("|----------------------------------------|");
    }

    public static void MenuAdm()
    {
        System.out.println("|----------------------------------------|");
        System.out.println("|                  MENU                  |");
        System.out.println("|                                        |");
        System.out.println("| O que deseja fazer?                    |");
        System.out.println("| 1- Adicionar empregado                 |");
        System.out.println("| 2- Remover empregado                   |");
        System.out.println("| 3- Cartao de ponto                     |");// MANUTENCAO
        System.out.println("| 4- Resultado da venda                  |");// MANUTENCAO
        System.out.println("| 5- Taxa de servico                     |");// AINDA NAO CRIADO
        System.out.println("| 6- Alterar detalhes do empregado       |");// MANUTENCAO
        //System.out.println("| 7- Agenda de Pagamento                 |");
        System.out.println("| 8- Lista e Informacoes de empregados   |");
        System.out.println("| 9- Passar o dia                        |");
        System.out.println("| 0- Sair                                |");
        System.out.println("|                                        |");
        System.out.println("| 37- undo                       73-redo |");
        System.out.println("|----------------------------------------|");
    }

    public static void cpempre(int np)
    {
        Scanner input = new Scanner(System.in);
        int valor =-1;
        np = Sistema.posicao(np);

        if(Tipo[np].equals("horista"))
        {
            System.out.println("Olá, " + Nome[np]);

            if(Entrada[np].equals("-"))
            {
                System.out.println("Horario de entrada:");
                //input.nextLine();
                Entrada[np] = input.nextLine();
            }
            if(!Entrada[np].equals("-") && Saida[np].equals("-"))
            {
                System.out.println("Horario de saida:");
                //input.nextLine();
                Saida[np] = input.nextLine();

                SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                Date inicio = null;
                Date fim = null;

                try
                {
                    inicio = format.parse(Entrada[np]);
                    fim = format.parse(Saida[np]);

                    long subtracao = fim.getTime() - inicio.getTime();
                    int diff = (int)subtracao / (60 * 60 * 1000) % 24;

                    diff = Math.abs(diff);
                    if(inicio.getTime() > fim.getTime())
                    {
                        diff = 24 % diff;
                    }

                    System.out.printf("\n%d horas\n",diff);

                    int hora = diff;
                    int extra;

                    if(hora > 8)
                    {
                        extra = hora - 8 ;

                        SalarioAtual[np] = SalarioAtual[np] + (Salario[np] * 8) + (Salario[np] * extra * 1.5 );

                        //System.out.printf("Salario atual eh de: %.2f", SalarioAtual[np]);
                    }
                    else if(hora <= 8)
                    {
                        SalarioAtual[np] = SalarioAtual[np] + Salario[np] * hora;
                    }

                    DiasTrabalho[np] = DiasTrabalho[np] + 1;

                }catch (Exception e)
                {
                }
            }
            else if(!Entrada[np].equals("-") && !Saida[np].equals("-"))
            {
                System.out.println("Esse dia ja foi finalizado.");
            }
        }
        if(Tipo[np].equals("assalariado") || Tipo[np].equals("comissionado"))
        {
            if(!Saida[np].equals("1"))
            {
                System.out.println("Olá, " + Nome[np] + "! Mais um dia de trabalho?");
                Sistema.SN();
                if(valor == -1)
                {
                    while(valor != 0 && valor != 1)
                    {
                        valor = input.nextInt();
                        if(valor == 1)
                        {
                            DiasTrabalho[np] = DiasTrabalho[np] + 1;
                            Saida[np] = "1";
                        }
                        if(valor != 1 && valor != 0) System.out.println("Insira uma resposta valida");
                    }
                }
            }
            else if(Saida[np].equals("1")) System.out.println("Esse dia ja foi finalizado.");
        }
    }

    public static void rvempre(int np)
    {
        Scanner input = new Scanner(System.in);
        double valor;
        np = Sistema.posicao(np);
        if(Tipo[np].equals("comissionado"))
        {
            if(DataRV[np][day].equals("-"))
            {
                System.out.println("Informe o valor da venda");
                valor = input.nextDouble();
                SalarioAtual[np] = SalarioAtual[np] + valor;
                DataRV[np][day] = dataEmString;
            }
            else System.out.println("Resultado das vendas ja feita neste dia");
        }
        else System.out.println("Empregado nao comissionado");
    }

    public static void tsempre(int np)
    {
        Scanner input = new Scanner(System.in);
        double valor;
        np = Sistema.posicao(np);
        if(Sindicato[np].equals("Faz parte do Sindicato."))
        {
            if(TaxaServicos[np] == 0)
            {
                System.out.println("Digite a taxa de servico cobrada mensalmente pelo Sindicato");
                valor = input.nextDouble();
                TaxaServicos[np] = valor;
                SalarioAtual[np] = SalarioAtual[np] - valor;
            }
            else if(TaxaServicos[np] != 0) System.out.println("Taxa de servico do Sindicato ja cobrada no mes: R$ " + TaxaServicos[np]);
        }
        else System.out.println("Empregado nao faz parte do sindicato.");
    }

    public static void infempre(int i)
    {
        i = Sistema.posicao(i);
        System.out.printf("ID: %d\nNome: %s\nEndereco: %s\nTipo: %s\n",ID[i],Nome[i],Endereco[i],Tipo[i]);

        if(Tipo[i].equals("horista"))
        {
            System.out.printf("Salario horario: R$ %.2f\n",Salario[i]);
        }
        if(Tipo[i].equals("assalariado"))
        {
            System.out.printf("Salario mensal: R$ %.2f\n",Salario[i]);
        }
        if(Tipo[i].equals("comissionado"))
        {
            System.out.printf("Comissao: R$ %.2f\n",Salario[i]);
        }

        if(Sindicato[i].equals("Faz parte do Sindicato."))
        {
            System.out.printf("Faz parte do Sindicato.\n");
            System.out.printf ("Identificacao no sindicato: %s\n", IdSindicato[i]);
            System.out.printf ("Taxa sindical: R$ %.2f\n", TaxaSindicato[i]);
        }else{
            System.out.printf("Nao faz parte do Sindicato.\n");
        }

        System.out.printf("Agenda de pagamento: %s\n", AgendaPagamento[i]);
        System.out.printf("Metodo de pagamento: %s\n", MetodoPagamento[i]);
        //System.out.printf("Entrada: %s\n", Entrada[i]);
        //System.out.printf("Saida: %s\n", Saida[i]);
        System.out.printf("Data de Registro: ");
        System.out.println(Data[i]);///
        System.out.println();
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int escolha = -1, opcao = -1, acesso, i=0, p=0;
        String senha;

        if(escolha == -1)
        {
            while(escolha != 0)
            {
                Sistema.tempo(opcao); Sistema.Inicializando();
                escolha = input.nextInt();
                if(escolha == 1)
                {
                    System.out.printf ("Digite o ID de acesso\n");
                    acesso = input.nextInt();
                    while(i<MAX)
                    {
                        if(acesso == ID[i]) p=1;

                        i++;
                    }
                    if(p == 1)
                    {
                        while(opcao != 0)
                        {
                            Sistema.MenuEmp();
                            opcao = input.nextInt();

                            if(opcao == 1 || opcao == 2 || opcao == 3) Sistema.UR();

                            if(opcao == 1) Sistema.cpempre(acesso);

                            if(opcao == 2) Sistema.rvempre(acesso);

                            if(opcao == 3) Sistema.tsempre(acesso);

                            if(opcao == 4) Sistema.NovaAgenda(acesso);

                            if(opcao == 5) Sistema.infempre(acesso);

                            if(opcao == 37) Sistema.undo();

                            if(opcao == 73) Sistema.redo();
                        }
                    }
                    else if(p==0) System.out.println("SENHA INCORRETA. TENTE NOVAMENTE.");
                    i=0;
                    opcao = -1;
                }

                if(escolha == 2)
                {
                    System.out.printf ("Digite a senha de acesso\n");
                    input.nextLine();
                    senha = input.nextLine();

                    if(senha.equals("123456") || senha.equals("java"))
                    {
                        while(opcao != 0)
                        {
                            if(opcao == -1) Sistema.tempo(opcao);

                            Sistema.MenuAdm();
                            opcao = input.nextInt();

                            if(opcao == 1 || opcao == 2 || opcao == 3 || opcao == 4 || opcao == 5 || opcao == 6 || opcao == 9) Sistema.UR();

                            if(opcao == 1) Sistema.add();

                            if(opcao == 2) Sistema.remove();

                            if(opcao == 3) Sistema.cartaoPonto();

                            if(opcao == 4) Sistema.resultadoVendas();

                            if(opcao == 5) Sistema.taxaServicos();

                            if(opcao == 6) Sistema.alterar();

                            //if(opcao == 7);

                            if(opcao == 8) Sistema.informacoes();

                            if(opcao == 9)
                            {
                                Sistema.tempo(opcao);
                                Sistema.folhaPagamento();
                            }

                            if(opcao == 37) Sistema.undo();

                            if(opcao == 73) Sistema.redo();

                            System.out.println();

                        }
                        opcao = -1;
                    }
                    else System.out.println("SENHA INCORRETA. TENTE NOVAMENTE.");
                }
            }
        }
    }

    public static void Inicializando()
    {
        System.out.println("|----------------------------------------------|");
        System.out.println("|                  SISTEMA                     |");
        System.out.println("|  1 - Funcionario                             |" );
        System.out.println("|  2 - Administrador                           |" );
        System.out.println("|  0 - Sair                                    |" );
        System.out.println("|----------------------------------------------|");
    }

    public static void ficha()
    {
        System.out.println();
        System.out.println("|-----------------------------------------------------------------------------|");
        System.out.println("                         FICHA DO EMPREGADO ADICIONADO  ");
        System.out.printf ("  ID: %d\n", ID[MAX]);
        System.out.printf ("  Nome: %s\n", Nome[MAX]);
        System.out.printf ("  Endereco: %s\n", Endereco[MAX]);
        System.out.printf ("  Tipo: %s\n", Tipo[MAX]);
        System.out.printf ("  Salario/Comissao: R$ %.2f\n", Salario[MAX]);
        if(Sindicato[tam].equals("Faz parte do Sindicato."))
        {
            System.out.printf ("  Faz parte do Sindicato.\n");
            System.out.printf ("  Identificacao no Sindicato: %s\n", IdSindicato[MAX]);
            System.out.printf ("  Taxa Sindical: R$ %.2f\n", TaxaSindicato[MAX]);
        }else{
            System.out.printf ("  Nao faz parte do Sindicato.\n");
        }
        System.out.printf ("  Agenda de pagamento: %s\n", AgendaPagamento[MAX]);
        System.out.printf ("  Metodo de pagamento: %s\n", MetodoPagamento[MAX]);
        System.out.printf ("  Data de Registro: %s\n",Data[MAX]);
        //System.out.println(novo.getSdf().format(novo.getData().getTime()));////
        System.out.println("|-----------------------------------------------------------------------------|\n");
    }

    public static void informacoes()
    {
        int i=0;
        if(tam == 0)
        {
            System.out.println("\nNAO HA EMPREGADOS\n");
        }
        if(tam > 0)
        {
            System.out.println("\nLISTA E INFORMACOES DE EMPREGADOS\n");
            while(i < MAX)
            {
                if(ID[i] != -1)
                {
                    System.out.printf("ID: %d\nNome: %s\nEndereco: %s\nTipo: %s\n",ID[i],Nome[i],Endereco[i],Tipo[i]);

                    if(Tipo[i].equals("horista"))
                    {
                        System.out.printf("Salario horario: R$ %.2f\n",Salario[i]);
                    }
                    if(Tipo[i].equals("assalariado"))
                    {
                        System.out.printf("Salario mensal: R$ %.2f\n",Salario[i]);
                    }
                    if(Tipo[i].equals("comissionado"))
                    {
                        System.out.printf("Comissao: R$ %.2f\n",Salario[i]);
                    }

                    if(Sindicato[i].equals("Faz parte do Sindicato."))
                    {
                        System.out.printf("Faz parte do Sindicato.\n");
                        System.out.printf ("Identificacao no sindicato: %s\n", IdSindicato[i]);
                        System.out.printf ("Taxa sindical: R$ %.2f\n", TaxaSindicato[i]);
                    }else{
                        System.out.printf("Nao faz parte do Sindicato.\n");
                    }

                    System.out.printf("Agenda de pagamento: %s\n", AgendaPagamento[i]);
                    System.out.printf("Metodo de pagamento: %s\n", MetodoPagamento[i]);
                    //System.out.printf("Entrada: %s\n", Entrada[i]);
                    //System.out.printf("Saida: %s\n", Saida[i]);
                    System.out.printf("Data de Registro: ");
                    System.out.println(Data[i]);///
                    System.out.println();
                }
                i++;
            }
        }
    }

    public static void SN()
    {
        System.out.println("|-------------------|");
        System.out.println("| Digite:           |");
        System.out.println("| 0 , se NAO        |");
        System.out.println("| 1 , se SIM        |");
        System.out.println("|-------------------|");
    }

    public static void Alteracao()
    {
        System.out.println("|----------------------------------------|");
        System.out.println("| Qual dado deseja alterar?              |");
        System.out.println("| 1- Nome do empregado                   |");
        System.out.println("| 2- Endereco do empregado               |");
        System.out.println("| 3- Tipo                                |");
        System.out.println("| 4- Metodo de pagamento                 |");
        System.out.println("| 5- Sindicato                           |");
        System.out.println("| 0- Voltar                              |");
        System.out.println("|----------------------------------------|");
    }

    public static void tempo(int op)
    {
        Sistema.uteis();
        if(op == 9)
        {
            day++;
            indice++;
            int j=0;
            while(j<MAX)
            {
                Entrada[j]= "-";
                Saida[j]= "-";
                j++;
            }
        }

        Sistema.diadasemana();
        Sistema.verifica();
        Sistema.diadasemana();


        dataEmString = day + "/" + month + "/" + year;
        System.out.println("Estamos em" + " " + dataEmString + " " + DiaDaSemana);

    }

    public static void verifica()
    {
        int i;
        for(i=0;i<32;i++)
        {
            TaxaServicos[i] = 0.0;
        }

        if(DiaDaSemana.equals("domingo"))
        {
            day++;
            indice++;
        }
        if(DiaDaSemana.equals("sábado"))
        {
            day = day +2;
            indice = indice + 2;
        }

        if(indice >= 8)
        {
            indice = indice -7;
        }

        if(day>maxima)
        {
            day=1;
            month++;
            if(month > 12)
            {
                month=1;
                year++;
            }
            diasdomes();
        }
    }

    public static void diadasemana()
    {

        if(indice == 1) DiaDaSemana = "domingo";

        if(indice == 2) DiaDaSemana = "segunda-feira";

        if(indice == 3) DiaDaSemana = "terça-feira";

        if(indice == 4) DiaDaSemana = "quarta-feira";

        if(indice == 5) DiaDaSemana = "quinta-feira";

        if(indice == 6) DiaDaSemana = "sexta-feira";

        if(indice == 7) DiaDaSemana = "sábado";
    }

    public static void diasdomes()
    {
        if(month == 1)
        {
            nomemes = "janeiro";
            maxima = 31;
        }

        if(month == 2)
        {
            nomemes = "fevereiro";
            if(year % 4 == 0)
            {
                maxima = 29;
            }else maxima = 28;
        }

        if(month == 3)
        {
            nomemes = "março";
            maxima = 31;
        }

        if(month == 4)
        {
            nomemes = "abril";
            maxima = 30;
        }

        if(month == 5)
        {
            nomemes = "maio";
            maxima = 31;
        }

        if(month == 6)
        {
            nomemes = "junho";
            maxima = 30;
        }

        if(month == 7)
        {
            nomemes = "julho";
            maxima = 31;
        }

        if(month == 8)
        {
            nomemes = "agosto";
            maxima = 31;
        }

        if(month == 9)
        {
            nomemes = "setembro";
            maxima = 30;
        }

        if(month == 10)
        {
            nomemes = "outubro";
            maxima = 31;
        }

        if(month == 11)
        {
            nomemes = "novembro";
            maxima = 30;
        }

        if(month == 12)
        {
            nomemes = "dezembro";
            maxima = 31;
        }
    }

    public static int posicao(int x)
    {
        String s = year + "" + 0;
        int np = x - Integer.parseInt(s);
        if(np>9 && np<99)
        {
            s = year + "" + 00;
            np = x - Integer.parseInt(s);
        }
        if(np>99 && np<999)
        {
            s = year + "" + 000;
            np = x - Integer.parseInt(s);
        }
        if(np>999 && np<9999)
        {
            s = year + "" + 0000;
            np = x - Integer.parseInt(s);
        }

        return np;
    }

    public static void uteis()
    {
        int ind= indice, d = day, x = maxima, i =0, mes = month;
        DiasUteis = 0;
        String semana= DiaDaSemana;
        int ultimodia = 5;

        while(day<=x && month == mes)
        {
            i++;
            ultimodia = day;
            day++;
            indice++;
            Sistema.diadasemana();

            if(day == 1 && !DiaDaSemana.equals("sábado") && !DiaDaSemana.equals("domingo"))
            {
                diaPrimeiro = day + "/" + mes + "/" + 2019;
            }
            else if(day == 2 && !DiaDaSemana.equals("sábado") && !DiaDaSemana.equals("domingo"))
            {
                diaPrimeiro = day + "/" + mes + "/" + 2019;
            }
            else if(day == 3 && !DiaDaSemana.equals("sábado") && !DiaDaSemana.equals("domingo"))
            {
                diaPrimeiro = day + "/" + mes + "/" + 2019;
            }

            if(day == 7 && !DiaDaSemana.equals("sábado") && !DiaDaSemana.equals("domingo"))
            {
                dia7 = day + "/" + mes + "/" + 2019;
            }
            else if(day == 8 && !DiaDaSemana.equals("sábado") && !DiaDaSemana.equals("domingo"))
            {
                dia7 = day + "/" + mes + "/" + 2019;
            }
            else if(day == 9 && !DiaDaSemana.equals("sábado") && !DiaDaSemana.equals("domingo"))
            {
                dia7 = day + "/" + mes + "/" + 2019;
            }

            Sistema.verifica();
            Sistema.diadasemana();
        }
        diaUltimo= ultimodia + "/" + mes + "/" + 2019;
        day=d;
        maxima=x;
        indice=ind;
        DiaDaSemana=semana;
        month= mes;
        DiasUteis = i;
    }

    public static void folhaPagamento()//////////////////////////
    {
        int i=0;
        if(tam>0)
        {
            System.out.println("|-----------------------------------------------------------------------------|");
            System.out.println("                    FOLHA DE PAGAMENTO DE " + dataEmString + " - " + DiaDaSemana + "\n");
            while(i<MAX)
            {

               if(Tipo[i].equals("horista"))
               {
                   if(DiaDaSemana.equals("segunda-feira") || DiaDaSemana.equals("Monday") )
                   {
                       if(Pagamento[i].equals("segunda-feira"))
                       {
                           System.out.println(" " + ID[i] + " - " + Nome[i] + " - R$ " + SalarioAtual[i] + " / " + MetodoPagamento[i]);
                           SalarioAtual[i] = 0.0;
                           DiasTrabalho[i] = 0;
                       }
                   }

                   if(DiaDaSemana.equals("terça-feira") || DiaDaSemana.equals("Tuesday") )
                   {
                       if(Pagamento[i].equals("terça-feira"))
                       {
                           System.out.println(" " + ID[i] + " - " + Nome[i] + " - R$ " + SalarioAtual[i] + " / " + MetodoPagamento[i]);
                           SalarioAtual[i] = 0.0;
                           DiasTrabalho[i] = 0;
                       }
                   }

                   if(DiaDaSemana.equals("quarta-feira") || DiaDaSemana.equals("Wednesday") )
                   {
                       if(Pagamento[i].equals("quarta-feira"))
                       {
                           System.out.println(" " + ID[i] + " - " + Nome[i] + " - R$ " + SalarioAtual[i] + " / " + MetodoPagamento[i]);
                           SalarioAtual[i] = 0.0;
                           DiasTrabalho[i] = 0;
                       }
                   }

                   if(DiaDaSemana.equals("quinta-feira") || DiaDaSemana.equals("Thursday") )
                   {
                       if(Pagamento[i].equals("quinta-feira"))
                       {
                           System.out.println(" " + ID[i] + " - " + Nome[i] + " - R$ " + SalarioAtual[i] + " / " + MetodoPagamento[i]);
                           SalarioAtual[i] = 0.0;
                           DiasTrabalho[i] = 0;
                       }
                   }

                   if(DiaDaSemana.equals("sexta-feira") || DiaDaSemana.equals("Sunday") )
                   {
                       if(Pagamento[i].equals("sexta-feira"))
                       {
                           System.out.println(" " + ID[i] + " - " + Nome[i] + " - R$ " + SalarioAtual[i] + " / " + MetodoPagamento[i]);
                           SalarioAtual[i] = 0.0;
                           DiasTrabalho[i] = 0;
                       }
                   }
                   if(day == ultimoDiaUtil)
                   {
                       SalarioAtual[i] = SalarioAtual[i] - TaxaSindicato[i];
                   }
               }

               if(Tipo[i].equals("assalariado"))
               {
                   if(dataEmString.equals(Pagamento[i]))
                   {
                       SalarioAtual[i] = SalarioAtual[i] + (Salario[i] / DiasUteis) * DiasTrabalho[i];
                       System.out.println(" " + ID[i] + " - " + Nome[i] + " - R$ " + SalarioAtual[i] + " / " + MetodoPagamento[i] + " DeS");
                       SalarioAtual[i] = 0.0;
                       SalarioAtual[i] = SalarioAtual[i] - TaxaSindicato[i];
                       DiasTrabalho[i] = 0;
                   }
               }

               if(Tipo[i].equals("comissionado"))
               {
                   if(DiaDaSemana.equals("segunda-feira") || DiaDaSemana.equals("Monday") )
                   {
                       System.out.println("oioioi");
                       if(Pagamento[i].equals("segunda-feira"))
                       {
                           if(bi[i].equals("0"))
                           {
                               System.out.println("ewffewf");
                               bi[i] = "1";
                           }
                           else if(bi[i].equals("1"))
                           {
                               SalarioAtual[i] = SalarioAtual[i] + (Salario[i] / DiasUteis / 2 ) * DiasTrabalho[i];
                               System.out.println(" " + ID[i] + " - " + Nome[i] + " - R$ " + SalarioAtual[i] + " / " + MetodoPagamento[i] + " DeS");
                               SalarioAtual[i] = 0.0;
                               DiasTrabalho[i] = 0;
                               bi[i] = "0";
                           }
                       }
                   }

                   if(DiaDaSemana.equals("terça-feira") || DiaDaSemana.equals("Tuesday") )
                   {
                       if(Pagamento[i].equals("terça-feira"))
                       {
                           if(bi[i].equals("0"))
                           {
                               bi[i] = "1";
                           }
                           else if(bi[i].equals("1"))
                           {
                               SalarioAtual[i] = SalarioAtual[i] + (Salario[i] / DiasUteis / 2 ) * DiasTrabalho[i];
                               System.out.println(" " + ID[i] + " - " + Nome[i] + " - R$ " + SalarioAtual[i] + " / " + MetodoPagamento[i] + " DeS");
                               SalarioAtual[i] = 0.0;
                               DiasTrabalho[i] = 0;
                               bi[i] = "0";
                           }
                       }
                   }

                   if(DiaDaSemana.equals("quarta-feira") || DiaDaSemana.equals("Wednesday") )
                   {
                       if(Pagamento[i].equals("quarta-feira"))
                       {
                           if(bi[i].equals("0"))
                           {
                               bi[i] = "1";
                           }
                           else if(bi[i].equals("1"))
                           {
                               SalarioAtual[i] = SalarioAtual[i] + (Salario[i] / DiasUteis / 2 ) * DiasTrabalho[i];
                               System.out.println(" " + ID[i] + " - " + Nome[i] + " - R$ " + SalarioAtual[i] + " / " + MetodoPagamento[i] + " DeS");
                               SalarioAtual[i] = 0.0;
                               DiasTrabalho[i] = 0;
                               bi[i] = "0";
                           }
                       }
                   }

                   if(DiaDaSemana.equals("quinta-feira") || DiaDaSemana.equals("Thursday") )
                   {
                       if(Pagamento[i].equals("quinta-feira"))
                       {
                           if(bi[i].equals("0"))
                           {
                               bi[i] = "1";
                           }
                           else if(bi[i].equals("1"))
                           {
                               SalarioAtual[i] = SalarioAtual[i] + (Salario[i] / DiasUteis / 2 ) * DiasTrabalho[i];
                               System.out.println(" " + ID[i] + " - " + Nome[i] + " - R$ " + SalarioAtual[i] + " / " + MetodoPagamento[i] + " DeS");
                               SalarioAtual[i] = 0.0;
                               DiasTrabalho[i] = 0;
                               bi[i] = "0";
                           }
                       }
                   }

                   if(DiaDaSemana.equals("sexta-feira") || DiaDaSemana.equals("Sunday") )
                   {
                       if(Pagamento[i].equals("sexta-feira"))
                       {
                           if(bi[i].equals("0"))
                           {
                               bi[i] = "1";
                           }
                           else if(bi[i].equals("1"))
                           {
                               SalarioAtual[i] = SalarioAtual[i] + (Salario[i] / DiasUteis / 2  * DiasTrabalho[i]);
                               System.out.println(" " + ID[i] + " - " + Nome[i] + " - R$ " + SalarioAtual[i] + " / " + MetodoPagamento[i] + " DeS");
                               SalarioAtual[i] = 0.0;
                               DiasTrabalho[i] = 0;
                               bi[i] = "0";
                           }
                       }
                   }
                   if(day == ultimoDiaUtil)
                   {
                       SalarioAtual[i] = SalarioAtual[i] - TaxaSindicato[i];
                   }
               }
               i++;
            }

            System.out.println("|-----------------------------------------------------------------------------|\n");
        }

    }

    public static void UR()//////////////
    {
        Sistema.copia();
        undo = 0;
        estado = estado + 1;
    }

    public static void copia()////////////
    {
        int i=0;
        while(i<=MAX)
        {
            NomeUR[estado][i] = Nome[i];
            EnderecoUR[estado][i] = Endereco[i];
            TipoUR[estado][i] = Tipo[i];
            TAMANHOUR[estado][i] = TAMANHO[i];
            SindicatoUR[estado][i] = Sindicato[i];
            IdSindicatoUR[estado][i] = IdSindicato[i];
            AgendaPagamentoUR[estado][i] = AgendaPagamento[i];
            MetodoPagamentoUR[estado][i] = MetodoPagamento[i];
            DataUR[estado][i] = Data[i];
       //     DataRVUR[estado][i][day] = DataRV[i][day];
            EntradaUR[estado][i] = Entrada[i];
            SaidaUR[estado][i] = Saida[i];
            PagamentoUR[estado][i] = Pagamento[i];
            biUR[estado][i] = bi[i];
            IDUR[estado][i] = ID[i];
            DiasTrabalhoUR[estado][i] = DiasTrabalho[i];
            TaxaSindicatoUR[estado][i] = TaxaSindicato[i];
            SalarioUR[estado][i] = Salario[i];
            SalarioAtualUR[estado][i] = SalarioAtual[i];
            ResultadoVendasUR[estado][i] = ResultadoVendas[i];
            TaxaServicosUR[estado][i] = TaxaServicos[i];
            i++;
        }
    }

    public static void undo()////////////
    {
        undo++;
        Sistema.copia();
        Nome = NomeUR[estado-w];
        Endereco = EnderecoUR[estado-w];
        Tipo = TipoUR[estado-w];
      //  TAMANHO = TAMANHOUR[estado-w];
        Sindicato = SindicatoUR[estado-w];
        IdSindicato = IdSindicatoUR[estado-w];
        AgendaPagamento = AgendaPagamentoUR[estado-w] ;
        MetodoPagamento = MetodoPagamentoUR[estado-w];
        Data = DataUR[estado-w];
    //    DataRV = DataRVUR[estado-w];
        Entrada = EntradaUR[estado-w] ;
        Saida = SaidaUR[estado-w];
        Pagamento = PagamentoUR[estado-w];
        bi = biUR[estado-w];
        ID = IDUR[estado-w];
        DiasTrabalho = DiasTrabalhoUR[estado-w];
        TaxaSindicato = TaxaSindicatoUR[estado-w];
        Salario = SalarioUR[estado-w];
        SalarioAtual = SalarioAtualUR[estado-w];
        ResultadoVendas = ResultadoVendasUR[estado-w];
        TaxaServicos = TaxaServicosUR[estado-w];
      //  MAX = TAMANHO[q-1];
        estado++;
        w = w + 2;
    }

    public static void redo()///////
    {
        if(undo!=0)
        {
            Sistema.copia();
            Nome = NomeUR[estado-z];
            Endereco = EnderecoUR[estado-z];
            Tipo = TipoUR[estado-z];
         //   TAMANHO = TAMANHOUR[estado-z];
            Sindicato = SindicatoUR[estado-z];
            IdSindicato = IdSindicatoUR[estado-z];
            AgendaPagamento = AgendaPagamentoUR[estado-z] ;
            MetodoPagamento = MetodoPagamentoUR[estado-z];
            Data = DataUR[estado-z];
       //     DataRV = DataRVUR[estado-z];
            Entrada = EntradaUR[estado-z] ;
            Saida = SaidaUR[estado-z];
            Pagamento = PagamentoUR[estado-z];
            bi = biUR[estado-z];
            ID = IDUR[estado-z];
            DiasTrabalho = DiasTrabalhoUR[estado-z];
            TaxaSindicato = TaxaSindicatoUR[estado-z];
            Salario = SalarioUR[estado-z];
            SalarioAtual = SalarioAtualUR[estado-z];
            ResultadoVendas = ResultadoVendasUR[estado-z];
            TaxaServicos = TaxaServicosUR[estado-z];

            z = z + 2;
       //     MAX = TAMANHO[q];
            estado++;
            undo--;
        }
    }

    public static void nvagHorista()
    {
        System.out.println("|----------------------------------------|");
        System.out.println("| Ola horista, qual agenda prefere?      |");
        System.out.println("| 1- semanal 1 segunda                   |");
        System.out.println("| 2- semanal 1 terça                     |");
        System.out.println("| 3- semanal 1 quarta                    |");
        System.out.println("| 4- semanal 1 quinta                    |");// MANUTENCAO
        System.out.println("| 5- semanal 1 sexta                     |");// MANUTENCAO
        System.out.println("| 0- Voltar                              |");
        System.out.println("|----------------------------------------|");
    }

    public static void nvagComissionado()
    {
        System.out.println("|----------------------------------------|");
        System.out.println("| Ola horista, qual agenda prefere?      |");
        System.out.println("| 1- semanal 2 segunda                   |");
        System.out.println("| 2- semanal 2 terça                     |");
        System.out.println("| 3- semanal 2 quarta                    |");
        System.out.println("| 4- semanal 2 quinta                    |");// MANUTENCAO
        System.out.println("| 5- semanal 2 sexta                     |");// MANUTENCAO
        System.out.println("| 0- Voltar                              |");
        System.out.println("|----------------------------------------|");
    }

    public static void nvagAssaalariado()
    {
        System.out.println("|-----------------------------------------|");
        System.out.println("| Ola assalariado, qual agenda prefere?   |");
        System.out.println("| 1- mensal 7                             |");
        System.out.println("| 2- mensal $                             |");
        System.out.println("| 3- mensal 1                             |");
        System.out.println("| 0- Voltar                               |");
        System.out.println("|-----------------------------------------|");
    }

    public static void NovaAgenda(int np)
    {

        Scanner input = new Scanner(System.in);
        double valor;
        int op=-1;
        np = Sistema.posicao(np);
        if(Tipo[np].equals("horista"))
        {
            while(op!=1 && op!=2 && op!=3 && op!=4 && op!=5 && op!=0)
            {
                Sistema.nvagHorista();
                op = input.nextInt();
                if(op==1) Pagamento[np] = "segunda-feira";
                if(op==2) Pagamento[np] = "terça-feira";
                if(op==3) Pagamento[np] = "quarta-feira";
                if(op==4) Pagamento[np] = "quinta-feira";
                if(op==5) Pagamento[np] = "sexta-feira";
                if(op!=1 && op!=2 && op!=3 && op!=4 && op!=5 && op!=0) System.out.println("Insira um numero valido.");
            }
        }
        if(Tipo[np].equals("assalariado"))
        {
            while(op!=1 && op!=2 && op!=3 && op!=0)
            {
                Sistema.nvagAssaalariado();
                op = input.nextInt();
                if(op==1) Pagamento[np] = dia7;
                if(op==2) Pagamento[np] = diaPrimeiro;
                if(op==3) Pagamento[np] = diaUltimo;
                if(op!=1 && op!=2 && op!=3 && op!=0) System.out.println("Insira um numero valido.");
            }
        }
        if(Tipo[np].equals("comissionado"))
        {
            while(op!=1 && op!=2 && op!=3 && op!=4 && op!=5 && op!=0)
            {
                Sistema.nvagComissionado();
                op = input.nextInt();
                if(op==1) Pagamento[np] = "segunda-feira";
                if(op==2) Pagamento[np] = "terça-feira";
                if(op==3) Pagamento[np] = "quarta-feira";
                if(op==4) Pagamento[np] = "quinta-feira";
                if(op==5) Pagamento[np] = "sexta-feira";
                if(op!=1 && op!=2 && op!=3 && op!=4 && op!=5 && op!=0) System.out.println("Insira um numero valido.");
            }
        }
    }
}
