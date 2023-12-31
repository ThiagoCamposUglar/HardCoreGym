package br.com.murillo.hardcoregym.interfaces.relatorio.web;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.RequestParameterMap;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.murillo.hardcoregym.application.service.AlunoService;
import br.com.murillo.hardcoregym.domain.aluno.Aluno;
import br.com.murillo.hardcoregym.domain.aluno.Aluno.Situacao;

@Named
@SessionScoped
public class RelatoriosSituacoesBean implements Serializable {

	private Situacao situacao;
	
	@EJB
	private AlunoService alunoService;
	
	@Inject
	@RequestParameterMap
	private Map<String, String> requestParamsMap;
	
	private List<Aluno> alunos;
	
	public void check() {
		String clear = requestParamsMap.get("clear");
		
		if(clear != null && Boolean.valueOf(clear)) {
			situacao = null;
			alunos = null;
		}
	}
	
	public String gerarRelatorio() {
		alunos = alunoService.listSituacoesAlunos(situacao);
		return null;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	
}
