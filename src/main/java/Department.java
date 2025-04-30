import javax.persistence.*;


@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dptNum;
    private String name;

    @OneToOne
    @JoinColumn(name="manager_id")
    private Employee manager;
}
