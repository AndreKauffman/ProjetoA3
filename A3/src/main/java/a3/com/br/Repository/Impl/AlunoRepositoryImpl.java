package a3.com.br.Repository.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import a3.com.br.Repository.AlunoRepository;
import a3.com.br.Service.Aluno;

@Repository
public class AlunoRepositoryImpl implements AlunoRepository {
    private Map<Long, Aluno> alunos = new HashMap<>();
    private Long nextId = 1L;

    @Override
    public Aluno salvar(Aluno aluno) {
        if (aluno.getId() == null) {
            aluno.setId(nextId);
            nextId++;
        }
        alunos.put(aluno.getId(), aluno);
        return aluno;
    }

    @Override
    public void deletar(Long id) {
        alunos.remove(id);
    }

    @Override
    public Aluno buscarPorId(Long id) {
        return alunos.get(id);
    }

    @Override
    public int buscarTamanho() {
        return alunos.size();
    }
}
