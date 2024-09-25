package tn.esprit.firstproject.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bloc implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idBloc;

    private String nomBloc;

    private Long capaciteBloc;

    @OneToMany(mappedBy = "bloc")
    @JsonBackReference
    private List<Chambre> chambres;

    @ManyToOne
    @JsonIgnore
    private Foyer foyer;
}
