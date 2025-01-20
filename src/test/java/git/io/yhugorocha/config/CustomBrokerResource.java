package git.io.yhugorocha.config;

import io.quarkus.test.common.QuarkusTestResourceConfigurableLifecycleManager;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

import java.util.Map;

public class CustomBrokerResource implements
        QuarkusTestResourceConfigurableLifecycleManager<WithCustomBroker> {

    DockerImageName image = DockerImageName.parse("postgres:17");
    PostgreSQLContainer<?> service = new PostgreSQLContainer<>(image);

    private String nameDataBase;
    private String username;
    private String password;
    private String port;

    @Override
    public void init( WithCustomBroker params ) {
        nameDataBase = params.nameDatabase();
        username = params.username();
        password = params.password();
        port = params.port();
    }

    @Override
    public Map<String, String> start() {
        service
                .withDatabaseName(nameDataBase)
                .withUsername(username)
                .withPassword(password)
                .withExposedPorts(Integer.parseInt(port))
                .start();
        return Map.of(
                "quarkus.datasource.username", username,
                "quarkus.datasource.password", password,
                "quarkus.datasource.jdbc.url", service.getJdbcUrl()
        );
    }

    @Override
    public void stop() {
        service.stop();
    }
}
