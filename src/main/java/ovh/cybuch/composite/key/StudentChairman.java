package ovh.cybuch.composite.key;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;

import lombok.Getter;
import lombok.Value;

@Getter
class StudentChairman implements Persistable {

	@Id
	private CompositeKey id;

	@CreatedDate
	private Instant createdDate;
	
	StudentChairman(String studentId, String groupId) {
		id = new CompositeKey(studentId, groupId);
	}
	
	private StudentChairman() {}

	@Override
	public boolean isNew() {
		return createdDate == null;
	}
	
	StudentChairmanDto dto() {
		return new StudentChairmanDto(id.studentId, id.groupId, createdDate);
	}

	@Value
	static class CompositeKey implements Serializable {
		private String studentId;
		private String groupId;
	}
}
