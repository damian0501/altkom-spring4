package pl.altkom.shop.repo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile("dev")
@Repository
public class InMemoryProductRepoMock implements ProductRepo {

}
