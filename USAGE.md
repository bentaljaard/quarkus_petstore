# Using the quarkus generator for generating an application based on an OpenAPi specification

1. Clone the https://github.com/bentaljaard/openapi-generator repo
2. Run mvn clean package -DskipTests=true to compile the custom generator
3. Clone this repo to a location (only need to keep the api-spec folder if you want to generate from scratch)
4. run the generator:

```
java -jar modules/openapi-generator-cli/target/openapi-generator-cli.jar generate -g java-quarkus -i ../petstore/api-spec/petstore.yaml  -o ../petstore -c ../petstore/api-spec/server-generator-config.yaml --ignore-file-override=../petstore/api-spec/openapi-server-ignore
````
