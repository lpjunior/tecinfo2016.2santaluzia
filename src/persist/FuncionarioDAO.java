package persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Funcionario;

public class FuncionarioDAO extends ConnectionDAO {

	private Connection conn = null;

	public FuncionarioDAO() {
		try {
			conn = getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void save(Funcionario f) throws SQLException {

		PreparedStatement stmt = null;
		try {
			if (f.getId() == null) {
				stmt = conn.prepareStatement(
						"insert into funcionario (nmFunc, email, login, senha) VALUES (?, ?, ?, md5(?))",
						Statement.RETURN_GENERATED_KEYS);
			} else {
				stmt = conn.prepareStatement(
						"update funcionario set nmFunc = ?, email = ?, login = ? where id = ?");
			}
			stmt.setString(1, f.getNmFunc());
			stmt.setString(2, f.getEmail());
			stmt.setString(3, f.getLogin());

			if (f.getId() != null) {
				// Update
				stmt.setLong(4, f.getId());
			}

			int count = stmt.executeUpdate();

			if (count == 0) {
				throw new SQLException("Erro ao inserir o funcionario");
			}
			// Se inseriu, ler o id auto incremento
			if (f.getId() == null) {
				Long id = getGeneratedId(stmt);
				f.setId(id);
			}
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

	public Funcionario getFuncionarioById(Long id) throws SQLException {

		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement("select * from funcionario where id = ?");

			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery(); // executeQuery() retorna uma consulta do banco
			if (rs.next()) { // rs.next verifica se a busca restornou algum resultado
				Funcionario f = createFuncionario(rs);
				rs.close();
				return f;
			}
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return null;
	}

	public List<Funcionario> findByName(String name) throws SQLException {

		List<Funcionario> funcionarios = new ArrayList<Funcionario>();

		PreparedStatement stmt = null;

		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select * from funcionario where lower(nmFunc) like ?");

			stmt.setString(1, "%" + name.toLowerCase() + "%");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Funcionario f = createFuncionario(rs);
				funcionarios.add(f);
			}

			rs.close();

		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return funcionarios;
	}

	public List<Funcionario> getFuncionarios() throws SQLException {

		List<Funcionario> funcionarios = new ArrayList<Funcionario>();

		PreparedStatement stmt = null;

		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select * from funcionario");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Funcionario f = createFuncionario(rs);
				funcionarios.add(f);
			}
			rs.close();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return funcionarios;
	}

	public boolean delete(Long id) throws SQLException {

		PreparedStatement stmt = null;

		try {
			conn = getConnection();
			stmt = conn.prepareStatement("delete from funcionario where id = ?");
			stmt.setLong(1, id);
			int count = stmt.executeUpdate();
			boolean ok = count > 0;
			return ok;
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

	// id gerado com o campo auto incremento
	public static Long getGeneratedId(Statement stmt) throws SQLException {

		ResultSet rs = stmt.getGeneratedKeys();

		if (rs.next()) {
			Long id = rs.getLong(1);
			return id;
		}

		return 0L;
	}

	public Funcionario createFuncionario(ResultSet rs) throws SQLException {

		Funcionario f = new Funcionario();

		f.setId(rs.getLong(1));
		f.setNmFunc(rs.getString(2));
		f.setEmail(rs.getString(3));
		f.setLogin(rs.getString(4));
		f.setSenha(rs.getString(5));

		return f;
	}
}
