package ovh.cybuch.composite.key;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StudentChairmanDto {
	private String studentId;
	private String groupId;
	private Instant createdDate;
}
