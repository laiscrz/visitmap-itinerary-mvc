package br.com.app.VisitMap.service;

import br.com.app.VisitMap.model.Itinerary;
import br.com.app.VisitMap.repository.IItineraryRepository;
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
class ItineraryServiceTest {

    @InjectMocks
    private ItineraryService itineraryService;

    @Mock
    private IItineraryRepository iItineraryRepository;

    @Test
    void testFindAllItineraries_Success() {
        // Arrange
        List<Itinerary> itineraries = new ArrayList<>();
        itineraries.add(new Itinerary());
        when(iItineraryRepository.findAll()).thenReturn(itineraries);

        // Act
        List<Itinerary> result = itineraryService.findAllItineraries();

        // Assert
        assertEquals(1, result.size());
        verify(iItineraryRepository, times(1)).findAll();
    }

    @Test
    void testFindByIdItinerary_Success() {
        // Arrange
        Itinerary itinerary = new Itinerary();
        when(iItineraryRepository.findById(anyLong())).thenReturn(Optional.of(itinerary));

        // Act
        Itinerary result = itineraryService.findByIdItinerary(1L);

        // Assert
        assertNotNull(result);
        verify(iItineraryRepository, times(1)).findById(1L);
    }

    @Test
    void testFindByIdItinerary_Failure() {
        // Arrange
        when(iItineraryRepository.findById(anyLong())).thenReturn(Optional.empty());

        // Act
        Itinerary result = itineraryService.findByIdItinerary(1L);

        // Assert
        assertNull(result);
        verify(iItineraryRepository, times(1)).findById(1L);
    }

    @Test
    void testSaveItinerary_Success() {
        // Arrange
        Itinerary itinerary = new Itinerary();

        // Act
        itineraryService.saveItinerary(itinerary);

        // Assert
        verify(iItineraryRepository, times(1)).save(itinerary);
    }

    @Test
    void testDeleteByIdItinerary_Success() {
        // Arrange
        Long id = 1L;

        // Act
        itineraryService.deleteByIdItinerary(id);

        // Assert
        verify(iItineraryRepository, times(1)).deleteById(id);
    }
}

