

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LembreteDAO {
    public void salvar(Lembrete l) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO lembrete ");
		sql.append("(titulo, msg, status) ");
		sql.append("VALUES (?,?,?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
                comando.setString(1, l.getTitulo());
                comando.setString(2, l.getMsg());
                comando.setBoolean(3, l.isStatus());
		comando.executeUpdate();
	}
	
    public void excluir(Lembrete l) throws SQLException {
	StringBuilder sql = new StringBuilder();
    	sql.append("DELETE FROM lembrete ");
	sql.append("WHERE codigo = ? ");
		
	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());
	comando.setLong(1, l.getId());
	comando.executeUpdate();
    }
	
    public void editar(Lembrete l) throws SQLException {
	StringBuilder sql = new StringBuilder();
	sql.append("UPDATE lembrete ");
	sql.append("SET titulo = ?, msg = ?, status = ? ");
	sql.append("WHERE codigo = ? ");
		
	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());
	comando.setString(1, l.getTitulo());
        comando.setString(2, l.getMsg());
	comando.setBoolean(2, l.isStatus());
	comando.executeUpdate();
    }
    
    public static void main(String[] args) {
        Lembrete f1= new Lembrete();
	f1.setMsg("TESTE");
        f1.setTitulo("TESTE");
        f1.setStatus(true);
		
	LembreteDAO fdao = new LembreteDAO();
	try {
            fdao.salvar(f1);
            System.out.println("Salvo com sucesso!!!");
        } catch (SQLException e) {
            System.out.println("Erro ao salvar!!!");
            e.printStackTrace();
	}
    }
}
