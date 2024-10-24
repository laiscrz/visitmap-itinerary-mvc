package br.com.app.VisitMap.model;

import br.com.app.VisitMap.model.enums.TypeEntry;
import br.com.app.VisitMap.model.enums.TypePlace;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "place")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da atração é obrigatório.")
    private String nome;

    @NotBlank(message = "A descrição é obrigatória.")
    private String descricao;

    @NotBlank(message = "A cidade é obrigatória.")
    private String cidade;

    @NotBlank(message = "O estado é obrigatório.")
    private String estado;

    @NotBlank(message = "A rua é obrigatória.")
    private String rua;

    @Enumerated(EnumType.STRING)
    private TypePlace tipo;

    @Size(max = 500, message = "A descrição não pode ter mais de 500 caracteres.")
    private String description;

    @Enumerated(EnumType.STRING)
    private TypeEntry entrada;

    private String urlImagem; 

    @ManyToMany(mappedBy = "places")
    @Valid
    private List<Itinerary> itineraries;
}
