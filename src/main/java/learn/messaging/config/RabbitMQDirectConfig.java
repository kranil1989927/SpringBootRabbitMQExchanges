package learn.messaging.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQDirectConfig {

	@Bean
	DirectExchange directExchange() {
		return new DirectExchange("direct-exchange");
	}

	@Bean
	Binding deMarketingBinding(Queue marketingQueue, DirectExchange directExchange) {
		return BindingBuilder.bind(marketingQueue).to(directExchange).with("marketing");
	}

	@Bean
	Binding deFinanceBinding(Queue financeQueue, DirectExchange directExchange) {
		return BindingBuilder.bind(financeQueue).to(directExchange).with("finance");
	}

	@Bean
	Binding deAdminBinding(Queue adminQueue, DirectExchange directExchange) {
		return BindingBuilder.bind(adminQueue).to(directExchange).with("admin");
	}

}
