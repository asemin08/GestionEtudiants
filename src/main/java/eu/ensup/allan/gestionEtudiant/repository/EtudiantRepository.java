package eu.ensup.allan.gestionEtudiant.repository;

import eu.ensup.allan.gestionEtudiant.domaine.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    public List<Etudiant> findAllBy();
}
