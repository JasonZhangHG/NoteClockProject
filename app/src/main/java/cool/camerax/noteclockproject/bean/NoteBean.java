package cool.camerax.noteclockproject.bean;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

@Entity
public class NoteBean implements Parcelable {
    @Id(autoincrement = false)
    public long creatTimeAsId;  //把创建时间作为表的ID
    @Property(nameInDb = "NoteBean")
    public String title;
    public String value;
    public int grade;
    private long clockTime;
    private String showClockTime;

    @Generated(hash = 1843229060)
    public NoteBean(long creatTimeAsId, String title, String value, int grade,
                    long clockTime, String showClockTime) {
        this.creatTimeAsId = creatTimeAsId;
        this.title = title;
        this.value = value;
        this.grade = grade;
        this.clockTime = clockTime;
        this.showClockTime = showClockTime;
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

    public long getClockTime() {
        return this.clockTime;
    }

    public void setClockTime(long clockTime) {
        this.clockTime = clockTime;
    }

    public String getShowClockTime() {
        return this.showClockTime;
    }

    public void setShowClockTime(String showClockTime) {
        this.showClockTime = showClockTime;
    }

    @Override
    public String toString() {
        return "NoteBean{" +
                "creatTimeAsId=" + creatTimeAsId +
                ", title='" + title + '\'' +
                ", value='" + value + '\'' +
                ", grade=" + grade +
                ", clockTime=" + clockTime +
                ", showClockTime='" + showClockTime + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.creatTimeAsId);
        dest.writeString(this.title);
        dest.writeString(this.value);
        dest.writeInt(this.grade);
        dest.writeLong(this.clockTime);
        dest.writeString(this.showClockTime);
    }

    protected NoteBean(Parcel in) {
        this.creatTimeAsId = in.readLong();
        this.title = in.readString();
        this.value = in.readString();
        this.grade = in.readInt();
        this.clockTime = in.readLong();
        this.showClockTime = in.readString();
    }

    public static final Creator<NoteBean> CREATOR = new Creator<NoteBean>() {
        @Override
        public NoteBean createFromParcel(Parcel source) {
            return new NoteBean(source);
        }

        @Override
        public NoteBean[] newArray(int size) {
            return new NoteBean[size];
        }
    };
}
