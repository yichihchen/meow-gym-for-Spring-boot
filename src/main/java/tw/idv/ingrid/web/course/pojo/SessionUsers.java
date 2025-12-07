package tw.idv.ingrid.web.course.pojo;





import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SESSION_USERS")
@IdClass(SessionUsersId.class)
public class SessionUsers {
	@Id
	@Column(name = "SESSION_ID")
	private Integer sessionId;
	@Id
	@Column(name = "USER_ID")
	private Integer userId;
}
