package net.comments.objects;

public interface CommentManager {
    void refresh();
    void save();
    void saveAndReturn(String number, String text, String state, String category);

}
