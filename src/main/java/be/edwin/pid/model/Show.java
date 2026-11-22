
package be.edwin.pid.model;

import com.github.slugify.Slugify;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "shows")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String slug;

    private String title;
    private String description;

    @Column(name = "poster_url")
    private String posterUrl;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    private boolean bookable;
    private double price;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Show() {
    }

    public Show(String title, String description, String posterUrl,
                Location location, boolean bookable, double price) {

        Slugify slg = new Slugify();

        this.slug = slg.slugify(title);
        this.title = title;
        this.description = description;
        this.posterUrl = posterUrl;
        this.bookable = bookable;
        this.price = price;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = null;

        setLocation(location);
    }

    public Long getId() {
        return id;
    }

    public String getSlug() {
        return slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        this.slug = new Slugify().slugify(title);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        if (this.location == location) {
            return;
        }

        Location ancienneLocation = this.location;
        this.location = location;

        if (ancienneLocation != null) {
            ancienneLocation.removeShow(this);
        }

        if (location != null) {
            location.addShow(this);
        }
    }

    public boolean isBookable() {
        return bookable;
    }

    public void setBookable(boolean bookable) {
        this.bookable = bookable;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Show [id=" + id
                + ", slug=" + slug
                + ", title=" + title
                + ", description=" + description
                + ", bookable=" + bookable
                + ", price=" + price + "]";
    }
}
