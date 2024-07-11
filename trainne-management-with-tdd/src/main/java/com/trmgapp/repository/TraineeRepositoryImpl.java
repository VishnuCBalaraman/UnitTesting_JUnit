package com.trmgapp.repository;

import com.trmgapp.model.Trainee;

import java.util.ArrayList;
import java.util.List;

public class TraineeRepositoryImpl implements TraineeRepository {

    private List<Trainee> trainees;
    private static volatile TraineeRepositoryImpl instance;

    private TraineeRepositoryImpl() {
        this.trainees = new ArrayList<>();
    }

    public static TraineeRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new TraineeRepositoryImpl();
        }
        return instance;
    }

    @Override
    public Trainee save(Trainee trainee) {
        trainees.add(trainee);
        return trainee;
    }

    @Override
    public void delete(int id) {
        trainees.removeIf(t->t.getId()==id);
    }

    @Override
    public Trainee findById(int id) {
        return trainees.stream().filter(t->t.getId()==id).findFirst().orElse(null);
    }

    @Override
    public List<Trainee> findAll() {
        return new ArrayList<>(trainees);
    }
}
