package com.example.poll.controller;

import com.example.poll.entity.Poll;
import com.example.poll.service.PollService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/poll")
public class PollController {
    private PollService pollService;

    public PollController(PollService pollService) {
        this.pollService = pollService;
    }
    @GetMapping("/list")
    public String listPollAnswers(Model model){

        List<Poll> pollAnswers = pollService.findAll();

        model.addAttribute("answers", pollAnswers);

        return "list-answers";
    }
  @RequestMapping("/save")
    public String savePollAnswers(@ModelAttribute("answers")Poll poll){
        pollService.save(poll);

         return "redirect:/poll/list";
    }
    @RequestMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        Poll poll = new Poll();

        model.addAttribute("answers", poll);

        return "poll-form";
    }
    @RequestMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id")long id, Model model){

        Poll poll = pollService.findById(id);

        model.addAttribute("answers",poll);

        return "poll-form";
    }
    @RequestMapping("/delete")
    public String delete(@RequestParam("id") long id){

        pollService.deleteById(id);

        return "redirect:/poll/list";
    }

}
