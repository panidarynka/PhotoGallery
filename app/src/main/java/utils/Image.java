package utils;

/**
 * Created by dasha on 15.08.16.
 */
public class Image {
    public String title;
    public int id;

    public Image(String title, int id) {
        this.title = title;
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
