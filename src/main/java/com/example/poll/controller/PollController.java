package com.example.poll.controller;

import com.example.poll.entity.Poll;
import com.example.poll.service.PollService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
