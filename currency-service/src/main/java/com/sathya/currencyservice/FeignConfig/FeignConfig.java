package com.sathya.currencyservice.FeignConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import feign.RequestInterceptor;
import io.micrometer.tracing.Span;
import io.micrometer.tracing.Tracer;

@Configuration
public class FeignConfig {

	@Bean
    public RequestInterceptor tracingFeignClientInterceptor(Tracer tracer) {
        return template -> {
            Span currentSpan =tracer.currentSpan();
            if (currentSpan != null) {
                template.header("X-B3-TraceId", currentSpan.context().traceId());
                template.header("X-B3-SpanId", currentSpan.context().spanId());
                template.header("X-B3-Sampled", currentSpan.context().sampled() ? "1" : "0");
            }
        };
    }
}
