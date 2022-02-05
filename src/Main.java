import exception.ExamMarkIsOutOfRangeException;
import exception.LabsMarkIsOutOfRangeException;
import exception.ProfessorIsNotPresentException;
import exception.StudentIsNull;
import classes.*;
import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.out;
import static java.lang.System.setOut;

public class Main {

    public static void searchSubjectbyName(List<Subject> subjects) {
        Scanner in = new Scanner(System.in);
        out.println("Write name of subject:  ");
        String subjectName = in.nextLine();
        subjects.stream()
                .filter(subject -> subject.name().equals(subjectName))
                .forEach(subject -> out.println("We found subject with name  " + subjectName + " :" + subject.getNumberOfCredit() + " credits"));
    }

    public static void searchStudentsGroupByName(Set<StudentsGroup> studentsGroups) {
        Scanner in = new Scanner(System.in);
        out.println("Write name of studentsGroup:  ");
        String groupName = in.nextLine();
        studentsGroups.stream()
                .filter(studentGroup -> studentGroup.getNameOfGroup().equals(groupName))
                .forEach(studentsGroup -> out.println("We found group with such name : " + groupName));
    }

    public static void searchDepartmentByName(Set<Department> departments) {
        Scanner in = new Scanner(System.in);
        out.println("Write name of department:  ");
        String departmentName = in.nextLine();
        departments.stream()
                .filter(department -> department.getDepartmentName().equals(departmentName))
                .forEach(department -> out.println("We found department with such name : " + departmentName));
    }


    public static void rateByProfessors(List<Student> students1, List<Professor> professors) throws ExamMarkIsOutOfRangeException {

        for (int i = 0; i < students1.size(); i++) {
            int mark = (int) (Math.random() * 61);
            Professor professor = professors.get(i);
            Student student = students1.get(i);
            professor.rate(student, mark);

        }
    }

    public static void rateByAssistants(List<Student> students1, List<Assistant> assistants) throws LabsMarkIsOutOfRangeException {
        for (int i = 0; i < students1.size(); i++) {
            int mark = (int) (Math.random() * 41);
            Assistant assistant = assistants.get(i);
            Student student = students1.get(i);
            assistant.rate(student, mark);
        }
    }


    public static void addBonusMarks(Map<Student, Integer> map, List<Student> students, Integer bonusMark) {
        for (Student student : students) {
            map.put(student, map.containsKey(student) ? map.get(student) + bonusMark : bonusMark);
            System.out.println("New exam  mark for " + student.getLastName() + " " + student.getFirstName() + " : " + map.get(student));
        }
        /*students.stream()
                .forEach(student -> {
                    map.put(student, map.get(student) + bonusMark);
                    System.out.println("New exam  mark for " + student.getLastName() + " " + student.getFirstName() + " : " + map.get(student))
                    ;
                });*/
    }

    public static void writeInfoAboutDirectorToFile(Director director) throws IOException {
        FileWriter writer = new FileWriter("university/src/director.txt");
        writer.append("Info about our university director:");
        writer.append("\n" + director.getLastName() + " " + director.getFirstName() + "| Age: " + director.getAge() + "| Weight: " + director.getWeight() + "| Height: " + director.getHeight() + "| Experience  : " + director.getExp() + "| Salary: " + Director.salaryD + " | Money : " + director.getMoney() + " |Rating: " + director.getRating() + "/%" + "|");
        writer.close();
    }


