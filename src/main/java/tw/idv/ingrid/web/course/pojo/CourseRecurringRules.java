package tw.idv.ingrid.web.course.pojo;




import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tw.idv.ingrid.core.pojo.Core;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "COURSE_RECURRING_RULES")
public class CourseRecurringRules extends Core {
	private static final long serialVersionUID = 2656068127653219211L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RULE_ID")
	private Integer ruleId;
	@Column(name = "COURSE_ID")
	private Integer courseId;
	@Column(name = "WEEKDAY")
	private Integer weekday;
	@Column(name = "TIME_SLOT")
	private Integer timeSlot;
}
