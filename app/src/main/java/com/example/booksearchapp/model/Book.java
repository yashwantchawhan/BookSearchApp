
package com.example.booksearchapp.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Book {

    @SerializedName("start")
    @Expose
    private Integer start;
    @SerializedName("numFound")
    @Expose
    private Integer numFound;
    @SerializedName("num_found")
    @Expose
    private Integer num_Found;
    @SerializedName("docs")
    @Expose
    private List<Doc> docs = null;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getNumFound() {
        return numFound;
    }

    public void setNumFound(Integer numFound) {
        this.numFound = numFound;
    }

    public List<Doc> getDocs() {
        return docs;
    }

    public void setDocs(List<Doc> docs) {
        this.docs = docs;
    }

}
