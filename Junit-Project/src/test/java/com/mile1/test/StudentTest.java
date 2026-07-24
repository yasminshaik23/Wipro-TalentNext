package com.mile1.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.mile1.bean.Student;
import com.mile1.exception.NullMarksArrayException;
import com.mile1.exception.NullNameException;
import com.mile1.exception.NullStudentObjectException;
import com.mile1.service.StudentReport;
import com.mile1.service.StudentService;

public class StudentTest {

    private StudentReport report;
    private StudentService service;

    @Before
    public void setUp() {
        report = new StudentReport();
        service = new StudentService();
    }

    @Test
    public void testGradeA() {
        Student s = new Student("John", new int[] {70, 70, 70});
        assertEquals("A", report.findGrades(s));
    }

    @Test
    public void testGradeAPlus() {
        Student s = new Student("John", new int[] {90, 90, 90});
        assertEquals("A+", report.findGrades(s));
    }

    @Test
    public void testGradeF() {
        Student s = new Student("John", new int[] {20, 80, 90});
        assertEquals("F", report.findGrades(s));
    }

    @Test(expected = NullStudentObjectException.class)
    public void testNullStudentObject() throws Exception {
        report.validate(null);
    }

    @Test(expected = NullNameException.class)
    public void testNullName() throws Exception {
        Student s = new Student(null, new int[] {80, 90, 95});
        report.validate(s);
    }

    @Test(expected = NullMarksArrayException.class)
    public void testNullMarksArray() throws Exception {
        Student s = new Student("John", null);
        report.validate(s);
    }

    @Test
    public void testNullNameCount() {

        Student[] data = new Student[4];

        data[0] = new Student("Sekar", new int[] {85, 75, 95});
        data[1] = new Student(null, new int[] {11, 22, 33});
        data[2] = null;
        data[3] = new Student("Manoj", null);

        assertEquals(1, service.findNumberOfNullName(data));
    }
    @Test
    public void testNullObjectCount() {

        Student[] data = new Student[4];

        data[0] = new Student("Sekar", new int[] {85, 75, 95});
        data[1] = new Student(null, new int[] {11, 22, 33});
        data[2] = null;
        data[3] = new Student("Manoj", null);

        assertEquals(1, service.findNumberOfNullObjects(data));
    }
    @Test
    public void testNullMarksCount() {

        Student[] data = new Student[4];

        data[0] = new Student("Sekar", new int[] {85, 75, 95});
        data[1] = new Student(null, new int[] {11, 22, 33});
        data[2] = null;
        data[3] = new Student("Manoj", null);

        assertEquals(1, service.findNumberOfNullMarksArray(data));
    }
}