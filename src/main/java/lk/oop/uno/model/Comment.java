package lk.oop.uno.model;

import org.springframework.stereotype.Component;

@Component
public class Comment {
    
    private String name;
    private String email;
    private String body;
    @Override
    public String toString() {
        return "CommentClient [body=" + body + ", email=" + email + ", name=" + name + "]";
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
