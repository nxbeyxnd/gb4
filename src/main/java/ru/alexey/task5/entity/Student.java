package ru.alexey.task5.entity;
/* 
22.05.2022: Alexey created this file inside the package: ru.alexey.task5.entity 
*/

import javax.persistence.*;

@Entity
@Table(name = "STUDENT")
public class Student {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "MARK", nullable = false)
    private int mark;

    public Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark){
        this.mark = mark;
    }
}
