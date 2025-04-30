import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empNum;
    private String firstName;
    private String lastName;
    private String title;
    private String phoneNumber;
    private String email;
    private LocalDate hireDate;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;


    @OneToMany(mappedBy = "manager")
    private List<Employee> directReports;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

}
