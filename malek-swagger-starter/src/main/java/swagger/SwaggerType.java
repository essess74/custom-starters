package swagger;

public enum SwaggerType {
    SWAGGER_2("swagger", "2.0"),
    SWAGGER_12("swagger", "1.2"),
    SPRING_WEB("spring-web", "1.0");
    private String type, version;

    SwaggerType(String type, String version) {
        this.type = type;
        this.version = version;
    }

    public String getType() {
        return type;
    }

    public String getVersion() {
        return version;
    }
}
