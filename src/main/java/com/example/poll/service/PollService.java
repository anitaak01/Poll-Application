package com.example.poll.service;

import com.example.poll.dao.PollRepository;
import com.example.poll.entity.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PollService implements Services {
    private PollRepository pollRepository;
    @Autowired
    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    @Override
    public List<Poll> findAll() {
        return pollRepository.findAll();
    }

    @Override
    public Poll findById(long id) {
        Optional<Poll> result = pollRepository.findById(id);

        Poll poll =  null;

        if(result.isPresent()){
            poll = result.get();
        }
        else{
            throw new RuntimeException("Did not find poll id - " + id);
        }

        return poll;
    }

    @Override
    public Poll save(Poll poll) {
        return pollRepository.save(poll);
    }

    @Override
    public void deleteById(long id) {
        pollRepository.deleteById(id);
    }
}
