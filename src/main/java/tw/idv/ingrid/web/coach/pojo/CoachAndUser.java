package tw.idv.ingrid.web.coach.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tw.idv.ingrid.web.user.pojo.User;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CoachAndUser {
	private CoachProfiles coachProfiles;
	private User user;
}
