public class User {
    private int id;
    private String firstName;
    private String secondName;
    private UserRoleEnum role;
    private OrgStructure org;
    private String position;

    public User(int id, String firstName, String secondName, UserRoleEnum role, OrgStructure org, String position) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.role = role;
        this.org = org;
        this.position = position;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }

    public OrgStructure getOrg() {
        return org;
    }

    public void setOrg(OrgStructure org) {
        this.org = org;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
