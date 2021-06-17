package id.co.javan.news.entity;

public class Berita {
    private Integer id;
    private String judul;
    private String slug;
    private String content;
    private Integer published;
    private String createdBy;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPublished(Integer published) {
        this.published = published;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getId() {
        return id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getContent() {
        return content;
    }

    public String getJudul() {
        return judul;
    }

    public Integer getPublished() {
        return published;
    }

    public String getSlug() {
        return slug;
    }
}
