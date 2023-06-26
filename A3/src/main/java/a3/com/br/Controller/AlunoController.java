package a3.com.br.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import a3.com.br.Service.Aluno;
import a3.com.br.Service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping("/lancar-nota")
    public ResponseEntity<Aluno> lancarNota(@RequestParam String nome, @RequestParam double nota) {
        Aluno aluno = alunoService.lancarNota(nome, nota);
        return ResponseEntity.ok(aluno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id) {
        alunoService.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
        Aluno aluno = alunoService.buscarPorId(id);
        if (aluno != null) {
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/tamanho")
    public ResponseEntity<Integer> buscarTamanho() {
        int tamanho = alunoService.buscarTamanho();
        return ResponseEntity.ok(tamanho);
    }
}
