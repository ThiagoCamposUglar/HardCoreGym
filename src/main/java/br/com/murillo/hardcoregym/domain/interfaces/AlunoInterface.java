package br.com.murillo.hardcoregym.domain.interfaces;

import java.time.LocalDate;
import java.util.List;

import br.com.murillo.hardcoregym.domain.acesso.Acesso;
import br.com.murillo.hardcoregym.domain.aluno.Aluno;
import br.com.murillo.hardcoregym.domain.aluno.Aluno.Situacao;

public interface AlunoInterface {
	
	public Aluno findByRG(Integer rg);
	
	public void delete (String matricula);
	
	public String getMaxMatriculaAno();
	
	public List<Aluno> listAlunos(String matricula, String nome, Integer rg, Integer telefone);
	
	public List<Aluno> listSituacoesAlunos(Situacao situacao);
	
	public List<Acesso> listAcessosAlunos (String matricula, LocalDate dataInicial, LocalDate dataFinal);
	

}
