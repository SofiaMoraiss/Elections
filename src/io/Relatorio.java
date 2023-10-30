package io;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import eleicao.Candidato;
import eleicao.Eleicao;

public class Relatorio {

    String criaStringListaCandidatos(List<Candidato> lista){
        int i = 1;
        String x ="";
        for (Candidato c : lista){
            x+=i + " - ";
            x+=c.toString()+"\n";
            i++;
        }
        x+= "\n";
        return x;
    }

    public void printaRelatorio(Eleicao e){
        // 1
        int n_eleitos = e.getEleitos().size();
        String relatorio = "Número de vagas: "+ n_eleitos +"\n\n";
        // 2
        String tipo_deputado = e.getOpcaoCargo();
        relatorio +="Deputados "+ tipo_deputado + " eleitos:\n";
        e.ordenaEleitos();
        relatorio += criaStringListaCandidatos(e.getEleitos());

        // 3
        relatorio += "Candidatos mais votados (em ordem decrescente de votação e respeitando número de vagas):\n";
        List<Candidato> candidatosOrdenados = new ArrayList<>(e.getCandidatos().values());
        Collections.sort(candidatosOrdenados);
        candidatosOrdenados = candidatosOrdenados.subList(0, n_eleitos);
        relatorio += criaStringListaCandidatos(candidatosOrdenados);

        // 4
        relatorio += "Teriam sido eleitos se a votação fosse majoritária, e não foram eleitos:\n";
        relatorio += criaStringListaCandidatos(printa4(e.getEleitos(), candidatosOrdenados));

        // 5
        relatorio += "Eleitos, que se beneficiaram do sistema proporcional:\n";
        relatorio += criaStringListaCandidatos(printa5(e.getEleitos(), candidatosOrdenados));
        // 6
        relatorio += "Votação dos partidos e número de candidatos eleitos:\n";
        //relatorio += printaListaPartidos(partidos_6);
        // 7
        relatorio += "Primeiro e último colocados de cada partido:\n";
        //relatorio += criaStringListaCandidatos(partidos_6);
        // 8
        relatorio += "Eleitos, por faixa etária (na data da eleição):\n";
        //relatorio += criaStringListaCandidatos(partidos_6);
        // 9
        relatorio += "Eleitos, por gênero:\n";
        //relatorio += printaListaPartidos(partidos_6);
        // 10
        //relatorio += "Total de votos válidos: " + total_votos + "\n";
        //relatorio += "Total de votos nominais: " + votos_nominais + "\n";
        //relatorio += "Total de votos de legenda: " + votos_legenda + "\n";
        
        System.out.println(relatorio);
    }
    

    public void printaNumEleitos(Eleicao e ){
        int n = e.getEleitos().size();
        System.out.println("NUM ELEITOS: "+ n + "\n");
    }

    public void printa2(Eleicao e){
        System.out.println("ANTES: \n\n");
        System.out.println(e.getEleitos());
        System.out.println("\nDEPOIS:\n\n");
        e.ordenaEleitos();
        System.out.println(e.getEleitos());
    }

    public void printa3(Eleicao e){
        //List<Candidato> lista = new ArrayList();
        int i = 0;
        //System.out.println(lista);
    }

    public List<Candidato> printa4(List<Candidato> eleitos, List<Candidato> eleitos_se_maj){
        List<Candidato> candidatos = new ArrayList<>();
        for (Candidato c : eleitos_se_maj){
            if (!eleitos.contains(c)){
                candidatos.add(c);
            }
        }
        return candidatos;
    }

    public List<Candidato> printa5(List<Candidato> eleitos, List<Candidato> eleitos_se_maj){
        List<Candidato> candidatos = new ArrayList<>();
        for (Candidato c : eleitos){
            if (!eleitos_se_maj.contains(c)){
                candidatos.add(c);
            }
        }
        return candidatos;
    }

    public void printa6(){

    }
    
}
