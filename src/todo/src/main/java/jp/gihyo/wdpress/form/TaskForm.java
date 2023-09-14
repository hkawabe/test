package jp.gihyo.wdpress.form;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // (d1)
@AllArgsConstructor
public class TaskForm {

	String subject; // (d2)

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate deadLine; // (d3)

	Boolean hasDone; // (d4)

	Boolean isNewTask; // (d5)

}
