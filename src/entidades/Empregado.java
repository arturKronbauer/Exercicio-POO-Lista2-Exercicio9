package entidades;

public class Empregado {
	private Integer id;
	private String nome;
	private Double salario;

	public Empregado() {
	}

	public Empregado(Integer id, String nome, Double salario) {
		this.id = id;
		this.nome = nome;
		this.salario = salario;
	}

	public void ajusteSalario(double percentage) {
		salario += salario * percentage / 100.0;
	}

	public String toString() {
		return id + ", " + nome + ", " + String.format("%.2f", salario);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
}
