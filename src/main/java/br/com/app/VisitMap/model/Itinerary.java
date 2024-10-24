package br.com.app.VisitMap.model;

import br.com.app.VisitMap.model.enums.TypeCountry;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "itinerary")
public class Itinerary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do itinerário é obrigatório.")
    private String nome;

    @Column(name = "data_criacao", updatable = false)
    private LocalDate dataCriacao;

    @Enumerated(EnumType.STRING)
    private TypeCountry pais;

    @ManyToMany
    @JoinTable(
            name = "itinerary_place",
            joinColumns = @JoinColumn(name = "itinerary_id"),
            inverseJoinColumns = @JoinColumn(name = "place_id")
    )
    @Valid
    @Size(min = 1, message = "É necessário selecionar pelo menos um local")
    private List<Place> places;

    @PrePersist
    protected void onCreate() {
        this.dataCriacao = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Itinerary{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
