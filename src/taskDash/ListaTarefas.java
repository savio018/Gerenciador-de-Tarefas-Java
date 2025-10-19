package taskDash;

public class ListaTarefas {

	private String nome, data, descricao;
	private Status status;

	
	public ListaTarefas (String nome, String data, String descricao) {
		
		this.nome = nome;
		this.data = data;
		this.descricao = descricao;
		this.status = Status.PENDENTE;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}

	
	
}
