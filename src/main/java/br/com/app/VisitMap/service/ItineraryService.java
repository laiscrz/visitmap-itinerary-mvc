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

    // Retorna todos
    public List<Itinerary> findAllItineraries() {
        return iItineraryRepository.findAll();
    }

    // Busca pelo ID
    public Itinerary findByIdItinerary(Long id) {
        return iItineraryRepository.findById(id).orElse(null);
    }

    // Salva ou atualiza
    public Itinerary saveItinerary(Itinerary itinerary) {
        return iItineraryRepository.save(itinerary);
    }

    // Remove pelo ID
    public void deleteByIdItinerary(Long id) {
        iItineraryRepository.deleteById(id);
    }
}
