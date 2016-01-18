package com.pvmm.utils;

import org.springframework.data.domain.Page;

public class Paginator<T> {
    private final int MAX_BUTTONS = 5;

    private int totalPages;
    private int currentPage;

    private int startButton = 1;
    private int endButton = 5;

    private boolean isFirst;
    private boolean isLast;

    public Paginator(Page<T> page) {
        this.totalPages = page.getTotalPages();
        this.currentPage = page.getNumber() + 1;

        this.isFirst = page.isFirst();
        this.isLast = page.isLast();

        this.guessFirstButton();
        this.guessLastButtonVisible();
    }


    private void guessFirstButton() {
        if( currentPage > MAX_BUTTONS ) {
            startButton = currentPage;
        }
    }

    private void guessLastButtonVisible() {
        if( totalPages <= MAX_BUTTONS ) {
            endButton = totalPages;
            return;
        }

        endButton = (startButton + MAX_BUTTONS) - 1;

        if( endButton > totalPages ) {
            endButton = totalPages;
        }
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
