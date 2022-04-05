import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Student> students = makeStudents();

        System.out.println("Уникальные курсы");
        System.out.println(filterUniqueCoursesFrom(students));
        System.out.println(" ");
        System.out.println("Любознательные");
        System.out.println(getTopThreeInquisitiveStudents(students));
        System.out.println(" ");
        System.out.println("Кто прошел курс \"Основы баз данных\" ");
        System.out.println(findStudentsByCourse(students, new Course("Основы баз данных")));
        System.out.println(" ");
        System.out.println("Самые популярные курсы");
        System.out.println(mostPopularCourse(students));
    }

    public static List<Student> makeStudents() {
        List<Student> students = Arrays.asList(
                new Student(
                        "Юлия Булатова",
                        Arrays.asList(
                                new Course("Основы ручного тестирования"),
                                new Course("HTML/CSS для тестировщиков"),
                                new Course("Git. Базовый курс"),
                                new Course("Основы баз данных"),
                                new Course("Как учиться эффективно. Видеокурс от методистов GeekUniversity")
                        )
                ),
                new Student(
                        "Игорь Кузнецов",
                        Arrays.asList(
                                new Course("Java Core для тестировщиков"),
                                new Course("Java. Уровень 1"),
                                new Course("Стажировка GeekBrains и Mail.Ru Group"),
                                new Course("Основы баз данных"),
                                new Course("Тестирование ПО. Уровень 2"),
                                new Course("Основы тестирования ПО")
                        )
                ),
                new Student(
                        "Миронова Ирина",
                        Arrays.asList(
                                new Course("Новогодний марафон"),
                                new Course("Java. Уровень 1"),
                                new Course("Java. Быстрый старт"),
                                new Course("Тестирование веб-приложений"),
                                new Course("HTML/CSS для тестировщиков"),
                                new Course("Путь программиста. История А. Волчека"),
                                new Course("#Geek_speak (онлайн-лекции от приглашенных экспертов)"),
                                new Course("Linux. Рабочая станция"),
                                new Course("Основы тест-аналитики"),
                                new Course("Основы ручного тестирования"),
                                new Course("Вводный курс студента"),
                                new Course("Посвящение в студенты GeekUniversity"),
                                new Course("Git. Базовый курс"),
                                new Course("Как учиться эффективно. Видеокурс от методистов GeekUniversity")
                        )
                ),
                new Student(
                        "Гаврилова Мария",
                        Arrays.asList(
                                new Course("Java. Уровень 1"),
                                new Course("Тестирование веб-приложений"),
                                new Course("HTML/CSS для тестировщиков"),
                                new Course("Linux. Рабочая станция"),
                                new Course("Основы тест-аналитики"),
                                new Course("Основы ручного тестирования"),
                                new Course("Посвящение в студенты GeekUniversity"),
                                new Course("Основы баз данных"),
                                new Course("Вводный курс студента"),
                                new Course("Как учиться эффективно. Видеокурс от методистов GeekUniversity")
                        )
                ),
                new Student(
                        "Мовлян Андрей",
                        Arrays.asList(
                                new Course("Java. Уровень 1"),
                                new Course("Регистрация в карьеру. Первый шаг"),
                                new Course("Основы программирования. Видеокурс"),
                                new Course("Тестирование веб-приложений"),
                                new Course("#Geek_speak (онлайн-лекции от приглашенных экспертов)"),
                                new Course("Git. Базовый курс"),
                                new Course("HTML/CSS для тестировщиков"),
                                new Course("Linux. Рабочая станция"),
                                new Course("Основы тест-аналитики"),
                                new Course("Вводный курс студента"),
                                new Course("Посвящение в студенты GeekUniversity"),
                                new Course("Основы ручного тестирования"),
                                new Course("Основы баз данных"),
                                new Course("Как учиться эффективно. Видеокурс от методистов GeekUniversity")
                                )
                ),
                new Student(
                        "Иван Таширев",
                        Arrays.asList(
                                new Course("Java Core для тестировщиков"),
                                new Course("HTML/CSS для тестировщиков"),
                                new Course("Подготовка к собеседованию. Тестирование ПО"),
                                new Course("Java. Уровень 1"),
                                new Course("Тестирование веб-приложений"),
                                new Course("Linux. Рабочая станция"),
                                new Course("Введение в тестирование. Практикум"),
                                new Course("Введение в тестирование")
                        )
                ),
                new Student(
                        "Максим Жегунов",
                        Arrays.asList(
                                new Course("Java. Уровень 1"),
                                new Course("#Geek_speak 2 (онлайн-лекции от приглашенных экспертов)"),
                                new Course("Java. Быстрый старт"),
                                new Course("На своем месте: цикл встреч с теми, кто нашел себя"),
                                new Course("Тестирование веб-приложений"),
                                new Course("HTML/CSS для тестировщиков"),
                                new Course("Linux. Рабочая станция"),
                                new Course("#Geek_speak (онлайн-лекции от приглашенных экспертов"),
                                new Course("Основы тест-аналитики"),
                                new Course("Основы ручного тестирования"),
                                new Course("Компьютерные сети. Интерактивный курс"),
                                new Course("Посвящение в студенты GeekUniversity"),
                                new Course("Основы баз данных"),
                                new Course("Git. Базовый курс"),
                                new Course("Как начать свой путь в разработке?"),
                                new Course("Тестирование ПО"),
                                new Course("Вводный курс студента"),
                                new Course("Как учиться эффективно. Видеокурс от методистов GeekUniversity")
                        )
                ),
                new Student(
                        "Рустам Рафисович",
                        Arrays.asList(
                                new Course("Java Core для тестировщиков"),
                                new Course("Подготовка к собеседованию. Тестирование ПО"),
                                new Course("Java. Уровень 1"),
                                new Course("Тестирование веб-приложений"),
                                new Course("HTML/CSS для тестировщиков"),
                                new Course("Linux. Рабочая станция"),
                                new Course("#Geek_speak (онлайн-лекции от приглашенных экспертов)"),
                                new Course("Компьютерные сети. Интерактивный курс"),
                                new Course("Основы тест-аналитики"),
                                new Course("Основы ручного тестирования"),
                                new Course("Посвящение в студенты GeekUniversity")
                        )
                ),
                new Student(
                        "Александр Баталин",
                        Arrays.asList(
                                new Course("Java Core для тестировщиков"),
                                new Course("Java для начинающих"),
                                new Course("Java. Уровень 1"),
                                new Course("Тестирование веб-приложений"),
                                new Course("HTML/CSS для тестировщиков"),
                                new Course("Linux. Рабочая станция"),
                                new Course("Основы тест-аналитики"),
                                new Course("Основы ручного тестирования"),
                                new Course("Вводный курс студента"),
                                new Course("Git. Базовый курс"),
                                new Course("Основы баз данных"),
                                new Course("Как учиться эффективно. Видеокурс от методистов GeekUniversity"),
                                new Course("Веб-разработка для начинающих"),
                                new Course("Тестирование ПО"),
                                new Course("Как начать свой путь в разработке?")
                        )
                ),
                new Student(
                        "Алексей Балашов",
                        Arrays.asList(
                                new Course("Java Core для тестировщиков"),
                                new Course("Java. Уровень 1"),
                                new Course("Тестирование веб-приложений"),
                                new Course("Вводный курс студента"),
                                new Course("Основы баз данных"),
                                new Course("Linux. Рабочая станция"),
                                new Course("Подготовка к поиску работы"),
                                new Course("Введение в тестирование"),
                                new Course("Введение в тестирование. Практикум"),
                                new Course("HTML/CSS. Интерактивный курс"),
                                new Course("Как учиться эффективно. Видеокурс от методистов GeekUniversity"),
                                new Course("Тестирование ПО")
                        )
                )
        );

        return students;
    }

    public static List<Course> filterUniqueCoursesFrom(List<Student> students) {
        List<Course> courses =
                students.stream()
                        .flatMap(element -> element.getAllCourses().stream())
                        .collect(Collectors.toList());

        return courses.stream()
                .filter(course -> Collections.frequency(courses, course) < 2)
                .collect(Collectors.toList());
    }

    public static List<Student> getTopThreeInquisitiveStudents(List<Student> from) {
        return from.stream()
                .sorted(new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        if (o1.getAllCourses().size() > o2.getAllCourses().size()) {
                            return -1;
                        } else if (o1.getAllCourses().size() < o2.getAllCourses().size()) {
                            return 1;
                        } else {
                            return 0;
                        }
                    }
                })
                .limit(3)
                .collect(Collectors.toList());
    }

    public static List<Student> findStudentsByCourse(List<Student> from, Course course) {
        return from.stream()
                .filter(student -> student.getAllCourses().contains(course))
                .collect(Collectors.toList());
    }

    public static List<Course> mostPopularCourse(List<Student> students) {
        List<Course> courses =
                students.stream()
                        .flatMap(element -> element.getAllCourses().stream())
                        .collect(Collectors.toList());

        return courses.stream()
                .filter(course -> Collections.frequency(courses, course) >= 9).limit(1)
                .collect(Collectors.toList());
    }
}
