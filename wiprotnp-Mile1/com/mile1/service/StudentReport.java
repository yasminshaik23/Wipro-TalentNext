package com.mile1.service;
import com.mile1.bean.Student;
import com.mile1.exception.*;
public class StudentReport {
    public String validate(Student student)
            throws NullNameException,
            NullMarksArrayException,
            NullStudentObjectException {

        if (student == null)
            throw new NullStudentObjectException();

        if (student.getName() == null)
            throw new NullNameException();

        if (student.getMarks() == null)
            throw new NullMarksArrayException();

        return "VALID";
    }
    public String findGrades(Student student) {
        int[] marks = student.getMarks();
        for (int m : marks) {
            if (m < 35)
                return "F";
        }
        int sum = 0;
        for (int m : marks)
            sum += m;
        if (sum < 150)
            return "C";
        else if (sum < 200)
            return "B";
        else if (sum < 250)
            return "A";
        else
            return "A+";
    }
}