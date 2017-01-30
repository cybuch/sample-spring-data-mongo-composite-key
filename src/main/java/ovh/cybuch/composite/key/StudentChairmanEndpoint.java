package ovh.cybuch.composite.key;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;

@RestController
@RequestMapping("/students")
class StudentChairmanEndpoint {

	private final StudentChairmanRepository studentChairmanRepository;

	StudentChairmanEndpoint(StudentChairmanRepository studentChairmanRepository) {
		Preconditions.checkNotNull(studentChairmanRepository);
		this.studentChairmanRepository = studentChairmanRepository;
	}

	@PostMapping("{studentId}/group/{groupId}")
	ResponseEntity<StudentChairmanDto> promoteToChairman(@PathVariable String studentId,
													     @PathVariable String groupId) {
		StudentChairman studentChairman = studentChairmanRepository.save(studentId, groupId);
		URI studentChairmanLocation = fromUriString("/students/" + studentChairman.getId().getStudentId() + "/group/" + studentChairman.getId().getGroupId()).build().toUri();
		return created(studentChairmanLocation).body(studentChairman.dto());
	}

	@GetMapping("{studentId}/group/{groupId}")
	ResponseEntity<StudentChairmanDto> getChairman(@PathVariable String studentId,
			 									   @PathVariable String groupId) {
		StudentChairman studentChairman = studentChairmanRepository.findOne(studentId, groupId);
		if (studentChairman == null) {
			return new ResponseEntity<>(NOT_FOUND);
		}
		return ok().body(studentChairman.dto());
	}
}
