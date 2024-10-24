package br.com.app.VisitMap.service;

import br.com.app.VisitMap.model.Place;
import br.com.app.VisitMap.repository.IPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {

    @Autowired
    private final IPlaceRepository placeRepository;

    public PlaceService(IPlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    // Retorna todas as músicas
    public List<Place> findAllPlaces() {
        return placeRepository.findAll();
    }

    // Busca uma lugar pelo ID
    public Place findByIdPlace(Long id) {
        return placeRepository.findById(id).orElse(null);
    }

    // Cria ou atualiza uma lugar
    public void savePlace(Place place) {
        placeRepository.save(place);
    }

    // Remove uma lugar pelo ID
    public void deleteByIdPlace(Long id) {
        Place place = findByIdPlace(id);
        if (place != null && (place.getItineraries() != null && !place.getItineraries().isEmpty())) {
            throw new RuntimeException("O ponto turístico está associado a um itinerário. Remova-o do itinerário antes de tentar excluí-lo.");
        }
        placeRepository.deleteById(id);
    }
}
