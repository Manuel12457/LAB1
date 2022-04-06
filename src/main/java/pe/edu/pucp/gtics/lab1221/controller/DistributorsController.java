package pe.edu.pucp.gtics.lab1221.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.pucp.gtics.lab1221.entity.Distributors;
import pe.edu.pucp.gtics.lab1221.repository.DistributorsRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/distributors")
public class DistributorsController {

    @Autowired
    DistributorsRepository distributorsRepository;

    public String listaDistribuidoras(Model model) {
        List<Distributors> distribuidorasList = distributorsRepository.findAll();
        model.addAttribute("distribuidorasList", distribuidorasList);
        return "distribuidoras/lista";
    }



    public String editarDistribuidoras(Model model){
            Optional<Distributors> optionalDistribuidoras = distributorsRepository.findById(id);
            if(optionalDistribuidoras.isPresent()){
                Distributors distribuidoras = optionalDistribuidoras.get();
                model.addAttribute("distribuidoras",distribuidoras);
                return "distribuidoras/editar";
            }else {
                return "redirect:/distribuidoras/lista";
            }
    };

    public String nuevaDistribuidora(){
        return "distribuidoras/lista";
    };

    public String guardarDistribuidora(Distributors distributors){
        distributorsRepository.save(distributors);
            return "redirect:/distribuidoras/lista";
    };

    public String borrarDistribuidora(){
            Optional<Distributors> optionalDistribuidoras = distributorsRepository.findById(id);
            if(optionalDistribuidoras.isPresent()){
                distributorsRepository.deleteById(id);
            }
            return "redirect:/distribuidoras/lista";
    };

}
