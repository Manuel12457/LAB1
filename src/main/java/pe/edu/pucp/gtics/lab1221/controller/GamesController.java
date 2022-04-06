package pe.edu.pucp.gtics.lab1221.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.edu.pucp.gtics.lab1221.entity.Games;
import pe.edu.pucp.gtics.lab1221.repository.GamesRepository;

import java.util.List;

@Controller
@RequestMapping(value = "/juegos", method = RequestMethod.GET)
public class GamesController {

    @Autowired
    GamesRepository gamesRepository;

    @GetMapping(" ")
    public String listaJuegos (Model model){

        List<Games> listaJuegos = gamesRepository.findAll(Sort.by("precio"));
        model.addAttribute("listaJuegos", listaJuegos);
        return "/juegos/lista";
    };

    public String editarJuegos(){
        return "";
    };

    public String guardarJuegos(){
        return "";
    };

}
