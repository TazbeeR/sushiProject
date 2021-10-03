package pl.coderslab.sushiProject;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "pl.coderslab")
@EnableTransactionManagement
public class AppConfig {

//    public Set<Converter> getConverters() {
//        Set<Converter> converters = new HashSet<>();
//        converters.add(new AuthorConverter());
//        return converters;
//    }
//
//    @Bean(name = "conversionService")
//    public ConversionService getConversionService() {
//        ConversionServiceFactoryBean factory = new ConversionServiceFactoryBean();
//        factory.setConverters(getConverters());
//        factory.afterPropertiesSet();
//        return factory.getObject();
//    }
}
