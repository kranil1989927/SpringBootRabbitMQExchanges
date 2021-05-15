package learn.messaging.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQFanoutConfig {

	@Bean
	FanoutExchange fanoutExchange() {
		return new FanoutExchange("fanout-exchange");
	}

	@Bean
	Binding marketingBinding(Queue marketingQueue, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(marketingQueue).to(fanoutExchange);
	}

	@Bean
	Binding financeBinding(Queue financeQueue, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(financeQueue).to(fanoutExchange);
	}

	@Bean
	Binding adminBinding(Queue adminQueue, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(adminQueue).to(fanoutExchange);
	}
}
