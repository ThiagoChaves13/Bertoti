package api.roupa.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import api.roupa.models.Roupa;
import api.roupa.repositories.RoupaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoupaService {

    final RoupaRepository roupaRepository;

    public RoupaService(RoupaRepository roupaRepository) {
        this.roupaRepository = roupaRepository;
    }

    @Transactional
    public Roupa save(Roupa roupa) {
        return roupaRepository.save(roupa);
    }


    public List<Roupa> findAll() {
        return roupaRepository.findAll();
    }

    public Optional<Roupa> findById(UUID id) {
        return roupaRepository.findById(id);
    }

    @Transactional
    public void delete(Roupa roupa) {
        roupaRepository.delete(roupa);
    }


}
