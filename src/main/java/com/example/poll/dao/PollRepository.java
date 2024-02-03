package com.example.poll.dao;
import com.example.poll.entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PollRepository extends JpaRepository<Poll, Long> {
    public List<Poll> findAllByOrderByLastName();
}
