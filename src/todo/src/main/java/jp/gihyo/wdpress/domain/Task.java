package jp.gihyo.wdpress.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity // (d1)
@Table(name = "task") // (d2)
@Data // (d3)
@AllArgsConstructor // (d4)
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;

	String subject;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate deadLine;

	Boolean hasDone;

	public Task() {
	}

	public Task(String subject, LocalDate deadLine, Boolean hasDone) {
		this.subject = subject;
		this.deadLine = deadLine;
		this.hasDone = hasDone;
	}

}
