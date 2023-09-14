package test;

/**
 * @author GxDong
 * @createTime 2023/08/01 16:58
 * @className Student
 */
public class Student {
    private String name;
    private String time;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
