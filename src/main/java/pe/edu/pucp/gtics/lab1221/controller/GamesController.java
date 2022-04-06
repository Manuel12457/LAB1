package pe.edu.pucp.gtics.lab1221.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.pucp.gtics.lab1221.entity.Games;
import pe.edu.pucp.gtics.lab1221.entity.Platforms;
import pe.edu.pucp.gtics.lab1221.repository.GamesRepository;
import pe.edu.pucp.gtics.lab1221.repository.PlatformsRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/juegos", method = RequestMethod.GET)
public class GamesController {

    @Autowired
    GamesRepository gamesRepository;
    @Autowired
    PlatformsRepository platformsRepository;

    @GetMapping("/lista")
    public String listaJuegos (Model model){

        List<Games> listaJuegos = gamesRepository.findAll(Sort.by("precio"));
        model.addAttribute("listaJuegos", listaJuegos);
        return "/juegos/lista";
    };

    @GetMapping("/editar")
    public String editarJuegos(@RequestParam("id") Integer id, Model model){

        Optional<Games> optionalGames = gamesRepository.findById(id);
        if (optionalGames.isPresent()) {

            Games juego = optionalGames.get();
            model.addAttribute("juego", juego);

            List<Platforms> listaPlataformas = platformsRepository.findAll();
            model.addAttribute("listaPlataformas", listaPlataformas);

            return "juegos/editar";
        } else {
            return "redirect:/juegos/lista";
        }
    };

    @PostMapping("/guardar")
    public String guardarJuegos(Games juego){

        gamesRepository.save(juego);
        return "redirect:/juegos/lista";
    };

}
