package a3.com.br.Service;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Aluno {
    private Long id;
    private String nome;
    private double nota;

}
