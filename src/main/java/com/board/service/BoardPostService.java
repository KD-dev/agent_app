package com.board.service;

import com.board.entity.BoardPost;
import com.board.entity.User;
import com.board.repository.BoardPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BoardPostService {

    @Autowired
    BoardPostRepository boardPostRepository;

    public List<BoardPost> findAll() {
        return boardPostRepository.findAll();
    }

    public BoardPost findOne(Integer seqNo) {
        return boardPostRepository.findOne(seqNo);
    }

    public BoardPost create(BoardPost boardPost) {
        return boardPostRepository.save(boardPost);
    }

    public BoardPost update(BoardPost boardPost) {
        return boardPostRepository.save(boardPost);
    }

    public void delete(Integer seqNo) {
        boardPostRepository.delete(seqNo);
    }
}
