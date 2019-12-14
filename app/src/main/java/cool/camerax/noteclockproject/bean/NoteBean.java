package cool.camerax.noteclockproject.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class NoteBean {
    @Id(autoincrement = false)
    public long creatTimeAsId;  //把创建时间作为表的ID
    @Property(nameInDb = "NoteBean")
    public String title;
    public String value;
    public int grade;

    @Generated(hash = 2042766287)
    public NoteBean(long creatTimeAsId, String title, String value, int grade) {
        this.creatTimeAsId = creatTimeAsId;
        this.title = title;
        this.value = value;
        this.grade = grade;
    }

    @Generated(hash = 451626881)
    public NoteBean() {
    }

    public long getCreatTimeAsId() {
        return this.creatTimeAsId;
    }

    public void setCreatTimeAsId(long creatTimeAsId) {
        this.creatTimeAsId = creatTimeAsId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getGrade() {
        return this.grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "NoteBean{" +
                "creatTimeAsId=" + creatTimeAsId +
                ", title='" + title + '\'' +
                ", value='" + value + '\'' +
                ", grade=" + grade +
                '}';
    }
}
