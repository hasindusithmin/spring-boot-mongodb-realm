package lk.oop.uno.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lk.oop.uno.model.Comment;
import lk.oop.uno.model.CommentDto;

@Service
public class CommentServ implements InCommentServ{
    
    @Autowired
    RestTemplate restTemplate;

    // Use HttpHeaders to set the Request Headers.
    HttpHeaders httpHeaders = new HttpHeaders();
    // Use HttpEntity to wrap the request object.
    HttpEntity<String> httpEntity;
    HttpEntity<Comment> _httpEntity;

    public CommentServ() {
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpEntity = new HttpEntity<String>(httpHeaders);
    }

    @Override
    public String get_all_comment(){
        String URL = String.format("https://data.mongodb-api.com/app/your-app-name/endpoint/comment?method=%s", "get");
        return restTemplate.exchange(URL, HttpMethod.GET,httpEntity,String.class).getBody();
    }
    @Override
    public CommentDto get_spec_comment(String email){
        String URL = String.format("https://data.mongodb-api.com/app/your-app-name/endpoint/comment?method=%s&email=%s", "get",email);
        return restTemplate.exchange(URL, HttpMethod.GET, httpEntity, CommentDto.class).getBody();
    }
    @Override
    public String add_comment(Comment comment){
        String URL = String.format("https://data.mongodb-api.com/app/your-app-name/endpoint/comment?method=%s", "post");
        _httpEntity = new HttpEntity<Comment>(comment,httpHeaders);
        return restTemplate.exchange(URL, HttpMethod.POST, _httpEntity, String.class).getBody();
    }
    @Override
    public String update_comment(Comment comment){
        String URL = String.format("https://data.mongodb-api.com/app/your-app-name/endpoint/comment?method=%s", "put");
        _httpEntity = new HttpEntity<Comment>(comment,httpHeaders);
        return restTemplate.exchange(URL, HttpMethod.PUT, _httpEntity, String.class).getBody();
    }
    @Override
    public String delete_comment(String email){
        String URL = String.format("https://data.mongodb-api.com/app/your-app-name/endpoint/comment?method=%s&email=%s", "delete",email);
        return restTemplate.exchange(URL, HttpMethod.DELETE, httpEntity, String.class).getBody();
    }

}
