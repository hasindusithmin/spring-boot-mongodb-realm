package lk.oop.uno.model;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CommentDto {
    
    private Map<String,String> _id;
    private String name;
    private String email;
    private String body;
    @Override
    public String toString() {
        return "CommentDto [_id=" + _id + ", body=" + body + ", email=" + email + ", name=" + name + "]";
    }
    public Map<String, String> get_id() {
        return _id;
    }
    public void set_id(Map<String, String> _id) {
        this._id = _id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    
}
