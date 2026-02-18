package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Boas vindas,Essa é minha primeira mensagem!";
    }

    //Adicionar ninja(CREATE)
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.criarNinja(ninja);
    }

    //Mostrar todos os Ninjas(READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    //Procurar ninja por ID(READ)
     @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable long id) {
        return ninjaService.listarNinjasPorId(id);
    }

    //Alterar dados dos ninjas(UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId() {
        return "Alterar Ninja por Id";
    }

    //Deletar Ninja(DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId() {
        return "Ninja Deletado por Id";
    }



}
