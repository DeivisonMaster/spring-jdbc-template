package br.com.jdbctemplate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import br.com.jdbctemplate.model.Usuario;

@Component
public class UsuarioDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Usuario> listar(){
		return jdbcTemplate.query("select * from usuario", 
				(rs, row) -> new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("email")));
	}
	
	public Usuario buscaPorId(Integer id) {
		return jdbcTemplate.queryForObject("select * from usuario where id = ? ", new Object[] {id},
				(rs, row) -> new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("email")));
	}
	
}
