package org.joksin.onlineshop.api;

import org.joksin.onlineshop.api.request.ChangeProductPriceRequest;
import org.joksin.onlineshop.model.Product;

public interface ChangeProductPriceUseCase {

    Product changePrice(ChangeProductPriceRequest changeProductPriceRequest);

}
