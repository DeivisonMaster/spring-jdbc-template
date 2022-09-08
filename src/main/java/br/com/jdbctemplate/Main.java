package br.com.jdbctemplate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.jdbctemplate.dao.UsuarioDAO;

public class Main {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(Main.class.getPackage().getName());
		
		UsuarioDAO dao = context.getBean(UsuarioDAO.class);
		dao.listar().forEach(u -> System.out.println(u));
		
		System.out.println("Buscar: " + dao.buscaPorId(4));
	}
}
