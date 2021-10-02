package com.pawelkorniak.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class FacadeController {

    private final ComnatRepository comnatRepository;

    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("comnats",comnatRepository.comnats);
        return "index";
    }

    @GetMapping("comnat/{name}")
    public String comnat(Model model, @PathVariable String name) {
        Comnat comnat = comnatRepository.findByName(name);
        model.addAttribute("comnatName",comnat.name);
        model.addAttribute("messages",comnat.messages);
        model.addAttribute("message",new Message());
        return "comnat";
    }

    @PostMapping("sendMessage/{comnatName}")
    public String sendMessage(Message message,@PathVariable String comnatName){
        Comnat comnat = comnatRepository.findByName(comnatName);
        comnat.add(message);
        return "redirect:/comnat/" + comnatName;
    }

}
