package jp.gihyo.wdpress.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.gihyo.wdpress.domain.Task;
import jp.gihyo.wdpress.repository.TodoRepository;

@Service // (d1)
public class TodoService {

	@Autowired // (d2)
	TodoRepository todoRepository;

	@Transactional(readOnly = true)
	public List<Task> findAllTasks() { // (d3)
		List<Task> allTasks = todoRepository.findAll();
		allTasks.sort(Comparator.comparing(Task::getDeadLine));
		return allTasks;
	}

	@Transactional(readOnly = false)
	public Task createTask(Task task) { // (d4)
		return todoRepository.save(task);
	}

	@Transactional(readOnly = true)
	public Optional<Task> findOneTask( // (d5)
			Integer id) {
		return todoRepository.findById(id);
	}

	@Transactional(readOnly = false)
	public Task updateTask(Task task) { // (d6)
		return todoRepository.save(task);
	}

	@Transactional(readOnly = false)
	public void deleteTask(Integer id) { // (d7)
		todoRepository.deleteById(id);
	}
}
