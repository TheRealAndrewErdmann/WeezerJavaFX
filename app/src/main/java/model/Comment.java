
import java.util.ArrayList;

public class Comment {
    private String author;
    private String comment;
    private ArrayList<Comment> replies;

    public Comment (String author, String comment) {
        this.author = author;
        this.comment = comment;
    }

    public boolean updateComment(String comment) {
        if(comment == null)
            return false;
        this.comment = comment;
        return true;
    }

    public boolean replyToComment(Comment reply) {
        if(reply == null)
            return false;
        return replies.add(reply);
    }
    
    public String getComment() {
        return comment;
    }

    public String getAuthor() {
        return author;
    }

}
