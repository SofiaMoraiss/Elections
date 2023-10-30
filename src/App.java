import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import eleicao.Eleicao;
import io.Leitor;
import io.Relatorio;

public class App {
    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: java -jar deputados.jar <opção_de_cargo> <caminho_arquivo_candidatos> <caminho_arquivo_voacao> <data>");
            System.exit(1);
        }

        int opcaoCargo=0;
        if (args[0].compareTo("--estadual")==0){
            opcaoCargo = 7;
        }
        else if (args[0].compareTo("--federal")==0){
            opcaoCargo = 6;
        }
        else {
            System.out.println("Opção de cargo inválida!");
            System.exit(1);
        }
        
        String caminhoArquivoCandidatos = args[1];
        String caminhoArquivoVotacao = args[2];
        Date data = null;

        try {
            data = new SimpleDateFormat("dd/MM/yyyy").parse(args[3]);
        }
        catch (ParseException e) {
            System.out.println("Data inválida");
            e.printStackTrace();
            System.exit(1);
        }

        Eleicao eleicao = new Eleicao(opcaoCargo, data);
        
        // TODO: ajustar leitor para classe utilizavel abaixo :P
        Leitor leitor = new Leitor();
        leitor.leArquivos(eleicao, caminhoArquivoVotacao, caminhoArquivoCandidatos);

        Relatorio r = new Relatorio();
        r.printaRelatorio(eleicao);
        //r.printaNumEleitos(eleicao);
        //r.printa2(eleicao);
        
        /* 
            Apenas testes, lembrar de remover depois
        */
        /* 
        for (Candidato c: eleicao.getCandidatos().values()) {
            System.out.println(c);
        }
        
        System.out.println("Candidatos eleitos: ");
        for (Candidato c: eleicao.getEleitos()) {
            System.out.println(c);
        }
        System.out.println("");

        System.out.println("Quantidade de partidos: " + eleicao.getPartidos().size());

        for (Partido p: eleicao.getPartidos().values()) {
            System.out.println(p + "\n--------------------------------------------------------------------------");
            for (Candidato c: p.getCandidatosDeferidos().values()) {
                System.out.println(c);
            }
            System.out.println("\n--------------------------------------------------------------------------\n");
        }*/
    }
}
