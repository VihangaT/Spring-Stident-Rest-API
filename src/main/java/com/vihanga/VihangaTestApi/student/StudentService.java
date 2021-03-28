package com.vihanga.VihangaTestApi.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents(){
       return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail= studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("Email taken");
        }
        studentRepository.save(student);
        System.out.println(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exits=studentRepository.existsById(studentId);
        if(!exits){
            throw new  IllegalStateException("A student with ID " +studentId+ " is not available");

        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {

        boolean exist=studentRepository.existsById(studentId);
        Student student= studentRepository.findById(studentId).orElseThrow(()-> new IllegalStateException(
                "Student with id " +studentId+ " does not exist"
        ));
        if(name !=null && name.length() > 0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        } else{
            throw new IllegalStateException("There is no change in the name");
        }

        if (email !=null && email.length() >0 && !Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptional =studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("Email Already taken");
            }else{
                student.setEmail(email);
            }

        }
    }
}
