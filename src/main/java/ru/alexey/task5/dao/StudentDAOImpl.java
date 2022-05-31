package ru.alexey.task5.dao;
/* 
22.05.2022: Alexey created this file inside the package: ru.alexey.task5.DAO 
*/

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.alexey.task5.config.MySessionFactorySingleton;
import ru.alexey.task5.entity.Student;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Override
    public List<Student> getAllStudent() {
        try (Session session = MySessionFactorySingleton.getFactory().getCurrentSession()) {
            session.beginTransaction();
            Query<Student> getAllStudentsQuery = session.createQuery("from Student order by id ASC", Student.class);
            List<Student> students = getAllStudentsQuery.getResultList();
            session.getTransaction().commit();
            return students;
        }

    }

    @Override
    public Optional<Student> getStudentByID(Long id) {
        try (Session session = MySessionFactorySingleton.getFactory().getCurrentSession()) {
            session.beginTransaction();
            Query<Student> getStudentByIdQuery = session.createQuery("from Student where id =:studentId", Student.class);
            getStudentByIdQuery.setParameter("studentId", id);

            Optional<Student> student = getStudentByIdQuery.uniqueResultOptional();
            session.getTransaction().commit();
            return student;
        }
    }

    @Override
    public Student saveStudent(Student student) {
        try (Session session = MySessionFactorySingleton.getFactory().getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(student);
            session.getTransaction().commit();
            return student;
        }
    }

    @Override
    public List<Student> addAll(List<Student> students) {
        try (Session session = MySessionFactorySingleton.getFactory().getCurrentSession()) {
            session.beginTransaction();
            for (Student s : students) {
                session.save(s);
            }
            session.getTransaction().commit();
            return students;
        }
    }

    @Override
    public void deleteStudentById(Long id) {
        try (Session session = MySessionFactorySingleton.getFactory().getCurrentSession()) {
            session.beginTransaction();
            Query studentToDeleteQuery = session
                    .createQuery("delete from Student where id = :idToDelete");
            studentToDeleteQuery.setParameter("idToDelete", id)
                    .executeUpdate();
        }
    }

    @Override
    public Long getCountData() {
        try (Session session = MySessionFactorySingleton.getFactory().getCurrentSession()) {
            session.beginTransaction();
            Query<Long> studentCountQuery = session
                    .createQuery("select count(*) from Student");
            return studentCountQuery.uniqueResult();
        }
    }
}
