package com.example.poll.service;

import com.example.poll.entity.Poll;

import java.util.List;

public interface Services {
    List<Poll> findAll();

    Poll findById(long id);

    Poll save(Poll poll);

    void deleteById(long id);
}
