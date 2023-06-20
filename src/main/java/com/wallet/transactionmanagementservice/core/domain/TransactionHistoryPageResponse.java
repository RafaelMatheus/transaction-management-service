package com.wallet.transactionmanagementservice.core.domain;

import java.util.List;

public class TransactionHistoryPageResponse<T> {
    private List<T> content;
    private int size;
    private int pageNumber;
    private int totalPages;

    public static <T> TransactionHistoryPageResponse<T> of(List<T> content, int size, int pageNumber, int totalPages) {
        return new TransactionHistoryPageResponse<>(content, size, pageNumber, totalPages);
    }

    public TransactionHistoryPageResponse(List<T> content, int size, int pageNumber, int totalPages) {
        this.content = content;
        this.size = size;
        this.pageNumber = pageNumber;
        this.totalPages = totalPages;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
