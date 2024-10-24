package br.com.app.VisitMap.service;

import br.com.app.VisitMap.model.Itinerary;
import br.com.app.VisitMap.repository.IItineraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItineraryService {
    @Autowired
    private final IItineraryRepository iItineraryRepository;

    public ItineraryService(IItineraryRepository iItineraryRepository) {
        this.iItineraryRepository = iItineraryRepository;
    }

    // Retorna todas
    public List<Itinerary> findAllItneraries() {
        return iItineraryRepository.findAll();
    }

    // Busca pelo ID
    public Itinerary findByIdPlaylist(Long id) {
        return iItineraryRepository.findById(id).orElse(null);
    }

    // Salva ou atualiza
    public Itinerary savePlaylist(Itinerary itinerary) {
        return iItineraryRepository.save(itinerary);
    }

    // Remove pelo ID
    public void deleteByIdPlaylist(Long id) {
        iItineraryRepository.deleteById(id);
    }
}
