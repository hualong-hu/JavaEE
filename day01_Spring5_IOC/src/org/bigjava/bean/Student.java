package org.bigjava.bean;
import java.util.Arrays;
import	java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ProjectName: JavaEE
 * @ClassName: Student
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-04 21:42
 * @Version v1.0
 */
public class Student {
    private String[] course;
    private List<String> name;
    private Map<String,Integer> score;
    private Set<String> teacher;
    private List<Courser> coursers;
    private List<Books> books;




   public void show(){
       System.out.println(Arrays.toString(course));
       System.out.println("name = " + name);
       System.out.println("score = " + score);
       System.out.println("teacher = " + teacher);
       System.out.println("coursers = " + coursers);
       System.out.println("books = " + books);
   }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    public List<Courser> getCoursers() {
        return coursers;
    }

    public void setCoursers(List<Courser> coursers) {
        this.coursers = coursers;
    }

    public String[] getCourse() {
        return course;
    }

    public void setCourse(String[] course) {
        this.course = course;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public Map<String, Integer> getScore() {
        return score;
    }

    public void setScore(Map<String, Integer> score) {
        this.score = score;
    }

    public Set<String> getTeacher() {
        return teacher;
    }

    public void setTeacher(Set<String> teacher) {
        this.teacher = teacher;
    }
}


class Courser {
    private String name;
    private double score;

    @Override
    public String toString() {
        return "Courser{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
class Books {
    private String name;
    private double price;

    @Override
    public String toString() {
        return "Books{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
