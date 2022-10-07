package com.taskCreator.demo.repositories;

import com.taskCreator.demo.models.de.TaskDE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITaskRepository extends JpaRepository<TaskDE, Long> {
    Optional<TaskDE> findByName(String name);
}
