package lk.oop.uno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.oop.uno.model.Comment;
import lk.oop.uno.model.CommentDto;
import lk.oop.uno.service.InCommentServ;

@RestController
@RequestMapping("/api/comment")
@CrossOrigin("http://127.0.0.1:5500")
public class CommentCont {
    
    @Autowired
    InCommentServ iServ;

    @GetMapping
    public String get(){
        return iServ.get_all_comment();
    }

    @GetMapping("/{email}")
    public CommentDto _get(@PathVariable String email){
        return iServ.get_spec_comment(email);
    }

    @PostMapping
    public String post(@RequestBody Comment comment){
        return iServ.add_comment(comment);
    }

    @PutMapping
    public String put(@RequestBody Comment comment){
        return iServ.update_comment(comment);
    }

    @DeleteMapping("/{email}")
    public String delete(@PathVariable String email) {
        return iServ.delete_comment(email);
    }
}
