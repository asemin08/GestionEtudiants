package eu.ensup.allan.gestionEtudiant.domaine;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String adresseMail;
    private String adresse;
    private String telephone;
    private String nom;
}