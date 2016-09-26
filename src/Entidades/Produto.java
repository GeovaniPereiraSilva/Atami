// Pacotes

package Entidades;

public class Produto {

// Declarando Variaveis
	private int codigo;
	private int categoria;
	private String nome;
	private String descricao;
	
	public int getCategoria() {
		return categoria;
	}

// Método que de um valor STRING tranforma para guardar registros 
// no Banco de dados em um valor INTEIRO
	
	public String getCategoriaFormatada() {
		if (categoria == 0) {
			return "Informática";
		} else if (categoria == 1) {
			return "Eletrônica";
		} else if (categoria == 2) {
			return "Imóvel";	
		} else {
			return "Outros";
		}
	}
	
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setId(int i) {
		// TODO Auto-generated method stub
		
	}

	public void setSenha(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setProduto(String string) {
		// TODO Auto-generated method stub
		
	}
}