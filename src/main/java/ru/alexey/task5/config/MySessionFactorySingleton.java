package ru.alexey.task5.config;
/* 
22.05.2022: Alexey created this file inside the package: ru.alexey.task5.config 
*/

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.alexey.task5.entity.Student;


public class MySessionFactorySingleton {
    private static SessionFactory factory;

    public MySessionFactorySingleton() {

    }

    public static SessionFactory getFactory() {
        if (factory == null) {
            factory = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Student.class)
                    .buildSessionFactory();
            return factory;
        }
        return factory;
    }
}
