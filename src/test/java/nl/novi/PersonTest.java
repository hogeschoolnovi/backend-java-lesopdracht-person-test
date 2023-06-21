package nl.novi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    Person person;
    Person johnDoe;
    
    // Deze methode runt voorafgaand aan elke test, door de BeforeEach annotatie. 
    // Deze methode is dus ideaal voor het opzetten van testdata, zodat je dat niet in elke test opnieuw hoeft te doen.
    @BeforeEach
    void setUp() {
        person = new Person("testman");
        johnDoe = new Person();
    }

    @Test
    void getName() {
        //Arrange (setUp())
        //Act
        String result = person.getName();
        //Assert
        assertEquals("testman", result);
    }

    @Test
    void nameShouldNotBeChangedDuringCreation(){
        //Arrange (setUp())
        //Act
        //Assert
        assertEquals("testman", person.getName());
    }

    @Test
    void personWithoutNameShouldBeNamedJohn(){
        //Arrange (setUp())
        //Act
        String result = johnDoe.getName();
        //Assert
        assertEquals("John", johnDoe.getName());
        assertEquals("Doe", johnDoe.getLastName());
    }

    @Test
    void setName() {
        //Arrange (setUp())
        //Act
        person.setName("novi");
        String result = person.getName();
        //Assert
        assertEquals("novi",result);
    }

    @Test
    void getLastNameIsNull() {
        //Arrange (setUp())
        //Act
        String result = person.getLastName();
        //Assert
        assertNull(result);
    }

    @Test
    void setLastName() {
        //Arrange (setUp())
        //Act
        person.setLastName("Jansen");
        String result = person.getLastName();
        //Assert
        assertEquals("Jansen", result);
    }

    @Test
    void lastNameShouldShouldStartWithUpperCaseWhenLowerCaseGiven(){
        //Arrange (setUp())
        //Act
        person.setLastName("lastname");
        String result = person.getLastName();
        //Assert
        assertEquals("Lastname", result);
    }

    @Test
    void getAgeIsNull() {
        //Arrange (setUp())
        //Act
        int result = person.getAge();
        //Assert
        assertEquals(0, result);
    }

    @Test
    void setAge() {
        //Arrange (setUp())
        //Act
        person.setAge(1);
        int result = person.getAge();
        //Assert
        assertEquals(1, result);
    }

    @Test
    void ageShouldAddOneYear() {
        //Arrange (setUp())
        person.setAge(1);
        //Act
        person.age();
        int result = person.getAge();
        //Assert
        assertEquals(2, result);
    }

    // Voor de assert in deze methode moet je in de Person class de equals() methode hebben overschreven.
    @Test
    void getPartner() {
        //Arrange (setUp())
        person.setPartner(johnDoe);
        //Act
        Person result = person.getPartner();
        //Assert
        assertEquals(johnDoe, result);
    }

    @Test
    void setPartner() {
        //Arrange (setUp())
        //Act
        person.setPartner(johnDoe);
        Person result = person.getPartner();
        //Assert
        assertEquals(johnDoe, result);
    }

    @Test
    void givenNoPartnerHasPartnerShouldReturnFalse() {
        //Arrange (setUp())
        //Act
        boolean result = person.hasPartner();
        //Assert
        assertFalse(result);
    }

    @Test
    void givenAPartnerHasPartnerShouldReturnTrue() {
        //Arrange (setUp())
        person.setPartner(johnDoe);
        //Act
        boolean result = person.hasPartner();
        //Assert
        assertTrue(result);
    }

    @Test
    void childShouldBeAddedToList() {
        //Arrange (setUp())
        //Act
        person.addChild(johnDoe);
        List<Person> result = person.getChildren();
        //Assert
        assertEquals(List.of(johnDoe), result);
    }

    @Test
    void shouldNotAddChildWithSameName() {
        //Arrange (setUp())
        person.addChild(johnDoe);
        person.addChild(johnDoe);
        //Act
        List<Person> result = person.getChildren();
        //Assert
        assertEquals(List.of(johnDoe), result);

    }

    @Test
    void setChildren() {
        //Arrange (setUp())
        Person child = new Person("child");
        List<Person> toAdd = new ArrayList<>();
        toAdd.add(johnDoe);
        toAdd.add(child);
        //Act
        person.setChildren(toAdd);
        List<Person> result = person.getChildren();
        //Assert
        assertEquals(toAdd, result);
    }
}
