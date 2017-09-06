package persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Produto;

public class ProdutoDAO extends ConnectionDAO {

	public void save(Produto p) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			if (p.getId() == null) {
				stmt = conn.prepareStatement(
						"insert into produto (nmProduto, descProduto, preco, quantidade) VALUES (?, ?, ?, ?)",
						Statement.RETURN_GENERATED_KEYS);
			} else {
				stmt = conn.prepareStatement(
						"update produto set nmProduto = ?, descProduto = ?, preco = ?, quantidade = ? where id = ?");
			}
			stmt.setString(1, p.getNmProduto());
			stmt.setString(2, p.getDescProduto());
			stmt.setDouble(3, p.getPreco());
			stmt.setInt(4, p.getQuantidade());

			if (p.getId() != null) {
				// Update
				stmt.setLong(5, p.getId());
			}

			int count = stmt.executeUpdate();

			if (count == 0) {
				throw new SQLException("Erro ao inserir o produto");
			}
			// Se inseriu, ler o id auto incremento
			if (p.getId() == null) {
				Long id = getGeneratedId(stmt);
				p.setId(id);
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

	public Produto createProduto(ResultSet rs) throws SQLException {
		Produto p = new Produto();
		
		p.setId(rs.getLong("id"));
		p.setNmProduto(rs.getString("nmProduto"));
		p.setDescProduto(rs.getString("descProduto"));
		p.setPreco(rs.getDouble("preco"));
		p.setQuantidade(rs.getInt("quantidade"));
		
		return p;
	}

	public Produto getProdutoById(Long id) throws SQLException {

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select * from produto where id = ?");

			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Produto p = createProduto(rs);
				rs.close();
				return p;
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

	public List<Produto> findByName(String name) throws SQLException {

		List<Produto> produtos = new ArrayList<Produto>();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select * from produto where lower(nome) like ?");

			stmt.setString(1, "%" + name.toLowerCase() + "%");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Produto p = createProduto(rs);
				produtos.add(p);
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
		return produtos;
	}

	public List<Produto> findByTipo(String tipo) throws SQLException {
		
		List<Produto> produtos = new ArrayList<Produto>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select * from produto where tipo = ?");
			stmt.setString(1, tipo);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Produto p = createProduto(rs);
				produtos.add(p);
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
		return produtos;
	}

	public List<Produto> getProdutos() throws SQLException {
		
		List<Produto> produtos = new ArrayList<Produto>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select * from produto");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Produto p = createProduto(rs);
				produtos.add(p);
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
		return produtos;
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

	public boolean delete(Long id) throws SQLException {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("delete from produto where id = ?");
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
}
