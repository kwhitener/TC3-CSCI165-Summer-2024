public class PrivacyLeakDriver {

    public static void main(String[] args) {
        
        Date hired = new Date(1, 4, 2020);
        Employee emp1 = new Employee("Ozzy", "Osborne", "123-45-6789", "jr. developer",45000, hired);
        
        emp1.setDateTerminated(new Date(1, 12, 2020));
        System.out.println(emp1);

        // exploit privacy leak
        Date d = emp1.getDateTerminated();
        d.setYear(1996);
        System.out.println(emp1);
    }
    
}
