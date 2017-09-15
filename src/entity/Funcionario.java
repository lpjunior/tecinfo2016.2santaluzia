package entity;

import java.io.Serializable;

public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nmFunc;
	private String email;
	private String login;
	private String senha;

	public Funcionario() {

	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nmFunc=" + nmFunc + ", email=" + email + ", login=" + login + ", senha="
				+ senha + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNmFunc() {
		return nmFunc;
	}

	public void setNmFunc(String nmFunc) {
		this.nmFunc = nmFunc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (email == null) {
			return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

}
