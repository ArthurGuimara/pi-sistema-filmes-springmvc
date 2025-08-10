package controller;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class FilmeRepositoryTest {

  @Test
  public void deveListarSemErro() {
    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
    ds.setUrl("jdbc:mysql://localhost:3306/cenaflix?useSSL=false&serverTimezone=UTC");
    ds.setUsername("root");
    ds.setPassword("root");

    FilmeRepository repo = new FilmeRepository();
    repo.getClass(); // só pra evitar warning
    // injetar template “na unha”
    try {
      java.lang.reflect.Field f = FilmeRepository.class.getDeclaredField("jdbc");
      f.setAccessible(true);
      f.set(repo, new JdbcTemplate(ds));
    } catch (Exception e) { fail(e.getMessage()); }

    List<Filme> lista = repo.listar();
    assertNotNull(lista);
  }
}
