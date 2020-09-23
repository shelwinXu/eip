package com.kingland.eip.asynchronous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class PreMain {
    public static void main(String[] args) {
        List<Book> bookList = initBookList();
        System.out.println(bookList);

        Map<Long, Double> bookIdScoreMap = initMap();
        Double aDouble = bookIdScoreMap.get(1L);
        System.out.println(aDouble);

        for (Long aLong : bookIdScoreMap.keySet()) {
            System.out.println(searchScoreById(aLong,bookIdScoreMap));
        }

        //runExample(bookList,bookIdScoreMap);
        //System.out.println(bookIdScoreMap);
    }

    public CompletionStage<List<Book>> getList(List<Book> bookList){
        Supplier<List<Book>> supplyBooks = () -> {
            //sleep(100);
            return bookList;
        };
        return CompletableFuture.supplyAsync(supplyBooks);
    }

    //public List<Book> runExample(CompletionStage<List<Book>> bookFuture,Long id){
    //
    //    bookFuture.thenCompose(
    //
    //
    //
    //
    //    ).toCompletableFuture().join();
    //
    //    //List<CompletableFuture<Book>> bookListFuture = bookFuture.stream()
    //    //        .map(book -> CompletableFuture.supplyAsync( // 使用异步的方式计算每种商品的价格
    //    //                () -> book.setId(id)))
    //    //        .collect(toList());
    //
    //    return bookListFuture.stream()
    //            .map(CompletableFuture::join)
    //            .collect(toList());
    //}


    //public static void runExample(List<Book> bookList, Map<Long, Double> bookIdScoreMap){
    //    ExecutorService executor1 = Executors.newSingleThreadExecutor();
    //    //ExecutorService executor2 = Executors.newSingleThreadExecutor();
    //
    //    Supplier<List<Book>> supplyBooks = () -> {
    //        sleep(100);
    //        return bookList;
    //    };
    //
    //    Supplier<List<Double>> supplyIds = () -> {
    //        sleep(100);
    //        return Arrays.asList(8.2,7.2,6.8,1.9,2.2,4.6,2.2,7.0,8.5,9.9);
    //    };
    //
    //    CompletableFuture<List<Book>> listCompletableFuture = CompletableFuture.supplyAsync(supplyBooks);
    //
    //    Function<List<Double>, CompletableFuture<List<Book>>> fetchBooks = books -> {
    //        sleep(300);
    //        System.out.println("Function is currently running in " + Thread.currentThread().getName());
    //        Supplier<List<Book>> bookSupplier =
    //                () -> {
    //                    System.out.println("Currently running in " + Thread.currentThread().getName());
    //                    return books.stream().map(Double ->{
    //                    }).collect(Collectors.toList());
    //                };
    //        return CompletableFuture.supplyAsync(bookSupplier);
    //    };
    //    Consumer<List<Book>> displayer = books -> {
    //        System.out.println("Running in " + Thread.currentThread().getName());
    //        books.forEach(System.out::println);
    //    };
    //    System.out.println("Currently running in " + Thread.currentThread().getName());
    //    sleep(6_000);
    //    executor1.shutdown();
    //}
    //private static void sleep(int timeout) {
    //    try {
    //        Thread.sleep(timeout);
    //    } catch (InterruptedException e) {
    //    }
    //}

    public static Double searchScoreById(Long id, Map<Long, Double> testMap){
        return testMap.get(id);
    }

    public static Map<Long,Double> initMap(){
        Map<Long,Double> map = new HashMap();
        map.put(1L,8.2);
        map.put(2L,7.2);
        map.put(3L,6.8);
        map.put(4L,1.9);
        map.put(5L,2.2);
        map.put(6L,4.6);
        map.put(7L,2.2);
        map.put(8L,7.0);
        map.put(9L,8.5);
        map.put(10L,9.9);

        return map;
    }

    public static List<Book> initBookList(){
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
                .id(7L)
                .name("Harry Potter 2")
                .create();
        Book book9 = new Book.Builder()
                .id(7L)
                .name("Harry Potter 3")
                .create();
        Book book10 = new Book.Builder()
                .id(3L)
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
    }
}