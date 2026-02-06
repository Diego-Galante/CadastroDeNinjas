package dev.java10x.CadastroDeNinjas.Ninjas;
import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//Transforma uma classe em um banco de dados
@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data //getters and setters
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private int idade;

    //@ManyToOne um ninja tem uma unica missao
    @ManyToOne
    @JoinColumn(name = "missoes_id") //Foreign key
    private MissoesModel missoes;

}
