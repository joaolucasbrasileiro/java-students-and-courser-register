package entities;

public class Users implements Comparable<Users> {

    private static int idCounter = 1;
    private Integer id;
    private String name;

    public Users() {}

    public Users(String name) {
        this.id = idCounter++;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[id=" + id + " | " + name + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        if (id != null ? !id.equals(users.id) : users.id != null) return false;
        return true;
    }
    @Override
    public int compareTo(Users o) {
        return this.name.compareTo(o.name);
    }

}
