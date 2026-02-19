package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

   private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // Criar Missao
    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missoesModel){
        return missoesService.criarMissao(missoesModel);
    }

    // Listar todas as missoes
    @GetMapping("/listar")
    public List<MissoesModel> listarMissao(){
        return missoesService.listarMissao();
    }


    // Listar missoes por id
    @GetMapping("/listar/{id}")
    public MissoesModel listarMissaoPorId(@PathVariable Long id){
        return missoesService.listarMissaoPorId(id);
    }

    // Alterar missoes

    // Deletar missoes
    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoPorId(@PathVariable Long id){
        missoesService.deletarMissaoPorId(id);
    }
}
