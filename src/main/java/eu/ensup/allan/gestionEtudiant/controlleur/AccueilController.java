package eu.ensup.allan.gestionEtudiant.controlleur;

import eu.ensup.allan.gestionEtudiant.domaine.Etudiant;
import eu.ensup.allan.gestionEtudiant.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/index")
public class AccueilController {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @RequestMapping(value = "/list", method= RequestMethod.GET)
    public String listOfGlasses(Model model){
        List<Etudiant> listEtudiants = etudiantRepository.findAll();
        model.addAttribute("listEtudiants", listEtudiants);
        return "list";
    }

    @GetMapping("/formulaire")
    public String viewGlasses(Model model) {
        model.addAttribute("etudiant", new Etudiant());
        return "formulaire";
    }

    @PostMapping("/index/save")
    public String saveEtudiant(@ModelAttribute Etudiant etudiant) {
        etudiantRepository.save(etudiant);
        return "redirect:/index/list";
    }


}
