package eu.ensup.allan.gestionEtudiant.domaine;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Etudiant extends Personne{
    private String dateAnniversaire;
}
