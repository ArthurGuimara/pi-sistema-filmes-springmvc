package controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FilmeController {

  @Autowired
  private FilmeRepository repo;

  @GetMapping("/filmes")
  public String listar(Model model) {
    List<Filme> filmes = repo.listar();
    model.addAttribute("filmes", filmes);
    return "filmes";
  }

  @GetMapping("/filmes/novo")
  public String novo(Model model) {
    model.addAttribute("filme", new Filme());
    return "filme-form";
  }

  @PostMapping("/filmes")
  public String salvar(@ModelAttribute Filme filme) {
    if (filme.getId() == null) repo.inserir(filme);
    else repo.atualizar(filme);
    return "redirect:/filmes";
  }

  @GetMapping("/filmes/{id}/editar")
  public String editar(@PathVariable int id, Model model) {
    model.addAttribute("filme", repo.porId(id));
    return "filme-form";
  }

  @PostMapping("/filmes/{id}/excluir")
  public String excluir(@PathVariable int id) {
    repo.excluir(id);
    return "redirect:/filmes";
  }
}
