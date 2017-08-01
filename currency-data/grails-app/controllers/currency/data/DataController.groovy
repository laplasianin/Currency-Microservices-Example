package currency.data

import grails.converters.JSON

import static java.time.format.DateTimeFormatter.ofPattern

class DataController {

    def currencyService

    def index() {

        List<Currency> fromDb = currencyService.retrieve()

        render fromDb.collect {
            [
                    eur: it.eur,
                    usd: it.usd,
                    date: it.date.format(ofPattern("dd.MM.yyyy"))
            ]
        } as JSON
    }




}
