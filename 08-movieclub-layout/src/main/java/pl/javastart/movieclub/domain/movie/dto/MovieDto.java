package pl.javastart.movieclub.domain.movie.dto;

public class MovieDto {
    private Long id;
    private String title;
    private String originalTitle;
    private Integer releaseYear;
    private String genre;
    private boolean promoted;

    public MovieDto(Long id, String title, String originalTitle, Integer releaseYear, String genre, boolean promoted) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.promoted = promoted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }
}
