package Entidades;

public class Cliente {
    private int codigo;
    private int categoria;
    private String nome;
    private String telefone;

    public int getCodigo() {
	return codigo;
    }

    public void setCodigo(int codigo) {
	this.codigo = codigo;
    }

    public int getCategoria() {
	return categoria;
    }

    public void setCategoria(int categoria) {
	this.categoria = categoria;
    }

    public String getCategoriaFormatada() {
	if (categoria == 0) {
	    return "Pessoa";
	} else {
	    return "Empresa";
	}
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getTelefone() {
	return telefone;
    }

    public void setTelefone(String telefone) {
	this.telefone = telefone;
    }

	public void setId(int parseInt) {
		// TODO Auto-generated method stub
		
	}

	public void setSenha(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setCliente(String string) {
		// TODO Auto-generated method stub
		
	}

}
