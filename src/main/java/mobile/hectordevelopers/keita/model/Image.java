package mobile.hectordevelopers.keita.model;

import javax.persistence.*;

/**
 * @author Abbas Irekeola
 * @Email abbasirekeola@gmail.com
 * 26/05/2021-21:15
 */

@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Lob
    private byte[] data;

    public String externalReferencePath;
    public String description;
    public Boolean inUse;

    public String contentType;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getExternalReferencePath() {
        return externalReferencePath;
    }

    public void setExternalReferencePath(String externalReferencePath) {
        this.externalReferencePath = externalReferencePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getInUse() {
        return inUse;
    }

    public void setInUse(Boolean inUse) {
        this.inUse = inUse;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
