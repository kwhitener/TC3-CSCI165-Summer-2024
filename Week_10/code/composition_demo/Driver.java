public class Driver {
    
    public static void main(String[] args) {
        
        // to use the Student(String name, String major, Date dateEnrolled)
        // constructor, you first need a few objects
        Date enrolled   = new Date(9, 1, 2024);
        String name     = "Frank N. Stein";
        String major    = "Computer Science";

        Student s1 = new Student(name, major, enrolled);
        System.out.println(s1); // there is a weird issue here with the Dates

        // chain methods of embedded objects
        Date g = s1.getExpectedGrad();
        int year = g.getYear();

        int gradYear = s1.getDateEnrolled().getYear();
        System.out.println(s1.getName() + " enrolled in " + gradYear);

        // assign the student an advisor. Need a Faculty object first
        Faculty advisor = new Faculty("Tony Iommi", "Computer Science", "Professor");
        s1.setAdvisor(advisor);

        // use method chaining to get the advisor's name
        System.out.println(s1.getName() + "'s advisor is: " + s1.getAdvisor().getName());


        // DEMONSTRATE PRIVACY LEAKS
        Date grad = s1.getExpectedGrad(); // this is a privacy leak
        grad.setYear(1900);

        System.out.println(s1);

        Date expGrad = new Date(9, 1, 2030);
        s1.setExpectedGrad(expGrad);
        expGrad.setYear(1900);
        System.out.println(s1);

        Date enrol = s1.getDateEnrolled();
        enrol.setYear(2112);
        System.out.println(s1);
    }
}
