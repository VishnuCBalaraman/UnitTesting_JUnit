package service;

import com.trmgapp.model.Trainee;
import com.trmgapp.repository.TraineeRepositoryImpl;
import com.trmgapp.service.TraineeServiceImpl;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


public class TraineeServiceImplIntegrationTest {


    TraineeServiceImpl service;

    @BeforeEach
    public void setUp(){
        this.service = new TraineeServiceImpl();
    }


    @Test
    public void testSave(){
        // Given
        Trainee t1 =  new Trainee(1,"Karan","karan@yahoo.com");
        // Then
        Assertions.assertEquals(t1,service.save(t1));

    }


    @Test
    public void testDelete(){
        // Given
        int id = 1;
        // When

        // Then
        service.delete(id);

    }


    @Test
    public void testFindById(){
        // Given
        int id = 1;
        // When

        // Then
        Assertions.assertNotNull(service.findById(id));

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

        // Then
        Assertions.assertEquals(trainees,service.findAll());


    }



}
