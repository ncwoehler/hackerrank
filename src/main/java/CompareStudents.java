import java.util.ArrayList;
import java.util.List;

//Complete the code
class CompareStudents
{

    static class Student{
        private int id;
        private String fname;
        private double cgpa;
        public Student(int id, String fname, double cgpa) {
            super();
            this.id = id;
            this.fname = fname;
            this.cgpa = cgpa;
        }
        public int getId() {
            return id;
        }
        public String getFname() {
            return fname;
        }
        public double getCgpa() {
            return cgpa;
        }
    }

    public static void main(String[] args){
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student(3, "Akshum", 3.68));
        studentList.add(new Student(1, "Akshum", 3.68));
        studentList.add(new Student(2, "Akshum", 3.68));

        studentList.sort((s1, s2) -> {
            int cgpaDiff = Double.compare(s1.getCgpa(), s2.getCgpa());
            if (cgpaDiff == 0) {
                int nameComp = s1.getFname().compareTo(s2.getFname());
                if(nameComp == 0){
                   return Integer.compare(s1.getId(), s2.getId());
                }
                return nameComp;
            }
            return cgpaDiff;
        });

        for(Student st: studentList){
            System.out.println(st.getFname() + st.getId());
        }
        System.exit(0);
    }
}



