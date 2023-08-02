package chatgpt.chatgpt.Entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DatePlace {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String keyword;
    private String address;
    @Builder
    public DatePlace(Long id, String name, String keyword, String address) {
        this.id = id;
        this.name = name;
        this.keyword = keyword;
        this.address = address;
    }
}
