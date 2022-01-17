package model;

import java.util.Objects;

public class Author {
    private Long authorId;
    private Name authorName;
    private String nationality;
    private Birth birth;
    private String authorDescription;

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setBirth(Birth birth) {
        this.birth = birth;
    }

    public void setAuthorDescription(String authorDescription) {
        this.authorDescription = authorDescription;
    }

    public void setAuthorName(Name authorName) {
        this.authorName = authorName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Author))
            return false;
        Author a = (Author) o;
        return a.authorId == authorId && a.authorName.equals(authorName)
                && a.nationality.equals(nationality) && a.birth.equals(birth)
                && a.authorDescription.equals(authorDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, authorName, nationality, birth, authorDescription);
    }
}
