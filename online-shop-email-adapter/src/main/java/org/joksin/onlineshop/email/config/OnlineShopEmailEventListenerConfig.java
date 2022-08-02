package org.joksin.onlineshop.email.config;

import org.joksin.onlineshop.email.EmailOrderCreatedEventListener;
import org.springframework.context.annotation.Import;

@Import(value = {
        EmailOrderCreatedEventListener.class
})
public class OnlineShopEmailEventListenerConfig {
}
