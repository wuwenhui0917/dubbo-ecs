/**
 * Created by Administrator on 2017/7/28.
 */
public class Bean2 {
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name="+this.name+" :age="+this.age+":sex="+this.sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private String age;
    private int sex;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
