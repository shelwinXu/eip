/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.lambada_date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.kingland.eip.lambada_date.Constants.*;

/**
 *  This class try to solve Lambda practice and Date practice
 */
public class Main {
    public static void main(String[] args) {
        List<Artist> artistList = initArtistList();
        //Lambda practice
        lambdaPractice(artistList);
        //Date practice
        datePractice();
    }

    /**
     * This class try to add some Artists in a ArtistList
     * @return artistList
     */
    public static List<Artist> initArtistList(){
        List<Artist> artistList = new ArrayList<>();
        Artist artistOne = new Artist.Builder()
                .name("Alan")
                .age(10)
                .profession(Profession.Singer)
                .create();
        Artist artistTwo = new Artist.Builder()
                .name("Alice")
                .age(45)
                .profession(Profession.Painter)
                .create();
        Artist artistThree = new Artist.Builder()
                .name("Mike")
                .age(63)
                .profession(Profession.Singer)
                .create();
        Artist artistFour = new Artist.Builder()
                .name("Helen")
                .age(30)
                .profession(Profession.Painter)
                .create();

        artistList.add(artistOne);
        artistList.add(artistTwo);
        artistList.add(artistThree);
        artistList.add(artistFour);
        return artistList;
    }

    /**
     * This function is try to solve lambda practice
     * @param artistList List of Artists
     */
    public static void lambdaPractice(List<Artist> artistList){
        //1. Find artists whoes name start with A.
        artistList.stream().filter(artist -> artist.getName().startsWith(NAME_SERACH))
                .forEach(System.out::println);
        //2. Get all ages from artists
        List<Integer> ageList = artistList.stream()
                .map(Artist::getAge)
                .collect(Collectors.toList());
        System.out.println(ageList);
        //3. Get first two ages from artists
        List<Integer> firstTwoCollect = ageList.stream()
                .limit(AGE_LIMIT_LENGTH)
                .collect(Collectors.toList());
        System.out.println(firstTwoCollect);
        //4. Sort the artist list by age in desc.
        List<Artist> sortedByAgeList = artistList.stream()
                .sorted((x, y) -> -Integer.compare(x.getAge(), y.getAge()))
                .collect(Collectors.toList());
        System.out.println(sortedByAgeList);
        //5. Print artists' name
        artistList.forEach(p -> System.out.println(p.getName()));
        //6. Get all even number ages from artists
        List<Integer> allEvenAgeCollect = ageList.stream()
                .filter(p -> p % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(allEvenAgeCollect);
        //7. Get max age from artists.
        int maxAge = artistList.stream().mapToInt(Artist::getAge).summaryStatistics().getMax();
        System.out.println("The max age is: " + maxAge);
        //8. Get singer whose age is less than 30.
        List<Artist> singerAgeCollect = artistList.stream()
                .filter(p -> p.getProfession() == Profession.Singer && p.getAge() > LIMIT_AGE)
                .collect(Collectors.toList());
        System.out.println(singerAgeCollect);
        //9. Get set collection from artists.
        Set<Artist> artistSet = (Set<Artist>) artistList.stream()
                .collect(Collectors.toSet());
        System.out.println(artistSet);
        //10.Return a List which data should be {1,2,3,4,5,6};
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        List<Integer> totalDataList = inputStream.flatMap((childList) -> childList.stream())
                .collect(Collectors.toList());
        System.out.println(totalDataList);
    }

    /**
     * This function is try to solve Date practice
     */
    public static void datePractice(){
        //1. start date 2020/9/13 7:23:23, end date 2020/9/15 13:15:35. Get milliseconds between start date and end date
        LocalDateTime startDate = LocalDateTime.of(2020,9,20,7,23,23);
        LocalDateTime endDate = LocalDateTime.of(2020,9,15,13,15,35);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/M/dd HH:mm:ss");
        long seconds = Duration.between(endDate, startDate).getSeconds();
        System.out.println(seconds);
        //2. Print local current time in format: "yyyy-MM-dd HH:mm:ss"
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println(currentTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        //3. Print last Thursday date for given time 2020/9/17, which will be 2020/9/10
        LocalDate givenDate = LocalDate.of(2020,9,17);
        System.out.println(givenDate.minusDays(WEEK_DAYS));
        //4. Transfer Instant to LocalDateTime by using default zoneId.
        Instant instantTime = Instant.now();
        LocalDateTime transferDateTime = instantTime.atZone(ZoneId.systemDefault()).toLocalDateTime();
        //5. Print year, month and day from current time.Format should be like "Year : %d Month : %d day : %d"
        LocalDate currentDate = currentTime.toLocalDate();
        System.out.printf("Year : %d Month : %d day : %d", currentDate.getYear(), currentDate.getMonth().getValue(), currentDate.getDayOfMonth());
        //6. Print date which is one week later from now.
        System.out.println(currentDate.plusDays(WEEK_DAYS));
    }
}
