package swagger;

import org.springframework.boot.context.properties.ConfigurationProperties;
import springfox.documentation.spi.DocumentationType;

@ConfigurationProperties("malek.swagger")
public class SwaggerProperties {

    private String basePackages = "";
    private SwaggerType type = SwaggerType.SWAGGER_2;

    public String getBasePackages() {
        return basePackages;
    }

    public void setBasePackages(String basePackages) {
        this.basePackages = basePackages;
    }

    DocumentationType getDocumentationType() {
        return new DocumentationType(type.getType(), type.getVersion());
    }

    public SwaggerType getType() {
        return type;
    }

    public void setType(SwaggerType type) {
        this.type = type;
    }
}
