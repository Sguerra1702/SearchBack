package edu.eci.cvds.SearchLibrary.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")

public class Search {
    @Id
    private String bookID; //Se cambio a String
    private String title;
    private String author;
    private String category;
    private Long isbn;
    //Nuevo
    private String SearchType;
    private String SearchParameter;
    private String SearchResult;




    public Search(){

    }

    public Search(String title,  String author, String category){
        this.title=title;
        this.author=author;
        this.category=category;

    }

    //Getters
    public String getBookID(){
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

    public String getsearchType(){
        return SearchType;
    }

    public String getSearchParameter(){
        return SearchParameter;
    }

    public String getSearchResult(){
        return SearchResult;
    }

    //Setters

    public void setBookId(String BookId){
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

    public void setSearchType(String SearchType){
        this.SearchType=SearchType;
    }

    public void setSearchParameter(String SearchParameter){
        this.SearchParameter=SearchParameter;
    }

    public void setSearchResult(String SearchResult){
        this.SearchResult=SearchResult;
    }

}
