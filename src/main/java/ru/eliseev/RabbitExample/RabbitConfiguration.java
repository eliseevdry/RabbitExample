package ru.eliseev.RabbitExample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RabbitConfiguration {
    @Bean
    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory("localhost");
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    public Queue myQueue() {
        return new Queue("myQueue");
    }

    //___3___mailing to all listeners___3___

    /*@Bean
    public Queue myQueue2() {
        return new Queue("myQueue2");
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("common-exchange");
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(myQueue()).to(fanoutExchange());
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(myQueue2()).to(fanoutExchange());
    }*/

    //___3___mailing to all listeners___3___


    //____1____receiver in config____1____

    /*@Bean
    public SimpleMessageListenerContainer messageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setQueueNames("myQueue");
        container.setMessageListener(message -> log.info("Received from myQueue : {}", new String(message.getBody())));
        return container;
    }*/

    //____1____receiver in config____1____

    //___4___key distribution___4___

    /*@Bean
    public Queue myQueue2() {
        return new Queue("myQueue2");
    }

    @Bean
    public DirectExchange fanoutExchange() {
        return new DirectExchange("direct-exchange");
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(myQueue()).to(fanoutExchange()).with("error");
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(myQueue2()).to(fanoutExchange()).with("info");
    }

    @Bean
    public Binding binding3() {
        return BindingBuilder.bind(myQueue2()).to(fanoutExchange()).with("warning");
    }*/

    //___4___key distribution___4___

    //___5___topic distribution___5___

    @Bean
    public Queue myQueue2() {
        return new Queue("myQueue2");
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topic-exchange");
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(myQueue()).to(topicExchange()).with("*.one");
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(myQueue2()).to(topicExchange()).with("two.*");
    }

    //___5___topic distribution___5___
}
