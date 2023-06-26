package a3.com.br.Service;

import org.springframework.stereotype.Service;

import a3.com.br.Repository.AlunoRepository;

@Service
public class AlunoService {
    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno lancarNota(String nome, double nota) {
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setNota(nota);

        return AlunoRepository.salvar(aluno);
    }

    public void deletarAluno(Long id) {
        alunoRepository.deletar(id);
    }

    public Aluno buscarPorId(Long id) {
        return alunoRepository.buscarPorId(id);
    }

    public int buscarTamanho() {
        return alunoRepository.buscarTamanho();
    }
}