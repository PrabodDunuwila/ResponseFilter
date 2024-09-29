# ResponseFilter

## Deploying the JAR File

After building the project, you can deploy the `request-filter.jar` in the `<IS-HOME>/repository/components/lib` directory.

## Adding Configurations

In the `<IS-HOME>/repository/conf/deployment.toml` file, make the following changes:

```toml
[[tomcat.filter]]
name = "RequestFilter"
class = "org.example.RequestFilter"

[[tomcat.filter_mapping]]
name = "RequestFilter"
url_pattern = "/*"
```
If you need to read further on this, please read the article [here](https://praboddunuwila.medium.com/4e6a828ce082).