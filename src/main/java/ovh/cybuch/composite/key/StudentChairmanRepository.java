package ovh.cybuch.composite.key;

import org.springframework.data.repository.Repository;

import ovh.cybuch.composite.key.StudentChairman.CompositeKey;

interface StudentChairmanRepository extends Repository<StudentChairman, CompositeKey> {
	
	StudentChairman save(StudentChairman entity);
	
	StudentChairman findOne(CompositeKey id);
	
	default StudentChairman save(String studentId, String groupId) {
		StudentChairman studentChairman = new StudentChairman(studentId, groupId);
		return save(studentChairman);
	}
	
	default StudentChairman findOne(String studentId, String groupId) {
		CompositeKey id = new CompositeKey(studentId, groupId);
		return findOne(id);
	}
}     