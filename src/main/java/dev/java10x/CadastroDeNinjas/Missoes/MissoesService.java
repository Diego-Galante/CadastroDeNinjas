package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // Criar Missao
    public MissoesModel criarMissao(MissoesModel missoesModel){
        return missoesRepository.save(missoesModel);
    }

    // Listar todas as missoes
    public List<MissoesModel> listarMissao(){
        return missoesRepository.findAll();
    }

    // Listar missoes por id
    public MissoesModel listarMissaoPorId(Long id){
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.orElse(null);
    }


    // Alterar missoes


    // Deletar missoes
    public void deletarMissaoPorId(Long id){
        missoesRepository.deleteById(id);
    }
}
