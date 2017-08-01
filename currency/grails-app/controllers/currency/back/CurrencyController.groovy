package currency.back

import grails.converters.JSON
import org.springframework.beans.factory.annotation.Autowired

class CurrencyController {
	static responseFormats = ['json', 'xml']

    @Autowired
    CurrencyClient currencyClient
	
    def index() {
        def currency = currencyClient.currency
        render currency as JSON
    }
}
