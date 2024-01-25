/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stusubfinals;
//StuSubFinals
/**
 *
 * @author geota
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class StuSubFinals {
    public static void main(String[] args) {
        StuSubFinals system = new StuSubFinals();
        boolean running = true;
        while (running) {
            System.out.print("1. Add Student \n2. Add Subject \n3. Edit Student \n4. Edit Subject \n5. Delete Student \n6. Delete Subject \n7. List Students \n8. List Subjects \n9. Exit\nEnter your choice: ");
            int choice = Integer.parseInt(system.scanner.nextLine());
            switch (choice) {
                case 1:
                    system.addStudent();
                    break;
                case 2:
                    system.addSubject();
                    break;
                case 3:
                    system.editStudent();
                    break;
                case 4:
                    system.editSubject();
                    break;
                case 5:
                    system.deleteStudent();
                    break;
                case 6:
                    system.deleteSubject();
                    break;
                case 7:
                    system.listStudents();
                    break;
                case 8:
                    system.listSubjects();
                    break;
                case 9:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }

        system.scanner.close();
    }
    private List<Student> students;
    private List<Subject> subjects;
    private Scanner scanner;

    public StuSubFinals() {
        students = new ArrayList<>();
        subjects = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addStudent() {
        System.out.println("Enter Student Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Student Age:");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Student Number:");
        String studentNumber = scanner.nextLine();
        System.out.println("Enter Student Section:");
        String section = scanner.nextLine();

        Student student = new Student(name, age, studentNumber, section);
        students.add(student);
        System.out.println("Student added successfully!");
    }

    public void addSubject() {
        System.out.println("Enter Subject Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Subject Code:");
        String code = scanner.nextLine();
        System.out.println("Enter Units:");
        int units = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Department:");
        String department = scanner.nextLine();

        Subject subject = new Subject(name, code, units, department);
        subjects.add(subject);
        System.out.println("Subject added successfully!");
    }
    
   public void editStudent() {
        System.out.println("Enter Student Number to edit:");
        String studentNumber = scanner.nextLine();

        for (Student student : students) {
            if (student.getStudentNumber().equals(studentNumber)) {
                System.out.println("Editing Student: " + student);
                System.out.println("Enter new Name (leave blank for no change):");
                String name = scanner.nextLine();
                if (!name.isEmpty()) {
                    student.setName(name);
                }

                System.out.println("Enter new Age (leave blank for no change):");
                String ageStr = scanner.nextLine();
                if (!ageStr.isEmpty()) {
                    int age = Integer.parseInt(ageStr);
                    student.setAge(age);
                }

                System.out.println("Enter new Section (leave blank for no change):");
                String section = scanner.nextLine();
                if (!section.isEmpty()) {
                    student.setSection(section);
                }

                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }

    public void editSubject() {
        System.out.println("Enter Subject Code to edit:");
        String subjectCode = scanner.nextLine();

        for (Subject subject : subjects) {
            if (subject.getSubjectCode().equals(subjectCode)) {
                System.out.println("Editing Subject: " + subject);
                System.out.println("Enter new Subject Name (leave blank for no change):");
                String name = scanner.nextLine();
                if (!name.isEmpty()) {
                    subject.setSubjectName(name);
                }

                System.out.println("Enter new Units (leave blank for no change):");
                String unitsStr = scanner.nextLine();
                if (!unitsStr.isEmpty()) {
                    int units = Integer.parseInt(unitsStr);
                    subject.setUnits(units);
                }

                System.out.println("Enter new Department (leave blank for no change):");
                String department = scanner.nextLine();
                if (!department.isEmpty()) {
                    subject.setDepartment(department);
                }

                System.out.println("Subject updated successfully!");
                return;
            }
        }

        System.out.println("Subject not found!");
    }

    public void deleteStudent() {
        System.out.println("Enter Student Number to delete:");
        String studentNumber = scanner.nextLine();

        students.removeIf(student -> student.getStudentNumber().equals(studentNumber));
        System.out.println("Student removed successfully!");
    }
    public void deleteSubject() {
        System.out.println("Enter Subject Code to delete:");
        String subjectCode = scanner.nextLine();

        subjects.removeIf(subject -> subject.getSubjectCode().equals(subjectCode));
        System.out.println("Subject removed successfully!");
    }
    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
    public void listSubjects() {
        if (subjects.isEmpty()) {
            System.out.println("No subjects found.");
        } else {
            for (Subject subject : subjects) {
                System.out.println(subject);
            }
        }
    }
}

class Student {
    private String name, studentNumber, section;
    private int age;

    public Student(String name, int age, String studentNumber, String section) {
        this.name = name;
        this.age = age;
        this.studentNumber = studentNumber;
        this.section = section;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getStudentNumber() {
        return studentNumber;
    }
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
    public String getSection() {
        return section;
    }
    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "Student{" + "name: '" + name + '\'' + ", age: " + age + ", studentNumber: '" + studentNumber + '\'' + ", section: '" + section + '\'' + '}';
    }
}

class Subject {
    private String subjectName, subjectCode, department;
    private int units;

    public Subject(String subjectName, String subjectCode, int units, String department) {
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.units = units;
        this.department = department;
    }

    public String getSubjectName() {
        return subjectName;
    }
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    public String getSubjectCode() {
        return subjectCode;
    }
    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }
    public int getUnits() {
        return units;
    }
    public void setUnits(int units) {
        this.units = units;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Subject{" + "subjectName: '" + subjectName + '\'' + ", subjectCode: '" + subjectCode + '\'' + ", units: " + units + ", department: '" + department + '\'' + '}';
    }
}