    public static void writeInfoAboutStudentsToFile(List<Student> students) throws IOException {
        FileWriter writer = new FileWriter("university/src/students.txt");
        writer.append("Info about our university students:");
        students.stream()
                .sorted(Comparator.comparing(Student::getLastName))
                .forEach(student -> {
                    try {
                        writer.append("\n" + student.getLastName() + " " + student.getFirstName() + "| Age: " + student.getAge() + "| Weight: " + student.getWeight() + "| Height: " + student.getHeight() + "| Year of studying  : " + student.getYearOfStudying() + "| Abscences: " + student.getAbscence() + " |");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        writer.close();
    }

    public static void writeInfoAboutAssistansToFile(List<Assistant> assistants) throws IOException {
        FileWriter writer = new FileWriter("university/src/assistants.txt");
        writer.append("Info about our university assistants:");
        assistants.stream()
                .sorted(Comparator.comparing(Assistant::getLastName))
                .forEach(assistant -> {
                    try {
                        writer.append("\n" + assistant.getLastName() + " " + assistant.getFirstName() + "| Age: " + assistant.getAge() + "| Weight: " + assistant.getWeight() + "| Height: " + assistant.getHeight() + "| Experience  : " + assistant.getExp() + "| Salary: " + Assistant.salaryA + " | Money : " + assistant.getMoney() + " |");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        writer.close();
    }

    public static void writeInfoAboutProfessorToFile(List<Professor> professors) throws IOException {
        FileWriter writer = new FileWriter("university/src/professors.txt");
        writer.append("Info about our university professors:");
        professors.stream()
                .sorted(Comparator.comparing(Professor::getLastName))
                .forEach(professor -> {
                    try {
                        writer.append("\n" + professor.getLastName() + " " + professor.getFirstName() + "| Age: " + professor.getAge() + "| Weight: " + professor.getWeight() + "| Height: " + professor.getHeight() + "| Experience  : " + professor.getExp() + "| Salary: " + Professor.salaryPr + " | Money : " + professor.getMoney() + " |");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        writer.close();
    }


    public static void writeInfoAboutDepartmentsToFile(List<Department> departments) throws IOException {
        FileWriter writer = new FileWriter("university/src/departments.txt");
        writer.append("Our university departments:");
        departments.stream()
                .sorted(Comparator.comparing(Department::getDepartmentName))
                .forEach(department -> {
                    try {
                        writer.append("\n |" + department.getDepartmentName() + " | ");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        writer.close();
    }

    public static void writeInfoAboutUniversityToFile(University university) throws IOException {
        FileWriter writer = new FileWriter("university/src/university.txt");
        writer.append("Info about our university:");
        writer.append("\n |" + university.getUniversityName() + "|" + " Address: " + university.getUniversityAddress() + "|");
        writer.close();
    }

    public static void writeInfoAboutStudentsGroupyToFile(List<StudentsGroup> studentsGroups) throws IOException {
        FileWriter writer = new FileWriter("university/src/groups.txt");
        writer.append("Our university groups of students:");
        studentsGroups.stream()
                .sorted(Comparator.comparing(StudentsGroup::getNameOfGroup))
                .forEach(studentsGroup -> {
                    try {
                        writer.append("\n |" + studentsGroup.getNameOfGroup() + "|");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        writer.close();
    }


    public static void readInfoAboutStudents() throws IOException {
        FileReader reader = new FileReader("university/src/students.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            out.println(line);
        }
        reader.close();
        bufferedReader.close();
    }

    public static void downloadUniversityEmblem() throws IOException {
        URL url = new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/d/de/Nulp_logo_ukr.jpg/809px-Nulp_logo_ukr.jpg");
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream("university/src/universityEmblem.jpg", true);
        int next;
        while ((next = is.read()) != -1) {
            os.write(next);
        }
        is.close();
        os.close();
    }

    public static void main(String[] args) throws
            ExamMarkIsOutOfRangeException, ProfessorIsNotPresentException, StudentIsNull, IllegalAccessException, NoSuchFieldException, IOException, LabsMarkIsOutOfRangeException {


        Director director = new Director("Yurii", "Bobalo", 76, 80, 190, 90, 100000, 50);


        Set<Lesson> lessons1 = new HashSet<>();
        lessons1.add(new Lesson(9, 10));
        lessons1.add(new Lesson(10, 11));
        lessons1.add(new Lesson(12, 13));
        lessons1.add(new Lesson(13, 14));
        lessons1.add(new Lesson(15, 16));


        List<Lesson> lessons2 = lessons1.stream().collect(Collectors.toList());


        Set<StudentsGroup> studentsGroups1 = new HashSet<>();
        studentsGroups1.add(new StudentsGroup("CE-101"));
        studentsGroups1.add(new StudentsGroup("CE-303"));
        studentsGroups1.add(new StudentsGroup("AM-201"));
        studentsGroups1.add(new StudentsGroup("AM-402"));
        studentsGroups1.add(new StudentsGroup("J-302"));
        studentsGroups1.add(new StudentsGroup("J-103"));
        studentsGroups1.add(new StudentsGroup("A-105"));
        studentsGroups1.add(new StudentsGroup("A-405"));
        studentsGroups1.add(new StudentsGroup("CS-103"));
        studentsGroups1.add(new StudentsGroup("CS-206"));
        studentsGroups1.add(new StudentsGroup("L-204"));
        studentsGroups1.add(new StudentsGroup("L-401"));


        List<StudentsGroup> studentsGroups2 = studentsGroups1.stream().collect(Collectors.toList());


        List<Lab> labs = new ArrayList<>();
        labs.add(new Lab(1, "dasddadas"));
        labs.add(new Lab(2, "vbvxxee"));
        labs.add(new Lab(3, "tetrneer"));
        labs.add(new Lab(4, "weewqewq"));
        labs.add(new Lab(5, "xczcxz"));
        labs.add(new Lab(6, "nbngfdgf"));


        List<Professor> professors = new ArrayList<>();
        professors.add(new Professor("Valerii", "Glukhov", 60, 70, 190, Subject.COMPUTER_LOGIC, lessons2.subList(0, 3), 50000, 30, studentsGroups2.subList(0, 2)));
        professors.add(new Professor("Andrii", "Kostyk", 50, 80, 180, Subject.HIGH_MATH, lessons2.subList(2, 5), 20000, 14, studentsGroups2.subList(0, 2)));
        professors.add(new Professor("Olena", "Gorina", 56, 60, 165, Subject.DISCRETE_MATH, lessons2.subList(0, 4), 60000, 16, studentsGroups2.subList(2, 4)));
        professors.add(new Professor("Gennadiy", "Boiko", 72, 82, 190, Subject.GERMAN, lessons2.subList(3, 5), 25000, 35, studentsGroups2.subList(2, 4)));
        professors.add(new Professor("Andriy", "Yarmolenko", 50, 85, 170, Subject.PHYSICS, lessons2.subList(0, 3), 17000, 20, studentsGroups2.subList(4, 6)));
        professors.add(new Professor("Vasyl", "Chaban", 80, 73, 180, Subject.POLITOLOGY, lessons2.subList(3, 5), 35000, 40, studentsGroups2.subList(4, 6)));
        professors.add(new Professor("Andrii", "Dobosevych ", 60, 86, 190, Subject.DESIGN, lessons2.subList(0, 4), 25000, 20, studentsGroups2.subList(6, 8)));
        professors.add(new Professor("Ivan", "Zotko", 85, 75, 182, Subject.LAW, lessons2.subList(1, 4), 55000, 45, studentsGroups2.subList(6, 8)));
        professors.add(new Professor("Yevhen", "Mostavchuk", 50, 71, 189, Subject.HISTORY, lessons2.subList(0, 3), 15000, 12, studentsGroups2.subList(8, 10)));
        professors.add(new Professor("Teodor", "Vakulenko", 65, 68, 172, Subject.PROGRAMMING, lessons2.subList(3, 5), 35000, 40, studentsGroups2.subList(8, 10)));
        professors.add(new Professor("Igor", "Anisimov", 58, 76, 175, Subject.ENGLISH, lessons2.subList(0, 3), 18000, 15, studentsGroups2.subList(10, 11)));
        professors.add(new Professor("Olga", "Ivanovska", 62, 70, 178, Subject.UKRAINIAN_LANGUAGE, lessons2.subList(3, 5), 28000, 28, studentsGroups2.subList(10, 11)));


        List<Assistant> assistants = new ArrayList<>();
        assistants.add(new Assistant("Anton", "Harchenko", 25, 80, 195, Subject.COMPUTER_LOGIC, lessons2.subList(4, 5), 5000, 1, labs.subList(0, 2)));
        assistants.add(new Assistant("Victor", "Tsygankov", 24, 70, 180, Subject.HIGH_MATH, lessons2.subList(0, 3), 1000, 1, labs.subList(0, 1)));
        assistants.add(new Assistant("Roman", "Yaremchuk", 27, 85, 185, Subject.DISCRETE_MATH, lessons2.subList(3, 5), 2000, 3, labs.subList(1, 3)));
        assistants.add(new Assistant("Volodymyr", "Stadnyk", 29, 90, 175, Subject.GERMAN, lessons2.subList(3, 4), 1500, 2, labs.subList(3, 5)));
        assistants.add(new Assistant("Oleg", "Paliy", 30, 90, 175, Subject.PHYSICS, lessons2.subList(0, 2), 4000, 3, labs.subList(4, 6)));
        assistants.add(new Assistant("Bogdan", "Martyniuk", 28, 60, 165, Subject.DESIGN, lessons2.subList(4, 5), 3000, 2, labs.subList(5, 6)));
        assistants.add(new Assistant("Anastasia", "Goltsova", 29, 58, 162, Subject.LAW, lessons2.subList(1, 3), 5000, 3, labs.subList(4, 6)));
        assistants.add(new Assistant("Oksana", "Oryshchyn", 34, 80, 170, Subject.HISTORY, lessons2.subList(2, 4), 6000, 5, labs.subList(0, 2)));
        assistants.add(new Assistant("Yurii", "Klushyn", 35, 70, 175, Subject.PROGRAMMING, lessons2.subList(1, 4), 7000, 5, labs.subList(4, 6)));
        assistants.add(new Assistant("Anton", "Moroz", 37, 67, 185, Subject.ENGLISH, lessons2.subList(3, 4), 9000, 7, labs.subList(5, 6)));
        assistants.add(new Assistant("Oleksiy", "Stepaniuk", 31, 76, 195, Subject.UKRAINIAN_LANGUAGE, lessons2.subList(1, 4), 4000, 2, labs.subList(1, 3)));
        assistants.add(new Assistant("Mykola", "Kuharevych", 33, 86, 189, Subject.POLITOLOGY, lessons2.subList(3, 5), 6000, 3, labs.subList(0, 2)));


        Set<Department> departments1 = new HashSet<>();
        departments1.add(new Department("Computer enineering", professors.subList(0, 2), assistants.subList(0, 2), studentsGroups2.subList(0, 2)));
        departments1.add(new Department("Applied Math", professors.subList(2, 4), assistants.subList(2, 4), studentsGroups2.subList(2, 4)));
        departments1.add(new Department("Journalism", professors.subList(4, 6), assistants.subList(4, 6), studentsGroups2.subList(4, 6)));
        departments1.add(new Department("Architecture", professors.subList(6, 8), assistants.subList(6, 8), studentsGroups2.subList(6, 8)));
        departments1.add(new Department("Computer Science", professors.subList(8, 10), assistants.subList(8, 10), studentsGroups2.subList(8, 10)));
        departments1.add(new Department("Law", professors.subList(10, 12), assistants.subList(10, 12), studentsGroups2.subList(10, 12)));


        List<Department> departments2 = departments1.stream().collect(Collectors.toList());


        University university = new University("Lviv Polytehnic National University", "Stepana Bandery street", director, departments1);

        List<Subject> subjects = new ArrayList<Subject>(Arrays.asList(Subject.values()));

        List<Student> students1 = new ArrayList<>();
        students1.add(new Student("Nazar", "Panasiuk", 19, 65, 170, 3, 4, true, subjects.subList(0, 6)));
        students1.add(new Student("Andrii", "Shevchenko", 17, 80, 190, 1, 2, false, subjects.subList(5, 10)));
        students1.add(new Student("Oleksandr", "Zinchenko", 18, 80, 182, 2, 0, true, subjects.subList(1, 6)));
        students1.add(new Student("Vitaliy", "Mykolenko", 20, 72, 175, 4, 10, false, subjects.subList(2, 7)));
        students1.add(new Student("Yevhen", "Konoplyanka", 17, 68, 173, 1, 6, false, subjects.subList(3, 8)));
        students1.add(new Student("Yurii", "Karpliuk", 18, 76, 18, 2, 1, true, subjects.subList(5, 11)));


        professors.get(0).rate(students1.get(1), 20);
        /*   professors.get(3).rate(students1.get(1),120);*/ //exception ExamMark is out of range//
        professors.get(5).Attend();
        professors.get(5).work();
        /*  professors.get(5).work();*///exception Proffesor is not present//
        professors.get(4).getExperience();
        professors.get(1).sendToComission(students1.get(3), 0);
        professors.get(1).sendToComission(students1.get(3));
        professors.get(1).sendInfoAboutStudents();
        departments2.get(0).checkStudentsGrades(professors.get(1));
        professors.get(2).getSalary();
        Person professor1 = new Professor("Andrii", "Gavryliuk", 64, 191, 85, subjects.get(5), lessons2.subList(1, 3), 20000, 30, studentsGroups2.subList(2, 4));
        professor1.sayInfo();

        assistants.get(0).getSalary();
        assistants.get(1).work();
        assistants.get(2).rate(students1.get(1), 25);
        /*   assistants.get(2).rate(students1.get(1),50);*/ //exception mark is out of range//
        assistants.get(3).sayInfo();
        assistants.get(1).getExperience();

        students1.get(0).sayInfo();
        students1.get(1).applyDocs(departments2.get(4));
        students1.get(2).mySubjects();
        students1.get(3).getAttendance();
        students1.get(3).Attend();
        students1.get(3).getAttendance();
        students1.get(3).doHomework(subjects.get(2));
        students1.get(3).askQuestion(subjects.get(3));

        director.sayInfo();
        director.ratingInfo();
        director.signTheOrder();
        university.makeAnnouncement(director);
        director.getSalary();
        director.work();
        director.getExperience();

        university.infoAboutUni();

        departments2.get(0).expelStudent(students1, 0);


        departments2.get(0).registerNewStudent(new Student("Oleg", "Svyrydiuk", 19, 182, 78, 3, 4, true, subjects.subList(0, 4)), students1);
        /* departments2.get(2).registerNewStudent(null,students1);*/ //exceprtion //
        writeInfoAboutStudentsToFile(students1);
        readInfoAboutStudents();
        /*searchSubjectbyName(subjects1);*/

        rateByProfessors(students1, professors);

        Map<Student, Integer> map = new HashMap<>();
        map.put(students1.get(0), students1.get(0).getExamMark());
        map.put(students1.get(1), students1.get(1).getExamMark());
        map.put(students1.get(2), students1.get(2).getExamMark());
        map.put(students1.get(3), students1.get(3).getExamMark());
        map.put(students1.get(4), students1.get(4).getExamMark());
        map.put(students1.get(5), students1.get(5).getExamMark());
        Set<Map.Entry<Student, Integer>> entrySet = map.entrySet();

        Set keySet = map.keySet().stream().collect(Collectors.toSet());

        Set valueSet = map.values().stream().collect(Collectors.toSet());

        addBonusMarks(map, students1.subList(0, 3), 3);

        MyThread myThread = new MyThread(students1);
        Thread myRunnable = new Thread(new MyRunnable(professors));
        myThread.start();
        myRunnable.start();

        writeInfoAboutStudentsToFile(students1);
        writeInfoAboutAssistansToFile(assistants);
        writeInfoAboutDirectorToFile(director);
        writeInfoAboutUniversityToFile(university);
        writeInfoAboutStudentsGroupyToFile(studentsGroups2);
        writeInfoAboutProfessorToFile(professors);
        writeInfoAboutDepartmentsToFile(departments2);
        downloadUniversityEmblem();


     /* Reflection
       Class<Director> directorClass = Director.class;

        /*System.out.println(directorClass.getName());
        System.out.println(directorClass.getSuperclass().getName());
        System.out.println(Arrays.toString(directorClass.getInterfaces()));*/
        /*for(Constructor<?> constructor:directorClass.getConstructors()){
            System.out.println(Arrays.toString(constructor.getParameters()));
        }*/

       /* Field field = directorClass.getDeclaredField("money"); //declared because private//
        field.setAccessible(true); //break encapsulation//
        System.out.println((field.get(directors.get(0))));*/

      /*for (Field nextField : directorClass.getDeclaredFields()) {
            nextField.setAccessible(true);
            System.out.println(nextField.getName() + " = " + nextField.get(directors.get(0)));
        }*/
      /*  field.set(directors.get(0),20);
        System.out.println(directors.get(0).getRating());*/
        /*for(Method method:directorClass.getMethods()){
            System.out.println(method.getName());
            System.out.println(Arrays.toString(method.getParameters()));
            for(Parameter parameter:method.getParameters()){
                System.out.println(parameter.getType()+" "+ parameter.getName()+" ,");
            }
            System.out.println();
            System.out.println("---------------------------");
        }*/
    }
}

