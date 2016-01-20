package com.pvmm.utils;

import org.springframework.data.domain.Page;

import javax.servlet.http.HttpServletRequest;

public class Paginator<T> {
    private static final int MIN_BUTTONS = 3;
    private static final int DEFAULT_VISIBLE_BUTTONS = 5;

    private int maxButtons;
    private int totalPages;
    private int currentPage;

    private int startButton;
    private int endButton;

    private boolean isFirst;
    private boolean isLast;

    private String uri;


    public Paginator(Page<T> page, HttpServletRequest request) {
        this(page, request, DEFAULT_VISIBLE_BUTTONS);
    }


    public Paginator(Page<T> page, HttpServletRequest request, int maxButtons) {
        this.preparePageData(page);
        this.prepareUri(request);

        this.maxButtons = maxButtons;

        this.guessFirstButtonVisible();
        this.guessLastButtonVisible();
    }


    private void preparePageData(Page<T> page) {
        this.totalPages = page.getTotalPages();
        this.currentPage = page.getNumber() + 1;
        this.isFirst = page.isFirst();
        this.isLast = page.isLast();
    }


    private void prepareUri(HttpServletRequest request) {
        this.uri = request.getRequestURI();
        String queryStr = request.getQueryString();

        if( queryStr == null ) {
            this.uri += "?page=";
            return;
        }

        this.uri += "?" + queryStr.replaceAll("&*page=[0-9]+", "") + "&page=";
    }


    private void guessFirstButtonVisible() {
        startButton = 1;

        if( currentPage < maxButtons) {
            return;
        }

        int halfButtons = (int) Math.floor(maxButtons / 2);
        int difference = totalPages - currentPage;

        if( difference <= halfButtons) {
            startButton = currentPage - maxButtons + difference + 1;
        } else {
            startButton = currentPage - halfButtons;
        }
    }


    private void guessLastButtonVisible() {
        endButton = maxButtons;

        if( totalPages <= maxButtons) {
            endButton = totalPages;
            return;
        }

        endButton = (startButton + maxButtons) - 1;

        if( endButton > totalPages ) {
            endButton = totalPages;
        }
    }


    public String getPageLink( int pageNumber ) {
        return (this.uri + pageNumber);
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getStartButton() {
        return startButton;
    }

    public int getEndButton() {
        return endButton;
    }

    public boolean isCurrentPage(int pageNum) {
        return this.currentPage == pageNum;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public boolean isLast() {
        return isLast;
    }
}
