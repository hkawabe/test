package jp.gihyo.wdpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.gihyo.wdpress.domain.Task;

@Repository
public interface TodoRepository extends JpaRepository<Task, Integer> {
}
