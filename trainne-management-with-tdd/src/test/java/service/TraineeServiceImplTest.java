package service;

import com.trmgapp.model.Trainee;
import com.trmgapp.repository.TraineeRepository;
import com.trmgapp.repository.TraineeRepositoryImpl;
import com.trmgapp.service.TraineeService;
import com.trmgapp.service.TraineeServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TraineeServiceImplTest {

    @InjectMocks
    TraineeServiceImpl service;

    @Mock
    TraineeRepositoryImpl traineeRepository;

    @Test
    public void testSave(){
        // Given
        Trainee t1 =  new Trainee(1,"Karan","karan@yahoo.com");
        // When
        Mockito.when(traineeRepository.save(t1)).thenReturn(t1);
        // Then
        Assertions.assertEquals(t1,service.save(t1));
        // Verify
        Mockito.verify(traineeRepository, Mockito.times(1)).save(t1);
    }


    @Test
    public void testDelete(){
        // Given
        int id = 1;
        // When
        Mockito.doNothing().when(traineeRepository).delete(id);
        // Then
        service.delete(id);
        // Verify
        Mockito.verify(traineeRepository, Mockito.times(1)).delete(1);

    }


    @Test
    public void testFindById(){
        // Given
        int id = 1;
        Trainee t1 = new Trainee(id,"Rahul","rahul@yahoo.com");
        // When
        Mockito.when(traineeRepository.findById(id)).thenReturn(t1);
        // Then
        service.findById(id);
        // Verify
        Mockito.verify(traineeRepository, Mockito.times(1)).findById(1);

    }


    @Test
    public void testFindAll(){
        // Given
        List<Trainee> trainees = List.of(
            new Trainee(1,"Karan","karan@yahoo.com"),
            new Trainee(2,"Rahul","rahul@yahoo.com"),
            new Trainee(3,"Rohit","rohit@yahoo.com")
        );
        // When
        Mockito.when(traineeRepository.findAll()).thenReturn(trainees);
        // Then
        service.findAll();
        // Verify
        Mockito.verify(traineeRepository, Mockito.times(1)).findAll();

    }



}
