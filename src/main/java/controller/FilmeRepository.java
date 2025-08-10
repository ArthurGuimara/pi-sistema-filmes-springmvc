package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class FilmeRepository {

    @Autowired
    private JdbcTemplate jdbc;

    private RowMapper<Filme> mapper = new RowMapper<Filme>() {
        @Override
        public Filme mapRow(ResultSet rs, int rowNum) throws SQLException {
            Filme f = new Filme();
            f.setId(rs.getInt("id"));
            f.setTitulo(rs.getString("titulo"));
            f.setSinopse(rs.getString("sinopse"));
            f.setGenero(rs.getString("genero"));
            f.setAno(rs.getInt("ano"));
            return f;
        }
    };

    public List<Filme> listar() {
        return jdbc.query("SELECT * FROM filme ORDER BY id DESC", mapper);
    }

    public void inserir(Filme f) {
        jdbc.update("INSERT INTO filme (titulo, sinopse, genero, ano) VALUES (?,?,?,?)",
                f.getTitulo(), f.getSinopse(), f.getGenero(), f.getAno());
    }

    public Filme porId(int id) {
        return jdbc.queryForObject("SELECT * FROM filme WHERE id=?", mapper, id);
    }

    public void atualizar(Filme f) {
        jdbc.update("UPDATE filme SET titulo=?, sinopse=?, genero=?, ano=? WHERE id=?",
                f.getTitulo(), f.getSinopse(), f.getGenero(), f.getAno(), f.getId());
    }

    public void excluir(int id) {
        jdbc.update("DELETE FROM filme WHERE id=?", id);
    }
}
