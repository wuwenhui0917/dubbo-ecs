/**
 * Created by Administrator on 2017/7/28.
 */
public class Bean1 {
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name="+this.name+",sex="+this.sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private int sex;

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
