package org.example10.models;

public class Posts {
    private int id_posts;
    private String posts_name;
    private int id_task;
    public Posts() {

    }
    public Posts(int id_posts, String posts_name, int id_task) {
        this.id_posts = id_posts;
        this.posts_name = posts_name;
        this.id_task = id_task;
    }

    public int getId_posts() {
        return id_posts;
    }

    public void setId_posts(int id_posts) {
        this.id_posts = id_posts;
    }

    public String getPosts_name() {
        return posts_name;
    }

    public void setPosts_name(String posts_name) {
        this.posts_name = posts_name;
    }

    public int getId_task() {
        return id_task;
    }

    public void setId_task(int id_task) {
        this.id_task = id_task;
    }
}
