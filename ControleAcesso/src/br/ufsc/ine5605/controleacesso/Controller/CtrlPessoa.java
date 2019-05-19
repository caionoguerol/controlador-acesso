/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.controleacesso.Controller;

import br.ufsc.ine5605.controleacesso.Model.Aluno;
import br.ufsc.ine5605.controleacesso.Model.Pessoa;
import br.ufsc.ine5605.controleacesso.Model.Sala;
import br.ufsc.ine5605.controleacesso.Model.Servidor;
import br.ufsc.ine5605.controleacesso.View.TelaPessoa;
import br.ufsc.ine5605.controleacesso.interfaces.ICtrlPessoa;
import java.util.ArrayList;

/**
 *
 * @author Caio Noguerol
 */
public class CtrlPessoa implements ICtrlPessoa {

    private final CtrlPrincipal ctrlPrincipal;

    private TelaPessoa telaPessoa;
    private ArrayList<Pessoa> pessoas;

    public CtrlPessoa(CtrlPrincipal ctrlPrincipal) {
        this.ctrlPrincipal = ctrlPrincipal;
        this.pessoas = new ArrayList<>();
        this.telaPessoa = new TelaPessoa(this);
    }

    public TelaPessoa getTelaPessoa() {
        return telaPessoa;
    }

    public CtrlPrincipal getCtrlPrincipal() {
        return ctrlPrincipal;
    }

    @Override
    public void incluiAluno(int matricula, String nome, int telefone, String email, String curso) {
        Pessoa alunoParaVerificar = findPessoaByMatricula(matricula);
        Pessoa alunoParaIncluir = null;
        if (alunoParaVerificar == null) {
            alunoParaIncluir = new Aluno(matricula, nome, telefone, email, curso);
        }
        pessoas.add(alunoParaIncluir);
    }

    @Override
    public void incluiServidor(int matricula, String nome, int telefone, String email, String cargo, boolean administrador) {
        Pessoa servidorParaVerificar = findPessoaByMatricula(matricula);
        if (servidorParaVerificar == null) {
            Pessoa servidorParaIncluir = new Servidor(matricula, nome, telefone, email, cargo, administrador);
        }
    }

    public void delPessoa(int matricula) {
        Pessoa pessoaParaDeletar = findPessoaByMatricula(matricula);
        if (pessoaParaDeletar != null) {
            pessoas.remove(pessoaParaDeletar);
        }
    }

    @Override
    public void cadastraSalaNaPessoa(int matricula, String codigoSala) {
        Sala salaParaCadastrar = ctrlPrincipal.getCtrlSala().findSalaByCodigoSala(codigoSala);
        Pessoa pessoaCadastro = findPessoaByMatricula(matricula);

        if (pessoaCadastro != null && salaParaCadastrar != null) {
            pessoaCadastro.addSala(salaParaCadastrar);
            salaParaCadastrar.addPessoa(pessoaCadastro);
        }
    }

    @Override
    public void delSalaNaPessoa(int matricula, String codigoSala) {
        Sala salaParaCadastrar = ctrlPrincipal.getCtrlSala().findSalaByCodigoSala(codigoSala);
        Pessoa pessoaCadastro = findPessoaByMatricula(matricula);

        if (pessoaCadastro != null && salaParaCadastrar != null) {
            pessoaCadastro.delSala(salaParaCadastrar);
            salaParaCadastrar.delPessoa(pessoaCadastro);
        }
    }

    /**
     *
     * @param matricula
     * @return
     */
    @Override
    public String listaSalasCadastradas(int matricula) {
        Pessoa pessoaCadastrada = findPessoaByMatricula(matricula);
        String lista = "";
        ArrayList<Sala> salasCadastradas = pessoaCadastrada.getSalasCadastradas();
       
        if (pessoaCadastrada != null) {
            for (Sala salaCadastrada : salasCadastradas) {
                lista += salaCadastrada.getCodigoSala() +" "+ salaCadastrada.getCentro() + "\n";
                return lista;
            }
        }
        lista = "Nao ha salas cadastradas";
        return lista;

    }
    
    @Override
    public String listAllPessoasCadastradas(){
        String  listaPessoasCadastradas = "";
        for(Pessoa pessoa: pessoas){
            listaPessoasCadastradas +="@" +pessoa.getMatricula() + " "+ pessoa.getNome()+"\n" ;
        }
        if(listaPessoasCadastradas.equals(" ")){
            listaPessoasCadastradas = "Nao ha pessoas cadastradas";
            return listaPessoasCadastradas;
        }
    return listaPessoasCadastradas;
    }
    
    public Pessoa findPessoaByMatricula(int matricula) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getMatricula() == matricula) {
                return pessoa;

            }
        }
        return null;
    }

}
