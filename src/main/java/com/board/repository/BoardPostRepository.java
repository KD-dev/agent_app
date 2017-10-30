package com.board.repository;

import com.board.entity.BoardPost;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Kyudong on 2017. 10. 30..
 */
public interface BoardPostRepository extends JpaRepository<BoardPost, Integer>{

}
