package Lesson9;


import java.util.List;
import java.util.stream.Collectors;

public class HomeWork {

    public static void main(String[] args) {

        List<Student> students = HomeWorkData.getStudentsList();
        Course randomCourse = HomeWorkData.getRandomCourse();
        System.out.println(getUnicsCourses(students));
        System.out.println(getStudentsWithMoreCourses(students));
        System.out.println(getStudentsWithCourse(students, randomCourse));
    }

    public static List<Course> getUnicsCourses(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getAllCourses().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Student> getStudentsWithMoreCourses(List<Student> students) {
        return students.stream()
                .sorted((s1, s2) -> (s2.getAllCourses().size()) - (s1.getAllCourses().size()))
                .limit(3)
                .collect(Collectors.toList());
    }

    public static List<Student> getStudentsWithCourse(List<Student> students, Course course) {
        System.out.println(course);
        return students.stream()
                .filter(student -> student.getAllCourses().contains(course))
                .collect(Collectors.toList());
    }
}
