package Modal;

import java.io.Serializable;

/**
 * Created by kuush on 12/12/2016.
 */

public class PP implements Serializable {

    private String sno;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    private String filename;
    private String Name;
}
