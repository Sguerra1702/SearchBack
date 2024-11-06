package edu.eci.cvds.SearchLibrary.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")

public class Search {
    @Id
    private Long bookID;
    private String title;
    private String author;
    private String category;
    private Long isbn;



    public Search(){

    }

    public Search(String title,  String author, String category){
        this.title=title;
        this.author=author;
        this.category=category;

    }

    //Getters
    public Long getBookID(){
        return bookID;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getCategory(){
        return category;
    }

    public Long getisbn(){
        return isbn;
    }

    //Setters

    public void setBookId(long BookId){
        this.bookID=BookId;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public void setAuthor(String author){
        this.author=author;
    }

    public void setCategory(String Category){
        this.category=Category;
    }

    public void setisbn(long isbn){
        this.isbn=isbn;
    }
}
