package com.pvmm.utils;

import org.springframework.data.domain.Page;

public class Paginator<T> {
    private final int MAX_BUTTONS = 5;

    private int totalPages;
    private int currentPage;

    private int startButton = 1;
    private int endButton = 5;



    public Paginator(Page<T> page) {
        this.totalPages = page.getTotalPages();
        this.currentPage = page.getNumber();

        if( currentPage > MAX_BUTTONS ) {
            startButton = currentPage;
        }

        if( totalPages <= MAX_BUTTONS ) {
            endButton = totalPages;
        }
    }

}
