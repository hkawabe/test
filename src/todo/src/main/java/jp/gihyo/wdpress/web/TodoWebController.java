package jp.gihyo.wdpress.web;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.gihyo.wdpress.domain.Task;
import jp.gihyo.wdpress.form.TaskForm;
import jp.gihyo.wdpress.service.TodoService;

@Controller // (d1)
public class TodoWebController {

	private static final String TASKS //
			= "tasks";

	private static final String REDIRECT_TO //
			= "redirect:/" + TASKS;

	@Autowired // (d2)
	TodoService todoService;

	// タスクを全件取得
	@GetMapping(value = "/tasks")
	public ModelAndView readAllTasks() { // (d3)
		TaskForm form = createInitialForm();
		ModelAndView modelAndView = toTasksPage();
		modelAndView.addObject("form", form);
		List<Task> tasks = todoService.findAllTasks();
		modelAndView.addObject(TASKS, tasks);
		return modelAndView;
	}

	private ModelAndView toTasksPage() {
		return new ModelAndView(TASKS);
	}

	private TaskForm createInitialForm() {
		String formSubject = "";
		LocalDate formDeadLine = LocalDate.now();
		Boolean isNewTask = true;
		Boolean hasDone = false;
		return new TaskForm(formSubject, formDeadLine, hasDone, isNewTask);
	}

	// タスクを1件作成
	@PostMapping(value = "/tasks") // (c1)
	public ModelAndView createOneTask(@ModelAttribute TaskForm form) { // (c2)
		createTaskFromForm(form); // (c3)
		return new ModelAndView(REDIRECT_TO);
	}

	private void createTaskFromForm(TaskForm form) {
		String subject = form.getSubject();
		LocalDate deadLine = form.getDeadLine();
		Boolean hasDone = form.getHasDone();
		Task task = new Task(subject, deadLine, hasDone);
		todoService.createTask(task);
	}

	// タスクを1件取得
	@GetMapping(value = "/tasks/{id}") // (c1)
	public ModelAndView readOneTask(@PathVariable Integer id) { // (c2)
		Optional<TaskForm> form = readTaskFromId(id);
		if (!form.isPresent()) { // (c3)
			return new ModelAndView(REDIRECT_TO);
		}
		ModelAndView modelAndView = toTasksPage();
		modelAndView.addObject("taskId", id); // (c4)
		modelAndView.addObject("form", form.get()); // (c5)
		List<Task> tasks = todoService.findAllTasks();
		modelAndView.addObject(TASKS, tasks); // (c6)
		return modelAndView;
	}

	private Optional<TaskForm> readTaskFromId(Integer id) {
		Optional<Task> task = todoService.findOneTask(id);
		if (!task.isPresent()) {
			return Optional.ofNullable(null);
		}
		String formSubject = task.get().getSubject();
		LocalDate formDeadLine = task.get().getDeadLine();
		Boolean hasDone = task.get().getHasDone();
		Boolean isNewTask = false;
		TaskForm form = new TaskForm(formSubject, formDeadLine, hasDone, isNewTask);
		return Optional.ofNullable(form);
	}

	// タスクを1件更新
	@PutMapping(value = "/tasks/{id}") // (c1)
	public ModelAndView updateOneTask(@PathVariable Integer id, // (c2)
			@ModelAttribute TaskForm form) { // (c3)
		updateTask(id, form); // (c4)
		return new ModelAndView(REDIRECT_TO);
	}

	private void updateTask(Integer id, TaskForm form) {
		String subject = form.getSubject();
		LocalDate deadLine = form.getDeadLine();
		Boolean hasDone = form.getHasDone();
		Task task = new Task(id, subject, deadLine, hasDone);
		todoService.updateTask(task);
	}

	@DeleteMapping(value = "/tasks/{id}") // (c1)
	public ModelAndView deleteOneTask(@PathVariable Integer id) { // (c2)
		deleteTask(id); // (c3)
		return new ModelAndView(REDIRECT_TO);
	}

	private void deleteTask(Integer id) {
		Optional<Task> task = todoService.findOneTask(id);
		if (task.isPresent()) {
			todoService.deleteTask(id);
		}
	}

}
