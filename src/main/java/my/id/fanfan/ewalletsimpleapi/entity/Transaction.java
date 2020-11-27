package my.id.fanfan.ewalletsimpleapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sender")
    private String sender;
    @Column(name = "recipent")
    private String recipient;
    @Column(name = "value")
    private Long value;
}
