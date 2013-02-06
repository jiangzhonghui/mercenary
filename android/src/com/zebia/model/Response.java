package com.zebia.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {

    private Integer page;

    @SerializedName("results_per_page")
    private Integer resultsPerPage = 15;

    private List<Artist> results;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Artist> getResults() {
        return results;
    }

    public void setResults(List<Artist> results) {
        this.results = results;
    }

    public Integer getResultsPerPage() {
        return resultsPerPage;
    }

    public void setResultsPerPage(Integer resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }
}
