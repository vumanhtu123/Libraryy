package net.fpl.Tuvmph18579.DTO;

public class BaiViet {
    String title;
    String description;
    String link;
    String pubdate;
    String img;

    public BaiViet() {
    }

    public BaiViet(String title, String description, String link, String pubdate, String img) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.pubdate = pubdate;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
