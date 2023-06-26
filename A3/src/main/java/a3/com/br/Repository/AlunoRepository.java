package a3.com.br.Repository;

import a3.com.br.Service.Aluno;

public interface AlunoRepository {
    Aluno salvar(Aluno aluno);
    void deletar(Long id);
    Aluno buscarPorId(Long id);
    int buscarTamanho();
}