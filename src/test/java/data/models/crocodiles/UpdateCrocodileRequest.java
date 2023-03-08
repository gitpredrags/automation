package data.models.crocodiles;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateCrocodileRequest implements Serializable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("sex")
    @Expose
    private Object sex;
    @SerializedName("date_of_birth")
    @Expose
    private Object dateOfBirth;
    private final static long serialVersionUID = -2935748678502921318L;


    public UpdateCrocodileRequest() {
    }

    public UpdateCrocodileRequest(String name, Object sex, Object dateOfBirth) {
        super();
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getSex() {
        return sex;
    }

    public void setSex(Object sex) {
        this.sex = sex;
    }

    public Object getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Object dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}