package com.dbwls.section01.object;

import java.util.Objects;

public class Book {

    private int number;
    private String title;
    private String author;
    private int price;

    public Book(int number, String title, String author, int price) {
        this.number = number;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    /* 아래에 오버라이딩 된 equals와 hashCode는 동등 객체(주소는 달라도 필드 값이 같은지 확인)
     * 판단에 사용되는 코드이다. */
    @Override
    public boolean equals(Object o) {
        /* 비교 대상 객체가 null이거나 다른 타입일 경우 비교 가치가 없으므로 바로 false 리턴 */
        if (o == null || getClass() != o.getClass()) return false;
        /* Book 타입이기 때문에 다운 캐스팅 가능 */
        Book book = (Book) o;
        /* 값 비교 또는 참조 타입의 경우 별도의 메소드를 활용해서 값이 같은지 비교하여
         * 모든 필드 값이 동일한 값을 가졌다고 판단 되면 true를 리턴한다. */
        return number == book.number && price == book.price && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, title, author, price);
    }
}