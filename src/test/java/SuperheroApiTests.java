import controllers.SuperheroController;
import dto.Superhero;
import io.restassured.response.Response;
import net.datafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuperheroApiTests extends SuperheroController {
    static Faker faker = new Faker();

    public static Superhero positiveHero() {
        return Superhero.builder()
                .fullName(faker.superhero().name())
                .birthDate(faker.timeAndDate().birthday("YYYY-MM-dd"))
                .phone(faker.phoneNumber().phoneNumber())
                .mainSkill(faker.superhero().power())
                .city(faker.address().city())
                .gender("M")
                .build();
    }

    public String generateSuperheroId() {
        Superhero superhero = positiveHero();
        Response response = createSuperhero(superhero);
        Superhero superheroCreated = response.as(Superhero.class);
        return Integer.toString(superheroCreated.getId());
    }

    @Test
    public void createSuperheroPositiveApiTest() {
        Superhero superhero = positiveHero();
        System.out.println(superhero);

        Response response = createSuperhero(superhero);
        System.out.println(response.getBody().asString());

        Superhero superheroCreated = response.as(Superhero.class);
        System.out.println(superheroCreated.toString());

        Assert.assertEquals(createSuperhero(superhero).getStatusCode(), 200);
    }

    @Test
    public void getAllSuperheroesPositiveApiTest() {
        Assert.assertEquals(getAllSuperheroes().getStatusCode(), 200);
    }

    @Test
    public void getSuperheroByIdPositiveApiTest() {
        Assert.assertEquals(getSuperheroByID(generateSuperheroId())
                .getStatusCode(), 200);
    }

    @Test
    public void deleteSuperheroByIdPositiveApiTest() {
        Assert.assertEquals(deleteSuperheroByID(generateSuperheroId())
                .getStatusCode(), 200);
    }
}
