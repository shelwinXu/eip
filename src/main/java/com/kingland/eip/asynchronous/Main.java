/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.asynchronous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

/**
 * this main class is due to test
 * @author KSC
 */
public class Main {
    public static void main(String[] args) {
        getBookList().thenCompose(books -> {
            List<CompletionStage> bookList = books.stream()
                    .map(book -> getScoreById(book.getId()).thenApply(score ->{
                        book.setScore(score);
                        return book;
                    })).collect(Collectors.toList());
            CompletableFuture done = CompletableFuture.allOf(bookList.toArray(new CompletableFuture[bookList.size()]));
            return done.thenApply(v -> bookList.stream().map(CompletionStage::toCompletableFuture)
                    .map(CompletableFuture::join).collect(Collectors.toList()));
        }).whenComplete((books,exception) -> {
            if (exception == null){
                List<Book> bookList = (List<Book>) books;
                bookList.forEach(System.out::println);
            }else {
                throw new RuntimeException((Exception)exception);
            }
        }).toCompletableFuture().join();
    }

    /**
     * This method can get the book list.
     * @return
     */
    public static CompletionStage<List<Book>> getBookList() {
        return CompletableFuture.supplyAsync(() -> {
            List<Book> bookList = new ArrayList<>();
            Book book1 = new Book.Builder()
                    .id(1L)
                    .name("Roman stories 1")
                    .create();
            Book book2 = new Book.Builder()
                    .id(2L)
                    .name("Roman stories 2")
                    .create();
            Book book3 = new Book.Builder()
                    .id(3L)
                    .name("Roman stories 3")
                    .create();
            Book book4 = new Book.Builder()
                    .id(4L)
                    .name("Roman stories 4")
                    .create();
            Book book5 = new Book.Builder()
                    .id(5L)
                    .name("Roman stories 5")
                    .create();
            Book book6 = new Book.Builder()
                    .id(6L)
                    .name("Roman stories 6")
                    .create();
            Book book7 = new Book.Builder()
                    .id(7L)
                    .name("Harry Potter 1")
                    .create();
            Book book8 = new Book.Builder()
                    .id(8L)
                    .name("Harry Potter 2")
                    .create();
            Book book9 = new Book.Builder()
                    .id(9L)
                    .name("Harry Potter 3")
                    .create();
            Book book10 = new Book.Builder()
                    .id(10L)
                    .name("On Java 8")
                    .create();

            bookList.add(book1);
            bookList.add(book2);
            bookList.add(book3);
            bookList.add(book4);
            bookList.add(book5);
            bookList.add(book6);
            bookList.add(book7);
            bookList.add(book8);
            bookList.add(book9);
            bookList.add(book10);
            return bookList;
        });
    }

    /**
     * This method can get book score by id
     * @param id
     * @return
     */
    public static CompletionStage<Double> getScoreById(Long id) {
        Map<Long, Double> bookScoreMap = new HashMap<Long,Double>(){{
            put(1L, 8.2);
            put(2L, 7.2);
            put(3L, 6.8);
            put(4L, 1.9);
            put(5L, 2.2);
            put(6L, 4.6);
            put(7L, 2.2);
            put(8L, 7.0);
            put(9L, 8.5);
            put(10L, 9.9);
        }};
        return CompletableFuture.supplyAsync(() -> bookScoreMap.get(id));
    }
}