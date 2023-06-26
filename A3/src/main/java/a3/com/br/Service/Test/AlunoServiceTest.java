package a3.com.br.Service.Test;

import a3.com.br.Repository.AlunoRepository;
import a3.com.br.Service.Aluno;
import a3.com.br.Service.AlunoService;

@RunWith(MockitoJUnitRunner.class)
public class AlunoServiceTest {
    @Mock
    private AlunoRepository alunoRepository;

    @InjectMocks
    private AlunoService alunoService;

    @Test
    public void testDeletarAluno() {
        // Dados de teste
        Long id = 1L;

        // Chamar o método a ser testado
        alunoService.deletarAluno(id);

        // Verificar se o método foi chamado corretamente
        verify(alunoRepository).deletar(id);
    }

    @Test
    public void testBuscarPorId() {
        // Dados de teste
        Long id = 1L;
        Aluno alunoEncontrado = new Aluno();
        alunoEncontrado.setId(id);
        alunoEncontrado.setNome("João");
        alunoEncontrado.setNota(9.5);

        // Comportamento esperado do mock
        when(alunoRepository.buscarPorId(id)).thenReturn(alunoEncontrado);

        // Chamar o método a ser testado
        Aluno aluno = alunoService.buscarPorId(id);

        // Verificar se o método foi chamado corretamente e se o resultado é o esperado
        verify(alunoRepository).buscarPorId(id);
        assertEquals(alunoEncontrado, aluno);
    }

    @Test
    public void testBuscarTamanho() {
        // Dados de teste
        int tamanhoEsperado = 10;

        // Comportamento esperado do mock
        when(alunoRepository.buscarTamanho()).thenReturn(tamanhoEsperado);

        // Chamar o método a ser testado
        int tamanho = alunoService.buscarTamanho();

        // Verificar se o método foi chamado corretamente e se o resultado é o esperado
        verify(alunoRepository).buscarTamanho();
        assertEquals(tamanhoEsperado, tamanho);
    }
}