package br.com.app.VisitMap.service;

import br.com.app.VisitMap.model.Itinerary;
import br.com.app.VisitMap.model.Place;
import br.com.app.VisitMap.repository.IPlaceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlaceServiceTest {

    @InjectMocks
    private PlaceService placeService;

    @Mock
    private IPlaceRepository placeRepository;


    @Test
    void testFindAllPlaces_Success() {
        // Arrange
        List<Place> places = new ArrayList<>();
        places.add(new Place());
        when(placeRepository.findAll()).thenReturn(places);

        // Act
        List<Place> result = placeService.findAllPlaces();

        // Assert
        assertEquals(1, result.size());
        verify(placeRepository, times(1)).findAll();
    }

    @Test
    void testFindByIdPlace_Success() {
        // Arrange
        Place place = new Place();
        when(placeRepository.findById(anyLong())).thenReturn(Optional.of(place));

        // Act
        Place result = placeService.findByIdPlace(1L);

        // Assert
        assertNotNull(result);
        verify(placeRepository, times(1)).findById(1L);
    }

    @Test
    void testFindByIdPlace_Failure() {
        // Arrange
        when(placeRepository.findById(anyLong())).thenReturn(Optional.empty());

        // Act
        Place result = placeService.findByIdPlace(1L);

        // Assert
        assertNull(result);
        verify(placeRepository, times(1)).findById(1L);
    }

    @Test
    void testSavePlace_Success() {
        // Arrange
        Place place = new Place();

        // Act
        placeService.savePlace(place);

        // Assert
        verify(placeRepository, times(1)).save(place);
    }

    @Test
    void testDeleteByIdPlace_Success() {
        // Arrange
        Place place = new Place();
        place.setItineraries(new ArrayList<>());
        when(placeRepository.findById(anyLong())).thenReturn(Optional.of(place));

        // Act
        placeService.deleteByIdPlace(1L);

        // Assert
        verify(placeRepository, times(1)).deleteById(1L);
    }

    @Test
    void testDeleteByIdPlace_Failure() {
        // Arrange
        Place place = new Place();
        List<Itinerary> itineraries = new ArrayList<>();
        itineraries.add(new Itinerary());
        place.setItineraries(itineraries);
        when(placeRepository.findById(anyLong())).thenReturn(Optional.of(place));

        // Act & Assert
        Exception exception = assertThrows(RuntimeException.class, () -> {
            placeService.deleteByIdPlace(1L);
        });

        assertEquals("O ponto turístico está associado a um itinerário. Remova-o do itinerário antes de tentar excluí-lo.", exception.getMessage());
        verify(placeRepository, never()).deleteById(anyLong());
    }

}

