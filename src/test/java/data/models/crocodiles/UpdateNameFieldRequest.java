package data.models.crocodiles;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateNameFieldRequest implements Serializable
{

    @SerializedName("name")
    @Expose
    private String name;
    private final static long serialVersionUID = 4572052671738494664L;

    public UpdateNameFieldRequest() {
    }

    public UpdateNameFieldRequest(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}