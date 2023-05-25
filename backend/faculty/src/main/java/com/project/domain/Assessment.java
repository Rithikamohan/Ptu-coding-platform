package com.project.domain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_assessment")
public class Assessment {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String question;

	    private String testCase;
	    private String Facultyname;

		public String getFacultyname() {
			return Facultyname;
		}

		public void setFacultyname(String facultyname) {
			Facultyname = facultyname;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getQuestion() {
			return question;
		}

		public void setQuestion(String question) {
			this.question = question;
		}

		public String getTestCase() {
			return testCase;
		}

		public void setTestCase(String testCase) {
			this.testCase = testCase;
		}
}
