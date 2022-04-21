package com.kashigin.stanislav.entity;



import javax.persistence.*;

@Entity
@Table(name = "org_structure", schema = "project")
public class OrgStructure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private User head;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private OrgStructure parent;

    public OrgStructure(Long id, String name, User head, OrgStructure parent) {
        this.id = id;
        this.name = name;
        this.head = head;
        this.parent = parent;
    }

    public OrgStructure() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getHead() {
        return head;
    }

    public void setHead(User head) {
        this.head = head;
    }

    public OrgStructure getParent() {
        return parent;
    }

    public void setParent(OrgStructure parent) {
        this.parent = parent;
    }
}
