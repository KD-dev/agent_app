package com.board.controller;

import com.board.entity.BoardPost;
import com.board.service.BoardPostService;
import com.sun.tools.javac.code.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.type.ErrorType;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Kyudong on 2017. 10. 30..
 */

@RestController
@RequestMapping(path = "/board")
public class BoardController {

    @Autowired
    BoardPostService boardPostService;


    @GetMapping
    public String list(Model model) {
        List<BoardPost> boardPosts = boardPostService.findAll();
        model.addAttribute("boardPosts", boardPosts);
        return "/board/list";
    }

    // 전체 게시판 글 가져오기 //
    @GetMapping(path = "/list")
    public List<BoardPost> showList(Model model) {
        List<BoardPost> boardPosts = boardPostService.findAll();
        return boardPosts;
    }

    // seqNo에 해당하는 게시글 가져오기 //
    @GetMapping(path = "/{seqNo}")
    public ResponseEntity<?> getBoard(@PathVariable("seqNo") int seqNo) {
        BoardPost findSeqNo = boardPostService.findOne(seqNo);
        if(findSeqNo == null) {
            return new ResponseEntity("no seqNo found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BoardPost>(findSeqNo, HttpStatus.OK);
    }

    // 게시판 글쓰기 //
    @PostMapping(path = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@Valid @RequestBody BoardPost boardPost, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return list(model);
        }

        boardPostService.create(boardPost);
        return "redirect:/board";
    }

    // seqNo에 해당하는 게시글 수정하기 //
    @PostMapping(path = "/edit/{seqNo}")
    public String update(@PathVariable("seqNo") int seqNo, @RequestBody BoardPost boardPost) {
        BoardPost getBoard = boardPostService.findOne(seqNo);
        if(getBoard == null) {
            return "No seqNo Found!!";
        }

        getBoard.setTitle(boardPost.getTitle());
        getBoard.setContent(boardPost.getContent());
        getBoard.setHit_count(boardPost.getHit_count());
        getBoard.setRegDate(boardPost.getRegDate());
        getBoard.setUpdateDate(boardPost.getUpdateDate());

        boardPostService.update(getBoard);

        return "redirect:/board";
    }

    // seqNo에 해당하는 게시글 삭제 //
    @DeleteMapping(path = "/{seqNo}")
    public String deleteBoard(@PathVariable("seqNo") int seqNo) {
        BoardPost findBoard = boardPostService.findOne(seqNo);

        if (findBoard == null) {
            return "Unable to delete. seqNo not found.";
        }

        boardPostService.delete(seqNo);

        return "redirect:/board";
    }

}
