package com.pawelkorniak.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class FacadeController {

    private final ComnatRepository comnatRepository;

    @GetMapping("index")
    public String index(Model model,@AuthenticationPrincipal ComnatUser principal){
        model.addAttribute("comnats",comnatRepository.comnats);
        model.addAttribute("principal",principal);

        return "index";
    }

    @GetMapping("comnat/{name}")
    public String comnat(Model model, @PathVariable String name, @AuthenticationPrincipal ComnatUser principal) {
        Comnat comnat = comnatRepository.findByName(name);
        model.addAttribute("comnatName",comnat.name);
        model.addAttribute("messages",comnat.messages);
        model.addAttribute("principal",principal);
        model.addAttribute("newMessage",new Message());
        return "comnat";
    }

    @PostMapping("sendMessage/{comnatName}")
    public String sendMessage(Message message,@PathVariable String comnatName,@AuthenticationPrincipal ComnatUser principal){
        Comnat comnat = comnatRepository.findByName(comnatName);
        message.setLocalDateTime();
        message.setAuthor(principal);
        comnat.add(message);
        return "redirect:/comnat/" + comnatName;
    }

}
