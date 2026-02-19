package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaRepository ninjaRepository;
    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService, NinjaRepository ninjaRepository) {
        this.ninjaService = ninjaService;
        this.ninjaRepository = ninjaRepository;
    }

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Boas vindas,Essa é minha primeira mensagem!";
    }

    //Adicionar ninja(CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + ninjaDTO.getNome() + " (ID): " + ninjaDTO.getId());
    }

    //Mostrar todos os Ninjas(READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //Procurar ninja por ID(READ)
     @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable long id) {
        if(ninjaService.listarNinjasPorId(id) != null) {
        NinjaDTO ninjaDTO = ninjaService.listarNinjasPorId(id);
            return ResponseEntity.ok(ninjaDTO);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID " + id + " não foi encontrado!");
        }
    }

    //Alterar dados dos ninjas(UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjaPorId(@PathVariable long id,@RequestBody NinjaDTO ninjaAtualizado) {
         NinjaDTO ninjaDTO = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninjaService.listarNinjasPorId(id) != null) {
        return ResponseEntity.ok(ninjaDTO);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID " + id + " não foi encontrado");
        }
    }

    //Deletar Ninja(DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable long id) {
        if(ninjaService.listarNinjasPorId(id) != null) {
           ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com o ID " + id + " deletado com sucesso!");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("o Ninja com o ID " + id + " não foi encontrado!");
        }
        }

}
