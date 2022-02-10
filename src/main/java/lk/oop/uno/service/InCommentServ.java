package lk.oop.uno.service;

import lk.oop.uno.model.Comment;

public interface InCommentServ {
    
    String get_all_comment();

    String get_spec_comment(String email);

    String add_comment(Comment comment);

    String update_comment(Comment comment);

    String delete_comment(String email);

}
