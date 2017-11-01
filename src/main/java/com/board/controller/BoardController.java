package com.board.controller;

import com.board.entity.BoardPost;
import com.board.service.BoardPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Kyudong on 2017. 10. 30..
 */

@RestController
public class BoardController {

    @Autowired
    BoardPostService boardPostService;

    @GetMapping
    public String list(Model model) {
        List<BoardPost> boardPosts = boardPostService.findAll();
        model.addAttribute("boardPosts", boardPosts);
        return "/board/list";
    }

    @GetMapping(path = "/board/list")
    public List<BoardPost> showList(Model model) {
        List<BoardPost> boardPosts = boardPostService.findAll();
        return boardPosts;
    }

    @PostMapping(path = "/board/create")
    public String create(@Validated BoardPost boardPost, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return list(model);
        }

        BoardPost boardPost1 = new BoardPost();
        boardPostService.create(boardPost1);
        return "redirect:/board";
    }
}
