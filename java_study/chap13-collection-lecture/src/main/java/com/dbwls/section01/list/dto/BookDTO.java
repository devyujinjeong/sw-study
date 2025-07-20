package com.dbwls.section01.list.dto;

public class BookDTO implements Comparable<BookDTO> {
    /* 도서 정보를 저장할 DTO 클래스를 만들어보자 */
    private int number;
    private String title;
    private String author;
    private int price;

    /* 기본 생성자 */
    public BookDTO() {

    }

    /* 모든 필드를 초기화하는 생성자 */
    public BookDTO(int number, String title, String author, int price) {
        super();
        this.number = number;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    /* setter/getter */
    public void setNumber(int number) {
        this.number = number;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    /* toString 오버라이딩 */
    @Override
    public String toString() {
        return "BookDTO [number=" + number + ", title=" + title + ", author=" + author + ", price=" + price + "]";
    }

    @Override
    public int compareTo(BookDTO o) {
        return this.title.compareTo(o.getTitle());
    }
}
